package com.dynamicCompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RuntimeCompile {

    public static void main(String[] args) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "/Users/dongwei/javaer/just-util/src/main/java/com/dynamicCompile/Helloworld.java");
        System.out.println(result == 0 ? "Compile successfully" : "Compile failed");
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp /Users/dongwei/javaer/just-util/src/main/java com.dynamicCompile.Helloworld");

        BufferedReader w = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println(w.readLine());
    }
}
