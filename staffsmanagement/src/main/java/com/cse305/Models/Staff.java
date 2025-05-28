package com.cse305.Models;

import java.util.ArrayList;

public class Staff extends User {
    private ArrayList<Duty> ListOfDuty = new ArrayList<>();
    
    public Staff(String id, String name, String password, ArrayList<Duty> listOfDuty) {
        super(id, name, password, "Staff");
        ListOfDuty = listOfDuty;
    }
    
    public ArrayList<Duty> getListOfDuty() {
        return ListOfDuty;
    }

    void ViewSchedule(){
        var sb = new StringBuilder();
        for(var duty : ListOfDuty) {
            sb.append("Place to work: " + duty.Name).append("\n").append(duty.DayOfWeek + " => " + duty.Shift).append("\n");
        }
        System.out.println(sb);
    };
    void CreateRequest(){};
    void ViewRoutine(){};
    void ViewSalary(){};
}
