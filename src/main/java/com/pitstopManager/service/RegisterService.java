package com.pitstopManager.service;

import com.pitstopManager.config.DbConfig;
import com.pitstopManager.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * RegisterService handles user registration in the PitStop Manager application.
 */
public class RegisterService {

    private Connection dbConn;

    /**
     * Constructor to initialize database connection
     */
    public RegisterService() {
        try {
            this.dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Registers a new user in the database.
     *
     * @param user The UserModel object with user details
     * @return true if registration is successful, false otherwise
     */
    public boolean registerUser(UserModel user) {
        if (dbConn == null) {
            System.err.println("Database connection is not available.");
            return false;
        }

        String insertQuery = "INSERT INTO users (username, email, password, role, created_at, last_login) " +
                             "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = dbConn.prepareStatement(insertQuery)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword()); // Consider encrypting this!
            stmt.setString(4, user.getRole());
            stmt.setTimestamp(5, user.getCreatedAt() != null ? user.getCreatedAt() : new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(6, user.getLastLogin());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error during user registration: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
