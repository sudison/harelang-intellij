package org.harelang.parser


import com.intellij.testFramework.ParsingTestCase
import org.harelang.HareFileType
import org.harelang.HareParserDefinition
import org.junit.Test

class ParserTests : ParsingTestCase("", HareFileType.defaultExtension, HareParserDefinition()) {
    override fun getTestDataPath() = "src/test/testdata/parsing"

    override fun skipSpaces() = true

    private fun printTree(code: String) {
        println(name)

        myFile = createPsiFile(
            testName, code
        )
        ensureParsed(myFile)
        println(toParseTreeText(myFile, skipSpaces(), includeRanges()))
    }

    @Test
    fun testPrintParseImports() {
        printTree("""use a::b::c; use a::b::{a}; use a::b::*; use a::b::{a, b, c = d};""")
    }

    @Test
    fun testParseImports() {
        doCodeTest("""use a::b::c; use a::b::{a}; use a::b::*; use a::b::{a, b, c = d};""")
    }

    @Test
    fun testParseFunction() {
        doCodeTest(
            """fn huh(a:int) void = {
       let i = 0;
        let s = "";
        i = s;
    };"""
        )
    }

    @Test
    fun testParseFunction2() {
        doCodeTest(
            """fn huh(a:int) void; fn a::b::foo() i32;"""
        )
    }

    @Test
    fun testParseGlobalBinding() {
        doCodeTest("""
            let a:i32 = 1;
            const a:i64 = 1232;
        """.trimIndent())
    }

    @Test
    fun testParseDef() {
        doCodeTest("""
            def a: i32 = i;
        """.trimIndent())
    }

    @Test
    fun testParseTypeDef() {
        doCodeTest("""
            type a = i32; type a::b = i16, c = i32;
        """.trimIndent())
    }

    @Test
    fun testParseEnum() {
        doCodeTest("""
            type a = enum { a, b, c = 1}; type b = enum i32 {a = 1};
        """.trimIndent())
    }

    @Test
    fun testParsePointer() {
        doCodeTest("""
            type a = *i32, b = nullable * i8;
        """.trimIndent())
    }

    @Test
    fun testParseStruct() {
        doCodeTest("""
            type a = struct {i : i32, b : struct { i : i64}, a::bc};
        """.trimIndent())
    }

    @Test
    fun testParseUnion() {
        doCodeTest("""
            type a = union {i : i32, b : union { i : i64}, a::bc};
        """.trimIndent())
    }

    @Test
    fun testParseTuple() {
        doCodeTest("""
            type a = (i32, i8, f64);
        """.trimIndent())
    }

    @Test
    fun testParseTagged() {
        doCodeTest("""
            type a = (i32|i8|f64);
        """.trimIndent())
    }

    @Test
    fun testParseSlicedArray() {
        doCodeTest("""
            type a = []i32, b = [3]i32, c = [*]i32, d = [_]i8;
        """.trimIndent())
    }

    @Test
    fun testParseString() {
        doCodeTest("""
            let s : str = "a";
        """.trimIndent())
    }

    @Test
    fun testParseFunctionType() {
        doCodeTest("""
            type s = fn () void, b = fn (a:i32) i32, c = fn (a:i8...) i32, d = fn (_:i8...) i32, e = fn (a:i32, b:i32) void;
        """.trimIndent())
    }
}