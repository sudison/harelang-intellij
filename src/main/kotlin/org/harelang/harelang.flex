package org.harelang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.harelang.parser.psi.HareTypes;
import org.harelang.parser.psi.HareElementType;
import com.intellij.psi.TokenType;

%%

%class HareLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

NON_DIGIT = [A-Z] | [a-z] | "_"
DIGIT = [0-9]
ALNUM = {NON_DIGIT} | {DIGIT}
IDENTIFIER = {NON_DIGIT} {ALNUM}*
COMMENT = "//" [^\n]* \n?
STRING_LITERAL = \".*\"
WHITESPACE      = \s

%%


<YYINITIAL> {
    ";" {return HareTypes.EOS;}
    "use" { return HareTypes.USE_KW; }
    "::" { return HareTypes.SCOPE; }

    {WHITESPACE} { return TokenType.WHITE_SPACE; }

    {IDENTIFIER} { return HareTypes.IDENTIFIER; }
    {COMMENT} {return HareElementType.Companion.getCOMMENT();}
    {STRING_LITERAL} {return HareElementType.Companion.getSTRING_LITERAL();}

}

[^]  { return TokenType.BAD_CHARACTER; }


