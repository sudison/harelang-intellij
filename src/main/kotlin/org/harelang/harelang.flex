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
    "," {return HareTypes.COMMA;}
    ":" {return HareTypes.COLON;}
    "(" { return HareTypes.LP; }
    ")" { return HareTypes.RP; }
    "{" { return HareTypes.LBR; }
    "}" { return HareTypes.RBR; }
    "i8" {return HareTypes.I8;}
    "i16" {return HareTypes.I16;}
    "i32" {return HareTypes.I32;}
    "i64" {return HareTypes.I64;}
    "u8" {return HareTypes.U8;}
    "u16" {return HareTypes.U16;}
    "u32" {return HareTypes.U32;}
    "u64" {return HareTypes.U64;}
    "int" {return HareTypes.INT;}
    "uint" {return HareTypes.UINT;}
    "size" {return HareTypes.SIZE;}
    "uintptr" {return HareTypes.UINTPTR;}
    "char" {return HareTypes.CHAR;}
    "void" {return HareTypes.VOID;}
    "fn" {return HareTypes.FN_KW;}
    "use" { return HareTypes.USE_KW; }
    "export" {return HareTypes.EXPORT_KW;}

    "::" { return HareTypes.SCOPE; }

    {WHITESPACE} { return TokenType.WHITE_SPACE; }

    {IDENTIFIER} { return HareTypes.IDENTIFIER; }
    {COMMENT} {return HareElementType.Companion.getCOMMENT();}
    {STRING_LITERAL} {return HareElementType.Companion.getSTRING_LITERAL();}

}

[^]  { return TokenType.BAD_CHARACTER; }


