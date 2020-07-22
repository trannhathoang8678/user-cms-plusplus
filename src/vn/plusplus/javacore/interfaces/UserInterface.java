package vn.plusplus.javacore.interfaces;

import vn.plusplus.javacore.models.User;

import java.util.List;

public interface UserInterface {

    //0. Common function
    List<User> readAllUserFromDB();
    void writeAllUserToDB(List<User> users);


    //1. Register feature
    boolean verifyData(User user);
    User findUserByUsername(String username);
    void saveAccountToDB(User user);

    //2. Login feature
    User findUserByUsernameAndPassword(String username, String password);

    //3. Reset password
    boolean verifyEmail(String email);
    User findUserByEmail(String email);
    void sendTokenResetToEmail(String email);
    void saveTokenResetToDB(String token, String email, String username);

    //4. Display user list
    void displayUsers(List<User> users);

    //5. Find user
    List<User> findUserByRangeAge(Integer fromAge, Integer toAge);
    List<User> findUserByGender(String gender);

    //6. Delete user
    // User findUserByUsername(String username);
    void removeUserToDB(User user);

    //7. Change password
    // User findUserByUsernameAndPassword(String username, String password); => Yeu cau nhap dung username va mat khau cu
    void verifyNewPass(String newPass, String oldPass);
    void updateUserPass(User user, String newPass);

    //8. Update user information
    // Call login feature first
    boolean verifyUpdateInfo(String email, String phone, String address);
    void updateUserInfo(User user, String email, String phone, String address);

}
