// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareExpression extends PsiElement {

  @Nullable
  HareAssignment getAssignment();

  @Nullable
  HareBindingList getBindingList();

  @NotNull
  List<HareCompoundExpression> getCompoundExpressionList();

  @NotNull
  List<HareExpression> getExpressionList();

  @Nullable
  HareForLoop getForLoop();

  @Nullable
  HareIfExpression getIfExpression();

  @NotNull
  List<HarePlanExpression> getPlanExpressionList();

}
