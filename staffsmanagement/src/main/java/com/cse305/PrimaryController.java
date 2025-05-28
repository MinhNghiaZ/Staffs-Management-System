package com.cse305;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cse305.Models.DataManager;
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
    public TextField EmailInput;
    @FXML
    public TextField PasswordInput;

    public void initialize() {
        dataManager.createManagerAccount("id1", "Nguyen Van A", "123");
        dataManager.createStaffAccount("id2", "Pham Thi B", "123");
        
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void Login() {
        String id = EmailInput.getText();
        String pass = PasswordInput.getText();

        if(dataManager.login(id, pass)) {
            System.out.println("hen qua duoc roi");
        } else {
            System.out.println("chua dc dauu");
        }
    }
}
