package vn.plusplus.javacore.models;

import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String address;
    private String gender;
    private int age;
    Scanner sc = new Scanner(System.in);
    //initialization
    public User(String username, String password, String fullname, String gender, int age, String address, String email) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }

    public User() {
        System.out.println("Write properties of your account ");
        System.out.println("Notice that there are no space in any properties of yours");
        System.out.print("Username: ");
        username = sc.next();
        System.out.print("Password: ");
        password = sc.next();
        System.out.print("Fullname: ");
        fullname = sc.next();
        System.out.print("Email: ");
        email = sc.next();
        System.out.print("Address: ");
        address = sc.next();
        System.out.print("Gender: ");
        gender = sc.next();
        System.out.print("Age: ");
        age = sc.nextInt();
    }
    //getters,setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
