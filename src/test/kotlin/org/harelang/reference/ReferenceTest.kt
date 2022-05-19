package org.harelang.reference

import org.harelang.parser.psi.HareEnumValue
import org.harelang.parser.psi.HareFieldAccessOp
import org.harelang.parser.psi.HareStructUnionField
import org.harelang.parser.psi.HareSymbol
import org.junit.Test

class ReferenceTest : ReferenceTestBase() {
    @Test
    fun testStructFieldRef() {
        val code = """
        type sa = struct {i:i32};
                        //X
        fn foo() void = {
            sa.i;
             //^
        };
    """
        checkReference(HareFieldAccessOp::class.java, HareStructUnionField::class.java, code)
    }

    @Test
    fun testEnumValueRef() {
        val code = """
        type color = enum {RED, WHITE};
                         //X
        fn foo() void = {
            let i = color::RED;
                         //^
        };
    """
        checkReference(HareSymbol::class.java, HareEnumValue::class.java, code)
    }
}