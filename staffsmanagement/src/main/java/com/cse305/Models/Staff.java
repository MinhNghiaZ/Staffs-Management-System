package com.cse305.Models;

import java.util.ArrayList;

public class Staff extends User {
    private ArrayList<Duty> ListOfDuty = new ArrayList<>();
    private ArrayList<String> ListOfRequestId = new ArrayList<>();
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
        System.out.println("Add duty successfully.");
        return true;
    }
    public boolean removeDuty(String dutyId) {
        for (Duty d : ListOfDuty) {
            if (d.ID.equals(dutyId)) {
                ListOfDuty.remove(d);
                System.out.println("Remove duty successfully.");
                return true;
            }
        }
        System.out.println("Duty with ID " + dutyId + " not found.");
        return false;
    }

    String ViewSchedule(){
        var sb = new StringBuilder();
        for(var duty : ListOfDuty) {
            sb.append("Place to work: " + duty.Place).append("\n").append(duty.DayOfWeek + " => " + duty.Shift).append("\n");
        }
        return sb.toString();
    };
    Request CreateRequest(String id, Staff staff, String dutyId, String type, boolean isAccepted) {
        Request request = new Request(id, staff.getId(), dutyId, type, isAccepted);
        ListOfRequestId.add(id);
        return request;
    };
    void ViewRoutine(){};
    String ViewSalary(){
        return "Total Salary: " + ListOfDuty.size() * 50+" $";
    };

    public ArrayList<String> getListOfRequestId() {
        return ListOfRequestId;
    }
}
