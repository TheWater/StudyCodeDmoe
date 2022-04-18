package week2.demo4;

public class LazyDoubleChck {
    private volatile static LazyDoubleChck lazy = null;
    private LazyDoubleChck(){}
    public static LazyDoubleChck getInstance(){
        if(lazy==null){
            synchronized (LazyDoubleChck.class){
                if(lazy==null){
                    lazy = new LazyDoubleChck();
                }
            }
        }
        return lazy;
    }

}
