package vn.plusplus.javacore.models;

public class User {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String address;
    private String gender;
    private int age;
    //initialization
    public User(String username, String password, String fullname, String email, String address, String gender, int age) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }

    public User() {
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
