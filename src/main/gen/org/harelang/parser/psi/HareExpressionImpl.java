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

public class HareExpressionImpl extends ASTWrapperPsiElement implements HareExpression {

  public HareExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareAssignment getAssignment() {
    return findChildByClass(HareAssignment.class);
  }

  @Override
  @Nullable
  public HareBindingList getBindingList() {
    return findChildByClass(HareBindingList.class);
  }

  @Override
  @NotNull
  public List<HareExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareExpression.class);
  }

  @Override
  @Nullable
  public HareIfExpression getIfExpression() {
    return findChildByClass(HareIfExpression.class);
  }

  @Override
  @NotNull
  public List<HareIndexingExpression> getIndexingExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareIndexingExpression.class);
  }

  @Override
  @NotNull
  public List<HarePlanExpression> getPlanExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HarePlanExpression.class);
  }

}
