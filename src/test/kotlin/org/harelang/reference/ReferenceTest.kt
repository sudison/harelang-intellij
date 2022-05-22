package org.harelang.reference

import com.intellij.psi.PsiElement
import org.harelang.parser.psi.*
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
    fun testNestedStructFieldRef() {
        val code = """
        type sa = struct {field1:i32, c: struct {field2:i32,},};
                                               //X
        fn foo() void = {
            sa.c.field2;
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

    @Test
    fun testLocalVarRef() {
        val code = """
        fn foo() void = {
            let a = 1;
              //X
            let i = a;
                  //^
        };
    """
        checkReference(HareSymbol::class.java, HareBinding::class.java, code)
    }

    @Test
    fun testFunParameterRef() {
        val code = """
        fn foo(arg1: int) void = {
             //X
            let i = arg1;
                  //^
        };
    """
        checkReference(HareSymbol::class.java, HareParameter::class.java, code)
    }

    @Test
    fun testForPredicateRef() {
        val code = """
        fn foo(arg1: int) void = {
            for (let i = 1;i+1) {
                   //X
                 let a = i;
                       //^
            };      
        };
    """
        checkReference(HareSymbol::class.java, HareBinding::class.java, code)
    }

    @Test
    fun testTypeRef() {
        val code = """
           type sa = i32;
              //X
        fn foo(arg1: int) sa = {
                        //^
            let i = 0;
        };
    """
        checkReference(HareSymbol::class.java, HareTypeBinding::class.java, code)
    }
}