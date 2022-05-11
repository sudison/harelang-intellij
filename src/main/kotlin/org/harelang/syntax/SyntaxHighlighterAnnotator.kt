package org.harelang.syntax

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import org.harelang.parser.psi.HareFloatingConstant
import org.harelang.parser.psi.HareFunctionDeclaration
import org.harelang.parser.psi.HareIntegerConstant
import org.harelang.parser.psi.HareRuneConstant

class SyntaxHighlighterAnnotator : Annotator {
    companion object {
        private val number =
                TextAttributesKey.createTextAttributesKey(
                    "NUMBER",
                    DefaultLanguageHighlighterColors.NUMBER
                )

        private val rune =
            TextAttributesKey.createTextAttributesKey(
                "RUNE",
                DefaultLanguageHighlighterColors.STRING
            )

        private val fnName =
            TextAttributesKey.createTextAttributesKey(
                "FUNCTION_NAME",
                DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
            )
    }


    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is HareIntegerConstant, is HareFloatingConstant ->
                holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange).textAttributes(number).create()
            is HareRuneConstant ->
                holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange).textAttributes(rune).create()
            is HareFunctionDeclaration -> {
                val i = element.identifierPath ?: return
                holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(i.textRange).textAttributes(fnName).create()
            }
        }

    }
}