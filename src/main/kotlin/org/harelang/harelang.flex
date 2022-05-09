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
%{
StringBuilder string = new StringBuilder();
%}
NON_DIGIT = [A-Z] | [a-z] | "_"
DIGIT = [0-9]
ALNUM = {NON_DIGIT} | {DIGIT}
IDENTIFIER = {NON_DIGIT} {ALNUM}*
COMMENT = "//" [^\n]* \n?
RAWSTRING = \`[^\`]*\`
RUNE_LITERAL = \'\\'\' | \'[^']*\'
WHITESPACE      = \s
DECIMAL_DIGITS = \d+
OCTAL_DIGITS = 0o [0-7]+
HEX_DIGITS = 0x [0-9a-fA-F]+
BIN_DIGITS = 0b [0-1]+
StringCharacter = [^\r\n\"\\]

%state STRING
%%


<YYINITIAL> {
    \" { yybegin(STRING); string.setLength(0); }
    "~" {return HareTypes.NOT;}
    "_" {return HareTypes.UNDERSCORE;}
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
    "!" {return HareTypes.BANG;}
    "[" {return HareTypes.LB;}
    "]" {return HareTypes.RB;}
    "(" { return HareTypes.LP; }
    ")" { return HareTypes.RP; }
    "{" { return HareTypes.LBR; }
    "}" { return HareTypes.RBR; }
    "." {return HareTypes.DOT;}
    "?" {return HareTypes.QUESTION;}
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
    "=>" {return HareTypes.MATCH_OP;}
    "<<=" {return HareTypes.LEFT_SHIFT_ASSIGN;}
    ">>=" {return HareTypes.RIGHT_SHIFT_ASSIGN;}
    "&&=" {return HareTypes.LOGICAL_AND_ASSIGN;}
    "||=" {return HareTypes.LOGICAL_OR_ASSIGN;}
    "^^=" {return HareTypes.LOGICAL_XOR_ASSIGN;}
    "as" {return HareTypes.AS_KW;}
    "is" {return HareTypes.IS_KW;}

    "i8" {return HareTypes.I8_TYPE;}
    "i16" {return HareTypes.I16_TYPE;}
    "i32" {return HareTypes.I32_TYPE;}
    "i64" {return HareTypes.I64_TYPE;}
    "u8" {return HareTypes.U8_TYPE;}
    "u16" {return HareTypes.U16_TYPE;}
    "u32" {return HareTypes.U32_TYPE;}
    "u64" {return HareTypes.U64_TYPE;}
    "int" {return HareTypes.INT_TYPE;}
    "uint" {return HareTypes.UINT_TYPE;}
    "size" {return HareTypes.SIZE_TYPE;}
    "uintptr" {return HareTypes.UINTPTR_TYPE;}
    "bool" {return HareTypes.BOOL_TYPE;}
    "valist" {return HareTypes.VALIST_TYPE;}
    "char" {return HareTypes.CHAR_TYPE;}
    "void" {return HareTypes.VOID_TYPE;}
    "f32" {return HareTypes.F32_TYPE;}
    "f64" {return HareTypes.F64_TYPE;}
    "fn" {return HareTypes.FN_KW;}
    "use" { return HareTypes.USE_KW; }
    "export" {return HareTypes.EXPORT_KW;}
    "true" {return HareTypes.TRUE_KW;}
    "false" {return HareTypes.FALSE_KW;}
    "null" {return HareTypes.NULL_KW;}
    "static" {return HareTypes.STATIC_KW;}
    "let" {return HareTypes.LET_KW;}
    "const" {return HareTypes.CONST_KW;}
    "def" {return HareTypes.DEF_KW;}
    "type" {return HareTypes.TYPE_KW;}
    "if" {return HareTypes.IF_KW;}
    "else" {return HareTypes.ELSE_KW;}
    "for" {return HareTypes.FOR_KW;}
    "enum" {return HareTypes.ENUM_KW;}
    "nullable" {return HareTypes.NULLABLE_KW;}
    "rune" {return HareTypes.RUNE_KW;}
    "struct" {return HareTypes.STRUCT_KW;}
    "str" {return HareTypes.STR_TYPE;}
    "union" {return HareTypes.UNION_KW;}
    "alloc" {return HareTypes.ALLOC_KW;}
    "free" {return HareTypes.FREE_KW;}
    "assert" {return HareTypes.ASSERT_KW;}
    "abort" {return HareTypes.ABORT_KW;}
    "defer" {return HareTypes.DEFER_KW;}
    "len" {return HareTypes.LEN_KW;}
    "offset" {return HareTypes.OFFSET_KW;}
    "append" {return HareTypes.APPEND_KW;}
    "insert" {return HareTypes.INSERT_KW;}
    "delete" {return HareTypes.DELETE_KW;}
    "vastart" {return HareTypes.VASTART_KW;}
    "vaarg" {return HareTypes.VAARG_KW;}
    "vaend" {return HareTypes.VAEND_KW;}
    "match" {return HareTypes.MATCH_KW;}
    "case" {return HareTypes.CASE_KW;}
    "switch" {return HareTypes.SWITCH_KW;}
    "break" {return HareTypes.BREAK_KW;}
    "continue" {return HareTypes.CONTINUE_KW;}
    "return" {return HareTypes.RETURN_KW;}
    "yield" {return HareTypes.YIELD_KW;}
    "@fini" {return HareTypes.FINI_ATTR;}
    "@init" {return HareTypes.INIT_ATTR;}
    "@test" {return HareTypes.TEST_ATTR;}
    "@noreturn" {return HareTypes.NORETURN_ATTR;}


    ".." {return HareTypes.DOTDOT;}
    "..." {return HareTypes.DOTDOTDOT;}


    "::" { return HareTypes.SCOPE; }

    {WHITESPACE} { return TokenType.WHITE_SPACE; }
    {DECIMAL_DIGITS} { return HareTypes.DECIMAL_DIGITS; }
    {OCTAL_DIGITS}   {return HareTypes.OCTAL_DIGITS;}
    {HEX_DIGITS}   {return HareTypes.HEX_DIGITS;}
    {BIN_DIGITS}   {return HareTypes.BIN_DIGITS;}

    {IDENTIFIER} { return HareTypes.IDENTIFIER; }
    {COMMENT} {return HareElementType.Companion.getCOMMENT();}
    {RUNE_LITERAL} {return HareTypes.RUNE_LITERAL;}
    {RAWSTRING} {return HareTypes.RAWSTRING;}

}
<STRING> {
  \"                             { yybegin(YYINITIAL); return HareTypes.STRING_LITERAL; }
  {StringCharacter}+ { string.append( yytext() ); }
  "\\\""                         { string.append( '\"' ); }
  "\\0"|"\\a"|"\\b"|"\\f"|"\\r"|"\\n"|"\\t"|"\\v"|"\\\\"|"\\'"  { string.append( yytext() ); }


  \r|\n|\r\n  { throw new RuntimeException("Unterminated string at end of line"); }
}
[^]  { return TokenType.BAD_CHARACTER; }


