package org.chaofei.entity;

public class Developer {
    private Language language;

    public Developer() {
        super();
    }

    public Developer(Language language) {
        super();
        this.language = language;
    }
    
    public Language getLanguage() {
        return language;
    }

    /**
     * 没有用set方法自动装配,用到的是构造函数自动装配
     */
//    public void setLanguage(Language language) {
//        this.language = language;
//    }

    @Override
    public String toString() {
        return "Developer [language=" + language + "]";
    }
}
