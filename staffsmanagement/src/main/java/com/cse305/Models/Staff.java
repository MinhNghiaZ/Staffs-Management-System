package com.cse305.Models;


import java.util.ArrayList;
import java.util.HashMap;

public class Staff extends User{
    private ArrayList<String> ListOfDutyId = new ArrayList<>();
    private ArrayList<String> ListOfRequestId = new ArrayList<>();

    public Staff(String id, String name, String password) {
        super(id, name, password, "Staff");
        // ListOfDutyId = (listOfDuty != null) ? listOfDuty : new ArrayList<>();
    }

    public ArrayList<String> getListOfDutyId() {
        return ListOfDutyId;
    }

    public boolean addDuty(Duty duty) {
        if (ListOfDutyId.contains(duty.ID)) {
            System.out.println("Duty with ID " + duty.ID + " already exists.");
            return false;
        }
        ListOfDutyId.add(duty.ID);
        return true;
    }

    public boolean removeDuty(String dutyId) {
        return ListOfDutyId.remove(dutyId);
    }

    String ViewSchedule(ArrayList<Duty> ListOfDuty) {
        var sb = new StringBuilder();
        for (var duty : ListOfDuty) {
            if (ListOfDutyId.contains(duty.ID)) {
                sb.append("Place to work: " + duty.Place).append("\n").append(duty.DayOfWeek + " => " + duty.Shift)
                        .append("\n");
            }

        }
        return sb.toString();
    };

    public boolean addRequest(Request request) {
        if (ListOfRequestId.contains(request.ID)) {
            System.out.println("Request with ID " + request.ID + " already exists.");
            return false;
        }
        ListOfRequestId.add(request.ID);
        return true;
    }

    // Overloading addRequest to accept request ID directly
    public boolean addRequest(String requestId) {
        if (ListOfRequestId.contains(requestId)) {
            System.out.println("Request with ID " + requestId + " already exists.");
            return false;
        }
        ListOfRequestId.add(requestId);
        return true;
    }

    public boolean removeRequest(String requestId) {
        return ListOfRequestId.remove(requestId);
    }

    void ViewRoutine() {
    };

    // get salary
    public String ViewSalary() {
        return (ListOfDutyId.size()) * 50 + " $";
    };

    public ArrayList<String> getListOfRequestId() {
        return ListOfRequestId;
    }

    public int getAbsent() {
        DataManager dataManager = DataManager.getInstance();
        ArrayList<Request> requestList = dataManager.requestList;
        int count = 0;
        for (Request re : requestList){
            if (re.isAccepted != null && re.StaffID.equals(this.ID) && re.isAccepted == true){
                count++;
            }
        }
        return count;
    }
    
}
