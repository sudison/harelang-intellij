package org.harelang

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.harelang.lexer.HareLexerAdapter
import org.harelang.parser.HareParser
import org.harelang.parser.psi.HareElementType
import org.harelang.parser.psi.HareFile
import org.harelang.parser.psi.HareTypes


class HareParserDefinition : ParserDefinition {
    companion object {
        private val FILE = IFileElementType(HareLang)
        private val Comment = TokenSet.create(HareElementType.COMMENT)
        private val StringLiteral = TokenSet.create(HareTypes.STRING_LITERAL)

    }

    override fun createParser(project: Project?) = HareParser()
    override fun createLexer(project: Project?) = HareLexerAdapter()
    override fun createFile(viewProvider: FileViewProvider) = HareFile(viewProvider)
    override fun createElement(node: ASTNode?) = HareTypes.Factory.createElement(node)
    override fun getFileNodeType() = FILE
    override fun getCommentTokens(): TokenSet {
        return Comment
    }

    override fun getStringLiteralElements(): TokenSet {
        return StringLiteral
    }
}