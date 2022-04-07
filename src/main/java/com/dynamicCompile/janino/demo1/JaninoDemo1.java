package com.dynamicCompile.janino.demo1;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.commons.compiler.IScriptEvaluator;
import org.codehaus.janino.ExpressionEvaluator;
import org.codehaus.janino.ScriptEvaluator;

import java.lang.reflect.InvocationTargetException;

public class JaninoDemo1 {

    public static void main(String[] args) {
        test5();
    }

    private static void test1(){
        try {
            String content="System.out.println(\"Hello world\");";
            IScriptEvaluator evaluator = new ScriptEvaluator();
            evaluator.cook(content);
            evaluator.evaluate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * arithmetic expression
     */
    private static void test2(){
        try {
            String express = "(1+2)*3";
            ScriptEvaluator evaluator = new ExpressionEvaluator();
            evaluator.cook(express);
            Object res = evaluator.evaluate(null);
            System.out.println(express + "=" + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * symbol expression
     */
    private static void test3(){

        try {
            // 首先定义一个表达式模拟器ExpressionEvaluator对象
            ExpressionEvaluator ee = new ExpressionEvaluator();

            // 定义一个算术表达式，表达式中需要有2个int类型的参数a和b
            String expression = "2 * (a + b)";
            ee.setParameters(new String[] { "a", "b" }, new Class[] { int.class, int.class });

            // 设置表达式的返回结果也为int类型
            ee.setExpressionType(int.class);

            // 这里处理（扫描，解析，编译和加载）上面定义的算数表达式.
            ee.cook(expression);

            // 根据输入的a和b参数执行实际的表达式计算过程
            int result = (Integer) ee.evaluate(new Object[] { 19, 23 });
            System.out.println(expression + " = " + result);
        } catch (CompileException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * script
     */
    private static void test4(){
        ScriptEvaluator se = new ScriptEvaluator();
        try {
            se.cook(
                    ""
                            + "static void method1() {\n"
                            + "    System.out.println(\"run in method1()\");\n"
                            + "}\n"
                            + "\n"
                            + "static void method2() {\n"
                            + "    System.out.println(\"run in method2()\");\n"
                            + "}\n"
                            + "\n"
                            + "method1();\n"
                            + "method2();\n"
                            + "\n"

            );
            se.evaluate(null);
        } catch (CompileException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * script with parameter
     */
    private static void test5(){
        ScriptEvaluator se = new ScriptEvaluator();
        se.setParameters(new String[] { "arg1", "arg2" }, new Class[] { String.class, int.class });
        try {
            se.cook(
                    ""
                            + "System.out.println(arg1);\n"
                            + "System.out.println(arg2);\n"
                            + "\n"
                            + "static void method1() {\n"
                            + "    System.out.println(\"run in method1()\");\n"
                            + "}\n"
                            + "\n"
                            + "public static void method2() {\n"
                            + "    System.out.println(\"run in method2()\");\n"
                            + "}\n"
                            + "\n"
                            + "method1();\n"
                            + "method2();\n"
                            + "\n"

            );
            se.evaluate(new Object[]{"aaa", 22});
        } catch (CompileException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
