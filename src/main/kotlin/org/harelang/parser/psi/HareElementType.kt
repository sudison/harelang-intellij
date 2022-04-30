package org.harelang.parser.psi

import com.intellij.psi.tree.IElementType
import org.harelang.HareLang

open class HareElementType(debugName: String) : IElementType(debugName, HareLang) {
    companion object {
        val COMMENT = HareElementType("COMMENT")
        val STRING_LITERAL = HareElementType("STRING_LITERAL")

    }
}