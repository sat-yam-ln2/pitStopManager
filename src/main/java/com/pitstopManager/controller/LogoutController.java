package com.pitstopManager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.pitstopManager.util.CookieUtil;
import com.pitstopManager.util.SessionUtil;

import java.io.IOException;

/**
 * LogoutController handles user logout by clearing session and cookies.
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles POST requests for logout.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delete relevant cookies (e.g., role, username, token, etc.)
        CookieUtil.deleteCookie(response, "role");

        // Invalidate the session
        SessionUtil.invalidateSession(request);

        // Redirect user to login page after logout
        response.sendRedirect(request.getContextPath() + "/login");
    }

    /**
     * Optional: Redirect GET request to POST for consistency.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
