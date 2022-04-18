package week2.demo3;

public class AbstractFactory {
    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();

        factory=new PythonCourseFactory();
        factory.createVideo().record();
        factory.createNote().edit();
    }
}
