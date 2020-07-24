package vn.plusplus.javacore;

import vn.plusplus.javacore.models.User;
import vn.plusplus.javacore.services.UserService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        while(true)
        {
            System.out.println("0.Exit");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Reset password");
            System.out.println("4.Display user list");
            System.out.println("5.Find users by range age");
            System.out.println("6.Find users by gender");
            System.out.println("7.Delete user");
            System.out.println("8.Change password");
            System.out.println("9.Update information");
            System.out.println("Write a corresponding number (from 0 to 8) to method you choose: ");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    User user = new User();
                    if(userService.verifyData(user)&&userService.findUserByUsername(user.getUsername())==null)
                    {
                        userService.saveAccountToDB(user);
                        System.out.println("Register success");
                    }
                    else
                    {
                        System.out.println("Register fail");
                    }
                    break;
                case 2:
                    String username = sc.next();
                    String password = sc.next();
                    if(userService.findUserByUsernameAndPassword(username,password)!=null)
                    {
                        System.out.println("Login success");
                    }
                    else
                    {
                        System.out.println("Login fail");
                    }
                    break;
                case 3:
                    String email = sc.next();
                    User user;
                    if(userService.verifyEmail(email)&&(user=userService.findUserByEmail(email)!=null))
                    {
                        userService.sendTokenResetToEmail(email);
                        System.out.println("Write the token you reiceive in your email");
                        String token = sc.next();
                        userService.saveTokenResetToDB(token,email,user.getUsername());
                    }
                    break;
                case 4:

            }
        }
    }
}
