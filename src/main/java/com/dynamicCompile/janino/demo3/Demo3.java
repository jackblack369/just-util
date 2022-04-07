package com.dynamicCompile.janino.demo3;

import org.codehaus.commons.compiler.IScriptEvaluator;
import org.codehaus.janino.ScriptEvaluator;

public class Demo3 {

    public static void main(String[] args) {
        try {
            IScriptEvaluator se = new ScriptEvaluator();
            se.setReturnType(String.class);
            se.cook("import com.dynamicCompile.janino.demo3.BaseClass;\n"
                    + "import com.dynamicCompile.janino.demo3.DerivedClass;\n"
                    + "BaseClass o=new DerivedClass(\"1\",\"join\");\n"
                    + "return o.toString();\n");
            Object res = se.evaluate(new Object[0]);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
