package com.pitstopManager.controller;

import com.pitstopManager.model.UserModel;
import com.pitstopManager.service.RegisterService;
import com.pitstopManager.util.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * RegisterController handles user registration requests and processes form
 * submissions. It validates input and provides user-friendly feedback.
 */
@WebServlet("/signup")
public class RegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final RegisterService registerService = new RegisterService();

    // ✅ Added to handle GET request when "Register" link is clicked
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Grab form inputs
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate and collect errors
        Map<String, String> errors = new HashMap<>();

        if (fullname == null || fullname.trim().isEmpty()) {
            errors.put("fullnameError", "Full name is required.");
        }

        if (email == null || !isValidEmail(email)) {
            errors.put("emailError", "Please enter a valid email address.");
        }

        if (password == null || password.trim().length() < 6) {
            errors.put("passwordError", "Password must be at least 6 characters.");
        }

        // If errors exist, send them back to the signup page
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            request.setAttribute("fullname", fullname);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
            return;
        }

        // Encrypt the password using AES encryption
        String encryptedPassword = PasswordUtil.encrypt(email, password);

        // Populate model with user data
        UserModel user = new UserModel();
        user.setUsername(fullname);
        user.setEmail(email);
        user.setPassword(encryptedPassword);  // Store encrypted password
        user.setRole("user");
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setLastLogin(null);

        boolean success = registerService.registerUser(user);

        if (success) {
            request.setAttribute("success", "Registration successful. Please login.");
            request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
        } else {
            request.setAttribute("globalError", "Registration failed. Please try again.");
            request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }
}
