package org.harelang.syntax

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import org.harelang.lexer.HareLexerAdapter
import org.harelang.parser.psi.HareElementType
import org.harelang.parser.psi.HareTypes
import kotlin.reflect.full.declaredMembers

object HareSyntaxHighlighter : SyntaxHighlighterBase() {
    private val keywords = HareTypes::class.declaredMembers.filter { it.name.endsWith("KW") }.map { it.call() }
    private val keywordsAttrs =
        arrayOf(TextAttributesKey.createTextAttributesKey("Hare_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD))
    private val lineComment =
        arrayOf(
            TextAttributesKey.createTextAttributesKey(
                "LINE_COMMENT",
                DefaultLanguageHighlighterColors.LINE_COMMENT
            )
        )

    override fun getHighlightingLexer(): Lexer {
        return HareLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when (tokenType) {
            in keywords -> keywordsAttrs
            HareElementType.COMMENT -> lineComment
            else -> emptyArray()
        }
    }
}

class HareSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
        return HareSyntaxHighlighter
    }
}