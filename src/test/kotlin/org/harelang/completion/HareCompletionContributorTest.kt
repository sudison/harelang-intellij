package org.harelang.completion

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
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
}
