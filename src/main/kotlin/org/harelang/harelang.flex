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
DECIMAL_DIGITS = \d+
%%


<YYINITIAL> {
    "=" {return HareTypes.ASSIGN;}
    "*" {return HareTypes.MULTIPLIES;}
    "/" {return HareTypes.DIVIDES;}
    "%" {return HareTypes.MODULUS;}
    "&" {return HareTypes.AND;}
    "+" {return HareTypes.ADDS;}
    "^" {return HareTypes.EXCLUSIVE_OR;}
    "|" {return HareTypes.INCLUSIVE_OR;}
    "<" {return HareTypes.LESSER_THAN;}
    ">" {return HareTypes.LARGER_THAN;}
    "-" {return HareTypes.SUBSTRACTS;}
    ";" {return HareTypes.EOS;}
    "," {return HareTypes.COMMA;}
    ":" {return HareTypes.COLON;}
    "[" {return HareTypes.LB;}
    "]" {return HareTypes.RB;}
    "(" { return HareTypes.LP; }
    ")" { return HareTypes.RP; }
    "{" { return HareTypes.LBR; }
    "}" { return HareTypes.RBR; }
    "+=" {return HareTypes.PLUS_ASSIGN;}
    "-=" {return HareTypes.MINUS_ASSIGN;}
    "*=" {return HareTypes.MULTIPLIES_ASSIGN;}
    "/=" {return HareTypes.DIVIDES_ASSIGN;}
    "%=" {return HareTypes.MODULUS_ASSIGN;}
    "&=" {return HareTypes.AND_ASSIGN;}
    "|=" {return HareTypes.OR_ASSIGN;}
    "^=" {return HareTypes.XOR_ASSIGN;}
    "&&" {return HareTypes.LOGICAL_AND;}
    "||" {return HareTypes.LOGICAL_OR;}
    "^^" {return HareTypes.LOGICAL_XOR;}
    "==" {return HareTypes.EQUAL;}
    "!=" {return HareTypes.NOT_EQUAL;}
    "<=" {return HareTypes.LESSER_EQUAL;}
    ">=" {return HareTypes.LARGER_EQUAL;}
    "<<" {return HareTypes.LEFT_SHIFT;}
    ">>" {return HareTypes.RIGHT_SHIFT;}
    "<<=" {return HareTypes.LEFT_SHIFT_ASSIGN;}
    ">>=" {return HareTypes.RIGHT_SHIFT_ASSIGN;}
    "&&=" {return HareTypes.LOGICAL_AND_ASSIGN;}
    "||=" {return HareTypes.LOGICAL_OR_ASSIGN;}
    "^^=" {return HareTypes.LOGICAL_XOR_ASSIGN;}
    "i8" {return HareTypes.I8_KW;}
    "i16" {return HareTypes.I16_KW;}
    "i32" {return HareTypes.I32_KW;}
    "i64" {return HareTypes.I64_KW;}
    "u8" {return HareTypes.U8_KW;}
    "u16" {return HareTypes.U16_KW;}
    "u32" {return HareTypes.U32_KW;}
    "u64" {return HareTypes.U64_KW;}
    "int" {return HareTypes.INT_KW;}
    "uint" {return HareTypes.UINT_KW;}
    "size" {return HareTypes.SIZE_KW;}
    "uintptr" {return HareTypes.UINTPTR_KW;}
    "char" {return HareTypes.CHAR_KW;}
    "void" {return HareTypes.VOID_KW;}
    "fn" {return HareTypes.FN_KW;}
    "use" { return HareTypes.USE_KW; }
    "export" {return HareTypes.EXPORT_KW;}
    "true" {return HareTypes.TRUE_KW;}
    "false" {return HareTypes.FALSE_KW;}
    "null" {return HareTypes.NULL_KW;}
    "static" {return HareTypes.STATIC_KW;}
    "let" {return HareTypes.LET_KW;}
    "const" {return HareTypes.CONST_KW;}
    "if" {return HareTypes.IF_KW;}
    "else" {return HareTypes.ELSE_KW;}
    "for" {return HareTypes.FOR_KW;}
    "::" { return HareTypes.SCOPE; }

    {WHITESPACE} { return TokenType.WHITE_SPACE; }
    {DECIMAL_DIGITS} { return HareTypes.DECIMAL_DIGITS; }

    {IDENTIFIER} { return HareTypes.IDENTIFIER; }
    {COMMENT} {return HareElementType.Companion.getCOMMENT();}
    {STRING_LITERAL} {return HareTypes.STRING_LITERAL;}

}

[^]  { return TokenType.BAD_CHARACTER; }


