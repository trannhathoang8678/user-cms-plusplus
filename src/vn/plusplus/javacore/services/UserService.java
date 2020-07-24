package vn.plusplus.javacore.services;

import vn.plusplus.javacore.interfaces.UserInterface;
import vn.plusplus.javacore.models.User;

import java.util.List;

public class UserService implements UserInterface {
    @Override
    public List<User> readAllUserFromDB() {
        return null;
    }

    @Override
    public void writeAllUserToDB(List<User> users) {

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
    public void verifyNewPass(String newPass, String oldPass) {

    }

    @Override
    public void updateUserPass(User user, String newPass) {

    }

    @Override
    public boolean verifyUpdateInfo(String email, String phone, String address) {
        return false;
    }

    @Override
    public void updateUserInfo(User user, String email, String phone, String address) {

    }
}
