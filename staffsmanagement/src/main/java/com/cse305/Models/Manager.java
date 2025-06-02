package com.cse305.Models;


// import java.util.ArrayList;

public class Manager extends User {
    
    // Manager class only purpose is to check if the user is a manager or not
    public Manager(String iD, String name, String password) {
       super(iD, name, password, "Manager");
    }
    
    // String ViewRoutineOfAllStaff(ArrayList<Staff> staffs, ArrayList<Duty> duties){
    //     String s ="";
    //     for(var staff : staffs) {
    //         s+= "Staff ID: " + staff.getId() + ", Name: " + staff.getName() + "\n" + staff.ViewSchedule(duties);
    //     }
    //     return s;
    // };
    // String ViewSalaryOfAllStaff(ArrayList<Staff> staffs){
    //     String s = "";
    //     for(var staff : staffs) {
    //         s += "Staff ID: " + staff.getId() + ", Name: " + staff.getName() + "\n" + staff.ViewSalary();
    //     }
    //     return s;
    // };
    //////////////////////////////////////
    /// Staff Id: 1, Name: Nguyen Van A//
    /// Total Salary: 200 $            //
    /// /////////////////////////////////
}
