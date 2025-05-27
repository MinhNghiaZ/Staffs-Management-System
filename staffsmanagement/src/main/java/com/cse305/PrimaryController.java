package com.cse305;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cse305.Models.DataManager;
import com.cse305.Models.Manager;
import com.cse305.Models.Request;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {
    //String iD, String name, String password, String role, ArrayList<Request> listOfRequest
    public HashMap<String, Manager> ManagerMap = new HashMap<>();
    public HashMap<String, String> StaffMap = new HashMap<>();
    public DataManager dataManager = new DataManager();
    @FXML
    public TextField EmailInput;
    @FXML
    public TextField PasswordInput;

    public void initialize() {
        Manager m1 = new Manager("1", "name1", "pass1", "role1", null);
        ManagerMap.put(m1.ID, m1);
        Manager m2 = new Manager("2", "name2", "pass2", "role2", null);
        ManagerMap.put(m2.ID, m2);
        Manager m3 = new Manager("3", "name3", "pass3", "role3", null);
        ManagerMap.put(m3.ID, m3);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void Login() {
        String id = EmailInput.getText();
        String pass = PasswordInput.getText();
        // if(ManagerMap.get(id) == null) {
        //     System.out.println("id is incorrect");
        // } else {
        //     if(pass.equals(ManagerMap.get(id).Password)) {
        //         System.out.println("success");
        //     } else {
        //         System.out.println("password is incorrect");
        //     }
        // }
        if(dataManager.login(id, pass)) {
            System.out.println("hen qua duoc roi");
        } else {
            System.out.println("chua dc dauu");
        }
    }
}
