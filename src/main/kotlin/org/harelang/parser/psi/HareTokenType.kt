package org.harelang.parser.psi

import com.intellij.psi.tree.IElementType
import org.harelang.HareLang

open class HareTokenType(debugName: String) : IElementType(debugName, HareLang) {
    fun realName(): String {
        val n = toString()
        return if (n.endsWith("KW")) {
            n.replace("_KW", "").lowercase()
        } else if (n.endsWith("TYPE")) {
            n.replace("_TYPE", "").lowercase()
        } else {
            n
        }
    }
}