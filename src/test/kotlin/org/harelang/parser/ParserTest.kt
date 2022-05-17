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
        printTree(
            """
        fn huh(a:int) void = { a::R
            """.trimIndent()
        )
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
        doCodeTest(
            """
            let a:i32 = 1;
            const a:i64 = 1232;
        """.trimIndent()
        )
    }

    @Test
    fun testParseDef() {
        doCodeTest(
            """
            def a: i32 = i;
        """.trimIndent()
        )
    }

    @Test
    fun testParseTypeDef() {
        doCodeTest(
            """
            type a = i32; type a::b = i16, c = i32;
        """.trimIndent()
        )
    }

    @Test
    fun testParseEnum() {
        doCodeTest(
            """
            type a = enum { a, b, c = 1,}; type b = enum i32 {a = 1};
        """.trimIndent()
        )
    }

    @Test
    fun testParsePointer() {
        doCodeTest(
            """
            type a = *i32, b = nullable * i8;
        """.trimIndent()
        )
    }

    @Test
    fun testParseStruct() {
        doCodeTest(
            """
            type a = struct {i : i32, b : struct { i : i64}, a::bc,};
        """.trimIndent()
        )
    }

    @Test
    fun testParseUnion() {
        doCodeTest(
            """
            type a = union {i : i32, b : union { i : i64}, a::bc};
        """.trimIndent()
        )
    }

    @Test
    fun testParseTuple() {
        doCodeTest(
            """
            type a = (i32, i8, f64), b = (a,b,);
        """.trimIndent()
        )
    }

    @Test
    fun testParseTagged() {
        doCodeTest(
            """
            type a = (i32|i8|f64);
        """.trimIndent()
        )
    }

    @Test
    fun testParseSlicedArray() {
        doCodeTest(
            """
            type a = []i32, b = [3]i32, c = [*]i32, d = [_]i8;
        """.trimIndent()
        )
    }

    @Test
    fun testParseString() {
        doCodeTest(
            """
            let s : str = "a", b : str = "c";
            let s : str = "line-one"
                           "line-two";
            let r: str = `abd`, c : str = `fkdf`;
            let rr : str = `one-line`
                           `two-line`
                           "third-line";
            const in:str = "\"a\" \"b\" \"\\a\" \"\\b\" \"\\f\" \"\\n\" \"\\r\" "
		"\"\\t\" \"\\v\" \"\\0\" \"\\\\\" \"\\\'\"";               
        """.trimIndent()
        )
    }

    @Test
    fun testParseFunctionType() {
        doCodeTest(
            """
            type s = fn () void, b = fn (a:i32) i32, c = fn (a:i8...,) i32, d = fn (_:i8...) i32, e = fn (a:i32, b:i32) void;
            type a = fn (a:i32,...,) void, b = fn(a:i32...,) void, c = fn(a:i32, ...) void;
        """.trimIndent()
        )
    }

    @Test
    fun testParseAliasType() {
        doCodeTest(
            """
            type s = a, b = a::b, c = ... a;
        """.trimIndent()
        )
    }

    @Test
    fun testParseArrayLiteral() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = [1,2,3,], b = [1...,], c = [1,2,3...,], d = [];
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseEnumLiteral() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = a::c, b = a::b::c;
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseStructLiteral() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = struct {x = 1, y:int = 2,}, b = coords {x = 1, y: int = 2}, c = coords {...}, d = coords {x = 1, ...};
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseNestedStructLiteral() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = struct {x = 1, struct {x = 1}}, b = struct {coords {x = 1, ...}};
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseTupleItems() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = (1, 2, 3,), b = (1);
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseStructAccess() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = a.b.c;
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseArrayAccess() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = a[1].a;
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseCallExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = a(1,b,c,);
            let b = a(1,b...,);
            let c = a();
            let d = a[1].a(1,2);
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseSlicingOp() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = a[1..2], b = a[..2], c = a[..];
            a[kdk..1] = b[..len(a)];
            a[..1] = b[a..len(a)];

            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseErrorPropagation() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = a!, b = a?, c = a?.a!.c;
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseAllocExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = alloc(1), b = alloc(1, 2), c = alloc(1...);
            free(a);
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseAssertExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            assert(a == b);
            assert(1, "failure");
            abort();
            abort("failure");
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseDeferExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            defer free(a);
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseMeasurementExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            size(a);
            len(a);
            offset(a.b.c);
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseSliceMutationExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            append(a[1], 1, 1);
            append(a[1], a...);
            append(a[1], a);
            insert(a[1], a);
            insert(a[1], a...);
            delete(a[1]);
            
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParsevaExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            vastart ();
            vaarg(1);
            vaend(1);
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseMatchExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = match (a) {
             case let b:i32 => "dfd";
             case i8 => "hello";
             case => "default";
            };
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseSwitchExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = switch (a) {
             case 1,2 => "dfd";
             case => "hello";
            };
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseControlExpression() {
        doCodeTest(
            """
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
        """.trimIndent()
        )
    }

    @Test
    fun testParseUnaryExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = &b, b = +1, c = -1, d = ~1, e = *1, f = !1;
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseCastExpression() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a = a::bc : i32:int, b = a as bool, c = a is bool;
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseAssignment() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            a.b.c = 1;
            a[1].b[2].c = 3;
            *p = 1;
            a[1..2] = [1,2];
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseBindings() {
        doCodeTest(
            """
            fn foo(a:int) void = {
            let a: i32 = 1, b = null, c = void;
            const a : int = 1;
            let a = 1;
            const a = 1;
            let (a, b) = (a,b);
            const (a, b) = (a, b);
            };
        """.trimIndent()
        )
    }

    @Test
    fun testParseFnAttr() {
        doCodeTest(
            """
            @init @test @init @noreturn fn init(a:int) void;
            @init @symbol("test") fn test(a:int) void;
            type s = @noreturn fn () void;
        """.trimIndent()
        )
    }

    @Test
    fun testParseIntegerConstant() {
        doCodeTest(
            """
            let a: i32 = 1234567890, b: i32 = 0x1234567890abcdefABCDEF, c: i32 = 0o1234567, d: i32 = 0b010101;
        """.trimIndent()
        )
    }

    @Test
    fun testParseFloatingConstant() {
        doCodeTest(
            """
            let a: f32 = 12.12, b: f32 = 12.12e+12f32, c: f64 = 1.1e-12f64, d: f64 = 1e5f64;
        """.trimIndent()
        )
    }

    @Test
    fun testParseRuneConstant() {
        doCodeTest(
            """
            @test fn ctype() void = {
	let a = '\'', b = '\t', c = ' ';
};
        """.trimIndent()
        )
    }

    @Test
    fun testParseLargeArray() {
        doCodeTest(
            """
                const testcert_bin: [_]u8 = [
                	0x30, 0x82, 0x02, 0x2c, 0x30, 0x82, 0x01, 0xd2, 0xa0, 0x03, 0x02, 0x01,
                	0x02, 0x02, 0x01, 0x00, 0x30, 0x0a, 0x06, 0x08, 0x2a, 0x86, 0x48, 0xce,
                	0x3d, 0x04, 0x03, 0x02, 0x30, 0x7d, 0x31, 0x0b, 0x30, 0x09, 0x06, 0x03,
                	0x55, 0x04, 0x06, 0x13, 0x02, 0x42, 0x45, 0x31, 0x0f, 0x30, 0x0d, 0x06,
                	0x03, 0x55, 0x04, 0x0a, 0x13, 0x06, 0x47, 0x6e, 0x75, 0x54, 0x4c, 0x53,
                	0x31, 0x25, 0x30, 0x23, 0x06, 0x03, 0x55, 0x04, 0x0b, 0x13, 0x1c, 0x47,
                	0x6e, 0x75, 0x54, 0x4c, 0x53, 0x20, 0x63, 0x65, 0x72, 0x74, 0x69, 0x66,
                	0x69, 0x63, 0x61, 0x74, 0x65, 0x20, 0x61, 0x75, 0x74, 0x68, 0x6f, 0x72,
                	0x69, 0x74, 0x79, 0x31, 0x0f, 0x30, 0x0d, 0x06, 0x03, 0x55, 0x04, 0x08,
                	0x13, 0x06, 0x4c, 0x65, 0x75, 0x76, 0x65, 0x6e, 0x31, 0x25, 0x30, 0x23,
                	0x06, 0x03, 0x55, 0x04, 0x03, 0x13, 0x1c, 0x47, 0x6e, 0x75, 0x54, 0x4c,
                	0x53, 0x20, 0x63, 0x65, 0x72, 0x74, 0x69, 0x66, 0x69, 0x63, 0x61, 0x74,
                	0x65, 0x20, 0x61, 0x75, 0x74, 0x68, 0x6f, 0x72, 0x69, 0x74, 0x79, 0x30,
                	0x1e, 0x17, 0x0d, 0x31, 0x31, 0x30, 0x35, 0x32, 0x33, 0x32, 0x30, 0x33,
                	0x38, 0x32, 0x31, 0x5a, 0x17, 0x0d, 0x31, 0x32, 0x31, 0x32, 0x32, 0x32,
                	0x30, 0x37, 0x34, 0x31, 0x35, 0x31, 0x5a, 0x30, 0x7d, 0x31, 0x0b, 0x30,
                	0x09, 0x06, 0x03, 0x55, 0x04, 0x06, 0x13, 0x02, 0x42, 0x45, 0x31, 0x0f,
                	0x30, 0x0d, 0x06, 0x03, 0x55, 0x04, 0x0a, 0x13, 0x06, 0x47, 0x6e, 0x75,
                	0x54, 0x4c, 0x53, 0x31, 0x25, 0x30, 0x23, 0x06, 0x03, 0x55, 0x04, 0x0b,
                	0x13, 0x1c, 0x47, 0x6e, 0x75, 0x54, 0x4c, 0x53, 0x20, 0x63, 0x65, 0x72,
                	0x74, 0x69, 0x66, 0x69, 0x63, 0x61, 0x74, 0x65, 0x20, 0x61, 0x75, 0x74,
                	0x68, 0x6f, 0x72, 0x69, 0x74, 0x79, 0x31, 0x0f, 0x30, 0x0d, 0x06, 0x03,
                	0x55, 0x04, 0x08, 0x13, 0x06, 0x4c, 0x65, 0x75, 0x76, 0x65, 0x6e, 0x31,
                	0x25, 0x30, 0x23, 0x06, 0x03, 0x55, 0x04, 0x03, 0x13, 0x1c, 0x47, 0x6e,
                	0x75, 0x54, 0x4c, 0x53, 0x20, 0x63, 0x65, 0x72, 0x74, 0x69, 0x66, 0x69,
                	0x63, 0x61, 0x74, 0x65, 0x20, 0x61, 0x75, 0x74, 0x68, 0x6f, 0x72, 0x69,
                	0x74, 0x79, 0x30, 0x59, 0x30, 0x13, 0x06, 0x07, 0x2a, 0x86, 0x48, 0xce,
                	0x3d, 0x02, 0x01, 0x06, 0x08, 0x2a, 0x86, 0x48, 0xce, 0x3d, 0x03, 0x01,
                	0x07, 0x03, 0x42, 0x00, 0x04, 0x52, 0xd8, 0x8d, 0x23, 0x8a, 0xe3, 0x67,
                	0xd7, 0x86, 0x36, 0xb1, 0x20, 0x0b, 0x09, 0x7d, 0xc8, 0xc9, 0xba, 0xa2,
                	0x20, 0x95, 0x2f, 0xc5, 0x4a, 0x63, 0xfa, 0x83, 0x5f, 0xce, 0x78, 0x2f,
                	0x8f, 0xf3, 0x62, 0xca, 0xfd, 0xb7, 0xf7, 0x80, 0x56, 0x9d, 0x6e, 0x17,
                	0xb9, 0x0e, 0x11, 0x4c, 0x48, 0xb2, 0xc0, 0xaf, 0x3b, 0x59, 0x17, 0x16,
                	0x30, 0x68, 0x09, 0x07, 0x99, 0x17, 0xfe, 0xdd, 0xa7, 0xa3, 0x43, 0x30,
                	0x41, 0x30, 0x0f, 0x06, 0x03, 0x55, 0x1d, 0x13, 0x01, 0x01, 0xff, 0x04,
                	0x05, 0x30, 0x03, 0x01, 0x01, 0xff, 0x30, 0x0f, 0x06, 0x03, 0x55, 0x1d,
                	0x0f, 0x01, 0x01, 0xff, 0x04, 0x05, 0x03, 0x03, 0x07, 0x06, 0x00, 0x30,
                	0x1d, 0x06, 0x03, 0x55, 0x1d, 0x0e, 0x04, 0x16, 0x04, 0x14, 0xf0, 0xb4,
                	0x81, 0xfe, 0x98, 0x12, 0xbf, 0xb5, 0x28, 0xb9, 0x64, 0x40, 0x03, 0xcb,
                	0xcc, 0x1f, 0x66, 0x4e, 0x28, 0x03, 0x30, 0x0a, 0x06, 0x08, 0x2a, 0x86,
                	0x48, 0xce, 0x3d, 0x04, 0x03, 0x02, 0x03, 0x48, 0x00, 0x30, 0x45, 0x02,
                	0x20, 0x31, 0xae, 0xc0, 0x3d, 0x4a, 0x3f, 0x21, 0xbe, 0x85, 0x17, 0xfc,
                	0xf0, 0xc7, 0xb2, 0x31, 0x07, 0x2a, 0x38, 0x56, 0x43, 0xd1, 0x36, 0xd5,
                	0x95, 0xe1, 0x7e, 0x52, 0xc0, 0x06, 0x43, 0x87, 0xa7, 0x02, 0x21, 0x00,
                	0x97, 0x8c, 0x0e, 0xb8, 0x3c, 0x0a, 0x41, 0xaf, 0xae, 0xa5, 0xcf, 0x06,
                	0x7e, 0xd5, 0xc4, 0xd8, 0x2f, 0xff, 0xe2, 0x62, 0x80, 0x34, 0x10, 0xba,
                	0x22, 0xdd, 0x35, 0x81, 0x46, 0x93, 0x22, 0x9a ...,
                ];
            """.trimIndent()
        )
    }
}