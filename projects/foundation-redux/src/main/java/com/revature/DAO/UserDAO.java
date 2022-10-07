package com.revature.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User; //be sure to create me too! :-)
import com.revature.util.ConnectionUtil;

public class UserDAO implements UserDAOint { //need to create a User INTERFACE, then implement here!
    @Override
    public Users getByUsername(String username){
        //create user object we will get data back to
        Users user = new Users();

        //connect with resources fed to us !
        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users WHERE user_name = ?";

            //PREPARE it, to prevent SQL injection attacks (scary...)
            PreparedStatement stmt = conn.prepareStatement(sql);

            //EYE set the string to the values
            stmt.setString(1, username);
            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null){
                //results not blank? GREAT! we found the user...
                rs.next();

                // Now we can pull the information out and store it in the teacher object

                int id = rs.getInt("user_id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String recUserN = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int role = rs.getInt("role_num");


                // NOW we create the user object!
                user = new Users(id,first,last,username,password,email,role);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Users createUser(String first_name, String last_name, String username, String password, String email, int role_num){
        Users user = new Users(); //new user object to INSERT into the database :-)
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO users (first_name, last_name, username, email, password, role_num) VALUES (?,?,?,?,?,?) RETURNING *"; //the RETURNING keyword is fun, here. I miss knex...

            //...remmber to PREPARE the statement !
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, username);
            stmt.setString(4, email);
            stmt.setString(5, password);
            stmt.setString(6, role_num);

            ResultSet rs; //--> create result set ie

            if ((rs = stmt.executeQuery()) != null){

                //........ move cursor FORWARD!
                rs.next();

                // Obtain values
                int id = rs.getInt("teacher_id"); //...resX ie, result or from "response". I miss res.json...
                String resFirst = rs.getString("first");
                String resLast = rs.getString("last");
                String resUsername = rs.getString("username");
                String resEmail = res.getString("email");
                String resPassword = rs.getString("password");
                int resRole = rs.getInt("role_num");

                user = new Users(id, resFirst, resLast, resUsername, resEmail, resPassword, resRole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't register user to the database");
        }

        return user;
    }
}
