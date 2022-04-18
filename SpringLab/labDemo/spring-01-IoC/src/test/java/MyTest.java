import com.dao.UserDaoImpl;
import com.dao.UserDaoMySqlImpl;
import com.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
//        ((UserServiceImpl)userService).setUserDao(new UserDaoMySqlImpl());
//        userService.getUser();

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();

    }
}
