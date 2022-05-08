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

public class HareFieldAccessExpressionImpl extends ASTWrapperPsiElement implements HareFieldAccessExpression {

  public HareFieldAccessExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitFieldAccessExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareExpression getExpression() {
    return findChildByClass(HareExpression.class);
  }

  @Override
  @NotNull
  public List<HareFieldAccessOp> getFieldAccessOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareFieldAccessOp.class);
  }

  @Override
  @Nullable
  public HarePlanExpression getPlanExpression() {
    return findChildByClass(HarePlanExpression.class);
  }

  @Override
  @Nullable
  public HareTupleItems getTupleItems() {
    return findChildByClass(HareTupleItems.class);
  }

}
