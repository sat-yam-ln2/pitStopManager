package com.pitstopManager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class login
 */
@WebServlet("/")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to login page if accessed via GET
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // For now, just implement basic validation without database integration
        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            // In a real application, you would validate against database
            // For now, just simulate successful login and redirect to home page
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("isLoggedIn", true);
            
            // Redirect to home page after successful login
            response.sendRedirect(request.getContextPath() + "/pages/home.jsp");
        } else {
            // If validation fails, redirect back to login with error message
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }
}