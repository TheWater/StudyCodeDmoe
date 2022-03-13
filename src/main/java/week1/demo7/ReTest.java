package week1.demo7;


import java.lang.reflect.Field;

public class ReTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1.获取Class对象
        Class c1 = Class.forName("week1.demo7.User");
        //2.构造一个对象（本质上调用User无参构造器
        //也可以使用有参构造器来实例化
        User user = (User)c1.newInstance();
        //3.获取类的名字
        System.out.println("获取包名+类名："+c1.getName());//获取包名+类名
        System.out.println("获取类名："+c1.getSimpleName());//获取类名
        //4.获取类的属性
        Field[] field1 = c1.getFields();//获取类的全部public属性
        for(Field filed : field1){
            System.out.println("获取类的全部public属性"+filed);
        }
        Field[] field2 = c1.getDeclaredFields();//获取类的全部属性
        for(Field filed : field2){
            System.out.println("获取类的全部属性："+filed);
        }

        Field id = c1.getField("id");//获取指定属性的值
        System.out.println("获取指定属性的值"+id);
        id.set(user,"123");//属性修改
        System.out.println("获取修改后属性的值"+user.id);//验证属性修改

    }
}
