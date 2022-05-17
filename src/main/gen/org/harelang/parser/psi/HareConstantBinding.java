// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;

public interface HareConstantBinding extends PsiNameIdentifierOwner {

  @Nullable
  HareExpression getExpression();

  @NotNull
  HareIdentifierPath getIdentifierPath();

  @Nullable
  HareType getType();

}
