package com.auth.servlet;

import com.auth.model.User;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.json.JSONObject;

public class GoogleCallbackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String CLIENT_ID =

    private static final String CLIENT_SECRET =

    private static final String REDIRECT_URI =
        "http://localhost:8080/loginANDregister/google-callback";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/login.html");
            return;
        }

        /* STEP 1: Exchange code for access token */
        URL tokenUrl = URI.create("https://oauth2.googleapis.com/token").toURL();
        HttpURLConnection conn = (HttpURLConnection) tokenUrl.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String params =
            "code=" + URLEncoder.encode(code, "UTF-8") +
            "&client_id=" + URLEncoder.encode(CLIENT_ID, "UTF-8") +
            "&client_secret=" + URLEncoder.encode(CLIENT_SECRET, "UTF-8") +
            "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, "UTF-8") +
            "&grant_type=authorization_code";

        try (OutputStream os = conn.getOutputStream()) {
            os.write(params.getBytes(StandardCharsets.UTF_8));
        }

        if (conn.getResponseCode() != 200) {
            response.sendRedirect(request.getContextPath() + "/login.html");
            return;
        }

        StringBuilder tokenResponse = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                tokenResponse.append(line);
            }
        }

        JSONObject tokenJson = new JSONObject(tokenResponse.toString());
        String accessToken = tokenJson.getString("access_token");

        /* STEP 2: Fetch Google user info */
        URL userInfoUrl = URI.create("https://www.googleapis.com/oauth2/v2/userinfo").toURL();
        HttpURLConnection userInfoConn =
                (HttpURLConnection) userInfoUrl.openConnection();

        userInfoConn.setRequestProperty("Authorization", "Bearer " + accessToken);

        if (userInfoConn.getResponseCode() != 200) {
            response.sendRedirect(request.getContextPath() + "/login.html");
            return;
        }

        StringBuilder userInfoResponse = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(userInfoConn.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                userInfoResponse.append(line);
            }
        }

        JSONObject userInfoJson = new JSONObject(userInfoResponse.toString());
        String email = userInfoJson.getString("email");
        String name  = userInfoJson.getString("name");

        /* STEP 3: Store user in session */
        User user = new User();
        user.setEmail(email);
        user.setUsername(name);

        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

        /* STEP 4: Redirect */
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
}
