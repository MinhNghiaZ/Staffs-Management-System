package com.cse305.Models;

import java.util.ArrayList;

public class Staff {
    public String ID;
    public String Name;
    public String Password;
    public String Role;
    ArrayList<Duty> ListOfDuty = new ArrayList<>();
    
    public Staff(String iD, String name, String password, String role, ArrayList<Duty> listOfDuty) {
        ID = iD;
        Name = name;
        Password = password;
        Role = role;
        ListOfDuty = listOfDuty;
    }
    
    public boolean Login(String name, String password){
        return this.Name.equals(name) && this.Password.equals(password);
    };
    void ViewSchedule(){};
    void CreateRequest(){};
    void ViewRoutine(){};
    void ViewSalary(){};
    void Logout(){};
}
