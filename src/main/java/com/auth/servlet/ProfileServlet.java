package com.auth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect("login.html?error=session_expired");
            return;
        }
        req.getRequestDispatcher("profile.jsp").forward(req, res);
    


        // User object session-இல் இருந்து எடு
        Object user = session.getAttribute("user");

        // User data JSP-க்கு அனுப்பவும்
        req.setAttribute("user", user);

        // profile.jsp-க்கு request forward பண்ணு
        req.getRequestDispatcher("profile.jsp").forward(req, res);
    }
}
