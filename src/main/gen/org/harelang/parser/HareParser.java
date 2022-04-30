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
  // void | i8 | i16 | i32 | i64 | u8 | u16 | u32 | u64 | int | uint | size | uintptr | char
  public static boolean buildin_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "buildin_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILDIN_TYPE, "<buildin type>");
    r = consumeToken(b, VOID);
    if (!r) r = consumeToken(b, I8);
    if (!r) r = consumeToken(b, I16);
    if (!r) r = consumeToken(b, I32);
    if (!r) r = consumeToken(b, I64);
    if (!r) r = consumeToken(b, U8);
    if (!r) r = consumeToken(b, U16);
    if (!r) r = consumeToken(b, U32);
    if (!r) r = consumeToken(b, U64);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, UINT);
    if (!r) r = consumeToken(b, SIZE);
    if (!r) r = consumeToken(b, UINTPTR);
    if (!r) r = consumeToken(b, CHAR);
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
  // LBR RBR
  public static boolean function_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_block")) return false;
    if (!nextTokenIs(b, LBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBR, RBR);
    exit_section_(b, m, FUNCTION_BLOCK, r);
    return r;
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

}
