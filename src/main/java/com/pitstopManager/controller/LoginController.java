package com.pitstopManager.controller;

import com.pitstopManager.model.UserModel;
import com.pitstopManager.service.LoginService;
import com.pitstopManager.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LoginService loginService;

    public LoginController() {
        super();
        loginService = new LoginService();  // Initialize LoginService
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the login page (this can be your login.jsp page)
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a user model object with the provided email and password
        UserModel userModel = new UserModel();
        userModel.setEmail(email);
        userModel.setPassword(password);

        // Authenticate user
        Boolean loginSuccess = loginService.loginUser(userModel);

        if (loginSuccess != null && loginSuccess) {
            // Login successful, set the user session and redirect to the dashboard or main page
            SessionUtil.setAttribute(request, "user", userModel);  // Store user in session
            response.sendRedirect("dashboard");  // Redirect to a dashboard or other page
        } else if (loginSuccess != null && !loginSuccess) {
            // Login failed, show an error message
            request.setAttribute("error", "Invalid email or password.");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } else {
            // In case of a server error (null returned from loginUser)
            request.setAttribute("error", "An error occurred while logging in. Please try again.");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }
}
