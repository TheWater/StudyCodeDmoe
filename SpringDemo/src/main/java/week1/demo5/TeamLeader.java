package week1.demo5;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {
    public void checkNumberOfCourse(){
        List<Course> courseList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已经发布的课程数量是："+courseList.size());
    }
}
