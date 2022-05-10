package org.harelang.lexer

import com.intellij.lexer.FlexAdapter

class HareLexerAdapter : FlexAdapter(HareLexer(null)) {
}