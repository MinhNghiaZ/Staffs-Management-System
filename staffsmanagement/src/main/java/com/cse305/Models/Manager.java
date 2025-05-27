package com.cse305.Models;

import java.util.ArrayList;

public class Manager {
    public String ID;
    public String Name;
    public String Password;
    public String Role;
    ArrayList<Request> ListOfRequest = new ArrayList<>();

    public Manager(String iD, String name, String password, String role, ArrayList<Request> listOfRequest) {
        ID = iD;
        Name = name;
        Password = password;
        Role = role;
        ListOfRequest = listOfRequest;
    }

    public boolean Login(String id, String password){
        return this.ID.equals(id) && this.Password.equals(password);
    };
    
    void Logout(){};
    ArrayList<Duty> CreateRoutine(){
        return null;
    };
    void ViewRoutineOfAllStaff(ArrayList<Staff> staffs){};
    void ViewSalaryOfAllStaff(ArrayList<Staff> staffs){};

}
