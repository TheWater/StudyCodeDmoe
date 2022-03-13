package week2.demo2;

import week2.demo2.ICourse;

public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("java正在录制课程");
    }
}

