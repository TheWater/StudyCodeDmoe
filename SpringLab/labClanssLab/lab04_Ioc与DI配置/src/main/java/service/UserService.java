package service;

public class UserService implements IUserService{
    IUserService userService;
    @Override
    public void getUser() {
        userService.getUser();
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
