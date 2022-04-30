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
  // import_decl*
  static boolean translation_unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translation_unit")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "translation_unit", c)) break;
    }
    return true;
  }

}
