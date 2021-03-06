// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareScalaType extends PsiElement {

  @Nullable
  HareEnumType getEnumType();

  @Nullable
  HareFloatingType getFloatingType();

  @Nullable
  HareIntegerType getIntegerType();

  @Nullable
  HarePointerType getPointerType();

}
