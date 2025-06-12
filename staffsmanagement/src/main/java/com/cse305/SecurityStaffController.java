package com.cse305;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import com.cse305.Models.DataManager;
import com.cse305.Models.Duty;
import com.cse305.Models.Staff;
import com.cse305.Models.User;

public class SecurityStaffController implements Initializable {

    // Navigation buttons
    @FXML
    private Button btnHome;

    @FXML
    private Button btnRequestLeave;

    @FXML
    private Button btnSalary;

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

    @FXML
    private Label staffNamePannel;

    HashMap<String, Label> labelMap = new HashMap<>();
    DataManager dataManager = DataManager.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize default view
        showHomePanel();

        // Set button actions
        btnHome.setOnAction(this::handleHomeButton);
        btnSalary.setOnAction(this::handleSalaryButton);
        btnRequestLeave.setOnAction(this::handleRequestLeaveButton);

        btnRequest.setOnAction(this::handleRequestSubmitButton);

        // Initialize choice boxes
        initializeChoiceBoxes();

        // setup map for labels
        setupMap();

        // Load duty information into labels for staff
        loadDutyToLabels();

        // load staff salary information

        staffNamePannel.setText(dataManager.loggedInUser.Name);
    }

    public void loadDutyToLabels() {
        ArrayList<Duty> staffDuty = dataManager.getDutyOfLoggedInStaff();
        System.out.println("Loading duty for staff: " + staffDuty.size() + " duties found.");

        clearLabelsText();

        for (Duty duty : staffDuty) {
            String day = duty.DayOfWeek;
            String shift = duty.Shift;
            shift = shift.split(" ")[0];
            String key = day + shift;
            // System.out.println("Loading duty for key: " + key);
            Label label = labelMap.get(key);
            String dutyText = duty.Place;

            label.setText(dutyText);

        }
    }

    public void clearLabelsText() {
        for (Label label : labelMap.values()) {
            label.setText("");
        }
    }

    public void setupMap() {
        labelMap.put("MondayMorning", MondayMorning);
        labelMap.put("MondayAfternoon", MondayAfternoon);
        labelMap.put("MondayEvening", MondayEvening);
        labelMap.put("TuesdayMorning", TuesdayMorning);
        labelMap.put("TuesdayAfternoon", TuesdayAfternoon);
        labelMap.put("TuesdayEvening", TuesdayEvening);
        labelMap.put("WednesdayMorning", WednesdayMorning);
        labelMap.put("WednesdayAfternoon", WednesdayAfternoon);
        labelMap.put("WednesdayEvening", WednesdayEvening);
        labelMap.put("ThursdayMorning", ThursdayMorning);
        labelMap.put("ThursdayAfternoon", ThursdayAfternoon);
        labelMap.put("ThursdayEvening", ThursdayEvening);
        labelMap.put("FridayMorning", FridayMorning);
        labelMap.put("FridayAfternoon", FridayAfternoon);
        labelMap.put("FridayEvening", FridayEvening);
        labelMap.put("SaturdayMorning", SaturdayMorning);
        labelMap.put("SaturdayAfternoon", SaturdayAfternoon);
        labelMap.put("SaturdayEvening", SaturdayEvening);
    }

    private void initializeChoiceBoxes() {
        // Initialize day choices
        optionChooseDay.getItems().addAll(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        // Initialize shift choices
        optionChooseShifts.getItems().addAll(
                "Morning Shift", "Afternoon Shift", "Evening Shift");
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
    private void handleRequestSubmitButton(ActionEvent event) {
        // TODO: Implement request submission functionality
        String day = optionChooseDay.getValue();
        String shift = optionChooseShifts.getValue();
        String reason = txtRequestReason.getText();
        Duty currentDuty = null;
        String currentUserId = dataManager.loggedInUser.getId();
        for (var duty : dataManager.dutyList) {
            if (duty.DayOfWeek.equals(day) && duty.Shift.equals(shift) && duty.StaffID.equals(currentUserId)) {
                currentDuty = duty;
                break;
            }
        }
        if (currentDuty == null) {
            System.out.println("No duty exist");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Requested shift doesn't exist");
            alert.showAndWait();
            return;
        }
        String requestId = UUID.randomUUID().toString();
        // Staff staff = (Staff) dataManager.loggedInUser;
        // staff.getListOfRequestId().add(requestId);

        String s = dataManager.CreateRequest(requestId, currentDuty.ID, day + " " + shift, reason);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText("Message");
        alert.setContentText(s);
        alert.showAndWait();
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
        Staff s = (Staff) dataManager.loggedInUser;
        int shift = s.getListOfDutyId().size();
        int request = 0;
        int leave = 0;
        for (var re : dataManager.requestList) {

            // request is for this staff -> request++
            if (re.StaffID.equals(s.ID)) {
                request++;
            }

            // request not proccessed yet -> skip
            if (re.isAccepted == null) {
                continue;
            }

            // request is accepted -> leave++
            if (re.isAccepted == true && re.StaffID.equals(s.ID)) {
                leave++;
            }

        }
        // TODO: Fetch actual data from database/service
        // labelTotalShift.setText("8");
        // labelTotalTakeLeave.setText("2");
        // labelTotalRequest.setText("5");

        labelTotalShift.setText(String.valueOf(shift));
        labelTotalTakeLeave.setText(String.valueOf(leave));
        labelTotalRequest.setText(String.valueOf(request));
    }

    // load salary of staff
    private void updateSalaryInfo() {
        // // TODO: Fetch actual data from database/service
        // TotalShift.setText("100");
        // Rate.setText("50$");
        // StaffSalary.setText("5,000$");
        Staff staff = (Staff) dataManager.loggedInUser;
        TotalShift.setText(Integer.toString(staff.getListOfDutyId().size()));
        Rate.setText(50 + "$");
        StaffSalary.setText(staff.ViewSalary());
    }

}
