package com.revature.services;

import java.util.Scanner;

public class UsersService {
    UserDAO ud = new UserDAO(); //instanceOf the user DAO we created! :-)
    Scanner io = new Scanner(System.in); //"input/output" ie
    public User login(){
        System.out.println("Please enter your username");
        String username = io.nextLine();
        System.out.println("Please enter your password");
        String password = io.nextLine();

        // Call the database
        Users user = us.getByUsername(username);

        //password checking
        if(user.getPassword().equals(password)){
            System.out.println("Welcome, " + username);
            System.out.println(user);
            return user;
        } else {
            System.out.println("Invalid Login");
            return null;
        }
    }
    public User register(){

        Users user = us.createUser(String name, String regusername, String email, String regpassword, int role_num); //currently not working ...
        System.out.println("Please enter your NAME.");
        name = io.nextLine();

        System.out.println("Please enter your USERNAME. Must be UNIQUE!");
        regusername = io.nextLine();

        System.out.println("Please enter your EMAIL.");
        email = io.nextLine();

        System.out.println("Please enter a new PASSWORD.");
        regpassword = io.nextLine();

        System.out.println("Please enter your ROLE. 1 for employee, 2 for management.");
        role_num = io.nextLine();

        //next, must check username is unique
        //if (GetUsername = null),,
        //proceed
        //else throw an error!

        //THEN NEXT,

        System.out.println("Your INFOS is: " + name + " " + regusername + " " + email + " " + regpassword + " " + role_num);
        return user;
    }
}
