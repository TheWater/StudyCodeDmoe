package week2.demo4;

public class HuangrySingleton {
    // 先加载静态属性及代码块，再加载构造方法和非静态
    private static HuangrySingleton huangrySingLeton = new HuangrySingleton();

    private HuangrySingleton() {
        System.out.println("构造方法");
    }

    public static HuangrySingleton getInstance() {
        System.out.println("getInstance");
        return huangrySingLeton;
        //饿汉式适用于单例对象较少的情况
    }
}
