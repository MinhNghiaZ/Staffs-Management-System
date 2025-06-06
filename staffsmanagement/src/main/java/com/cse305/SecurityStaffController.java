package com.cse305;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecurityStaffController implements Initializable {
    
    // Navigation buttons
    @FXML
    private Button btnHome;
    
    @FXML
    private Button btnRequestLeave;
    
    @FXML
    private Button btnSalary;
    
    @FXML
    private Button btnChangeInformation;
    
    // Panels
    @FXML
    private AnchorPane homePanel;
    
    @FXML
    private AnchorPane salaryPanel;
    
    @FXML
    private AnchorPane RequestLeavePanel;
    
    @FXML
    private AnchorPane TablePane;
    
    // Home panel labels
    @FXML
    private Label labelTotalShift;
    
    @FXML
    private Label labelTotalTakeLeave;
    
    @FXML
    private Label labelTotalRequest;
    
    // Salary labels
    @FXML
    private Label TotalShift;
    
    @FXML
    private Label Rate;
    
    @FXML
    private Label StaffSalary;
    
    // Request Leave components
    @FXML
    private ChoiceBox<String> optionChooseDay;
    
    @FXML
    private ChoiceBox<String> optionChooseShifts;
    
    @FXML
    private TextArea txtRequestReason;
    
    @FXML
    private Button btnChecking;
    
    @FXML
    private Button btnRequest;
    
    // All schedule labels
    @FXML
    private Label MondayMorning;
    
    @FXML
    private Label MondayAfternoon;
    
    @FXML
    private Label MondayEvening;
    
    @FXML
    private Label TuesdayMorning;
    
    @FXML
    private Label TuesdayAfternoon;
    
    @FXML
    private Label TuesdayEvening;
    
    @FXML
    private Label WednesdayMorning;
    
    @FXML
    private Label WednesdayAfternoon;
    
    @FXML
    private Label WednesdayEvening;
    
    @FXML
    private Label ThursdayMorning;
    
    @FXML
    private Label ThursdayAfternoon;
    
    @FXML
    private Label ThursdayEvening;
    
    @FXML
    private Label FridayMorning;
    
    @FXML
    private Label FridayAfternoon;
    
    @FXML
    private Label FridayEvening;
    
    @FXML
    private Label SaturdayMorning;
    
    @FXML
    private Label SaturdayAfternoon;
    
    @FXML
    private Label SaturdayEvening;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize default view
        showHomePanel();
        
        // Set button actions
        btnHome.setOnAction(this::handleHomeButton);
        btnSalary.setOnAction(this::handleSalaryButton);
        btnRequestLeave.setOnAction(this::handleRequestLeaveButton);
        btnChangeInformation.setOnAction(this::handleChangeInformationButton);
        btnChecking.setOnAction(this::handleCheckingButton);
        btnRequest.setOnAction(this::handleRequestSubmitButton);
        
        // Initialize choice boxes
        initializeChoiceBoxes();
    }
    
    private void initializeChoiceBoxes() {
        // Initialize day choices
        optionChooseDay.getItems().addAll(
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        );
        
        // Initialize shift choices
        optionChooseShifts.getItems().addAll(
            "Morning Shift", "Afternoon Shift", "Evening Shift"
        );
    }
    
    @FXML
    private void handleHomeButton(ActionEvent event) {
        showHomePanel();
    }
    
    @FXML
    private void handleSalaryButton(ActionEvent event) {
        showSalaryPanel();
    }
    
    @FXML
    private void handleRequestLeaveButton(ActionEvent event) {
        showRequestLeavePanel();
    }
    
    @FXML
    private void handleChangeInformationButton(ActionEvent event) {
        // TODO: Implement change information functionality
        System.out.println("Change Information clicked");
    }
    
    @FXML
    private void handleCheckingButton(ActionEvent event) {
        // TODO: Implement checking functionality
        System.out.println("Checking button clicked");
    }
    
    @FXML
    private void handleRequestSubmitButton(ActionEvent event) {
        // TODO: Implement request submission functionality
        String day = optionChooseDay.getValue();
        String shift = optionChooseShifts.getValue();
        String reason = txtRequestReason.getText();
        
        System.out.println("Request submitted - Day: " + day + ", Shift: " + shift + ", Reason: " + reason);
    }
    
    @FXML
    private void Logout(ActionEvent event) {
        try {
            App.setRoot("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Logout button clicked");
    }
    
    private void showHomePanel() {
        homePanel.setVisible(true);
        salaryPanel.setVisible(false);
        RequestLeavePanel.setVisible(false);
        
        // Update home panel statistics
        updateHomeStatistics();
    }
    
    private void showSalaryPanel() {
        homePanel.setVisible(false);
        salaryPanel.setVisible(true);
        RequestLeavePanel.setVisible(false);
        
        // Update salary information
        updateSalaryInfo();
    }
    
    private void showRequestLeavePanel() {
        homePanel.setVisible(false);
        salaryPanel.setVisible(false);
        RequestLeavePanel.setVisible(true);
    }
    
    private void updateHomeStatistics() {
        // TODO: Fetch actual data from database/service
        labelTotalShift.setText("8");
        labelTotalTakeLeave.setText("2");
        labelTotalRequest.setText("5");
    }
    
    private void updateSalaryInfo() {
        // TODO: Fetch actual data from database/service
        TotalShift.setText("100");
        Rate.setText("50$");
        StaffSalary.setText("5,000$");
    }
}
