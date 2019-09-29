package org.chaofei.entity;
/**
 * 
 * @author chaofei
 *  如果没有找到默认的构造函数，自动检测将按类型选择装配。
 * autodetect   如果有默认的构造方法，通过 construct的方式自动装配，否则使用 byType的方式自动装配。
 *   用于spring2.5 ，spring3.0测试不通过，估计是废弃了
 */
public class Panda {
    private KungFu kungfu;
    
//    public Panda(KungFu kungfu) {
//        System.out.println("autowiring by constructor");
//        this.kungfu = kungfu;
//    }

    public KungFu getKungfu() {
        return kungfu;
    }

    public void setKungfu(KungFu kungfu) {
        System.out.println("autowiring by type");
        this.kungfu = kungfu;
    }
    
    @Override
    public String toString() {
        return "Panda [kungfu=" + kungfu + "]";
    }
}
