package week2.demo4;

public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExetorThread());
        Thread thread2 = new Thread(new ExetorThread());
        thread1.start();
        thread2.start();
    }
}
