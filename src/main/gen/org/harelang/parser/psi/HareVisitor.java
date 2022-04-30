// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class HareVisitor extends PsiElementVisitor {

  public void visitBuildinType(@NotNull HareBuildinType o) {
    visitPsiElement(o);
  }

  public void visitFunctionArgs(@NotNull HareFunctionArgs o) {
    visitPsiElement(o);
  }

  public void visitFunctionBlock(@NotNull HareFunctionBlock o) {
    visitPsiElement(o);
  }

  public void visitFunctionDefinition(@NotNull HareFunctionDefinition o) {
    visitPsiElement(o);
  }

  public void visitImportDecl(@NotNull HareImportDecl o) {
    visitPsiElement(o);
  }

  public void visitImportPath(@NotNull HareImportPath o) {
    visitPsiElement(o);
  }

  public void visitType(@NotNull HareType o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
