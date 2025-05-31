package com.cse305;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AdminController implements Initializable {
    
    @FXML
    private Button btnHome;
    
    @FXML
    private Button btnAddStaff;
    
    @FXML
    private Button btnAddSchedule;
    
    @FXML
    private Button btnSalary;
    
    @FXML
    private AnchorPane HomePanel;
    
    @FXML
    private AnchorPane AddStaffPanel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set initial state - show home panel by default
        showHomePanel();
        
        // Add event handlers for navigation buttons
        btnHome.setOnAction(e -> showHomePanel());
        btnAddStaff.setOnAction(e -> showAddStaffPanel());
       
    }
    
    private void showHomePanel() {
        HomePanel.setVisible(true);
        AddStaffPanel.setVisible(false);
        // Add other panels here when you create them
    }
    
    private void showAddStaffPanel() {
        HomePanel.setVisible(false);
        AddStaffPanel.setVisible(true);
        // Hide other panels here when you create them
    }
    
    
}