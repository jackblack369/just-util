package com.aviator;

// 导入规则引擎包
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {

    public static void main(String[] args) {
        // 定义一个字符串
        String myString = "Hello, how are you today?";

        // 使用 split() 方法将字符串按空格进行切分
        String[] words = (String[]) AviatorEvaluator.execute("string.split(\"Hello. how are you today\", '.')");

        // 输出切分后的结果
        System.out.println(Arrays.toString(words));
    }

    private void test1() {
        String express = "let amountString = toString(oper_amount);\n" +
                "if (!string.contains(amountString, '.')) {\n" +
                "\treturn false;\n" +
                "}\n" +
                "let stringArray = string.split(amountString, \"\\\\.\");\n" +
                "let integerPart = stringArray[0];\n" +
                "if (long(integerPart) % 100 != 0) {\n" +
                "\treturn false;\n" +
                "}\n" +
                "let decimalStringList = seq.list('01', '02', '03');\n" +
                "let decimalPart = stringArray[1];\n" +
                "for decimalString in decimalStringList {\n" +
                "\tif (decimalPart == decimalString) {\n" +
                "    \treturn true;\t\n" +
                "\t}\n" +
                "}\n" +
                "return false;";
        AviatorEvaluatorInstance instance = AviatorEvaluator.getInstance();
        instance.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
        Expression expression = instance.compile(express, true);
        System.out.println(expression.getVariableNames());
        Map<String, Object> env = new HashMap<>();
        env.put("oper_amount", 100.01D);
        System.out.println(expression.execute(env));
    }


}
