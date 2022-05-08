// This is a generated file. Not intended for manual editing.
package org.harelang.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.harelang.parser.psi.HareTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class HarePostfixOpImpl extends ASTWrapperPsiElement implements HarePostfixOp {

  public HarePostfixOpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitPostfixOp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareCallOp getCallOp() {
    return findChildByClass(HareCallOp.class);
  }

  @Override
  @Nullable
  public HareErrorPropagationOp getErrorPropagationOp() {
    return findChildByClass(HareErrorPropagationOp.class);
  }

  @Override
  @Nullable
  public HareFieldAccessOp getFieldAccessOp() {
    return findChildByClass(HareFieldAccessOp.class);
  }

  @Override
  @Nullable
  public HareIndexingOp getIndexingOp() {
    return findChildByClass(HareIndexingOp.class);
  }

  @Override
  @Nullable
  public HareSlicingOp getSlicingOp() {
    return findChildByClass(HareSlicingOp.class);
  }

}
