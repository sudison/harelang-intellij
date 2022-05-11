package org.harelang.syntax

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import org.harelang.parser.psi.*

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

        private val globalVar =
            TextAttributesKey.createTextAttributesKey(
                "GLOBAL_VARIABLE",
                DefaultLanguageHighlighterColors.STATIC_FIELD
            )

        private val constant =
            TextAttributesKey.createTextAttributesKey(
                "CONSTANT",
                DefaultLanguageHighlighterColors.CONSTANT
            )

        private val type =
            TextAttributesKey.createTextAttributesKey(
                "TYPE",
                DefaultLanguageHighlighterColors.CLASS_NAME
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
            is HareGlobalDeclaration -> {
                element.globalBindings.globalBindingList.forEach {
                    val i = it.identifierPath
                    holder
                        .newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(i.textRange).textAttributes(globalVar).create()
                }
            }
            is HareConstantDeclaration -> {
                element.constantBindings.constantBindingList.forEach {
                    val i = it.identifierPath
                    holder
                        .newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(i.textRange).textAttributes(constant).create()
                }
            }
            is HareTypeDeclaration -> {
                element.typeBindings.typeBindingList.forEach {
                    val i = it.identifierPath
                    holder
                        .newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .range(i.textRange).textAttributes(type).create()
                }
            }
        }

    }
}