package com.cse305.Models;

import java.util.ArrayList;

public class DataManager {
    public ArrayList<Manager> managerList;
    public ArrayList<Staff> staffList;

    public String loggedInRole = "";

    public Manager createManagerAccount(String name, String password){
        String id = "manager_"+managerList.size(); // might change to uuid or smth
        // TODO: encrypt password, find a use for the "role" variable
        Manager newManager = new Manager(id, name, password, "Manager", null);
        
        return newManager;
    }
    
    public Staff createStaffAccount(String name, String password){
        String id = "staff_"+staffList.size();
        Staff newStaff = new Staff(id, name, password, "Staff", null);
        return newStaff;
    }

    public boolean login(String name, String password){
        //TODO: encrypt password before checking
        for (Manager manager : managerList){
            if (manager.Login(name,password)){
                loggedInRole = "Manager";
                return true;
            }
        }
        for (Staff staff : staffList){
            if (staff.Login(name,password)){
                loggedInRole = "Staff";
                return true;
            }
        }
        return false;
    }

}
