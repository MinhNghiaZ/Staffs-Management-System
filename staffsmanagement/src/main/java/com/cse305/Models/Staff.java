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

    public boolean addDuty(Duty duty) {
        for (Duty d : ListOfDuty) {
            if (d.ID.equals(duty.ID)) {
                System.out.println("Staff already has a duty with this ID.");
                return false;
            }
        }

        ListOfDuty.add(duty);
        return true;
    }
    public boolean removeDuty(String dutyId) {
        for (Duty d : ListOfDuty) {
            if (d.ID.equals(dutyId)) {
                ListOfDuty.remove(d);
                return true;
            }
        }
        System.out.println("Duty with ID " + dutyId + " not found.");
        return false;
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
