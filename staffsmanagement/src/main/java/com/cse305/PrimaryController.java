package com.cse305;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cse305.Models.DataManager;
import com.cse305.Models.Duty;
import com.cse305.Models.Manager;
import com.cse305.Models.Request;
import com.cse305.Models.Staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.TextField;

public class PrimaryController {
    //String iD, String name, String password, String role, ArrayList<Request> listOfRequest

    public DataManager dataManager = DataManager.getInstance();
    @FXML
    public TextField EmailInput; //use for login, create
    @FXML
    public TextField PasswordInput; //login, create
    @FXML
    public TextField Name; //create
    @FXML
    public TextField DutyID;
    @FXML
    public TextField DutyName;
    @FXML
    public TextField DutyShift;
    @FXML
    public TextField DutyDay;
    @FXML
    public TextField UserDutyID;

    public void initialize() {
        // dataManager.createManagerAccount("id1", "Nguyen Van A", "123");
        // dataManager.createStaffAccount("id2", "Pham Thi B", "123");
        // dataManager.saveData();
        dataManager.loadData();
    }

    //LOGIN DONE LOGIN
    public void Login() {
        String id = EmailInput.getText();
        String pass = PasswordInput.getText();
        if(dataManager.login(id, pass)) {
            for(var pp : dataManager.userList) {
                if(pp.getId().equals(id)) {
                    if(pp.getRole().equals("Manager")) {
                        try {
                            App.setRoot("AdminUI");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(pp.getRole().equals("Staff")) {
                        try {
                            App.setRoot("SecurityStaff");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        //dataManager.login(id, pass);
    }   

    //CREATE USER
    //String id, String name, String password these field get from frame
    //NEED precise "fx:id" in .fxml file to take the text
    public void createManager() {
        String id = EmailInput.getText();
        String name = Name.getText();
        String password = PasswordInput.getText();
        dataManager.createManagerAccount(id, name, password);
    }
    public void createStaff() {
        String id = EmailInput.getText();
        String name = Name.getText();
        String password = PasswordInput.getText();
        dataManager.createStaffAccount(id, name, password);
    }

    //manager
    public void showListRequest() {
        dataManager.showListRequest();
    }

    //manager
    // public void createDuty() {
    //     String dutyID = DutyID.getText();
    //     String dutyName = DutyName.getText();
    //     String dutyShift = DutyShift.getText();
    //     String dutyDay = DutyDay.getText();
    //     String userDutyID = UserDutyID.getText();
        
    //     if (dataManager.giveDuty(dutyID, dutyName, userDutyID, dutyDay, dutyShift)){
    //         System.out.println("Create duty successfuly");
    //     }else{
    //         System.out.println("Create duty failed");
    //     }             
    // }

    //manager
    
}
