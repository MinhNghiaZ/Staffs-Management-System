package com.cse305.Models;

import java.util.ArrayList;

public class Manager extends User {
    private ArrayList<Request> ListOfRequest = new ArrayList<>();
    
    public Manager(String iD, String name, String password, ArrayList<Request> listOfRequest) {
       super(iD, name, password, "Manager");
        ListOfRequest = listOfRequest;
    }
    
    public ArrayList<Request> getListOfRequest() {
        return ListOfRequest;
    }
    // create duty
    ArrayList<Duty> CreateRoutine(){
        return null;
    };

    String ViewRoutineOfAllStaff(ArrayList<Staff> staffs){
        String s ="";
        for(var staff : staffs) {
            s+= "Staff ID: " + staff.getId() + ", Name: " + staff.getName() + "\n" + staff.ViewSchedule();
        }
        return s;
    };
    String ViewSalaryOfAllStaff(ArrayList<Staff> staffs){
        String s = "";
        for(var staff : staffs) {
            s += "Staff ID: " + staff.getId() + ", Name: " + staff.getName() + "\n" + staff.ViewSalary();
        }
        return s;
    };
    //////////////////////////////////////
    /// Staff Id: 1, Name: Nguyen Van A//
    /// Total Salary: 200 $            //
    /// /////////////////////////////////
}
