package com.cse305.Models;

import java.util.ArrayList;

public class DataManager {

    public ArrayList<User> userList = new ArrayList<>();
    public User loggedInUser;

    private static DataManager instance;

    ////////////////////////////////////////////////////
    // IMPORTANT: USE THIS WHEN Calling DataManager  //
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

    /**
     * Creates a new Manager account with the given ID, name, and password.
     * If the ID already exists, it will not create a new account and return false.
     * @param id
     * @param name
     * @param password
     * @return boolean indicating success or failure of account creation
     */
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

    /**
     * Creates a new Staff account with the given ID, name, and password.
     * If the ID already exists, it will not create a new account and return false.
     * @param id
     * @param name
     * @param password
     * @return boolean indicating success or failure of account creation
     */
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

    //CreateDuty button for manager
    public Duty createDuty(String id, String name, Staff s, String day, String shift) {
        return new Duty(id, name, s, day, shift);
    }
}
