package week2.demo5;

public class ShallowCloneTest {
    public static void main(String[] args) {
        QiTianDaShengShallow qi = new QiTianDaShengShallow();
        QiTianDaShengShallow clone = (QiTianDaShengShallow) qi.clone();
        System.out.println("浅克隆："+(qi.jinGuBang==clone.jinGuBang));

    }
}
