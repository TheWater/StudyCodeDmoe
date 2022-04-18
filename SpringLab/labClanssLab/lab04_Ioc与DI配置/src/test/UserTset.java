import dao.SomeUser;
import dao.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTset {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SomeUser someUser = (SomeUser) context.getBean("someUser");
        User[] someUserArray = someUser.getSomeUserArray();
        for (int i = 0; i < someUserArray.length; i++) {
            System.out.println(someUserArray[i].getName()+"   ");
        }

    }
}
