package week1.demo4;

public class Dog implements IEateAnimal,ISwimAnimal{
    @Override
    public void eat() {
        System.out.println("狗可以吃饭");
    }

    @Override
    public void swim() {
        System.out.println("狗可以游泳");
    }
}
