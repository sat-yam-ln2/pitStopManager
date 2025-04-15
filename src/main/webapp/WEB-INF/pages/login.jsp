<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PitStop Manager</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="background">
        <div class="login-container">
            <h1>PitStop Manager</h1>
            <form action="login" method="post">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="driverdata@pitstopmanager.com">
                
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Password">
                
                <button type="submit" class="login-btn">Login</button>
				<div class="register-link">
				    <span>New to PitStop Manager?</span>
				    <a href="${pageContext.request.contextPath}/signup">Register</a>
				</div>
            </form>
            
            <% 
                // Check if error is present in the request attribute
                String error = (String) request.getAttribute("error");
                if (error != null && !error.isEmpty()) { 
            %>
                <div class="error-message"><%= error %></div>
            <% 
                } 
            %>
        </div>
    </div>
</body>
</html>
