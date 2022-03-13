package week1.demo1;

public class JavaDiscountCourse extends JavaCourse{
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double getPrice() {
        return super.getPrice()*0.6;
    }
    public Double getOriginPrice(){
        return  super.getPrice();
    }
}
