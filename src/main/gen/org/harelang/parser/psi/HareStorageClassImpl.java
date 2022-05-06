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

public class HareStorageClassImpl extends ASTWrapperPsiElement implements HareStorageClass {

  public HareStorageClassImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HareVisitor visitor) {
    visitor.visitStorageClass(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HareVisitor) accept((HareVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HareAliasType getAliasType() {
    return findChildByClass(HareAliasType.class);
  }

  @Override
  @Nullable
  public HareFunctionType getFunctionType() {
    return findChildByClass(HareFunctionType.class);
  }

  @Override
  @Nullable
  public HareScalaType getScalaType() {
    return findChildByClass(HareScalaType.class);
  }

  @Override
  @Nullable
  public HareSliceArrayType getSliceArrayType() {
    return findChildByClass(HareSliceArrayType.class);
  }

  @Override
  @Nullable
  public HareStructUnionType getStructUnionType() {
    return findChildByClass(HareStructUnionType.class);
  }

  @Override
  @Nullable
  public HareTaggedUnionType getTaggedUnionType() {
    return findChildByClass(HareTaggedUnionType.class);
  }

  @Override
  @Nullable
  public HareTupleType getTupleType() {
    return findChildByClass(HareTupleType.class);
  }

  @Override
  @Nullable
  public HareUnwrappedAlias getUnwrappedAlias() {
    return findChildByClass(HareUnwrappedAlias.class);
  }

}
