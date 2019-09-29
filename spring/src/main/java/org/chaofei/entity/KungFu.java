package org.chaofei.entity;

public class KungFu {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "KungFu [name=" + name + "]";
    }
}
