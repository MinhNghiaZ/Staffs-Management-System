package com.cse305.Models;

import java.util.ArrayList;

public class DataManager {

    public ArrayList<User> userList = new ArrayList<>();
    public User loggedInUser;

    private static DataManager instance;

    ////////////////////////////////////////////////////
    // IMPORTANT: Use this when calling DataManager  //
    // DO NOT CREATE NEW DataManager OBJECTS        //
    // This is Singleton Pattern                   //
    ////////////////////////////////////////////////
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    //TODO: Implement methods to load and save user data from/to a file

    public boolean createManagerAccount(String id, String name, String password) {
        // TODO: encrypt password
        if (checkExist(id)) {
            System.out.println("ID already exists. Please choose a different ID.");
            return false;
        }
        Manager newManager = new Manager(id, name, password, null);
        userList.add(newManager);
        System.out.println("Manager account created successfully.");
        return true;
    }

    public boolean createStaffAccount(String id, String name, String password) {
        if (checkExist(id)) {
            System.out.println("ID already exists. Please choose a different ID.");
            return false;
        }
        Staff newStaff = new Staff(id, name, password, null);
        userList.add(newStaff);
        System.out.println("Staff account created successfully.");
        return true;
    }


    public boolean login(String id, String password) {

        // TODO: encrypt password before checking
        if (checkExist(id) == false) {
            System.out.println("ID does not exist. Please register first.");
            return false;
        }

        for (User user : userList) {
            if (user.login(id, password)) {
                loggedInUser = user;
                System.out.println("Login successful. Role: " + loggedInUser.getRole());
                return true;
            }
        }

        System.out.println("Login failed. Incorrect password.");
        return false;
    }

    // Private methods
    private boolean checkExist(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    //Manager function

    //ShowListRequest button for manager
    public void showListRequest() {
        Manager currentManager = (Manager)loggedInUser;
        var listRequest = currentManager.getListOfRequest();
        for(var request : listRequest) {
            System.out.println("Request ID: " + request.ID);
            System.out.println("Staff ID: " + request.StaffID);
            System.out.println("DutyId ID: " + request.DutyId);
            System.out.println("Type ID: " + request.Type);
            System.out.println("Request ID: " + request.isAccepted);
        }
    }

    //giveDuty using staff object
    public boolean giveDuty(String id, String name, Staff s, String day, String shift) {
        Duty newDuty = new Duty(id, name, s, day, shift);
        if (s.addDuty(newDuty)) {
            return true;
        }
        System.out.println("Failed to give duty.");
        return false;
    }
    // giveDuty but use String staffId instead of Staff object
    public boolean giveDuty(String id, String name, String staffId, String day, String shift){
        Staff staff = (Staff) getUserById(staffId);
        if (staff == null) {
            System.out.println("Staff with ID " + staffId + " does not exist.");
            return false;
        }
        return giveDuty(id, name, staff, day, shift);
    }

    public ArrayList<Staff> getStaffList() {
        ArrayList<Staff> staffList = new ArrayList<>();
        for (User user : userList) {
            if (user.getRole().equals("Staff")) {
                staffList.add((Staff) user);
            }
        }
        return staffList;
    }

    public User getUserById(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
