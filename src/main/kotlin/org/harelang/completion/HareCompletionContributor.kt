package org.harelang.completion


import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.elementType
import com.intellij.psi.util.prevLeafs
import com.intellij.util.ProcessingContext
import org.harelang.parser.psi.HareFile
import org.harelang.parser.psi.HareTokenType
import org.harelang.parser.psi.HareTypes

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
    }

    init {
        // top level keyword
        extend(
            CompletionType.BASIC,
            psiElement(HareTypes.IDENTIFIER).withSuperParent(2, HareFile::class.java).with(OnStatementBeginning()),
            HareCompletionProvider(topKeyWords)
        )
    }
}