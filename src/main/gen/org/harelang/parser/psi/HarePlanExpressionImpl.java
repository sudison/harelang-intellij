// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.harelang.parser.psi.HareTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class HarePlanExpressionImpl extends ASTWrapperPsiElement implements HarePlanExpression {

  public HarePlanExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitPlanExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareArrayLiteral getArrayLiteral() {
    return findChildByClass(HareArrayLiteral.class);
  }

  @Override
  @Nullable
  public HareConstant getConstant() {
    return findChildByClass(HareConstant.class);
  }

  @Override
  @Nullable
  public HareEnumLiteral getEnumLiteral() {
    return findChildByClass(HareEnumLiteral.class);
  }

  @Override
  @Nullable
  public HareStructLiteral getStructLiteral() {
    return findChildByClass(HareStructLiteral.class);
  }

  @Override
  @Nullable
  public HareSymbol getSymbol() {
    return findChildByClass(HareSymbol.class);
  }

}
