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
    fun testTypeCompletion() {
        listOf(
            Pair("let i: i3", "i32"),
        ).forEach {
            keywordCompletion(it.first, it.second)
        }
    }
}
