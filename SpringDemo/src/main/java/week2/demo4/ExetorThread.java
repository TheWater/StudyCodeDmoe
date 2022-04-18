package week2.demo4;

public class ExetorThread implements Runnable{
    @Override
    public void run() {
        LazyDoubleChck singleton = LazyDoubleChck.getInstance();
        System.out.println(Thread.currentThread().getName()+':'+singleton);
    }
}
