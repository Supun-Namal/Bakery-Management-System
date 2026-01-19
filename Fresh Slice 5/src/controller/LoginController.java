/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import model.UserDAO;

public class LoginController {
    private UserDAO userDAO;

    public LoginController() {
        userDAO = new UserDAO();
    }

    public User authenticate(String username, String password) {
        return userDAO.validateUser(username, password);
    }
}

