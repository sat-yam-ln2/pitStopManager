package com.pitstopManager.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.pitstopManager.config.DbConfig;
import com.pitstopManager.model.UserModel;

/**
 * LoginService provides methods for user authentication and registration.
 */
public class LoginService {
    
    /**
     * Authenticates a user based on email and password.
     * 
     * @param userModel UserModel containing login credentials
     * @return Boolean true if login successful, false if credentials invalid, null if server error
     */
    public Boolean loginUser(UserModel userModel) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DbConfig.getDbConnection();
            
            String sql = "SELECT * FROM user WHERE Email = ? AND Password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userModel.getEmail());
            stmt.setString(2, userModel.getPassword()); // In a real app, use password hashing!
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Populate the user model with data from database
                userModel.setUserId(rs.getInt("UserID"));
                userModel.setUsername(rs.getString("Username"));
                userModel.setRole(rs.getString("Role"));
                userModel.setCreatedAt(rs.getTimestamp("CreatedAt"));
                userModel.setLastLogin(rs.getTimestamp("LastLogin"));
                
                // Update last login time
                updateLastLogin(userModel.getUserId());
                
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null; // Indicates server error
        } finally {
            closeResources(conn, stmt, rs);
        }
    }
    
    /**
     * Updates the last login timestamp for a user.
     * 
     * @param userId The ID of the user
     */
    private void updateLastLogin(int userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DbConfig.getDbConnection();
            
            String sql = "UPDATE user SET LastLogin = ? WHERE UserID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(2, userId);
            
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
    }
    
    /**
     * Registers a new user in the system.
     * 
     * @param userModel UserModel containing user information
     * @return Boolean true if registration successful, false if failed, null if server error
     */
    public Boolean registerUser(UserModel userModel) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DbConfig.getDbConnection();
            
            String sql = "INSERT INTO user (Username, Email, Password, Role, CreatedAt) " +
                         "VALUES (?, ?, ?, ?, ?)";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userModel.getUsername());
            stmt.setString(2, userModel.getEmail());
            stmt.setString(3, userModel.getPassword()); // In a real app, use password hashing!
            stmt.setString(4, userModel.getRole() != null ? userModel.getRole() : "user");
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null; // Indicates server error
        } finally {
            closeResources(conn, stmt, null);
        }
    }
    
    /**
     * Helper method to close database resources.
     */
    private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) DbConfig.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}