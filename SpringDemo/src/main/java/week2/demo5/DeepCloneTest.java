package week2.demo5;

public class DeepCloneTest {
    public static void main(String[] args) {
        QiTianDaShengDeep qi = new QiTianDaShengDeep();
        QiTianDaShengDeep clone = (QiTianDaShengDeep) qi.clone();
        System.out.println("深克隆："+(qi.jinGuBang==clone.jinGuBang));
    }
}
