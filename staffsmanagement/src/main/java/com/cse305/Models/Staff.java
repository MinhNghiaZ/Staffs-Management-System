package com.cse305.Models;

import java.util.ArrayList;

public class Staff {
    public String ID;
    public String Name;
    public String Password;
    public String Role;
    ArrayList<Duty> ListOfDuty = new ArrayList<>();

    void Login(){};
    void ViewSchedule(){};
    void CreateRequest(){};
    void ViewRoutine(){};
    void ViewSalary(){};
    void Logout(){};
}
