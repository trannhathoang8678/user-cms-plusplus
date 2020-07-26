package vn.plusplus.javacore.services;

import vn.plusplus.javacore.interfaces.UserInterface;
import vn.plusplus.javacore.models.User;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.List;

public class UserService implements UserInterface {
    @Override
    public List<User> readAllUserFromDB() {
        return null;
    }

    @Override
    public void writeAllUserToDB(List<User> users) {
       // users.add(new User("username","password","fullname","gender",18,"address","email"));
        String file = new File("data/user.txt").getAbsolutePath();
        try(FileWriter fileWriter = new FileWriter(file,false);
            PrintWriter printWriter = new PrintWriter(fileWriter))
        {

                for(User user :users)
                    printWriter.append(user.getUsername() + '#' + user.getPassword() + '#'
                    + user.getFullname() + '#' + user.getGender() + '#' +user.getAge() + '#'
                    + user.getAddress() + '#' +user.getEmail() + '\n');

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public boolean verifyData(User user) {
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        List<User> users = readAllUserFromDB();
        return null;
    }

    @Override
    public void saveAccountToDB(User user) {
        List<User> users = readAllUserFromDB();
        // Do your code


        // End your code
        writeAllUserToDB(users);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public boolean verifyEmail(String email) {
        return false;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public String sendTokenResetToEmail(String email) {
        return null;
    }

    @Override
    public boolean verifyToken(String token, String userToken) {
        return false;
    }

    @Override
    public void displayUsers(List<User> users) {

    }

    @Override
    public List<User> findUserByRangeAge(Integer fromAge, Integer toAge) {
        return null;
    }

    @Override
    public List<User> findUserByGender(String gender) {
        return null;
    }

    @Override
    public void removeUserToDB(User user) {

    }

    @Override
    public boolean verifyNewPass(String newPass, String oldPass) {
        return false;
    }

    @Override
    public void updateUserPass(User user, String newPass) {

    }

    @Override
    public boolean verifyUpdateInfo(String email, int age, String address) {
        return false;
    }

    @Override
    public void updateUserInfo(User user, String email, int age, String address) {

    }
}
