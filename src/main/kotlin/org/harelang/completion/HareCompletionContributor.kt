package org.harelang.completion


import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.ObjectPattern
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.elementType
import com.intellij.psi.util.prevLeafs
import com.intellij.util.ProcessingContext
import org.harelang.parser.psi.HareFile
import org.harelang.parser.psi.HareTokenType
import org.harelang.parser.psi.HareTypes

val PsiElement.leftSiblings: Sequence<PsiElement>
    get() = generateSequence(this.prevSibling) { it.prevSibling }

fun <T, Self : ObjectPattern<T, Self>> ObjectPattern<T, Self>.with(name: String, cond: (T) -> Boolean): Self =
    with(object : PatternCondition<T>(name) {
        override fun accepts(t: T, context: ProcessingContext?): Boolean = cond(t)
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
    val a = e.leftSiblings.toList()
    e.leftSiblings.filter { pattern.accepts(it) }.any()
}

class OnStatementBeginning : PatternCondition<PsiElement>("on statement beginning") {
    override fun accepts(t: PsiElement, context: ProcessingContext?): Boolean {
        val prev = t.prevLeafs.filter { it !is PsiWhiteSpace }.firstOrNull()
        return prev == null || prev.elementType == HareTypes.EOS
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

        private val buildinTypes = listOf(
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
        // : type
        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withPrevSiblingSkipping(psiElement().whitespace(), psiElement(HareTypes.COLON)),
            HareCompletionProvider(buildinTypes)
        )

        // : function return type
        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER)
                .withSuperParent(1, HareFile::class.java)
                .hasPrevSibling(psiElement(HareTypes.FN_KW)),
            HareCompletionProvider(buildinTypes)
        )
    }
}