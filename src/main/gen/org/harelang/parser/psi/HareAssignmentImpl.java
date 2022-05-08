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

public class HareAssignmentImpl extends ASTWrapperPsiElement implements HareAssignment {

  public HareAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareAllocExpression getAllocExpression() {
    return findChildByClass(HareAllocExpression.class);
  }

  @Override
  @Nullable
  public HareAssertionExpression getAssertionExpression() {
    return findChildByClass(HareAssertionExpression.class);
  }

  @Override
  @Nullable
  public HareAssignmentOp getAssignmentOp() {
    return findChildByClass(HareAssignmentOp.class);
  }

  @Override
  @Nullable
  public HareCompoundExpression getCompoundExpression() {
    return findChildByClass(HareCompoundExpression.class);
  }

  @Override
  @Nullable
  public HareDeferExpression getDeferExpression() {
    return findChildByClass(HareDeferExpression.class);
  }

  @Override
  @NotNull
  public List<HareExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareExpression.class);
  }

  @Override
  @Nullable
  public HareMatchExpression getMatchExpression() {
    return findChildByClass(HareMatchExpression.class);
  }

  @Override
  @Nullable
  public HareMeasurementExpression getMeasurementExpression() {
    return findChildByClass(HareMeasurementExpression.class);
  }

  @Override
  @Nullable
  public HareObjectSelector getObjectSelector() {
    return findChildByClass(HareObjectSelector.class);
  }

  @Override
  @Nullable
  public HarePlanExpression getPlanExpression() {
    return findChildByClass(HarePlanExpression.class);
  }

  @Override
  @NotNull
  public List<HarePostfixOp> getPostfixOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HarePostfixOp.class);
  }

  @Override
  @Nullable
  public HareSliceMutationExpression getSliceMutationExpression() {
    return findChildByClass(HareSliceMutationExpression.class);
  }

  @Override
  @Nullable
  public HareSlicingExpression getSlicingExpression() {
    return findChildByClass(HareSlicingExpression.class);
  }

  @Override
  @Nullable
  public HareSwitchExpression getSwitchExpression() {
    return findChildByClass(HareSwitchExpression.class);
  }

  @Override
  @Nullable
  public HareTupleItems getTupleItems() {
    return findChildByClass(HareTupleItems.class);
  }

  @Override
  @NotNull
  public List<HareUnaryOperator> getUnaryOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HareUnaryOperator.class);
  }

  @Override
  @Nullable
  public HareVariadicExpression getVariadicExpression() {
    return findChildByClass(HareVariadicExpression.class);
  }

}
