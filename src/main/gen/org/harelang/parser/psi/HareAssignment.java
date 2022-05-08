// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareAssignment extends PsiElement {

  @Nullable
  HareAllocExpression getAllocExpression();

  @Nullable
  HareAssertionExpression getAssertionExpression();

  @Nullable
  HareAssignmentOp getAssignmentOp();

  @Nullable
  HareCompoundExpression getCompoundExpression();

  @Nullable
  HareDeferExpression getDeferExpression();

  @NotNull
  List<HareExpression> getExpressionList();

  @Nullable
  HareMatchExpression getMatchExpression();

  @Nullable
  HareMeasurementExpression getMeasurementExpression();

  @Nullable
  HareObjectSelector getObjectSelector();

  @Nullable
  HarePlanExpression getPlanExpression();

  @NotNull
  List<HarePostfixOp> getPostfixOpList();

  @Nullable
  HareSliceMutationExpression getSliceMutationExpression();

  @Nullable
  HareSlicingExpression getSlicingExpression();

  @Nullable
  HareSwitchExpression getSwitchExpression();

  @Nullable
  HareTupleItems getTupleItems();

  @NotNull
  List<HareUnaryOperator> getUnaryOperatorList();

  @Nullable
  HareVariadicExpression getVariadicExpression();

}
