package beforeAdivice;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeTest {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        IHello helloSpeaker=context.getBean("helloSpeaker",IHello.class);
        helloSpeaker.hello("Spring");
    }
}
