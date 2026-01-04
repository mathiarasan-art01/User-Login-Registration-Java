<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.auth.model.User" %>

<%
User user = (User) session.getAttribute("user");
if (user == null) {
    response.sendRedirect(request.getContextPath() + "/login.html");
    return;
}

String username = user.getUsername();
String email = user.getEmail();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>

<style>
body {
    margin: 0;
    height: 100vh;
    font-family: 'Segoe UI', sans-serif;
    background: linear-gradient(135deg, #141e30, #243b55);
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
}
.profile-card {
    background: rgba(255,255,255,0.1);
    padding: 40px;
    width: 420px;
    border-radius: 18px;
    text-align: center;
}
.avatar {
    width: 100px;
    height: 100px;
    margin: auto;
    border-radius: 50%;
    background: linear-gradient(135deg, #00c6ff, #0072ff);
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 40px;
    font-weight: bold;
}
.btn {
    padding: 12px 26px;
    margin: 6px;
    border-radius: 30px;
    text-decoration: none;
    font-weight: 600;
}
.back { background: white; color: #333; }
.logout { background: #ff4b2b; color: white; }
</style>
</head>

<body>

<div class="profile-card">
    <div class="avatar"><%= email.substring(0,1).toUpperCase() %></div>
    <h1><%= username %></h1>
    <p><strong>Email:</strong> <%= email %></p>

    <a href="welcome.jsp" class="btn back">⬅ Back</a>
    <a href="logout" class="btn logout">Logout</a>
</div>

</body>
</html>



