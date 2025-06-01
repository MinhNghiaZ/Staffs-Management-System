package com.cse305.Models;

import java.util.ArrayList;

public class DataManager {

    public ArrayList<User> userList = new ArrayList<>();
    public ArrayList<Request> requestList = new ArrayList<>();
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
    //In here if the screen of all request is show, manager can click in ACCEPT or REJECT button
    //After that, update the request status in the list
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

    //button to show routine of all staff in manager screen
    public String ViewRoutineOfAllStaff() {
        Manager currentManager = (Manager)loggedInUser;
        ArrayList<Staff> staffs = getStaffList();
        return currentManager.ViewRoutineOfAllStaff(staffs);
    }

    //button to show salary of all staff in manager screen
    public String ViewSalaryOfAllStaff() {
        Manager currentManager = (Manager)loggedInUser;
        ArrayList<Staff> staffs = getStaffList();
        return currentManager.ViewSalaryOfAllStaff(staffs);
    }


    //Staff function

    //button to view schedule as a staff
    public String ViewSchedule() {
        Staff currentStaff = (Staff) loggedInUser;
        return currentStaff.ViewSchedule();
    }

    //button to create a request as a staff
    public String CreateRequest(String id, String dutyId, String type) {
        Staff currentStaff = (Staff) loggedInUser;
        Request request = currentStaff.CreateRequest(id, currentStaff, dutyId, type, false);
        requestList.add(request);
        return "Request created successfully.";
    }

    //button to show routine as a staff SCHEDULE AS ROUTINE
    public String ViewRoutine() {
        Staff currentStaff = (Staff) loggedInUser;
        return currentStaff.ViewSchedule();
    }

    //button to view salary as a staff
    public String ViewSalary() {
        Staff currentStaff = (Staff) loggedInUser;
        return currentStaff.ViewSalary();
    }

    // Display requests for staff (see if their requests are accepted or not)
    public String ViewRequestStaff() {
        Staff currentStaff = (Staff) loggedInUser;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> requestIds = currentStaff.getListOfRequestId();
        for (Request request : requestList){
            if (requestIds.contains(request.ID)){
                sb.append("Request ID: ").append(request.ID)
                  .append(", Staff ID: ").append(request.StaffID)
                  .append(", Duty ID: ").append(request.DutyId)
                  .append(", Type: ").append(request.Type)
                  .append(", Accepted: ").append(request.isAccepted)
                  .append("\n");
            }
        }
        return sb.toString();
    }

    // Display all requests for manager (see all requests made by staff)
    public String ViewAllRequestManager() {
        StringBuilder sb = new StringBuilder();
        for (Request request : requestList) {
            sb.append("Request ID: ").append(request.ID)
              .append(", Staff ID: ").append(request.StaffID)
              .append(", Duty ID: ").append(request.DutyId)
              .append(", Type: ").append(request.Type)
              .append(", Accepted: ").append(request.isAccepted)
              .append("\n");
        }
        return sb.toString();
    }
    //funtion to update data when request was process;
    //In MANAGER SCREEN IF ACCEPT button was clicked, then update the request status to ACCEPTED and add the duty to staff
    // IF REJECT button was clicked, then update the request status to REJECTED and remain the duty for staff

    public void processRequest(String requestId, boolean isAccepted){
        for (Request request : requestList){
            if (request.ID.equals(requestId)){
                if (isAccepted){
                    request.accept();
                    Staff staff = (Staff) getUserById(request.StaffID);
                    if (staff != null){
                        staff.removeDuty(request.DutyId);
                    }else{
                        System.out.println("Staff with ID " + request.StaffID + " does not exist.");
                    }
                }else{
                    request.reject();
                }
            }
        }
    }
}
