package week1.demo1;

public class OpenCloseTest {
    public static void main(String[] args) {
        ICoure javaCourse;
        javaCourse = new JavaDiscountCourse(1,"面向对象程序设计",120.0);
        System.out.println(javaCourse.getPrice());
    }
}
