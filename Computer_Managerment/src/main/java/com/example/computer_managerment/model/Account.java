package com.example.computer_managerment.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Account {
    protected int id;
    protected String email;
    protected String password;
    protected String fullName;
    protected int idCountry;
    public Account(){}

    public Account(int id, String email, String password, String fullName, int idCountry) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.idCountry = idCountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @NotEmpty
    @NotEmpty(message = "Email không được để trống")
    @Email(regexp = "^[A-Za-z0-9._]+@[a-z]+\\.[a-z]{2,3}$", message = "Email khong hop le!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }
}
