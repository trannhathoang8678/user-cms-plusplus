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

    @Override // Quang
    public boolean verifyData(User user) {
        if(verifyEmail(user.getEmail()) && user.getPassword().matches(".{6,}") &&
                user.getFullname() != null &&
                user.getAddress() != null &&
                user.getAge() != 0 &&
                user.getGender() != null &&
                user.getUsername() != null){
            return true;
        }
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        List<User> users = readAllUserFromDB();
        return null;
    }

    @Override //Quang
    public void saveAccountToDB(User user) {
        List<User> users = readAllUserFromDB();
        // Do your code
        users.add(user);
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

    @Override // Quang
    public User findUserByEmail(String email) {
        List<User> users = readAllUserFromDB();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public void sendTokenResetToEmail(String email) {

    }

    @Override
    public void saveTokenResetToDB(String token, String email, String username) {

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
