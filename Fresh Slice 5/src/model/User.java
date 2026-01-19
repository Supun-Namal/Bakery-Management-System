/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class User {

    private int userId;
    private String username;
    private String password;
    private String role;

    
    private String firstName;
    private String lastName;
    private String email;

    public User() {
    }

   
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    
    public User(String username, String password,
            String firstName, String lastName, String email) {

        this.username = username;
        this.password = password;
        this.role = "Assistant"; // 🔒 FIXED
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
