// This is a generated file. Not intended for manual editing.
package org.harelang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.harelang.parser.psi.HareTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class HareParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return translation_unit(b, l + 1);
  }

  /* ********************************************************** */
  // multiplicative_expression additive_operator additive_expression* | multiplicative_expression
  static boolean additive_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additive_expression_0(b, l + 1);
    if (!r) r = multiplicative_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // multiplicative_expression additive_operator additive_expression*
  private static boolean additive_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicative_expression(b, l + 1);
    r = r && additive_operator(b, l + 1);
    r = r && additive_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // additive_expression*
  private static boolean additive_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additive_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additive_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ADDS | SUBSTRACTS
  static boolean additive_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_operator")) return false;
    if (!nextTokenIs(b, "", ADDS, SUBSTRACTS)) return false;
    boolean r;
    r = consumeToken(b, ADDS);
    if (!r) r = consumeToken(b, SUBSTRACTS);
    return r;
  }

  /* ********************************************************** */
  // shift_expression AND and_expression* | shift_expression
  static boolean and_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = and_expression_0(b, l + 1);
    if (!r) r = shift_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shift_expression AND and_expression*
  private static boolean and_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shift_expression(b, l + 1);
    r = r && consumeToken(b, AND);
    r = r && and_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // and_expression*
  private static boolean and_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!and_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "and_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // object_selector assignment_op expression
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = object_selector(b, l + 1);
    r = r && assignment_op(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ASSIGN | PLUS_ASSIGN | MINUS_ASSIGN | MULTIPLIES_ASSIGN | DIVIDES_ASSIGN |
  // MODULUS_ASSIGN | AND_ASSIGN | OR_ASSIGN | XOR_ASSIGN | LEFT_SHIFT_ASSIGN | RIGHT_SHIFT_ASSIGN | LOGICAL_AND_ASSIGN |
  // LOGICAL_OR_ASSIGN | LOGICAL_XOR_ASSIGN
  public static boolean assignment_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_OP, "<assignment op>");
    r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, PLUS_ASSIGN);
    if (!r) r = consumeToken(b, MINUS_ASSIGN);
    if (!r) r = consumeToken(b, MULTIPLIES_ASSIGN);
    if (!r) r = consumeToken(b, DIVIDES_ASSIGN);
    if (!r) r = consumeToken(b, MODULUS_ASSIGN);
    if (!r) r = consumeToken(b, AND_ASSIGN);
    if (!r) r = consumeToken(b, OR_ASSIGN);
    if (!r) r = consumeToken(b, XOR_ASSIGN);
    if (!r) r = consumeToken(b, LEFT_SHIFT_ASSIGN);
    if (!r) r = consumeToken(b, RIGHT_SHIFT_ASSIGN);
    if (!r) r = consumeToken(b, LOGICAL_AND_ASSIGN);
    if (!r) r = consumeToken(b, LOGICAL_OR_ASSIGN);
    if (!r) r = consumeToken(b, LOGICAL_XOR_ASSIGN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ASSIGN expression
  public static boolean binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, BINDING, r);
    return r;
  }

  /* ********************************************************** */
  // STATIC_KW* LET_KW bindings | STATIC_KW* CONST_KW bindings
  public static boolean binding_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINDING_LIST, "<binding list>");
    r = binding_list_0(b, l + 1);
    if (!r) r = binding_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STATIC_KW* LET_KW bindings
  private static boolean binding_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding_list_0_0(b, l + 1);
    r = r && consumeToken(b, LET_KW);
    r = r && bindings(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STATIC_KW*
  private static boolean binding_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_list_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, STATIC_KW)) break;
      if (!empty_element_parsed_guard_(b, "binding_list_0_0", c)) break;
    }
    return true;
  }

  // STATIC_KW* CONST_KW bindings
  private static boolean binding_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding_list_1_0(b, l + 1);
    r = r && consumeToken(b, CONST_KW);
    r = r && bindings(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STATIC_KW*
  private static boolean binding_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding_list_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, STATIC_KW)) break;
      if (!empty_element_parsed_guard_(b, "binding_list_1_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // binding COMMA bindings* | binding
  public static boolean bindings(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindings")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bindings_0(b, l + 1);
    if (!r) r = binding(b, l + 1);
    exit_section_(b, m, BINDINGS, r);
    return r;
  }

  // binding COMMA bindings*
  private static boolean bindings_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindings_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && bindings_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // bindings*
  private static boolean bindings_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindings_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bindings(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bindings_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // postfix_expression
  static boolean buildin_expression(PsiBuilder b, int l) {
    return postfix_expression(b, l + 1);
  }

  /* ********************************************************** */
  // VOID_KW | I8_KW | I16_KW | I32_KW | I64_KW | U8_KW | U16_KW | U32_KW | U64_KW | INT_KW | UINT_KW | SIZE_KW | UINTPTR_KW | CHAR_KW
  public static boolean buildin_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "buildin_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILDIN_TYPE, "<buildin type>");
    r = consumeToken(b, VOID_KW);
    if (!r) r = consumeToken(b, I8_KW);
    if (!r) r = consumeToken(b, I16_KW);
    if (!r) r = consumeToken(b, I32_KW);
    if (!r) r = consumeToken(b, I64_KW);
    if (!r) r = consumeToken(b, U8_KW);
    if (!r) r = consumeToken(b, U16_KW);
    if (!r) r = consumeToken(b, U32_KW);
    if (!r) r = consumeToken(b, U64_KW);
    if (!r) r = consumeToken(b, INT_KW);
    if (!r) r = consumeToken(b, UINT_KW);
    if (!r) r = consumeToken(b, SIZE_KW);
    if (!r) r = consumeToken(b, UINTPTR_KW);
    if (!r) r = consumeToken(b, CHAR_KW);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // unary_expression
  static boolean cast_expression(PsiBuilder b, int l) {
    return unary_expression(b, l + 1);
  }

  /* ********************************************************** */
  // inclusive_or_expression comparison_operator comparison_expression* | inclusive_or_expression
  static boolean comparison_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comparison_expression_0(b, l + 1);
    if (!r) r = inclusive_or_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inclusive_or_expression comparison_operator comparison_expression*
  private static boolean comparison_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inclusive_or_expression(b, l + 1);
    r = r && comparison_operator(b, l + 1);
    r = r && comparison_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comparison_expression*
  private static boolean comparison_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comparison_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "comparison_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LESSER_THAN | LARGER_THAN | LESSER_EQUAL | LARGER_EQUAL
  static boolean comparison_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_operator")) return false;
    boolean r;
    r = consumeToken(b, LESSER_THAN);
    if (!r) r = consumeToken(b, LARGER_THAN);
    if (!r) r = consumeToken(b, LESSER_EQUAL);
    if (!r) r = consumeToken(b, LARGER_EQUAL);
    return r;
  }

  /* ********************************************************** */
  // integer_constant | string_const | NULL_KW | TRUE_KW | FALSE_KW | VOID_KW
  public static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT, "<constant>");
    r = integer_constant(b, l + 1);
    if (!r) r = string_const(b, l + 1);
    if (!r) r = consumeToken(b, NULL_KW);
    if (!r) r = consumeToken(b, TRUE_KW);
    if (!r) r = consumeToken(b, FALSE_KW);
    if (!r) r = consumeToken(b, VOID_KW);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // comparison_expression equality_operator equality_expression* | comparison_expression
  static boolean equality_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equality_expression_0(b, l + 1);
    if (!r) r = comparison_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comparison_expression equality_operator equality_expression*
  private static boolean equality_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comparison_expression(b, l + 1);
    r = r && equality_operator(b, l + 1);
    r = r && equality_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // equality_expression*
  private static boolean equality_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!equality_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "equality_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EQUAL | NOT_EQUAL
  static boolean equality_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_operator")) return false;
    if (!nextTokenIs(b, "", EQUAL, NOT_EQUAL)) return false;
    boolean r;
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    return r;
  }

  /* ********************************************************** */
  // and_expression EXCLUSIVE_OR exclusive_or_expression* | and_expression
  static boolean exclusive_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusive_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exclusive_or_expression_0(b, l + 1);
    if (!r) r = and_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // and_expression EXCLUSIVE_OR exclusive_or_expression*
  private static boolean exclusive_or_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusive_or_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = and_expression(b, l + 1);
    r = r && consumeToken(b, EXCLUSIVE_OR);
    r = r && exclusive_or_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exclusive_or_expression*
  private static boolean exclusive_or_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusive_or_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!exclusive_or_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exclusive_or_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // assignment | binding_list | logical_or_expression
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = assignment(b, l + 1);
    if (!r) r = binding_list(b, l + 1);
    if (!r) r = logical_or_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LP parameter_list RP
  public static boolean function_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_args")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && parameter_list(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, FUNCTION_ARGS, r);
    return r;
  }

  /* ********************************************************** */
  // LBR expression* RBR
  public static boolean function_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_block")) return false;
    if (!nextTokenIs(b, LBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBR);
    r = r && function_block_1(b, l + 1);
    r = r && consumeToken(b, RBR);
    exit_section_(b, m, FUNCTION_BLOCK, r);
    return r;
  }

  // expression*
  private static boolean function_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EXPORT_KW? FN_KW IDENTIFIER function_args type function_block
  public static boolean function_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition")) return false;
    if (!nextTokenIs(b, "<function definition>", EXPORT_KW, FN_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEFINITION, "<function definition>");
    r = function_definition_0(b, l + 1);
    r = r && consumeTokens(b, 1, FN_KW, IDENTIFIER);
    p = r; // pin = 2
    r = r && report_error_(b, function_args(b, l + 1));
    r = p && report_error_(b, type(b, l + 1)) && r;
    r = p && function_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // EXPORT_KW?
  private static boolean function_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_0")) return false;
    consumeToken(b, EXPORT_KW);
    return true;
  }

  /* ********************************************************** */
  // USE_KW import_path EOS
  public static boolean import_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_decl")) return false;
    if (!nextTokenIs(b, USE_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_DECL, null);
    r = consumeToken(b, USE_KW);
    p = r; // pin = 1
    r = r && report_error_(b, import_path(b, l + 1));
    r = p && consumeToken(b, EOS) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IDENTIFIER (SCOPE IDENTIFIER)*
  public static boolean import_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_path")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && import_path_1(b, l + 1);
    exit_section_(b, m, IMPORT_PATH, r);
    return r;
  }

  // (SCOPE IDENTIFIER)*
  private static boolean import_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_path_1", c)) break;
    }
    return true;
  }

  // SCOPE IDENTIFIER
  private static boolean import_path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SCOPE, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // exclusive_or_expression INCLUSIVE_OR inclusive_or_expression* | exclusive_or_expression
  static boolean inclusive_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusive_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inclusive_or_expression_0(b, l + 1);
    if (!r) r = exclusive_or_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // exclusive_or_expression INCLUSIVE_OR inclusive_or_expression*
  private static boolean inclusive_or_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusive_or_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exclusive_or_expression(b, l + 1);
    r = r && consumeToken(b, INCLUSIVE_OR);
    r = r && inclusive_or_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inclusive_or_expression*
  private static boolean inclusive_or_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusive_or_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inclusive_or_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inclusive_or_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // postfix_expression LB expression RB
  public static boolean indexing_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexing_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDEXING_EXPRESSION, "<indexing expression>");
    r = postfix_expression(b, l + 1);
    r = r && consumeToken(b, LB);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RB);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DECIMAL_DIGITS integer_suffix?
  public static boolean integer_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_constant")) return false;
    if (!nextTokenIs(b, DECIMAL_DIGITS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DECIMAL_DIGITS);
    r = r && integer_constant_1(b, l + 1);
    exit_section_(b, m, INTEGER_CONSTANT, r);
    return r;
  }

  // integer_suffix?
  private static boolean integer_constant_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_constant_1")) return false;
    integer_suffix(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "i" | "u" | "z" | "i8" | "i16" | "i32" | "i64" | "u8" | "u16" | "u32" | "u64"
  public static boolean integer_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_suffix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_SUFFIX, "<integer suffix>");
    r = consumeToken(b, "i");
    if (!r) r = consumeToken(b, "u");
    if (!r) r = consumeToken(b, "z");
    if (!r) r = consumeToken(b, "i8");
    if (!r) r = consumeToken(b, "i16");
    if (!r) r = consumeToken(b, "i32");
    if (!r) r = consumeToken(b, "i64");
    if (!r) r = consumeToken(b, "u8");
    if (!r) r = consumeToken(b, "u16");
    if (!r) r = consumeToken(b, "u32");
    if (!r) r = consumeToken(b, "u64");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // equality_expression LOGICAL_AND logical_and_expression* | equality_expression
  static boolean logical_and_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logical_and_expression_0(b, l + 1);
    if (!r) r = equality_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // equality_expression LOGICAL_AND logical_and_expression*
  private static boolean logical_and_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equality_expression(b, l + 1);
    r = r && consumeToken(b, LOGICAL_AND);
    r = r && logical_and_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logical_and_expression*
  private static boolean logical_and_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_and_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_and_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // logical_xor_expression LOGICAL_OR logical_or_expression* | logical_xor_expression
  static boolean logical_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logical_or_expression_0(b, l + 1);
    if (!r) r = logical_xor_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logical_xor_expression LOGICAL_OR logical_or_expression*
  private static boolean logical_or_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logical_xor_expression(b, l + 1);
    r = r && consumeToken(b, LOGICAL_OR);
    r = r && logical_or_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logical_or_expression*
  private static boolean logical_or_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_or_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_or_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // logical_and_expression LOGICAL_XOR logical_xor_expression* |logical_and_expression
  static boolean logical_xor_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_xor_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logical_xor_expression_0(b, l + 1);
    if (!r) r = logical_and_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logical_and_expression LOGICAL_XOR logical_xor_expression*
  private static boolean logical_xor_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_xor_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logical_and_expression(b, l + 1);
    r = r && consumeToken(b, LOGICAL_XOR);
    r = r && logical_xor_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logical_xor_expression*
  private static boolean logical_xor_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_xor_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_xor_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_xor_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // cast_expression multiplicative_operator multiplicative_expression+ | cast_expression
  static boolean multiplicative_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicative_expression_0(b, l + 1);
    if (!r) r = cast_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // cast_expression multiplicative_operator multiplicative_expression+
  private static boolean multiplicative_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cast_expression(b, l + 1);
    r = r && multiplicative_operator(b, l + 1);
    r = r && multiplicative_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // multiplicative_expression+
  private static boolean multiplicative_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicative_expression(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!multiplicative_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicative_expression_0_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MULTIPLIES | DIVIDES | MODULUS
  static boolean multiplicative_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_operator")) return false;
    boolean r;
    r = consumeToken(b, MULTIPLIES);
    if (!r) r = consumeToken(b, DIVIDES);
    if (!r) r = consumeToken(b, MODULUS);
    return r;
  }

  /* ********************************************************** */
  // plan_expression | LP expression RP
  static boolean nested_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = plan_expression(b, l + 1);
    if (!r) r = nested_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LP expression RP
  private static boolean nested_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | indexing_expression
  public static boolean object_selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_selector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_SELECTOR, "<object selector>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = indexing_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER COLON type
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // parameter COMMA parameter_list* | parameter
  public static boolean parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_list_0(b, l + 1);
    if (!r) r = parameter(b, l + 1);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // parameter COMMA parameter_list*
  private static boolean parameter_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && parameter_list_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // parameter_list*
  private static boolean parameter_list_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameter_list(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter_list_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER | constant
  public static boolean plan_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plan_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PLAN_EXPRESSION, "<plan expression>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = constant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nested_expression | indexing_expression
  static boolean postfix_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression")) return false;
    boolean r;
    r = nested_expression(b, l + 1);
    if (!r) r = indexing_expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // additive_expression shift_operator shift_expression* | additive_expression
  static boolean shift_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shift_expression_0(b, l + 1);
    if (!r) r = additive_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // additive_expression shift_operator shift_expression*
  private static boolean shift_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additive_expression(b, l + 1);
    r = r && shift_operator(b, l + 1);
    r = r && shift_expression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shift_expression*
  private static boolean shift_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expression_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!shift_expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shift_expression_0_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LEFT_SHIFT | RIGHT_SHIFT
  static boolean shift_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_operator")) return false;
    if (!nextTokenIs(b, "", LEFT_SHIFT, RIGHT_SHIFT)) return false;
    boolean r;
    r = consumeToken(b, LEFT_SHIFT);
    if (!r) r = consumeToken(b, RIGHT_SHIFT);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean string_const(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_const")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, STRING_CONST, r);
    return r;
  }

  /* ********************************************************** */
  // import_decl* function_definition*
  static boolean translation_unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = translation_unit_0(b, l + 1);
    r = r && translation_unit_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // import_decl*
  private static boolean translation_unit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "translation_unit_0", c)) break;
    }
    return true;
  }

  // function_definition*
  private static boolean translation_unit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "translation_unit_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // buildin_type
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = buildin_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // buildin_expression
  static boolean unary_expression(PsiBuilder b, int l) {
    return buildin_expression(b, l + 1);
  }

}
