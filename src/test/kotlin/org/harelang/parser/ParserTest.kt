package org.harelang.parser


import com.intellij.testFramework.ParsingTestCase
import org.harelang.HareFileType
import org.harelang.HareParserDefinition
import org.junit.Test

class ParserTests : ParsingTestCase("", HareFileType.defaultExtension, HareParserDefinition()) {
    override fun getTestDataPath() = "src/testdata/parsing"

    override fun skipSpaces() = true

    private fun printTree() {
        println(name)

        myFile = createPsiFile(
            testName, """use a::b::c; use a::b::{a}; use a::b::*; use a::b::{a, b, c = d};"""
        )
        ensureParsed(myFile)
        println(toParseTreeText(myFile, skipSpaces(), includeRanges()))
    }

    @Test
    fun testComments() {
        printTree()
    }
}