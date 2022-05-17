// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;

public interface HareTypeBinding extends PsiNameIdentifierOwner {

  @NotNull
  HareIdentifierPath getIdentifierPath();

  @NotNull
  HareType getType();

}
