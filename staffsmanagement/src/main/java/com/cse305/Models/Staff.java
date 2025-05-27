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
    
    public boolean Login(String id, String password){
        return this.ID.equals(id) && this.Password.equals(password);
    };
    void ViewSchedule(){
        var sb = new StringBuilder();
        for(var duty : ListOfDuty) {
            sb.append("Place to work: " + duty.Name).append("\n").append(duty.StartTime + " => " + duty.EndTime);
        }
        System.out.println(sb);
    };
    void CreateRequest(){};
    void ViewRoutine(){};
    void ViewSalary(){};
    void Logout(){};
}
