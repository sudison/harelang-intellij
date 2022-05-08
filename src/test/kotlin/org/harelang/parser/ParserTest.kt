package org.harelang.parser


import com.intellij.testFramework.ParsingTestCase
import org.harelang.HareFileType
import org.harelang.HareParserDefinition
import org.junit.Test

class ParserTests : ParsingTestCase("", HareFileType.defaultExtension, HareParserDefinition()) {
    override fun getTestDataPath() = "src/test/testdata/parsing"

    override fun skipSpaces() = true

    private fun printTree(code: String) {
        println(name)

        myFile = createPsiFile(
            testName, code
        )
        ensureParsed(myFile)
        println(toParseTreeText(myFile, skipSpaces(), includeRanges()))
    }

    @Test
    fun testPrintParseImports() {
        printTree("""use a::b::c; use a::b::{a}; use a::b::*; use a::b::{a, b, c = d};""")
    }

    @Test
    fun testParseImports() {
        doCodeTest("""use a::b::c; use a::b::{a}; use a::b::*; use a::b::{a, b, c = d};""")
    }

    @Test
    fun testParseFunction() {
        doCodeTest(
            """fn huh(a:int) void = {
       let i = 0;
        let s = "";
        i = s;
    };"""
        )
    }

    @Test
    fun testParseFunction2() {
        doCodeTest(
            """fn huh(a:int) void; fn a::b::foo() i32;"""
        )
    }

    @Test
    fun testParseGlobalBinding() {
        doCodeTest("""
            let a:i32 = 1;
            const a:i64 = 1232;
        """.trimIndent())
    }

    @Test
    fun testParseDef() {
        doCodeTest("""
            def a: i32 = i;
        """.trimIndent())
    }

    @Test
    fun testParseTypeDef() {
        doCodeTest("""
            type a = i32; type a::b = i16, c = i32;
        """.trimIndent())
    }

    @Test
    fun testParseEnum() {
        doCodeTest("""
            type a = enum { a, b, c = 1}; type b = enum i32 {a = 1};
        """.trimIndent())
    }

    @Test
    fun testParsePointer() {
        doCodeTest("""
            type a = *i32, b = nullable * i8;
        """.trimIndent())
    }

    @Test
    fun testParseStruct() {
        doCodeTest("""
            type a = struct {i : i32, b : struct { i : i64}, a::bc,};
        """.trimIndent())
    }

    @Test
    fun testParseUnion() {
        doCodeTest("""
            type a = union {i : i32, b : union { i : i64}, a::bc};
        """.trimIndent())
    }

    @Test
    fun testParseTuple() {
        doCodeTest("""
            type a = (i32, i8, f64);
        """.trimIndent())
    }

    @Test
    fun testParseTagged() {
        doCodeTest("""
            type a = (i32|i8|f64);
        """.trimIndent())
    }

    @Test
    fun testParseSlicedArray() {
        doCodeTest("""
            type a = []i32, b = [3]i32, c = [*]i32, d = [_]i8;
        """.trimIndent())
    }

    @Test
    fun testParseString() {
        doCodeTest("""
            let s : str = "a";
        """.trimIndent())
    }

    @Test
    fun testParseFunctionType() {
        doCodeTest("""
            type s = fn () void, b = fn (a:i32) i32, c = fn (a:i8...) i32, d = fn (_:i8...) i32, e = fn (a:i32, b:i32) void;
        """.trimIndent())
    }

    @Test
    fun testParseAliasType() {
        doCodeTest("""
            type s = a, b = a::b, c = ... a;
        """.trimIndent())
    }

    @Test
    fun testParseArrayLiteral() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = [1,2,3], b = [1...], c = [1,2,3...];
            };
        """.trimIndent())
    }

    @Test
    fun testParseEnumLiteral() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = a::c, b = a::b::c;
            };
        """.trimIndent())
    }

    @Test
    fun testParseStructLiteral() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = struct {x = 1, y:int = 2,}, b = coords {x = 1, y: int = 2}, c = coords {...}, d = coords {x = 1, ...};
            };
        """.trimIndent())
    }

    @Test
    fun testParseNestedStructLiteral() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = struct {x = 1, struct {x = 1}}, b = struct {coords {x = 1, ...}};
            };
        """.trimIndent())
    }

    @Test
    fun testParseTupleItems() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = (1, 2, 3), b = (1);
            };
        """.trimIndent())
    }

    @Test
    fun testParseStructAccess() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = a.b.c;
            };
        """.trimIndent())
    }

    @Test
    fun testParseArrayAccess() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = a[1].a;
            };
        """.trimIndent())
    }

    @Test
    fun testParseCallExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = a(1,b,c);
            let b = a(1,b...);
            let c = a();
            let d = a[1].a(1,2);
            };
        """.trimIndent())
    }

    @Test
    fun testParseSlicingOp() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = a[1..2], b = a[..2], c = a[..];
            };
        """.trimIndent())
    }

    @Test
    fun testParseErrorPropagation() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = a!, b = a?, c = a?.a!.c;
            };
        """.trimIndent())
    }

    @Test
    fun testParseAllocExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = alloc(1), b = alloc(1, 2), c = alloc(1...);
            free(a);
            };
        """.trimIndent())
    }

    @Test
    fun testParseAssertExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            assert(a == b);
            assert(1, "failure");
            abort();
            abort("failure");
            };
        """.trimIndent())
    }

    @Test
    fun testParseDeferExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            defer free(a);
            };
        """.trimIndent())
    }

    @Test
    fun testParseMeasurementExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            size(a);
            len(a);
            offset(a.b.c);
            };
        """.trimIndent())
    }

    @Test
    fun testParseSliceMutationExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            append(a[1], 1, 1);
            append(a[1], a...);
            append(a[1], a);
            insert(a[1], a);
            insert(a[1], a...);
            delete(a[1]);
            
            };
        """.trimIndent())
    }

    @Test
    fun testParsevaExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            vastart ();
            vaarg(1);
            vaend(1);
            };
        """.trimIndent())
    }

    @Test
    fun testParseMatchExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = match (a) {
             case let b:i32 => "dfd";
             case i8 => "hello";
             case => "default";
            };
            };
        """.trimIndent())
    }

    @Test
    fun testParseSwitchExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
            let a = switch (a) {
             case 1,2 => "dfd";
             case => "hello";
            };
            };
        """.trimIndent())
    }

    @Test
    fun testParseControlExpression() {
        doCodeTest("""
            fn foo(a:int) void = {
                :l {
                    for (i < len(items); i += 1) {
		                if (items[i] == "Hare") {
			                i;
                            break :l;
                            yield;
                            yield "dfd";
                            yield :l;
                            yield :l, "fdf";
		                } else {
                            1;
                            continue :l;
                            continue;
                            return 1;
                            return;
                        };
	                };
                };
          };
        """.trimIndent())
    }
}