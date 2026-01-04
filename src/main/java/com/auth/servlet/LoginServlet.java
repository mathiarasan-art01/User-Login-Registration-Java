package com.auth.servlet;

import com.auth.dao.UserDAO;
import com.auth.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // UserDAO object create பண்ணுங்கள்
        UserDAO dao = new UserDAO();

        // loginUser method call பண்ணி User object பெறுங்கள்
        User user = dao.loginUser(email, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("email", user.getEmail());
            session.setAttribute("username", user.getUsername());
            res.sendRedirect("welcome.jsp");
        } else {
            res.sendRedirect("login.html?error=invalid_credentials");
        }
    }
}

   

