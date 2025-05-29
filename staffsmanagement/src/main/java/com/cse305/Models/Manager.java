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

    ArrayList<Duty> CreateRoutine(){
        return null;
    };

    void ViewRoutineOfAllStaff(ArrayList<Staff> staffs){};
    void ViewSalaryOfAllStaff(ArrayList<Staff> staffs){};

}
