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
  @NotNull
  public List<HareAllocExpression> getAllocExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareAllocExpression.class);
  }

  @Override
  @NotNull
  public List<HareAssertionExpression> getAssertionExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareAssertionExpression.class);
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
  public List<HareCompoundExpression> getCompoundExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareCompoundExpression.class);
  }

  @Override
  @NotNull
  public List<HareDeferExpression> getDeferExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareDeferExpression.class);
  }

  @Override
  @NotNull
  public List<HareExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareExpression.class);
  }

  @Override
  @Nullable
  public HareForLoop getForLoop() {
    return findChildByClass(HareForLoop.class);
  }

  @Override
  @Nullable
  public HareIfExpression getIfExpression() {
    return findChildByClass(HareIfExpression.class);
  }

  @Override
  @NotNull
  public List<HareMatchExpression> getMatchExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareMatchExpression.class);
  }

  @Override
  @NotNull
  public List<HareMeasurementExpression> getMeasurementExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareMeasurementExpression.class);
  }

  @Override
  @NotNull
  public List<HarePlanExpression> getPlanExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HarePlanExpression.class);
  }

  @Override
  @NotNull
  public List<HarePostfixOp> getPostfixOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HarePostfixOp.class);
  }

  @Override
  @NotNull
  public List<HareSliceMutationExpression> getSliceMutationExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareSliceMutationExpression.class);
  }

  @Override
  @NotNull
  public List<HareSwitchExpression> getSwitchExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareSwitchExpression.class);
  }

  @Override
  @NotNull
  public List<HareTupleItems> getTupleItemsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareTupleItems.class);
  }

  @Override
  @NotNull
  public List<HareVariadicExpression> getVariadicExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareVariadicExpression.class);
  }

}
