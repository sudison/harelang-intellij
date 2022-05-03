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
            testName, """export fn main(a: i8, b: i32) i32 {  for (let a = b; a < 1; true) {let a = 1, b =2;}}"""
        )
        ensureParsed(myFile)
        println(toParseTreeText(myFile, skipSpaces(), includeRanges()))
    }

    @Test
    fun testComments() {
        printTree()
    }
}