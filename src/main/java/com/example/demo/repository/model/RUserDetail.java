package com.example.demo.repository.model;

import java.io.Serializable;

public class RUserDetail implements Serializable {

    private static final long serialVersionUID = -6347911007178390219L;

    private long user_id;
    private String role;

    public RUserDetail(long user_id, String role) {
        this.user_id = user_id;
        this.role = role;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RUserDetail{" +
                "userId=" + user_id +
                ", role='" + role + '\'' +
                '}';
    }
}
