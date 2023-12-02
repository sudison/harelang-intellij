package org.harelang.completion


import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.*
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.psi.util.prevLeafs
import com.intellij.util.ProcessingContext
import org.harelang.parser.psi.*
import org.harelang.reference.*


val PsiElement.leftSiblings: Sequence<PsiElement>
    get() = generateSequence(this.prevSibling) { it.prevSibling }

fun <T, Self : ObjectPattern<T, Self>> ObjectPattern<T, Self>.with(name: String, cond: (T) -> Boolean): Self =
    with(object : PatternCondition<T>(name) {
        override fun accepts(t: T & Any, context: ProcessingContext?): Boolean = cond(t)
    })

fun <T : PsiElement, Self : PsiElementPattern<T, Self>> PsiElementPattern<T, Self>.withPrevSiblingSkipping(
    skip: ElementPattern<out T>,
    pattern: ElementPattern<out T>
): Self = with("withPrevSiblingSkipping") { e ->
    val sibling = e.leftSiblings.dropWhile { skip.accepts(it) }
        .firstOrNull() ?: return@with false
    pattern.accepts(sibling)
}

fun <T : PsiElement, Self : PsiElementPattern<T, Self>> PsiElementPattern<T, Self>.hasPrevSibling(
    pattern: ElementPattern<out T>
): Self = with("hasPrevSibling") { e ->
    e.leftSiblings.filter { pattern.accepts(it) }.any()
}

fun <T : PsiElement, Self : PsiElementPattern<T, Self>> PsiElementPattern<T, Self>.hasPrevSiblings(
    vararg patterns: ElementPattern<out T>
): Self = with("hasPrevSibling") { e ->
    var ps = patterns.toList()
    e.leftSiblings.filter {
        val f = ps.firstOrNull()
        if (f != null && f.accepts(it)) {
            ps = ps.drop(1)
            true
        } else {
            false
        }
    }.any()
}

class OnStatementBeginning(private val e: PsiElementPattern.Capture<PsiElement>? = null) : PatternCondition<PsiElement>("on statement beginning") {
    override fun accepts(t: PsiElement, context: ProcessingContext?): Boolean {
        val prev = t.prevLeafs.filter { it !is PsiWhiteSpace }.firstOrNull()
        if (prev != null && e != null) {
            return e.accepts(prev)
        }
        return prev == null || prev.elementType == HareTypes.EOS || prev.elementType == HareTypes.LBR
    }
}

class HareCompletionProvider(private val les: List<LookupElement>) : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val p = result.prefixMatcher.prefix
        val a = les.filter { it.lookupString.startsWith(p) }
        a.forEach(result::addElement)
    }
}

fun createLookup(t: String?): LookupElement? {
    t ?: return null
    return LookupElementBuilder
        .create(t)
        .withPresentableText(t)
        .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
}

// handle single id
class HareReferenceProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val p = result.prefixMatcher.prefix
        parameters.position.getLocalReferences(p, false).forEach {
            val t = createLookup(it.name())
            if (t != null) {
                result.addElement(t)
            }
        }
        parameters.position.containingFile?.globalDeclarationsInModule()?.forEach {
            if (it.name()?.startsWith(p) == true) {
                val t = createLookup(it.name())
                if (t != null) {
                    result.addElement(t)
                }
            }
        }
    }
}

class HareScopeReferenceProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val p = result.prefixMatcher.prefix
        parameters.position.parent.prevSibling?.hareReference()?.psi()?.evaluate()?.lookup(p)?.forEach {
            val t = createLookup(it.name())
            if (t != null) {
                result.addElement(t)
            }
        }
    }
}

class HarePostFixProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val p = result.prefixMatcher.prefix
        parameters.position.parent.parent.prevSibling?.hareReference()?.psi()?.evaluate()?.lookup(p)?.forEach {
            val t = createLookup(it.name())
            if (t != null) {
                result.addElement(t)
            }
        }
    }
}

class HareStructFieldNameProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val p = result.prefixMatcher.prefix
        PsiTreeUtil.findFirstParent(parameters.position) {
            it is HareStructLiteral
        }?.hareReference()?.psi()?.evaluate()?.lookup(p)?.forEach {
            val t = createLookup(it.name())
            if (t != null) {
                result.addElement(t)
            }
        }
    }
}

class HareImportPathProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val p = result.prefixMatcher.prefix
        if (parameters.position.parent.prevSibling == null) {
            val roots = parameters.position.containingFile?.originalFile?.virtualFile?.rootDirs(parameters.position.project)
            roots?.forEach { rootDir ->
                ModuleDir(parameters.position.project, rootDir).psi().evaluate()?.lookup(p)?.forEach {
                    val t = createLookup(it.name())
                    if (t != null) {
                        result.addElement(t)
                    }
                }
            }
        } else {
            PsiTreeUtil.findSiblingBackward(parameters.position.parent, HareTypes.IMPORT_ID, null)?.hareReference()?.psi()?.evaluate()?.lookup(p)?.forEach {
                val t = createLookup(it.name())
                if (t != null) {
                    result.addElement(t)
                }
            }
        }
    }
}

class HareTypeProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val p = result.prefixMatcher.prefix
        PsiTreeUtil.collectElementsOfType(parameters.position.containingFile, HareTypeBinding::class.java).forEach {
            if (it.nameIdentifier?.text?.startsWith(p) == true) {
                val t = createLookup(it.nameIdentifier?.text)
                if (t != null) {
                    result.addElement(t)
                }
            }
        }
        HareCompletionContributor.buildinTypes.forEach {
            if (it.lookupString.startsWith(p)) {
                result.addElement(it)
            }
        }
    }
}

class HareCompletionContributor : CompletionContributor() {
    companion object {
        private val topKeyWords = listOf(
            HareTypes.USE_KW,
            HareTypes.EXPORT_KW,
            HareTypes.FN_KW,
            HareTypes.LET_KW,
            HareTypes.CONST_KW,
            HareTypes.DEF_KW,
            HareTypes.TYPE_KW,
        ).map {
            val t = it as HareTokenType
            LookupElementBuilder
                .create(t.realName())
                .withPresentableText(t.realName())
                .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
        }

        private val topKeyWordsAfterExport = listOf(
            HareTypes.FN_KW,
            HareTypes.LET_KW,
            HareTypes.CONST_KW,
            HareTypes.DEF_KW,
            HareTypes.TYPE_KW,
        ).map {
            val t = it as HareTokenType
            LookupElementBuilder
                .create(t.realName())
                .withPresentableText(t.realName())
                .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
        }

        private val localKeyWords = listOf(
            HareTypes.LET_KW,
            HareTypes.CONST_KW,
            HareTypes.DEFER_KW,
            HareTypes.FOR_KW,
            HareTypes.IF_KW,
            HareTypes.MATCH_KW,
            HareTypes.RETURN_KW,
            HareTypes.SWITCH_KW,
        ).map {
            val t = it as HareTokenType
            LookupElementBuilder
                .create(t.realName())
                .withPresentableText(t.realName())
                .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
        }

        private val typeDefinitionKeyWords = listOf(
            HareTypes.ENUM_KW,
            HareTypes.STRUCT_KW,
            HareTypes.UNION_KW,
            ).map {
            val t = it as HareTokenType
            LookupElementBuilder
                .create(t.realName())
                .withPresentableText(t.realName())
                .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
        }


         val buildinTypes = listOf(
            HareTypes.I8_TYPE,
            HareTypes.I16_TYPE,
            HareTypes.I32_TYPE,
            HareTypes.I64_TYPE,
            HareTypes.U8_TYPE,
            HareTypes.U16_TYPE,
            HareTypes.U32_TYPE,
            HareTypes.U64_TYPE,
            HareTypes.BOOL_TYPE,
            HareTypes.F32_TYPE,
            HareTypes.F64_TYPE,
            HareTypes.SIZE_TYPE,
            HareTypes.UINTPTR_TYPE,
            HareTypes.UINT_TYPE,
            HareTypes.VOID_TYPE,
            HareTypes.RUNE_KW,
            HareTypes.NULL_KW,
            HareTypes.VALIST_TYPE,
            HareTypes.CHAR_TYPE,
            HareTypes.STR_TYPE,
        ).map {
            val t = it as HareTokenType
            LookupElementBuilder
                .create(t.realName())
                .withPresentableText(t.realName())
                .withAutoCompletionPolicy(AutoCompletionPolicy.NEVER_AUTOCOMPLETE)
        }
    }

    init {
        // top level keyword
        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withSuperParent(2, HareFile::class.java).with(OnStatementBeginning()),
            HareCompletionProvider(topKeyWords)
        )
        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER)
                .withParents(PsiErrorElement::class.java, HareFile::class.java)
                .with(OnStatementBeginning(psiElement(HareTypes.EXPORT_KW))),
            HareCompletionProvider(topKeyWordsAfterExport)
        )
        // : type
        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withSuperParent(
                4, StandardPatterns.or(
                    psiElement(HareTypes.TYPE).withPrevSiblingSkipping(
                        psiElement().whitespace(), psiElement(HareTypes.COLON)
                    ), (psiElement(HareTypes.TYPE).withPrevSiblingSkipping(
                        psiElement().whitespace(), psiElement(HareTypes.RP)
                    ))
                )
            ),
            HareTypeProvider()
        )
        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withSuperParent(4, psiElement(HareTypes.EXPRESSION_LIST))
                .with(OnStatementBeginning()),
            HareCompletionProvider(localKeyWords)
        )
        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withSuperParent(
                4, psiElement(HareTypes.TYPE).withPrevSiblingSkipping(
                    psiElement().whitespace(), psiElement(HareTypes.ASSIGN)
                )
            ),
            HareCompletionProvider(typeDefinitionKeyWords)
        )

        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withParent(psiElement(HareTypes.SYMBOL).withParent(psiElement(HareTypes.PLAN_EXPRESSION))),
            HareReferenceProvider()
        )

        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withParent(psiElement(HareTypes.SYMBOL).withParent(psiElement(HareTypes.ENUM_LITERAL))),
            HareScopeReferenceProvider()
        )

        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withParent(psiElement(HareTypes.FIELD_ACCESS_OP)),
            HarePostFixProvider()
        )

        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withParent(psiElement(HareTypes.SYMBOL).withParent(psiElement(HareTypes.FIELD_VALUE))),
            HareStructFieldNameProvider()
        )

        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withParent(psiElement(HareTypes.IMPORT_ID)),
            HareImportPathProvider()
        )
    }
}