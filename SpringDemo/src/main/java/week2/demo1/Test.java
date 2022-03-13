package week2.demo1;

import week2.demo1.ICourse;
import week2.demo1.JavaCourse;

public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        CourseFactoryRef factoryRef = new CourseFactoryRef();
        ICourse course = factoryRef.create(JavaCourse.class);
        course.record();
    }
}
