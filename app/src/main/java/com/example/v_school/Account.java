package com.example.v_school;

import java.io.Serializable;

public class Account implements Serializable {
    private String id;
    private String username;
    private String phone;
    private String address;
    private String role;
    private String password;

    public Account() {
    }

    public Account(String id, String username, String phone, String address, String role) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public Account(String id, String username, String phone, String address, String role, String password) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

