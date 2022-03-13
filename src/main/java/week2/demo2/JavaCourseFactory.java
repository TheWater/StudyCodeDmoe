package week2.demo2;

import week2.demo2.ICourse;
import week2.demo2.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
