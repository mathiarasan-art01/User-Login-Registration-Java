package com.auth.servlet;

import com.auth.dao.UserDAO;
import com.auth.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;  // ✅ ADD THIS

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(username, email, password);
        UserDAO dao = new UserDAO();
        dao.registerUser(user);

        res.sendRedirect("login.html");
    }
}
