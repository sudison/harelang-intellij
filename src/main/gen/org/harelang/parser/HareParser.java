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
  // multiplicative_expression (additive_operator multiplicative_expression)*
  static boolean additive_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicative_expression(b, l + 1);
    r = r && additive_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (additive_operator multiplicative_expression)*
  private static boolean additive_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additive_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additive_expression_1", c)) break;
    }
    return true;
  }

  // additive_operator multiplicative_expression
  private static boolean additive_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additive_operator(b, l + 1);
    r = r && multiplicative_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // identifier_path
  public static boolean alias_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_path(b, l + 1);
    exit_section_(b, m, ALIAS_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // shift_expression (AND shift_expression)*
  static boolean and_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shift_expression(b, l + 1);
    r = r && and_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (AND shift_expression)*
  private static boolean and_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!and_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "and_expression_1", c)) break;
    }
    return true;
  }

  // AND shift_expression
  private static boolean and_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && shift_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression DOTDOTDOT  | expression COMMA argument_list | expression
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = argument_list_0(b, l + 1);
    if (!r) r = argument_list_1(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression DOTDOTDOT
  private static boolean argument_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, DOTDOTDOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression COMMA argument_list
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && argument_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LB array_members RB
  public static boolean array_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal")) return false;
    if (!nextTokenIs(b, LB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LB);
    r = r && array_members(b, l + 1);
    r = r && consumeToken(b, RB);
    exit_section_(b, m, ARRAY_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // expression DOTDOTDOT | expression COMMA array_members | expression
  public static boolean array_members(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_members")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_MEMBERS, "<array members>");
    r = array_members_0(b, l + 1);
    if (!r) r = array_members_1(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression DOTDOTDOT
  private static boolean array_members_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_members_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, DOTDOTDOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression COMMA array_members
  private static boolean array_members_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_members_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && array_members(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // binding (COMMA binding)*
  public static boolean bindings(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindings")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding(b, l + 1);
    r = r && bindings_1(b, l + 1);
    exit_section_(b, m, BINDINGS, r);
    return r;
  }

  // (COMMA binding)*
  private static boolean bindings_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindings_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bindings_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bindings_1", c)) break;
    }
    return true;
  }

  // COMMA binding
  private static boolean bindings_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindings_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && binding(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // postfix_expression
  static boolean buildin_expression(PsiBuilder b, int l) {
    return postfix_expression(b, l + 1);
  }

  /* ********************************************************** */
  // LP argument_list? RP
  public static boolean call_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_op")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && call_op_1(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, CALL_OP, r);
    return r;
  }

  // argument_list?
  private static boolean call_op_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_op_1")) return false;
    argument_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // unary_expression
  static boolean cast_expression(PsiBuilder b, int l) {
    return unary_expression(b, l + 1);
  }

  /* ********************************************************** */
  // inclusive_or_expression (comparison_operator inclusive_or_expression)*
  static boolean comparison_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inclusive_or_expression(b, l + 1);
    r = r && comparison_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comparison_operator inclusive_or_expression)*
  private static boolean comparison_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comparison_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "comparison_expression_1", c)) break;
    }
    return true;
  }

  // comparison_operator inclusive_or_expression
  private static boolean comparison_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comparison_operator(b, l + 1);
    r = r && inclusive_or_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // LBR expression_list RBR
  public static boolean compound_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_expression")) return false;
    if (!nextTokenIs(b, LBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBR);
    r = r && expression_list(b, l + 1);
    r = r && consumeToken(b, RBR);
    exit_section_(b, m, COMPOUND_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // LP expression RP expression
  public static boolean conditional_branch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_branch")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && expression(b, l + 1);
    exit_section_(b, m, CONDITIONAL_BRANCH, r);
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
  // identifier_path COLON type ASSIGN expression
  public static boolean constant_binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_binding")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_path(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, CONSTANT_BINDING, r);
    return r;
  }

  /* ********************************************************** */
  // constant_binding (COMMA constant_binding)*
  public static boolean constant_bindings(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_bindings")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = constant_binding(b, l + 1);
    r = r && constant_bindings_1(b, l + 1);
    exit_section_(b, m, CONSTANT_BINDINGS, r);
    return r;
  }

  // (COMMA constant_binding)*
  private static boolean constant_bindings_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_bindings_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constant_bindings_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "constant_bindings_1", c)) break;
    }
    return true;
  }

  // COMMA constant_binding
  private static boolean constant_bindings_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_bindings_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && constant_binding(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEF_KW constant_bindings
  public static boolean constant_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_declaration")) return false;
    if (!nextTokenIs(b, DEF_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEF_KW);
    r = r && constant_bindings(b, l + 1);
    exit_section_(b, m, CONSTANT_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // function_declaration | global_declaration | constant_declaration | type_declaration
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = function_declaration(b, l + 1);
    if (!r) r = global_declaration(b, l + 1);
    if (!r) r = constant_declaration(b, l + 1);
    if (!r) r = type_declaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (EXPORT_KW? declaration EOS)+
  public static boolean declarations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declarations")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATIONS, "<declarations>");
    r = declarations_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!declarations_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "declarations", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EXPORT_KW? declaration EOS
  private static boolean declarations_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declarations_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = declarations_0_0(b, l + 1);
    r = r && declaration(b, l + 1);
    r = r && consumeToken(b, EOS);
    exit_section_(b, m, null, r);
    return r;
  }

  // EXPORT_KW?
  private static boolean declarations_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declarations_0_0")) return false;
    consumeToken(b, EXPORT_KW);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER (SCOPE IDENTIFIER)+
  public static boolean enum_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_literal")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && enum_literal_1(b, l + 1);
    exit_section_(b, m, ENUM_LITERAL, r);
    return r;
  }

  // (SCOPE IDENTIFIER)+
  private static boolean enum_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_literal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_literal_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!enum_literal_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_literal_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // SCOPE IDENTIFIER
  private static boolean enum_literal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_literal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SCOPE, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // integer_type | RUNE_KW
  public static boolean enum_storage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_storage")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_STORAGE, "<enum storage>");
    r = integer_type(b, l + 1);
    if (!r) r = consumeToken(b, RUNE_KW);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENUM_KW enum_storage? LBR enum_values RBR
  public static boolean enum_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type")) return false;
    if (!nextTokenIs(b, ENUM_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM_KW);
    r = r && enum_type_1(b, l + 1);
    r = r && consumeToken(b, LBR);
    r = r && enum_values(b, l + 1);
    r = r && consumeToken(b, RBR);
    exit_section_(b, m, ENUM_TYPE, r);
    return r;
  }

  // enum_storage?
  private static boolean enum_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_type_1")) return false;
    enum_storage(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER ASSIGN expression | IDENTIFIER
  public static boolean enum_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_value_0(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ENUM_VALUE, r);
    return r;
  }

  // IDENTIFIER ASSIGN expression
  private static boolean enum_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // enum_value (COMMA enum_value)*
  public static boolean enum_values(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_values")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_value(b, l + 1);
    r = r && enum_values_1(b, l + 1);
    exit_section_(b, m, ENUM_VALUES, r);
    return r;
  }

  // (COMMA enum_value)*
  private static boolean enum_values_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_values_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_values_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_values_1", c)) break;
    }
    return true;
  }

  // COMMA enum_value
  private static boolean enum_values_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_values_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enum_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // comparison_expression (equality_operator comparison_expression)*
  static boolean equality_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comparison_expression(b, l + 1);
    r = r && equality_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (equality_operator comparison_expression)*
  private static boolean equality_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!equality_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "equality_expression_1", c)) break;
    }
    return true;
  }

  // equality_operator comparison_expression
  private static boolean equality_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equality_operator(b, l + 1);
    r = r && comparison_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // QUESTION | BANG
  public static boolean error_propagation_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_propagation_op")) return false;
    if (!nextTokenIs(b, "<error propagation op>", BANG, QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ERROR_PROPAGATION_OP, "<error propagation op>");
    r = consumeToken(b, QUESTION);
    if (!r) r = consumeToken(b, BANG);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // and_expression (EXCLUSIVE_OR and_expression)*
  static boolean exclusive_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusive_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = and_expression(b, l + 1);
    r = r && exclusive_or_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EXCLUSIVE_OR and_expression)*
  private static boolean exclusive_or_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusive_or_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!exclusive_or_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exclusive_or_expression_1", c)) break;
    }
    return true;
  }

  // EXCLUSIVE_OR and_expression
  private static boolean exclusive_or_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusive_or_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXCLUSIVE_OR);
    r = r && and_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assignment | binding_list | logical_or_expression | if_expression | for_loop
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = assignment(b, l + 1);
    if (!r) r = binding_list(b, l + 1);
    if (!r) r = logical_or_expression(b, l + 1);
    if (!r) r = if_expression(b, l + 1);
    if (!r) r = for_loop(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (expression EOS)+
  public static boolean expression_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_LIST, "<expression list>");
    r = expression_list_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!expression_list_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_list", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression EOS
  private static boolean expression_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, EOS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOT IDENTIFIER | DOT integer_constant
  public static boolean field_access_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_access_op")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, DOT, IDENTIFIER);
    if (!r) r = field_access_op_1(b, l + 1);
    exit_section_(b, m, FIELD_ACCESS_OP, r);
    return r;
  }

  // DOT integer_constant
  private static boolean field_access_op_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_access_op_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && integer_constant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // struct_literal | IDENTIFIER (COLON type)? ASSIGN expression
  public static boolean field_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_value")) return false;
    if (!nextTokenIs(b, "<field value>", IDENTIFIER, STRUCT_KW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_VALUE, "<field value>");
    r = struct_literal(b, l + 1);
    if (!r) r = field_value_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER (COLON type)? ASSIGN expression
  private static boolean field_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_value_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && field_value_1_1(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON type)?
  private static boolean field_value_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_value_1_1")) return false;
    field_value_1_1_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean field_value_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_value_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // field_value (COMMA field_value)*
  public static boolean field_values(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_values")) return false;
    if (!nextTokenIs(b, "<field values>", IDENTIFIER, STRUCT_KW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_VALUES, "<field values>");
    r = field_value(b, l + 1);
    r = r && field_values_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA field_value)*
  private static boolean field_values_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_values_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field_values_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_values_1", c)) break;
    }
    return true;
  }

  // COMMA field_value
  private static boolean field_values_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_values_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && field_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // F32_TYPE | F64_TYPE
  public static boolean floating_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floating_type")) return false;
    if (!nextTokenIs(b, "<floating type>", F32_TYPE, F64_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLOATING_TYPE, "<floating type>");
    r = consumeToken(b, F32_TYPE);
    if (!r) r = consumeToken(b, F64_TYPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FOR_KW LP for_predicate RP expression
  public static boolean for_loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop")) return false;
    if (!nextTokenIs(b, FOR_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR_KW, LP);
    r = r && for_predicate(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && expression(b, l + 1);
    exit_section_(b, m, FOR_LOOP, r);
    return r;
  }

  /* ********************************************************** */
  // binding_list EOS expression EOS expression | binding_list EOS expression | expression EOS expression | expression
  public static boolean for_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_PREDICATE, "<for predicate>");
    r = for_predicate_0(b, l + 1);
    if (!r) r = for_predicate_1(b, l + 1);
    if (!r) r = for_predicate_2(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // binding_list EOS expression EOS expression
  private static boolean for_predicate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_predicate_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding_list(b, l + 1);
    r = r && consumeToken(b, EOS);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, EOS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // binding_list EOS expression
  private static boolean for_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_predicate_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding_list(b, l + 1);
    r = r && consumeToken(b, EOS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression EOS expression
  private static boolean for_predicate_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_predicate_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, EOS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FN_KW identifier_path prototype (ASSIGN expression)?
  public static boolean function_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration")) return false;
    if (!nextTokenIs(b, FN_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, null);
    r = consumeToken(b, FN_KW);
    p = r; // pin = 1
    r = r && report_error_(b, identifier_path(b, l + 1));
    r = p && report_error_(b, prototype(b, l + 1)) && r;
    r = p && function_declaration_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (ASSIGN expression)?
  private static boolean function_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_3")) return false;
    function_declaration_3_0(b, l + 1);
    return true;
  }

  // ASSIGN expression
  private static boolean function_declaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FN_KW prototype
  public static boolean function_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_type")) return false;
    if (!nextTokenIs(b, FN_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FN_KW);
    r = r && prototype(b, l + 1);
    exit_section_(b, m, FUNCTION_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // identifier_path COLON type (ASSIGN expression)?
  public static boolean global_binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_binding")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_path(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    r = r && global_binding_3(b, l + 1);
    exit_section_(b, m, GLOBAL_BINDING, r);
    return r;
  }

  // (ASSIGN expression)?
  private static boolean global_binding_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_binding_3")) return false;
    global_binding_3_0(b, l + 1);
    return true;
  }

  // ASSIGN expression
  private static boolean global_binding_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_binding_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // global_binding (COMMA global_binding)*
  public static boolean global_bindings(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_bindings")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = global_binding(b, l + 1);
    r = r && global_bindings_1(b, l + 1);
    exit_section_(b, m, GLOBAL_BINDINGS, r);
    return r;
  }

  // (COMMA global_binding)*
  private static boolean global_bindings_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_bindings_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!global_bindings_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "global_bindings_1", c)) break;
    }
    return true;
  }

  // COMMA global_binding
  private static boolean global_bindings_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_bindings_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && global_binding(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LET_KW global_bindings | CONST_KW global_bindings
  public static boolean global_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_declaration")) return false;
    if (!nextTokenIs(b, "<global declaration>", CONST_KW, LET_KW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_DECLARATION, "<global declaration>");
    r = global_declaration_0(b, l + 1);
    if (!r) r = global_declaration_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LET_KW global_bindings
  private static boolean global_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_declaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET_KW);
    r = r && global_bindings(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CONST_KW global_bindings
  private static boolean global_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_declaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONST_KW);
    r = r && global_bindings(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (SCOPE IDENTIFIER)*
  public static boolean identifier_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_path")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && identifier_path_1(b, l + 1);
    exit_section_(b, m, IDENTIFIER_PATH, r);
    return r;
  }

  // (SCOPE IDENTIFIER)*
  private static boolean identifier_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier_path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifier_path_1", c)) break;
    }
    return true;
  }

  // SCOPE IDENTIFIER
  private static boolean identifier_path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SCOPE, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF_KW conditional_branch | IF_KW conditional_branch ELSE_KW if_expression | IF_KW conditional_branch ELSE_KW expression
  public static boolean if_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expression")) return false;
    if (!nextTokenIs(b, IF_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_expression_0(b, l + 1);
    if (!r) r = if_expression_1(b, l + 1);
    if (!r) r = if_expression_2(b, l + 1);
    exit_section_(b, m, IF_EXPRESSION, r);
    return r;
  }

  // IF_KW conditional_branch
  private static boolean if_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_KW);
    r = r && conditional_branch(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IF_KW conditional_branch ELSE_KW if_expression
  private static boolean if_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_KW);
    r = r && conditional_branch(b, l + 1);
    r = r && consumeToken(b, ELSE_KW);
    r = r && if_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IF_KW conditional_branch ELSE_KW expression
  private static boolean if_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_KW);
    r = r && conditional_branch(b, l + 1);
    r = r && consumeToken(b, ELSE_KW);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ASSIGN
  public static boolean import_alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_alias")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ASSIGN);
    exit_section_(b, m, IMPORT_ALIAS, r);
    return r;
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
  // (use_statement_member_list | use_statement)+
  public static boolean imports(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports")) return false;
    if (!nextTokenIs(b, USE_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = imports_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!imports_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "imports", c)) break;
    }
    exit_section_(b, m, IMPORTS, r);
    return r;
  }

  // use_statement_member_list | use_statement
  private static boolean imports_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports_0")) return false;
    boolean r;
    r = use_statement_member_list(b, l + 1);
    if (!r) r = use_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // exclusive_or_expression (INCLUSIVE_OR exclusive_or_expression)*
  static boolean inclusive_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusive_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exclusive_or_expression(b, l + 1);
    r = r && inclusive_or_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INCLUSIVE_OR exclusive_or_expression)*
  private static boolean inclusive_or_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusive_or_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inclusive_or_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inclusive_or_expression_1", c)) break;
    }
    return true;
  }

  // INCLUSIVE_OR exclusive_or_expression
  private static boolean inclusive_or_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusive_or_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INCLUSIVE_OR);
    r = r && exclusive_or_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // LB expression RB
  public static boolean indexing_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexing_op")) return false;
    if (!nextTokenIs(b, LB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LB);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RB);
    exit_section_(b, m, INDEXING_OP, r);
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
  // I8_TYPE | I16_TYPE | I32_TYPE | I64_TYPE | U8_TYPE | U16_TYPE | U32_TYPE | U64_TYPE | INT_TYPE | UINT_TYPE | SIZE_TYPE | UINTPTR_TYPE | CHAR_TYPE
  public static boolean integer_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_TYPE, "<integer type>");
    r = consumeToken(b, I8_TYPE);
    if (!r) r = consumeToken(b, I16_TYPE);
    if (!r) r = consumeToken(b, I32_TYPE);
    if (!r) r = consumeToken(b, I64_TYPE);
    if (!r) r = consumeToken(b, U8_TYPE);
    if (!r) r = consumeToken(b, U16_TYPE);
    if (!r) r = consumeToken(b, U32_TYPE);
    if (!r) r = consumeToken(b, U64_TYPE);
    if (!r) r = consumeToken(b, INT_TYPE);
    if (!r) r = consumeToken(b, UINT_TYPE);
    if (!r) r = consumeToken(b, SIZE_TYPE);
    if (!r) r = consumeToken(b, UINTPTR_TYPE);
    if (!r) r = consumeToken(b, CHAR_TYPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // equality_expression (LOGICAL_AND equality_expression)*
  static boolean logical_and_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equality_expression(b, l + 1);
    r = r && logical_and_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LOGICAL_AND equality_expression)*
  private static boolean logical_and_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_and_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_and_expression_1", c)) break;
    }
    return true;
  }

  // LOGICAL_AND equality_expression
  private static boolean logical_and_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_and_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOGICAL_AND);
    r = r && equality_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logical_xor_expression (LOGICAL_OR logical_xor_expression)*
  static boolean logical_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logical_xor_expression(b, l + 1);
    r = r && logical_or_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LOGICAL_OR logical_xor_expression)*
  private static boolean logical_or_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_or_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_or_expression_1", c)) break;
    }
    return true;
  }

  // LOGICAL_OR logical_xor_expression
  private static boolean logical_or_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_or_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOGICAL_OR);
    r = r && logical_xor_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logical_and_expression (LOGICAL_XOR logical_and_expression)*
  static boolean logical_xor_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_xor_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logical_and_expression(b, l + 1);
    r = r && logical_xor_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LOGICAL_XOR logical_and_expression)*
  private static boolean logical_xor_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_xor_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logical_xor_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_xor_expression_1", c)) break;
    }
    return true;
  }

  // LOGICAL_XOR logical_and_expression
  private static boolean logical_xor_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_xor_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOGICAL_XOR);
    r = r && logical_and_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ASSIGN IDENTIFIER | IDENTIFIER
  public static boolean member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, IDENTIFIER, ASSIGN, IDENTIFIER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MEMBER, r);
    return r;
  }

  /* ********************************************************** */
  // member (COMMA member)*
  public static boolean member_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_list")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = member(b, l + 1);
    r = r && member_list_1(b, l + 1);
    exit_section_(b, m, MEMBER_LIST, r);
    return r;
  }

  // (COMMA member)*
  private static boolean member_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!member_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "member_list_1", c)) break;
    }
    return true;
  }

  // COMMA member
  private static boolean member_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && member(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // cast_expression (multiplicative_operator cast_expression)*
  static boolean multiplicative_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cast_expression(b, l + 1);
    r = r && multiplicative_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (multiplicative_operator cast_expression)*
  private static boolean multiplicative_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplicative_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicative_expression_1", c)) break;
    }
    return true;
  }

  // multiplicative_operator cast_expression
  private static boolean multiplicative_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicative_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicative_operator(b, l + 1);
    r = r && cast_expression(b, l + 1);
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
  // plan_expression | LP tuple_items RP | LP expression RP
  static boolean nested_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = plan_expression(b, l + 1);
    if (!r) r = nested_expression_1(b, l + 1);
    if (!r) r = nested_expression_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LP tuple_items RP
  private static boolean nested_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && tuple_items(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, null, r);
    return r;
  }

  // LP expression RP
  private static boolean nested_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nested_expression_2")) return false;
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
  // (IDENTIFIER | UNDERSCORE) COLON type
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, "<parameter>", IDENTIFIER, UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = parameter_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER | UNDERSCORE
  private static boolean parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, UNDERSCORE);
    return r;
  }

  /* ********************************************************** */
  // parameters COMMA? DOTDOTDOT?
  public static boolean parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list")) return false;
    if (!nextTokenIs(b, "<parameter list>", IDENTIFIER, UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, "<parameter list>");
    r = parameters(b, l + 1);
    r = r && parameter_list_1(b, l + 1);
    r = r && parameter_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA?
  private static boolean parameter_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // DOTDOTDOT?
  private static boolean parameter_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_2")) return false;
    consumeToken(b, DOTDOTDOT);
    return true;
  }

  /* ********************************************************** */
  // parameter (COMMA parameter)*
  public static boolean parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters")) return false;
    if (!nextTokenIs(b, "<parameters>", IDENTIFIER, UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETERS, "<parameters>");
    r = parameter(b, l + 1);
    r = r && parameters_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA parameter)*
  private static boolean parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_1", c)) break;
    }
    return true;
  }

  // COMMA parameter
  private static boolean parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // enum_literal | struct_literal | IDENTIFIER | constant | array_literal
  public static boolean plan_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plan_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PLAN_EXPRESSION, "<plan expression>");
    r = enum_literal(b, l + 1);
    if (!r) r = struct_literal(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = constant(b, l + 1);
    if (!r) r = array_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NULLABLE_KW? MULTIPLIES type
  public static boolean pointer_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pointer_type")) return false;
    if (!nextTokenIs(b, "<pointer type>", MULTIPLIES, NULLABLE_KW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POINTER_TYPE, "<pointer type>");
    r = pointer_type_0(b, l + 1);
    r = r && consumeToken(b, MULTIPLIES);
    r = r && type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NULLABLE_KW?
  private static boolean pointer_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pointer_type_0")) return false;
    consumeToken(b, NULLABLE_KW);
    return true;
  }

  /* ********************************************************** */
  // nested_expression postfix_op*
  static boolean postfix_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nested_expression(b, l + 1);
    r = r && postfix_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // postfix_op*
  private static boolean postfix_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!postfix_op(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "postfix_expression_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // field_access_op | slicing_op | indexing_op | call_op | error_propagation_op
  public static boolean postfix_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIX_OP, "<postfix op>");
    r = field_access_op(b, l + 1);
    if (!r) r = slicing_op(b, l + 1);
    if (!r) r = indexing_op(b, l + 1);
    if (!r) r = call_op(b, l + 1);
    if (!r) r = error_propagation_op(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LP parameter_list? RP type
  public static boolean prototype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prototype")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && prototype_1(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && type(b, l + 1);
    exit_section_(b, m, PROTOTYPE, r);
    return r;
  }

  // parameter_list?
  private static boolean prototype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prototype_1")) return false;
    parameter_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // integer_type | floating_type | enum_type  | pointer_type | RUNE_KW | BOOL_TYPE | VALIST_TYPE |  VOID_TYPE
  public static boolean scala_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scala_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCALA_TYPE, "<scala type>");
    r = integer_type(b, l + 1);
    if (!r) r = floating_type(b, l + 1);
    if (!r) r = enum_type(b, l + 1);
    if (!r) r = pointer_type(b, l + 1);
    if (!r) r = consumeToken(b, RUNE_KW);
    if (!r) r = consumeToken(b, BOOL_TYPE);
    if (!r) r = consumeToken(b, VALIST_TYPE);
    if (!r) r = consumeToken(b, VOID_TYPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // additive_expression (shift_operator additive_expression)*
  static boolean shift_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additive_expression(b, l + 1);
    r = r && shift_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (shift_operator additive_expression)*
  private static boolean shift_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!shift_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shift_expression_1", c)) break;
    }
    return true;
  }

  // shift_operator additive_expression
  private static boolean shift_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shift_operator(b, l + 1);
    r = r && additive_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // LB (expression | MULTIPLIES | UNDERSCORE)? RB type
  public static boolean slice_array_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_array_type")) return false;
    if (!nextTokenIs(b, LB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LB);
    r = r && slice_array_type_1(b, l + 1);
    r = r && consumeToken(b, RB);
    r = r && type(b, l + 1);
    exit_section_(b, m, SLICE_ARRAY_TYPE, r);
    return r;
  }

  // (expression | MULTIPLIES | UNDERSCORE)?
  private static boolean slice_array_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_array_type_1")) return false;
    slice_array_type_1_0(b, l + 1);
    return true;
  }

  // expression | MULTIPLIES | UNDERSCORE
  private static boolean slice_array_type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_array_type_1_0")) return false;
    boolean r;
    r = expression(b, l + 1);
    if (!r) r = consumeToken(b, MULTIPLIES);
    if (!r) r = consumeToken(b, UNDERSCORE);
    return r;
  }

  /* ********************************************************** */
  // LB expression? DOTDOT expression? RB
  public static boolean slicing_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slicing_op")) return false;
    if (!nextTokenIs(b, LB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LB);
    r = r && slicing_op_1(b, l + 1);
    r = r && consumeToken(b, DOTDOT);
    r = r && slicing_op_3(b, l + 1);
    r = r && consumeToken(b, RB);
    exit_section_(b, m, SLICING_OP, r);
    return r;
  }

  // expression?
  private static boolean slicing_op_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slicing_op_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // expression?
  private static boolean slicing_op_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slicing_op_3")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // scala_type | struct_union_type | tuple_type | tagged_union_type | slice_array_type | function_type | alias_type | unwrapped_alias | STR_TYPE
  public static boolean storage_class(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storage_class")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STORAGE_CLASS, "<storage class>");
    r = scala_type(b, l + 1);
    if (!r) r = struct_union_type(b, l + 1);
    if (!r) r = tuple_type(b, l + 1);
    if (!r) r = tagged_union_type(b, l + 1);
    if (!r) r = slice_array_type(b, l + 1);
    if (!r) r = function_type(b, l + 1);
    if (!r) r = alias_type(b, l + 1);
    if (!r) r = unwrapped_alias(b, l + 1);
    if (!r) r = consumeToken(b, STR_TYPE);
    exit_section_(b, l, m, r, false, null);
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
  // field_values (COMMA DOTDOTDOT)? | DOTDOTDOT
  public static boolean struct_initializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_initializer")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_INITIALIZER, "<struct initializer>");
    r = struct_initializer_0(b, l + 1);
    if (!r) r = consumeToken(b, DOTDOTDOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // field_values (COMMA DOTDOTDOT)?
  private static boolean struct_initializer_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_initializer_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_values(b, l + 1);
    r = r && struct_initializer_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA DOTDOTDOT)?
  private static boolean struct_initializer_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_initializer_0_1")) return false;
    struct_initializer_0_1_0(b, l + 1);
    return true;
  }

  // COMMA DOTDOTDOT
  private static boolean struct_initializer_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_initializer_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, DOTDOTDOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRUCT_KW LBR field_values RBR | IDENTIFIER LBR struct_initializer RBR
  public static boolean struct_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_literal")) return false;
    if (!nextTokenIs(b, "<struct literal>", IDENTIFIER, STRUCT_KW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_LITERAL, "<struct literal>");
    r = struct_literal_0(b, l + 1);
    if (!r) r = struct_literal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRUCT_KW LBR field_values RBR
  private static boolean struct_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_literal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STRUCT_KW, LBR);
    r = r && field_values(b, l + 1);
    r = r && consumeToken(b, RBR);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER LBR struct_initializer RBR
  private static boolean struct_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_literal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, LBR);
    r = r && struct_initializer(b, l + 1);
    r = r && consumeToken(b, RBR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER COLON type | struct_union_type | identifier_path
  public static boolean struct_union_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_union_field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_UNION_FIELD, "<struct union field>");
    r = struct_union_field_0(b, l + 1);
    if (!r) r = struct_union_type(b, l + 1);
    if (!r) r = identifier_path(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER COLON type
  private static boolean struct_union_field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_union_field_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // struct_union_field (COMMA struct_union_field)*
  public static boolean struct_union_fields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_union_fields")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_UNION_FIELDS, "<struct union fields>");
    r = struct_union_field(b, l + 1);
    r = r && struct_union_fields_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA struct_union_field)*
  private static boolean struct_union_fields_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_union_fields_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!struct_union_fields_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "struct_union_fields_1", c)) break;
    }
    return true;
  }

  // COMMA struct_union_field
  private static boolean struct_union_fields_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_union_fields_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && struct_union_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (STRUCT_KW | UNION_KW) LBR struct_union_fields RBR
  public static boolean struct_union_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_union_type")) return false;
    if (!nextTokenIs(b, "<struct union type>", STRUCT_KW, UNION_KW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_UNION_TYPE, "<struct union type>");
    r = struct_union_type_0(b, l + 1);
    r = r && consumeToken(b, LBR);
    r = r && struct_union_fields(b, l + 1);
    r = r && consumeToken(b, RBR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRUCT_KW | UNION_KW
  private static boolean struct_union_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_union_type_0")) return false;
    boolean r;
    r = consumeToken(b, STRUCT_KW);
    if (!r) r = consumeToken(b, UNION_KW);
    return r;
  }

  /* ********************************************************** */
  // type (INCLUSIVE_OR type)+
  public static boolean tagged_types(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_types")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAGGED_TYPES, "<tagged types>");
    r = type(b, l + 1);
    r = r && tagged_types_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (INCLUSIVE_OR type)+
  private static boolean tagged_types_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_types_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tagged_types_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!tagged_types_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tagged_types_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // INCLUSIVE_OR type
  private static boolean tagged_types_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_types_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INCLUSIVE_OR);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LP tagged_types RP
  public static boolean tagged_union_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_union_type")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && tagged_types(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, TAGGED_UNION_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // imports* declarations*
  static boolean translation_unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = translation_unit_0(b, l + 1);
    r = r && translation_unit_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // imports*
  private static boolean translation_unit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!imports(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "translation_unit_0", c)) break;
    }
    return true;
  }

  // declarations*
  private static boolean translation_unit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!declarations(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "translation_unit_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expression (COMMA expression)+
  public static boolean tuple_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_items")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_ITEMS, "<tuple items>");
    r = expression(b, l + 1);
    r = r && tuple_items_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA expression)+
  private static boolean tuple_items_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_items_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tuple_items_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!tuple_items_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_items_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA expression
  private static boolean tuple_items_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_items_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LP tuple_types RP
  public static boolean tuple_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_type")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && tuple_types(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, TUPLE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // type (COMMA type)+
  public static boolean tuple_types(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_types")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_TYPES, "<tuple types>");
    r = type(b, l + 1);
    r = r && tuple_types_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA type)+
  private static boolean tuple_types_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_types_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tuple_types_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!tuple_types_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_types_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA type
  private static boolean tuple_types_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_types_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CONST_KW? BANG? storage_class
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = type_0(b, l + 1);
    r = r && type_1(b, l + 1);
    r = r && storage_class(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CONST_KW?
  private static boolean type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_0")) return false;
    consumeToken(b, CONST_KW);
    return true;
  }

  // BANG?
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    consumeToken(b, BANG);
    return true;
  }

  /* ********************************************************** */
  // identifier_path ASSIGN type
  public static boolean type_binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_binding")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_path(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && type(b, l + 1);
    exit_section_(b, m, TYPE_BINDING, r);
    return r;
  }

  /* ********************************************************** */
  // type_binding (COMMA type_binding)*
  public static boolean type_bindings(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_bindings")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_binding(b, l + 1);
    r = r && type_bindings_1(b, l + 1);
    exit_section_(b, m, TYPE_BINDINGS, r);
    return r;
  }

  // (COMMA type_binding)*
  private static boolean type_bindings_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_bindings_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_bindings_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_bindings_1", c)) break;
    }
    return true;
  }

  // COMMA type_binding
  private static boolean type_bindings_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_bindings_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_binding(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE_KW type_bindings
  public static boolean type_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration")) return false;
    if (!nextTokenIs(b, TYPE_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_KW);
    r = r && type_bindings(b, l + 1);
    exit_section_(b, m, TYPE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // buildin_expression | compound_expression
  static boolean unary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression")) return false;
    boolean r;
    r = buildin_expression(b, l + 1);
    if (!r) r = compound_expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // DOTDOTDOT identifier_path
  public static boolean unwrapped_alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unwrapped_alias")) return false;
    if (!nextTokenIs(b, DOTDOTDOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOTDOTDOT);
    r = r && identifier_path(b, l + 1);
    exit_section_(b, m, UNWRAPPED_ALIAS, r);
    return r;
  }

  /* ********************************************************** */
  // USE_KW import_alias* import_path (SCOPE "*")? EOS
  public static boolean use_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_statement")) return false;
    if (!nextTokenIs(b, USE_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USE_STATEMENT, null);
    r = consumeToken(b, USE_KW);
    p = r; // pin = 1
    r = r && report_error_(b, use_statement_1(b, l + 1));
    r = p && report_error_(b, import_path(b, l + 1)) && r;
    r = p && report_error_(b, use_statement_3(b, l + 1)) && r;
    r = p && consumeToken(b, EOS) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // import_alias*
  private static boolean use_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_statement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_alias(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "use_statement_1", c)) break;
    }
    return true;
  }

  // (SCOPE "*")?
  private static boolean use_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_statement_3")) return false;
    use_statement_3_0(b, l + 1);
    return true;
  }

  // SCOPE "*"
  private static boolean use_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCOPE);
    r = r && consumeToken(b, "*");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // USE_KW import_alias* import_path SCOPE LBR member_list RBR EOS
  public static boolean use_statement_member_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_statement_member_list")) return false;
    if (!nextTokenIs(b, USE_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USE_KW);
    r = r && use_statement_member_list_1(b, l + 1);
    r = r && import_path(b, l + 1);
    r = r && consumeTokens(b, 0, SCOPE, LBR);
    r = r && member_list(b, l + 1);
    r = r && consumeTokens(b, 0, RBR, EOS);
    exit_section_(b, m, USE_STATEMENT_MEMBER_LIST, r);
    return r;
  }

  // import_alias*
  private static boolean use_statement_member_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_statement_member_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_alias(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "use_statement_member_list_1", c)) break;
    }
    return true;
  }

}
