package models;

import java.time.Instant;

public class User {
    private long id;
    private String nameUser;
    private String passWord;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String role;

    private Instant timeCreatUser;

    public User() {
    }

    public User(long id, String nameUser, String password, String name, String phone, String email, String address, String role, Instant timeCreatUser) {
        this.id = id;
        this.nameUser = nameUser;
        this.passWord = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
        this.timeCreatUser = timeCreatUser;
    }

    public Instant getTimeCreatUser() {
        return timeCreatUser;
    }

    public void setTimeCreatUser(Instant timeCreatUser) {
        this.timeCreatUser = timeCreatUser;
    }

    public static User parseUser(String rawUser) {
        String[] array = rawUser.split(",");
        User user = new User();
        user.setId(Long.parseLong(array[0]));
        user.setNameUser(array[1]);
        user.setPassWord(array[2]);
        user.setName(array[3]);
        user.setPhone(array[4]);
        user.setEmail(array[5]);
        user.setAddress(array[6]);
        user.setRole(array[7]);
        user.setTimeCreatUser(Instant.parse(array[8]));
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                id,
                nameUser,
                passWord,
                name,
                phone,
                email,
                address,
                role,
                timeCreatUser);
    }
}
