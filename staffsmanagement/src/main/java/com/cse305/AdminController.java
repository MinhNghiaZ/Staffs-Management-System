package com.cse305;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import com.cse305.Models.User;

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
    private Button btnStaffRequest;

    @FXML
    private Button btnRequestAccept;

    // Add the two new buttons
    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnDenied;

    @FXML
    private AnchorPane HomePanel;

    @FXML
    private AnchorPane AddStaffPanel;

    @FXML
    private AnchorPane AddSchedulePanel;

    @FXML
    private AnchorPane StaffRequestPanel;

    @FXML
    private AnchorPane SalaryPannel;

    // TableViews for different panels
    @FXML
    private TableView<User> UserTable;

    @FXML
    private TableView<User> RequestTable; // For Staff Request Panel

    // Table columns for UserTable (Add Staff Panel)
    @FXML
    private TableColumn<User, String> colId;

    @FXML
    private TableColumn<User, String> colName;

    @FXML
    private TableColumn<User, String> colPassword;

    @FXML
    private TableColumn<User, String> colRole;

    // Table columns for RequestTable (Staff Request Panel)
    @FXML
    private TableColumn<User, String> colId1;

    @FXML
    private TableColumn<User, String> colName1;

    @FXML
    private TableColumn<User, String> colPassword1;

    @FXML
    private TableColumn<User, String> colRole1;

    @FXML
    private TableColumn<User, String> colRole11;

    // Text fields for Add Staff form
    @FXML
    private TextField txtCreateEmployeeId;

    @FXML
    private TextField txtCreateName;

    @FXML
    private ChoiceBox<String> optionCreateRole;

    // ChoiceBox fields for Add Schedule
    @FXML
    private ChoiceBox<String> optionSelectDay;

    @FXML
    private ChoiceBox<String> optionSelectTime;

    @FXML
    private ChoiceBox<String> optionSelectWorkingPlace;

    // New buttons for creating account and resetting
    @FXML
    private Button btnCreateAccount;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnAssign;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set initial state - show home panel by default
        showHomePanel();

        // Add event handlers for navigation buttons
        btnHome.setOnAction(e -> showHomePanel());
        btnAddStaff.setOnAction(e -> showAddStaffPanel());
        btnAddSchedule.setOnAction(e -> showAddSchedulePanel());
        btnStaffRequest.setOnAction(e -> showStaffRequestPanel());
        btnSalary.setOnAction(e->showSalaryPannel());


        // Add event handlers for action buttons
        btnLogOut.setOnAction(e -> handleLogOut());
        btnRequestAccept.setOnAction(e -> handleAcceptRequest());
        btnDenied.setOnAction(e -> handleDenyRequest());

        // Add event handlers for form buttons
        btnCreateAccount.setOnAction(e -> handleCreateAccount());
        btnReset.setOnAction(e -> handleReset());

        // Add event handler for Add Schedule panel button
        btnAssign.setOnAction(e -> handleAssignSchedule());

        // Initialize the ChoiceBox options
        initializeChoiceBoxes();
    }

    

    // Action button handlers
    private void handleLogOut() {
        // TODO: Implement logout functionality
        System.out.println("Logout button clicked");
    }

    private void handleAcceptRequest() {
        // TODO: Implement accept request functionality
        System.out.println("Accept request button clicked");
    }

    private void handleDenyRequest() {
        // TODO: Implement deny request functionality
        System.out.println("Deny request button clicked");
    }

    // Add Staff panel handlers
    private void handleCreateAccount() {
        // TODO: Implement create account functionality
        System.out.println("Create Account button clicked");
    }

    private void handleReset() {
        // TODO: Implement reset form functionality
        System.out.println("Reset button clicked");
    }

    // Add Schedule panel handler
    private void handleAssignSchedule() {
        // TODO: Implement assign schedule functionality
        System.out.println("Assign Schedule button clicked");
    }

    private void initializeChoiceBoxes() {
        // Initialize Day options
        optionSelectDay.getItems().addAll(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        // Initialize Time options
        optionSelectTime.getItems().addAll(
                "Morning Shift (6:00 AM - 2:00 PM)",
                "Afternoon Shift (2:00 PM - 10:00 PM)",
                "Evening Shift (10:00 PM - 6:00 AM)");

        // Initialize Working Place options
        optionSelectWorkingPlace.getItems().addAll(
                "Main Entrance", "Parking Lot", "Building A", "Building B",
                "Rooftop");

        // Initialize Role options for Add Staff
        optionCreateRole.getItems().addAll(
                "Security Guard", "Administrator");

        // Set default selections
        optionSelectDay.setValue("Monday");
        optionSelectTime.setValue("Morning Shift (6:00 AM - 2:00 PM)");
        optionSelectWorkingPlace.setValue("Main Entrance");
        optionCreateRole.setValue("Security Guard");
    }

    private void showHomePanel() {
        HomePanel.setVisible(true);
        AddStaffPanel.setVisible(false);
        AddSchedulePanel.setVisible(false);
        StaffRequestPanel.setVisible(false);
        SalaryPannel.setVisible(false);
    }

    private void showAddStaffPanel() {
        HomePanel.setVisible(false);
        AddStaffPanel.setVisible(true);
        AddSchedulePanel.setVisible(false);
        StaffRequestPanel.setVisible(false);
        SalaryPannel.setVisible(false);
    }

    private void showAddSchedulePanel() {
        HomePanel.setVisible(false);
        AddStaffPanel.setVisible(false);
        AddSchedulePanel.setVisible(true);
        StaffRequestPanel.setVisible(false);
        SalaryPannel.setVisible(false);
    }

    private void showStaffRequestPanel() {
        HomePanel.setVisible(false);
        AddStaffPanel.setVisible(false);
        AddSchedulePanel.setVisible(false);
        StaffRequestPanel.setVisible(true);
        SalaryPannel.setVisible(false);
    }

    private void showSalaryPannel(){
        HomePanel.setVisible(false);
        AddStaffPanel.setVisible(false);
        AddSchedulePanel.setVisible(false);
        StaffRequestPanel.setVisible(false);
        SalaryPannel.setVisible(true);

    }
}