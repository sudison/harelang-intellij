package org.harelang.completion

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import junit.framework.TestCase
import org.harelang.HareFileType
import org.junit.Test

class HareCompletionContributorTest : LightPlatformCodeInsightFixture4TestCase() {
    private fun keywordCompletion(typeStr: String, completion: String) {
        myFixture.configureByText(HareFileType, "")
        myFixture.type(typeStr)
        val l = myFixture.completeBasic()
        assertTrue(l.size == 1)
        assertEquals(l[0].lookupString, "$completion")
    }

    @Test
    fun testTopLevelKeywordsCompletion() {
        listOf(
            Pair("u", "use"),
            Pair("use io;u", "use"),
            Pair("e", "export"),
            Pair("d", "def"),
            Pair("l", "let"),
            Pair("c", "const"),
            Pair("f", "fn"),
            Pair("t", "type"),
            ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testTopLevelKeywordsAfterExportCompletion() {
        listOf(
            Pair("export f", "fn"),
            Pair("export d", "def"),
            Pair("export l", "let"),
            Pair("export c", "const"),
            Pair("export t", "type"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testDefCompletion() {
        listOf(
            Pair("def i: i3", "i32"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testTypeCompletion() {
        listOf(
            Pair("let i: i3", "i32"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionArgTypeCompletion() {
        listOf(
            Pair("fn huh(a:i3", "i32"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionReturnTypeCompletion() {
        listOf(
            Pair("fn huh(a:i32) i3", "i32"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionExpressionCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { l", "let"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionExpressionConstCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { c", "const"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionExpressionConstMultipleStatementsCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { const i = 1; c", "const"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionDeferExpressionCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { d", "defer"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }
    @Test
    fun testFunctionReturnCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { r", "return"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionForCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { f", "for"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionIfCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { i", "if"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionMatchCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { m", "match"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionSwitchCompletion() {
        listOf(
            Pair("fn huh(a:i32) void = { s", "switch"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testEnumCompletion() {
        listOf(
            Pair("type e = e", "enum"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testStructCompletion() {
        listOf(
            Pair("type e = s", "struct"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testUnionCompletion() {
        listOf(
            Pair("type e = u", "union"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testStructTypeDefCompletion() {
        listOf(
            Pair("type e = struct {i:i3", "i32"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testExpressionGlobalLetCompletion() {
        listOf(
            Pair("let gi:i32 = 1; fn v()void = {g", "gi"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testExpressionGlobalConstCompletion() {
        listOf(
            Pair("const gi:i32 = 1; fn v()void = {g", "gi"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testExpressionGlobalFunctionCompletion() {
        listOf(
            Pair("fn gfoo() void = {return 1;}; fn v()void = {g", "gfoo"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testEnumValueCompletion() {
        listOf(
            Pair("export type ga = enum {RED,BLACK,}; fn v()void = {ga::R", "RED"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testStructFieldAccessCompletion() {
        listOf(
            Pair("export type ga = struct {field1:i32}; fn v()void = {ga.fi", "field1"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testLocalVarCompletion() {
        listOf(
            Pair("fn v()void = {let gi = 1; let a = g", "gi"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunParameterCompletion() {
        listOf(
            Pair("fn v(arg1:int, arg21:int)void = {let gi = arg2", "arg21"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testForPredicateCompletion() {
        listOf(
            Pair("fn v()void = {for(let ii = 0;ii+1) {let a = i", "ii"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testForPredicateExpressionCompletion() {
        listOf(
            Pair("fn v()void = {for(let ii = 0;i", "ii"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testMatchCaseCompletion() {
        listOf(
            Pair("fn v()void = { match(p) { case let ii: i32 => i", "ii"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testCustomizedTypeCompletion() {
        listOf(
            Pair("type aa = i32; fn v()a", "aa"),
            Pair("type aa = i32; fn v(i:a", "aa"),
            Pair("type aa = i32; fn v()void = { let i:a", "aa"),
            ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testFunctionReturnStructCompletion() {
        listOf(
            Pair("type sa = struct {ii:i32}; fn foo() sa = {i;}; fn bar() void = {foo().i", "ii"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testStructInitCompletion() {
        listOf(
            Pair("type sa = struct {ii:i32}; fn bar() void = { let i = s", "sa"),
            Pair("type sa = struct {ii:i32}; fn bar() void = { let i = sa {i", "ii"),
            Pair("let gi1: i32 = 1; type sa = struct {gi2:i32}; fn bar() void = { let i = sa {gi2 = g", "gi1"),
            ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testLocalStructWithTypeDefCompletion() {
        listOf(
            Pair("type sa = struct {ii:i32}; fn bar() void = { let i:sa = sa {ii = 1}; let b = i.i", "ii"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testLocalStructNoTypeDefCompletion() {
        listOf(
            Pair("type sa = struct {ii:i32}; fn bar() void = { let i = sa {ii = 1}; let b = i.i", "ii"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }

    @Test
    fun testModuleCompletion() {
        myFixture.addFileToProject("foo/a.ha", "export const fa: i32 = 0;")
        myFixture.configureByText(HareFileType, "")
        myFixture.type("use f")
        val l = myFixture.completeBasic()
        TestCase.assertTrue(l.size == 1)
        assertEquals(l[0].lookupString, "foo")
    }

    @Test
    fun testNestedModuleCompletion() {
        myFixture.addFileToProject("foo/a.ha", "export const fa: i32 = 0;")
        myFixture.addFileToProject("foo/bar/a.ha", "export const fa: i32 = 0;")
        myFixture.configureByText(HareFileType, "")
        myFixture.type("use foo::b")
        val l = myFixture.completeBasic()
        TestCase.assertTrue(l.size == 1)
        assertEquals(l[0].lookupString, "bar")
    }

    @Test
    fun testRefModuleCompletion() {
        myFixture.addFileToProject("foo/a.ha", "export const fa: i32 = 0;")
        myFixture.addFileToProject("foo/bar/a.ha", "export const fa: i32 = 0;")
        myFixture.configureByText(HareFileType, "")
        myFixture.type("use foo; const a: i32 = foo::f")
        val l = myFixture.completeBasic()
        TestCase.assertTrue(l.size == 1)
        assertEquals(l[0].lookupString, "fa")
    }

    @Test
    fun testRefNestedModuleCompletion() {
        myFixture.addFileToProject("foo/a.ha", "export const fa: i32 = 0;")
        myFixture.addFileToProject("foo/bar/a.ha", "export const fa: i32 = 0;")
        myFixture.configureByText(HareFileType, "")
        myFixture.type("use foo::bar; const a: i32 = bar::f")
        val l = myFixture.completeBasic()
        TestCase.assertTrue(l.size == 1)
        assertEquals(l[0].lookupString, "fa")
    }

    @Test
    fun testShouldNotRefPrivateDataCompletion() {
        myFixture.addFileToProject("foo/a.ha", "const fa: i32 = 0;")
        myFixture.configureByText(HareFileType, "")
        myFixture.type("use foo; const a: i32 = foo::f")
        val l = myFixture.completeBasic()
        TestCase.assertTrue(l.isEmpty())
    }
}
