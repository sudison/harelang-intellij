// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HareStructLiteral extends PsiElement {

  @Nullable
  HareFieldValues getFieldValues();

  @Nullable
  HareStructInitializer getStructInitializer();

  @NotNull
  List<HareSymbol> getSymbolList();

}
