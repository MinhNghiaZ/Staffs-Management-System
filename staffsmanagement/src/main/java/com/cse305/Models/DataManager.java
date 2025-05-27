package com.cse305.Models;

import java.util.ArrayList;

public class DataManager {
    public ArrayList<Manager> managerList = new ArrayList<>();
    public ArrayList<Staff> staffList = new ArrayList<>();

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

    public boolean login(String id, String password){
        Manager m1 = new Manager("1", "name1", "pass1", "Manager", null);
        Manager m2 = new Manager("2", "name2", "pass2", "Manager", null);
        Manager m3 = new Manager("3", "name3", "pass3", "Manager", null);
        managerList.add(m1);
        managerList.add(m3);
        managerList.add(m2);
        //TODO: encrypt password before checking
        for (Manager manager : managerList){
            if (manager.Login(id,password)){
                loggedInRole = "Manager";
                System.out.println("ok");
                return true;
            }
        }
        for (Staff staff : staffList){
            if (staff.Login(id,password)){
                loggedInRole = "Staff";
                System.out.println("ok");
                return true;
            }
        }
        System.out.println("not ok");
        return false;
    }

}
