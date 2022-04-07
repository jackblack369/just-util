package com.dynamicCompile.janino.demo2;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ClassBodyEvaluator;
import org.codehaus.janino.Scanner;

import java.io.IOException;
import java.io.StringReader;

public class Demo2 {
    public static void main(String[] args) {
        try {
            Foo f = (Foo) ClassBodyEvaluator.createFastClassBodyEvaluator(
                    new Scanner(null, new StringReader("public int bar(int a, int b) { return a + b; }")),
                    Foo.class,                  // 实现的父类或接口
                    (ClassLoader) null          // 这里设置为null表示使用当前线程的class loader
            );
            System.out.println("1 + 2 = " + f.bar(1, 2));
        } catch (CompileException | IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
