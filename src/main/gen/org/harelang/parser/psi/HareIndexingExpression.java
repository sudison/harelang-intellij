// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareIndexingExpression extends PsiElement {

  @NotNull
  List<HareExpression> getExpressionList();

  @Nullable
  HareIndexingExpression getIndexingExpression();

  @Nullable
  HarePlanExpression getPlanExpression();

}
