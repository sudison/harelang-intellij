// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class HareVisitor extends PsiElementVisitor {

  public void visitImportDecl(@NotNull HareImportDecl o) {
    visitPsiElement(o);
  }

  public void visitImportPath(@NotNull HareImportPath o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
