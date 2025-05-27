package com.cse305.Models;

import java.util.ArrayList;

public class Manager {
    public String ID;
    public String Name;
    public String Password;
    public String Role;
    ArrayList<Request> ListOfRequest = new ArrayList<>();

    void Login(){};
    void Logout(){};
    ArrayList<Duty> CreateRoutine(){
        return null;
    };
    void ViewRoutineOfAllStaff(ArrayList<Staff> staffs){};
    void ViewSalaryOfAllStaff(ArrayList<Staff> staffs){};

}
