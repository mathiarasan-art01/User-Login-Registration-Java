<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.auth.model.User" %>

<%
User user = (User) session.getAttribute("user");
if (user == null) {
    response.sendRedirect(request.getContextPath() + "/login.html");
    return;
}

String email = user.getEmail();
String username = user.getUsername();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>

<style>
body {
    margin: 0;
    height: 100vh;
    font-family: 'Segoe UI', sans-serif;
    background: radial-gradient(circle at top, #1d2671, #c33764);
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
}
.card {
    background: rgba(0,0,0,0.35);
    backdrop-filter: blur(10px);
    padding: 40px;
    border-radius: 18px;
    width: 420px;
    text-align: center;
}
.avatar {
    width: 90px;
    height: 90px;
    margin: auto;
    border-radius: 50%;
    background: linear-gradient(135deg,#00f260,#0575e6);
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 36px;
    font-weight: bold;
}
.btn {
    display: inline-block;
    padding: 12px 28px;
    margin: 8px;
    border-radius: 30px;
    text-decoration: none;
    font-weight: 600;
}
.profile { background: white; color: #333; }
.logout { background: #ff4b2b; color: white; }
</style>
</head>

<body>

<div class="card">
    <div class="avatar">
        <%= email.substring(0,1).toUpperCase() %>
    </div>

    <h1>Welcome, <%= username %> 🎉</h1>
    <p><strong>Email:</strong> <%= email %></p>

    <a href="<%= request.getContextPath() %>/profile.jsp" class="btn profile">
        View Profile
    </a>

    <a href="<%= request.getContextPath() %>/logout" class="btn logout">
        Logout
    </a>
</div>

</body>
</html>

