package com.pitstopManager.model;

import java.sql.Timestamp;

/**
 * UserModel represents a user in the PitStop Manager application.
 */
public class UserModel {
    private int userId;
    private String username;
    private String email;
    private String password;
    private String role;
    private Timestamp createdAt;
    private Timestamp lastLogin;
    
    /**
     * Default constructor
     */
    public UserModel() {
    }
    
    /**
     * Full constructor with all fields
     */
    public UserModel(int userId, String username, String email, String password, 
                     String role, Timestamp createdAt, Timestamp lastLogin) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
    }
    
    // Getters and Setters
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
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
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    public Timestamp getLastLogin() {
        return lastLogin;
    }
    
    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }
}