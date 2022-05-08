// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HarePostfixOp extends PsiElement {

  @Nullable
  HareCallOp getCallOp();

  @Nullable
  HareErrorPropagationOp getErrorPropagationOp();

  @Nullable
  HareFieldAccessOp getFieldAccessOp();

  @Nullable
  HareIndexingOp getIndexingOp();

  @Nullable
  HareSlicingOp getSlicingOp();

}
