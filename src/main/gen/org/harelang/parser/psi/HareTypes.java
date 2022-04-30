// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface HareTypes {

  IElementType IMPORT_DECL = new HareElementType("IMPORT_DECL");
  IElementType IMPORT_PATH = new HareElementType("IMPORT_PATH");

  IElementType EOS = new HareTokenType("EOS");
  IElementType IDENTIFIER = new HareTokenType("IDENTIFIER");
  IElementType SCOPE = new HareTokenType("SCOPE");
  IElementType USE_KW = new HareTokenType("USE_KW");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == IMPORT_DECL) {
        return new HareImportDeclImpl(node);
      }
      else if (type == IMPORT_PATH) {
        return new HareImportPathImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
