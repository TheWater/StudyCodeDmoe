package week2.demo1;
//  1、假设现在开设有Java架构、大数据、人工智能等课程。
//  2、我们有一个课程标准ICourse接口：
//  3、创建一个Java课程的实现类：
import week2.demo1.ICourse;

public class CourseFactoryRef {
    public ICourse create(Class<? extends ICourse> clazz) throws InstantiationException, IllegalAccessException {
        if(null != clazz){
            return clazz.newInstance();
       }
        return null;
    }
}
