package dao;

public class UserDao implements IUserDao{
    private User user;

    public void getUser() {
        System.out.println(user);
    }

    public void setUser(User user) {
        this.user = user;
    }


}
