package vn.plusplus.javacore;

import vn.plusplus.javacore.models.User;
import vn.plusplus.javacore.services.UserService;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        while (true) {
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
            User user;
            String username, password, email, phone, address;
            int age;
            switch (choice) {
                case 1:
                    user = new User();
                    if (userService.verifyData(user) && userService.findUserByUsername(user.getUsername()) == null) {
                        userService.saveAccountToDB(user);
                        System.out.println("Register success");
                    } else {
                        System.out.println("Register fail");
                    }
                    break;
                case 2:
                    username = sc.next();
                    password = sc.next();
                    if (userService.findUserByUsernameAndPassword(username, password) != null) {
                        System.out.println("Login success");
                    } else {
                        System.out.println("Login fail");
                    }
                    break;
                case 3:
                    System.out.print("Write you email: ");
                    email = sc.next();
                    user = null;
                    if (userService.verifyEmail(email) && ((user = userService.findUserByEmail(email)) != null)) {
                        String token = userService.sendTokenResetToEmail(email);
                        System.out.println("Write the token you reiceive in your email");
                        String userToken = sc.next();
                        if (userService.verifyToken(token, userToken)) {
                            System.out.println("Token is correct, create your new password");
                            do {
                                System.out.println("Write password with more than 6 characters with no space");
                                password = sc.next();
                            }
                            while (!userService.verifyNewPass(password, user.getPassword()));
                            userService.updateUserPass(user, password);
                            System.out.println("Reset password success");
                        } else {
                            System.out.println("Reset password fail");
                        }
                    }
                    break;
                case 4:
                    userService.displayUsers(userService.readAllUserFromDB());
                    break;
                case 5:
                    System.out.println("Write range age");
                    System.out.print("From: ");
                    int fromAge = sc.nextInt();
                    System.out.print("To: ");
                    int toAge = sc.nextInt();
                    userService.displayUsers(userService.findUserByRangeAge(fromAge, toAge));
                    break;
                case 6:
                    System.out.print("Write gender you want to find (M or F): ");
                    String gender = sc.next();
                    userService.displayUsers(userService.findUserByGender(gender));
                    break;
                case 7:
                    System.out.print("Write username you want to remove");
                    username = sc.next();
                    userService.removeUserToDB(userService.findUserByUsername(username));
                    break;
                case 8:
                    username = sc.next();
                    password = sc.next();
                    if ((user = userService.findUserByUsernameAndPassword(username, password)) != null) {
                        System.out.println("Login success");
                        do {
                            System.out.println("Write password with more than 6 characters with no space");
                            password = sc.next();
                        }
                        while (!userService.verifyNewPass(password, user.getPassword()));
                        userService.updateUserPass(user, password);
                        System.out.println("Reset password success");
                    } else {
                        System.out.println("Login fail");
                    }
                    break;
                case 9:
                    username = sc.next();
                    password = sc.next();
                    if ((user = userService.findUserByUsernameAndPassword(username, password)) != null) {
                        System.out.println("Login success");
                        System.out.print("Email: ");
                        email = sc.next();
                        System.out.print("Address: ");
                        address = sc.next();
                        System.out.print("Age: ");
                        age = sc.nextInt();
                        userService.verifyUpdateInfo(email, age, address);
                        userService.updateUserInfo(user, email, age, address);
                    } else {
                        System.out.println("Login fail");
                    }
                    break;
                case 0:
                    System.out.println("End of program");
                    return;
                default:
                    System.out.println("Please choose the right number");
            }
        }
    }
}
