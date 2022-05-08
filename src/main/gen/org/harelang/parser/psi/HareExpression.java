// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareExpression extends PsiElement {

  @NotNull
  List<HareAllocExpression> getAllocExpressionList();

  @NotNull
  List<HareAssertionExpression> getAssertionExpressionList();

  @Nullable
  HareAssignment getAssignment();

  @Nullable
  HareBindingList getBindingList();

  @NotNull
  List<HareCompoundExpression> getCompoundExpressionList();

  @Nullable
  HareControlExpression getControlExpression();

  @NotNull
  List<HareDeferExpression> getDeferExpressionList();

  @NotNull
  List<HareExpression> getExpressionList();

  @Nullable
  HareForLoop getForLoop();

  @Nullable
  HareIfExpression getIfExpression();

  @NotNull
  List<HareMatchExpression> getMatchExpressionList();

  @NotNull
  List<HareMeasurementExpression> getMeasurementExpressionList();

  @NotNull
  List<HarePlanExpression> getPlanExpressionList();

  @NotNull
  List<HarePostfixOp> getPostfixOpList();

  @NotNull
  List<HareSliceMutationExpression> getSliceMutationExpressionList();

  @NotNull
  List<HareSwitchExpression> getSwitchExpressionList();

  @NotNull
  List<HareTupleItems> getTupleItemsList();

  @NotNull
  List<HareType> getTypeList();

  @NotNull
  List<HareUnaryOperator> getUnaryOperatorList();

  @NotNull
  List<HareVariadicExpression> getVariadicExpressionList();

}
