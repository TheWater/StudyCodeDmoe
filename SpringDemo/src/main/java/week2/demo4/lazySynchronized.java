package week2.demo4;

public class lazySynchronized {
    private lazySynchronized(){}
    private static lazySynchronized lazy = null;
    public synchronized static lazySynchronized getInstance(){
        if(lazy==null){
            lazy = new lazySynchronized();
        }
        return lazy;
    }
}
