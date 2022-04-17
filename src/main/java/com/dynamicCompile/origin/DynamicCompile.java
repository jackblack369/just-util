package com.dynamicCompile.origin;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicCompile {
    public static void main(String[] args) throws IOException {

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "/Users/dongwei/javaer/just-util/src/main/java/com/dynamicCompile/origin/Helloworld.java");
        System.out.println(result==0?"Compile successfully":"Compile failed");

        try {
            URL[] urls = new URL[]{new URL("file:/Users/dongwei/javaer/just-util/src/main/java")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class<?> c = loader.loadClass("com.dynamicCompile.origin.Helloworld");
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object)new String[]{});//Objects called by static methods without thanks
            //Reason for adding Object cast
            //Since the variable parameter is JDK5.0, m.invoke(null, new String[]{"23","34"}) is available;
            //The compiler will compile it into the format of m.invoke(null,"23","34"); and there will be parameter mismatch
            //Do this for parameters with arrays
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
