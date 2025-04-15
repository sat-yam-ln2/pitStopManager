<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - PitStop Manager</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="signup-container">
        <div class="signup-left">
            <img src="${pageContext.request.contextPath}/css/signup_bg.jpg" alt="Car Image">
        </div>
        <div class="signup-right">
            <h1>Sign up</h1>
            <form action="signup" method="post">
                
                <!-- Full Name -->
                <label for="fullname">Full name</label>
                <input type="text" id="fullname" name="fullname" placeholder="Username" value="${param.fullname}">
                <!-- Display Error for Full Name -->
                <div class="error">
                    ${not empty requestScope.fullnameError ? requestScope.fullnameError : ''}
                </div>

                <!-- Email -->
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="driverdata@pitstopmanager.com" value="${param.email}">
                <!-- Display Error for Email -->
                <div class="error">
                    ${not empty requestScope.emailError ? requestScope.emailError : ''}
                </div>

                <!-- Password -->
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="************">
                <!-- Display Error for Password -->
                <div class="error">
                    ${not empty requestScope.passwordError ? requestScope.passwordError : ''}
                </div>

                <!-- Global Error -->
                <div class="error global-error">
                    ${not empty requestScope.globalError ? requestScope.globalError : ''}
                </div>

                <button type="submit" class="signup-btn">Register</button>
            </form>
        </div>
    </div>
</body>
</html>
