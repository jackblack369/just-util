package com.dynamicCompile.janino.demo3;

public class DerivedClass extends BaseClass {
    private String name;

    public DerivedClass(String baseId, String name) {
        super(baseId);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDerivedClass [name=" + name + "]";
    }

}
