package com.cse305.Models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;

public class DataManager {

    public ArrayList<User> userList = new ArrayList<>(); // List of all users (managers and staff)
    public ArrayList<Duty> dutyList = new ArrayList<>(); // List of all duties assigned to staff
    public ArrayList<Request> requestList = new ArrayList<>(); // List of all requests made by staff
    public User loggedInUser;
    private final static String FILE_PATH = "data.lmao"; // Path to the file where data will be saved
    
    private static DataManager instance;

    ////////////////////////////////////////////////////
    // IMPORTANT: Use this when calling DataManager //
    // DO NOT CREATE NEW DataManager OBJECTS //
    // This is Singleton Pattern //
    ////////////////////////////////////////////////
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void saveData(){
        try{
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            DataContainer container = new DataContainer(userList, dutyList, requestList);
            oos.writeObject(container);
            oos.close();
            System.out.println("Data saved successfully");
        }catch (IOException e){
            System.out.println("Error saving: "+e.getMessage());
        }
    }
    public void loadData() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File " + FILE_PATH + " not found. Starting with empty data.");
            return;
        }
        try{
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            DataContainer container = (DataContainer) ois.readObject();

            userList.clear();
            dutyList.clear();
            requestList.clear();

            userList.addAll(container.userList);
            dutyList.addAll(container.dutyList);
            requestList.addAll(container.requestList);
            ois.close();
            System.out.println("Data loaded successfully");

        }catch (ClassNotFoundException e) {
            System.out.println("Error loading: " + e.getMessage());
        }catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }

    public boolean createManagerAccount(String id, String name, String password) {
        // encrypt password before storing
        password = AES.encrypt(password);
        if (checkExist(id)) {
            System.out.println("ID already exists. Please choose a different ID.");
            return false;
        }
        Manager newManager = new Manager(id, name, password);
        userList.add(newManager);
        System.out.println("Manager account created successfully.");

        //save data
        saveData();
        return true;
    }

    public boolean createStaffAccount(String id, String name, String password) {
        // encrypt password before storing
        password = AES.encrypt(password);
        if (checkExist(id)) {
            System.out.println("ID already exists. Please choose a different ID.");
            return false;
        }
        //ArrayList<String> list = new ArrayList<>();
        Staff newStaff = new Staff(id, name, password);
        userList.add(newStaff);
        System.out.println("Staff account created successfully.");

        //save data
        saveData();
        return true;
    }

    public boolean login(String id, String password) {
        // encrypt password before checking
        password = AES.encrypt(password);

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

    // Manager function

    // ShowListRequest button for manager
    // In here if the screen of all request is show, manager can click in ACCEPT or
    // REJECT button
    // After that, update the request status in the list
    public void showListRequest() {
        if (!loggedInUser.getRole().equals("Manager")) {
            System.out.println("You are not authorized to view the request list.");
            return;
        }

        for (var request : requestList) {
            System.out.println("Request ID: " + request.ID);
            System.out.println("Staff ID: " + request.StaffID);
            System.out.println("DutyId ID: " + request.DutyId);
            System.out.println("Type ID: " + request.Type);
            System.out.println("Request ID: " + request.isAccepted);
        }
    }

    // giveDuty using staff object
    public boolean giveDuty(String name, String staffId, String day, String shift) {
        //Duty newDuty = new Duty(id, name, staffId, day, shift);
        String dutyID = UUID.randomUUID().toString();
        Duty newDuty = new Duty(dutyID, name, staffId, day, shift);
        Staff s = (Staff) getUserById(staffId);
        
        for (Duty duty : dutyList){
            if (duty.DayOfWeek.equals(newDuty.DayOfWeek) && duty.Shift.equals(newDuty.Shift)){
                System.out.println("ERROR: This shift already has a duty.");
                return false;
            }
        }

        if (s.addDuty(newDuty)){
            dutyList.add(newDuty);
            saveData();
            return true;
        }
        
        return false;
        
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

    // button to show routine of all staff in manager screen
    public String ViewRoutineOfAllStaff() {
        // maybe return the arrayList of all duty then map it to the table
        // just need to run through dutyList to get all duties
        return "ViewRoutineOfAllStaff function is not implemented yet.";
    }

    // button to show salary of all staff in manager screen
    public String ViewSalaryOfAllStaff() {
        // may need to rework later
        ArrayList<Staff> staffs = getStaffList();
        StringBuilder sb = new StringBuilder();
        for (Staff staff : staffs) {
            sb.append("Staff ID: ").append(staff.getId())
                    .append(", Name: ").append(staff.getName())
                    .append(", Total Salary: ").append(staff.ViewSalary())
                    .append("\n");
        }
        return sb.toString();
    }

    // Staff function

    // button to view schedule as a staff
    public String ViewSchedule() {
        Staff currentStaff = (Staff) loggedInUser;
        return currentStaff.ViewSchedule(dutyList);
    }

    // Get the list of duties assigned to the logged-in staff
    public ArrayList<Duty> getDutyOfLoggedInStaff(){
        if (!loggedInUser.getRole().equals("Staff")) {
            System.out.println("You are not Staff, Cannot view your own duty.");
            return new ArrayList<>();
        }

        Staff currentStaff = (Staff) loggedInUser;
        ArrayList<Duty> staffDuties = new ArrayList<>();
        ArrayList<String> staffDutiesId = currentStaff.getListOfDutyId();
        for (Duty duty : dutyList) {
            if (staffDutiesId.contains(duty.ID)) {
                staffDuties.add(duty);
            }
        }
        return staffDuties;
    }

    // get duty lists of all staff
    public ArrayList<Duty> getDutyOfAllStaff(){
        return dutyList;
    }

    // button to create a request as a staff
    public String CreateRequest(String id, String dutyId, String type) {
        // May need to check if request for this duty already exists
        Staff currentStaff = (Staff) loggedInUser;
        String staffId = currentStaff.getId();

        for (Request request : requestList) {
            if (request.DutyId.equals(dutyId) && request.StaffID.equals(staffId)) {
                return "Request for this duty already exists.";
            }
        }

        Request request = new Request(id, staffId, dutyId, type, false);
        requestList.add(request);
        return currentStaff.addRequest(request.ID) ? "Request created successfully." : "Failed to create request.";
    }

    // button to show routine as a staff SCHEDULE AS ROUTINE
    public String ViewRoutine() {
        Staff currentStaff = (Staff) loggedInUser;
        return currentStaff.ViewSchedule(dutyList);
    }

    // button to view salary as a staff
    public String ViewSalary() {
        Staff currentStaff = (Staff) loggedInUser;
        return currentStaff.ViewSalary();
    }

    // Display requests for staff (see if their requests are accepted or not)
    public String ViewRequestStaff() {
        Staff currentStaff = (Staff) loggedInUser;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> requestIds = currentStaff.getListOfRequestId();
        for (Request request : requestList) {
            if (requestIds.contains(request.ID)) {
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
    // funtion to update data when request was process;
    // In MANAGER SCREEN IF ACCEPT button was clicked, then update the request
    // status to ACCEPTED and add the duty to staff
    // IF REJECT button was clicked, then update the request status to REJECTED and
    // remain the duty for staff

    public void processRequest(String requestId, boolean isAccepted) {
        for (Request request : requestList) {
            if (request.ID.equals(requestId)) {
                if (isAccepted) {
                    request.accept();
                    Staff staff = (Staff) getUserById(request.StaffID);
                    if (staff != null) {
                        if (staff.removeDuty(request.DutyId)) {
                            for (Duty duty : dutyList) {
                                if (duty.ID.equals(request.DutyId)) {
                                    dutyList.remove(duty);
                                    break;
                                }
                            }
                             System.out.println("Request " + requestId + " accepted. Duty " + request.DutyId
                                + " removed from staff " + request.StaffID + ".");
                        }else{
                            System.out.println("Failed to remove duty " + request.DutyId + " from staff " + request.StaffID + ".");
                        }
                        // maybe need to remove the duty from dutyList as well

                       
                    } else {
                        System.out.println("Staff with ID " + request.StaffID + " does not exist.");
                    }
                } else {
                    request.reject();
                }
            }
        }
    }


    // DataContainer class to hold all data for serialization
    public static class DataContainer implements Serializable{
        public ArrayList<User> userList;
        public ArrayList<Duty> dutyList;
        public ArrayList<Request> requestList;
        public DataContainer(ArrayList<User> userList, ArrayList<Duty> dutyList, ArrayList<Request> requestList) {
            this.userList = userList;
            this.dutyList = dutyList;
            this.requestList = requestList;
        }
    }
}
