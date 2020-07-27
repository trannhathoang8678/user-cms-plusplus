package vn.plusplus.javacore;

import vn.plusplus.javacore.services.UserService;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserService();
        if (userService.verifyEmail("q@uang145ok") ) {
            System.out.println("ok");
        }else {
            System.out.println("fall");
        }
    }
}
