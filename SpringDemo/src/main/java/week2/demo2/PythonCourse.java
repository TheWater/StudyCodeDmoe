package week2.demo2;

import week2.demo2.ICourse;

public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("Python正在录制课程");
    }
}
