package com.cse305.Models;

public class User {
    public String ID;
    public String Name;
    public String Password;
    public String Role;

    public User(String id, String name, String password, String role) {
        this.ID = id;
        this.Name = name;
        this.Password = password;
        this.Role = role;
    }

    public String getId() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public String getPassword() {
        return Password;
    }
    public String getRole() {
        return Role;
    }
    public boolean login(String id, String password) {
        return this.ID.equals(id) && this.Password.equals(password);
    }
    public void logout() {
        // Implement logout logic if needed
    }


}
