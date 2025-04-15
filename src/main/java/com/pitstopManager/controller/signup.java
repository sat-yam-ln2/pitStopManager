package com.pitstopManager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to signup page if accessed via GET
        request.getRequestDispatcher("WEB-INF/pages/signup.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Validate input fields
        boolean isValid = validateRegistrationInput(fullName, email, password);
        
        if (isValid) {
            // In a real application, you would save user data to the database
            // For now, just simulate successful registration and redirect to login page
            
            // Add a success message for the login page
            request.getSession().setAttribute("successMessage", "Registration successful! Please login.");
            
            // Redirect to login page after successful registration
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            // If validation fails, redirect back to signup with error message
            request.setAttribute("errorMessage", "Please fill all fields with valid information");
            request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
        }
    }
    
    /**
     * Validates user registration inputs
     * @param fullName User's full name
     * @param email User's email address
     * @param password User's password
     * @return true if all inputs are valid, false otherwise
     */
    private boolean validateRegistrationInput(String fullName, String email, String password) {
        // Check if any field is empty
        if (fullName == null || email == null || password == null) {
            return false;
        }
        
        if (fullName.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }
        
        // Basic email validation
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }
        
        // Basic password validation (at least 6 characters)
        if (password.length() < 6) {
            return false;
        }
        
        return true;
    }
}