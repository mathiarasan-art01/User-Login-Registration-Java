package com.auth.dao;

import com.auth.model.User;
import com.auth.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // ✅ REGISTER USER
    public void registerUser(User user) {
        try {
            Connection con = DBUtil.getConnection();

            String sql = "INSERT INTO users(username, email, password) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ LOGIN USER  ← THIS METHOD WAS MISSING
    public User loginUser(String email, String password) {
        User user = null;
        try {
            Connection con = DBUtil.getConnection();

            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String userEmail = rs.getString("email");
                // Password usually not returned, but if needed:
                String userPassword = rs.getString("password");

                user = new User(username, userEmail, userPassword);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


     
     public boolean googleUserExists(String email) {
    	    boolean exists = false;
    	    try {
    	        Connection con = DBUtil.getConnection();
    	        PreparedStatement ps =
    	            con.prepareStatement("SELECT id FROM users WHERE email=?");
    	        ps.setString(1, email);
    	        ResultSet rs = ps.executeQuery();
    	        exists = rs.next();
    	        con.close();
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	    return exists;
    	}

    	public void registerGoogleUser(String name, String email) {
    	    try {
    	        Connection con = DBUtil.getConnection();
    	        PreparedStatement ps =
    	            con.prepareStatement(
    	                "INSERT INTO users(username, email, password) VALUES (?,?,?)");
    	        ps.setString(1, name);
    	        ps.setString(2, email);
    	        ps.setString(3, "GOOGLE");
    	        ps.executeUpdate();
    	        con.close();
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	}


}
