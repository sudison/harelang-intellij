// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareConstantBinding extends PsiElement {

  @NotNull
  HareExpression getExpression();

  @NotNull
  HareIdentifierPath getIdentifierPath();

  @NotNull
  HareType getType();

}