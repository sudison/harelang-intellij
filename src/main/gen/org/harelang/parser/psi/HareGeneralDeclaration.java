// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareGeneralDeclaration extends PsiElement {

  @Nullable
  HareConstantDeclaration getConstantDeclaration();

  @Nullable
  HareFunctionDeclaration getFunctionDeclaration();

  @Nullable
  HareGlobalDeclaration getGlobalDeclaration();

  @Nullable
  HareTypeDeclaration getTypeDeclaration();

}
