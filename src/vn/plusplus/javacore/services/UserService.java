package vn.plusplus.javacore.services;

import vn.plusplus.javacore.interfaces.UserInterface;
import vn.plusplus.javacore.models.User;

import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserService implements UserInterface {

    private SendEmailService emailService;

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();

    private static final String DATA_FOR_RANDOM_STRING = CHAR_UPPER;
    private static SecureRandom random = new SecureRandom();


    private SendEmailService getEmailService() {
        if (emailService == null) {
            emailService = new SendEmailService();
        }
        return emailService;
    }

    @Override
    public List<User> readAllUserFromDB() {
        List<User> users = new ArrayList<>();
        User user;
        String file = new File("data/user.txt").getAbsolutePath();
        String line;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] s = line.split("#");
                user = new User(s[0], s[1], s[2], s[3], Integer.parseInt(s[4]), s[5], s[6]);
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

    @Override // Quang
    public boolean verifyData(User user) {
        if (user.getFullname() != null && user.getAge() != 0 &&
                user.getGender().matches("[MF]") &&
                user.getAddress() != null &&
                user.getUsername() != null &&
                user.getPassword().matches(".{6,}") &&
                user.getEmail().endsWith("@gmail.com")) {
            return true;
        }
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        List<User> users = readAllUserFromDB();
        for (User a : users) {
            if (a.getUsername().equals(username)) {
                return a;
            }
        }
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
        List<User> users = readAllUserFromDB();
        for (User a : users) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public boolean verifyEmail(String email) {
        if (email.endsWith("@gmail.com"))
            return true;
        else
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
    public String sendTokenResetToEmail(String email) {
        String token = generateRandomString(6);
        String content = "Token to reset password for you: " + token;
        emailService = getEmailService();
        try {
            emailService.sendEmail("Reset password email", email, content);
        } catch (Exception e) {
            System.out.println("Send email reset pass failed");
        }
        return token;
    }

    public static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);

        }

        return sb.toString();

    }

    @Override
    public boolean verifyToken(String token, String userToken) {
        if (token.equals(userToken)) {
            return true;
        }
        return false;
    }

    @Override
    public void displayUsers(List<User> users) {
        int cnt = 0;
        for (User user : users) {
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
        List<User> users = readAllUserFromDB();
        List<User> usersInRangeAge = new ArrayList<>();
        boolean checkUsersInRangeAgeExist = false;
        for (User user : users)
            if (user.getAge() >= fromAge && user.getAge() <= toAge) {
                usersInRangeAge.add(user);
                checkUsersInRangeAgeExist = true;
            }
        if (checkUsersInRangeAgeExist)
            return usersInRangeAge;
        else
            return null;
    }

    @Override
    public List<User> findUserByGender(String gender) {
        List<User> users = readAllUserFromDB();
        List<User> usersByGender = new ArrayList<>();
        boolean checkUsersByGenderExist = false;
        for (User user : users)
            if (user.getGender().equals(gender)) {
                usersByGender.add(user);
                checkUsersByGenderExist = true;
            }
        if (checkUsersByGenderExist)
            return usersByGender;
        else
            return null;
    }

    @Override
    public void removeUserToDB(User userNeedToRemove) {
        if(userNeedToRemove == null)
        {
            System.out.println("There is no user in DB have the same username");
            return;
        }
        List<User> users = readAllUserFromDB();
        List<User> usersListHaveDeletedUser = new ArrayList<>();;
        for( User user : users)
            if(!user.getUsername().equals(userNeedToRemove.getUsername()))
            {
                usersListHaveDeletedUser.add(user);
            }
        writeAllUserToDB(usersListHaveDeletedUser);
    }

    @Override
    public boolean verifyNewPass(String newPass, String oldPass) {
        if (newPass.matches("[^ ]{6,}") && !newPass.equals(oldPass))
            return true;
        else
            return false;
    }

    @Override
    public void updateUserPass(User user, String newPass) {
    }

    @Override
    public boolean verifyUpdateInfo(String email, int age, String address) {
        {
            if (email.endsWith("@gmail.com")) {
                return true;
            }
            if (age > 0 && age < 120) {
                return true;
            }
            if (address != null && address != "") {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateUserInfo(User user, String email, int age, String address) {
        List<User> allUsers = readAllUserFromDB();

        for (User u : allUsers) {
            if (u.getUsername().equals(user.getUsername())) {
                u.setEmail(email);
                u.setAge(age);
                u.setAddress(address);
                break;
            }
        }

        writeAllUserToDB(allUsers);
    }
}
