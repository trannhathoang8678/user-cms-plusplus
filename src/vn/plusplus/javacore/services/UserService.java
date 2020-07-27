package vn.plusplus.javacore.services;

import vn.plusplus.javacore.interfaces.UserInterface;
import vn.plusplus.javacore.models.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserInterface {
    @Override
    public List<User> readAllUserFromDB() {
        List<User> users = new ArrayList<>();
        User user;
        String file = new File("data/user.txt").getAbsolutePath();
        String line ;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while( (line = bufferedReader.readLine()) != null)
            {
                String[] s = line.split("#");
                user = new User(s[0],s[1],s[2],s[3],Integer.parseInt(s[4]),s[5],s[6]);
                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Doc file bi loi");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void writeAllUserToDB(List<User> users) {
        // users.add(new User("username","password","fullname","gender",18,"address","email"));
        String file = new File("data/user.txt").getAbsolutePath();
        try (FileWriter fileWriter = new FileWriter(file, false);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (User user : users)
                printWriter.append(user.getUsername() + '#' + user.getPassword() + '#'
                        + user.getFullname() + '#' + user.getGender() + '#' + user.getAge() + '#'
                        + user.getAddress() + '#' + user.getEmail() + '\n');

        } catch (IOException e) {
            System.out.println("Ghi vao file bi loi");
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
        int cnt = 0;
        for(User user : users)
        {
            System.out.println("User " + ++cnt);
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Gender: " + user.getGender());
            System.out.println("Age: " + user.getAge());
            System.out.println("Address: " + user.getAddress());
            System.out.println("Email: " + user.getEmail());
        }
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
