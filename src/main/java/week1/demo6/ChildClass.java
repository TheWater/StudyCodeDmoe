package week1.demo6;

public class ChildClass extends ParentClass{
    @Override
    public void pm(MyDog mydog) {
        super.pm(mydog);
    }
    public void cm(){
        System.out.println("子类可以增加自己的方法");
    }
}
