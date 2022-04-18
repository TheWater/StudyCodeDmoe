import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAcountService;

public class setterInJectTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IAcountService acountService = (IAcountService) context.getBean("accountService");
        acountService.getAccount();
    }
}
