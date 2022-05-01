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

public class HareIndexingExpressionImpl extends ASTWrapperPsiElement implements HareIndexingExpression {

  public HareIndexingExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitIndexingExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HareExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareExpression.class);
  }

  @Override
  @Nullable
  public HareIndexingExpression getIndexingExpression() {
    return findChildByClass(HareIndexingExpression.class);
  }

  @Override
  @Nullable
  public HarePlanExpression getPlanExpression() {
    return findChildByClass(HarePlanExpression.class);
  }

}
