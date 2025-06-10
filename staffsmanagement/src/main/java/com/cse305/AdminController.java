package com.cse305;

import java.util.*;
import java.io.IOException;
import java.net.URL;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import com.cse305.Models.DataManager;
import com.cse305.Models.Duty;
import com.cse305.Models.User;
import com.cse305.Models.Staff;

public class AdminController implements Initializable {
    public DataManager dataManager = DataManager.getInstance();

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
    private TextField txtCreatePassword;

    @FXML
    private ChoiceBox<String> optionCreateRole;

    // ChoiceBox fields for Add Schedule
    @FXML
    private TextField scheEmID;
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

    // scheduel pannel
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

    //Salary Table
    @FXML
    private TableView<Staff> SalaryTable;

    @FXML
    private TableColumn<Staff, String> staffNameCol;

    @FXML
    private TableColumn<Staff, String> staffIdCol;

    @FXML
    private TableColumn<Staff, Integer> totalShiftCol;

    @FXML
    private TableColumn<Staff, Integer> dayAbsentCol;

    @FXML
    private TableColumn<Staff, String> rateCol;

    @FXML
    private TableColumn<Staff, String> totalSalaryCol;

    public boolean flag = false;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set initial state - show home panel by default
        showHomePanel();

        // Add event handlers for navigation buttons
        btnHome.setOnAction(e -> showHomePanel());
        btnAddStaff.setOnAction(e -> showAddStaffPanel());
        btnAddSchedule.setOnAction(e -> showAddSchedulePanel());
        btnStaffRequest.setOnAction(e -> showStaffRequestPanel());
        btnSalary.setOnAction(e -> showSalaryPannel());

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
        
        //apply scheduel duty
        setupMap();
        clearLabelsText();
        LoadDutyOfStaff();

        //setup and load SalaryTable
        
        SetUpSalaryTable();
        LoadSalaryTable();

        //tét check if the PANEL load fully
        flag = true;
    }

    // Action button handlers
    private void handleLogOut() {
        // TODO: Implement logout functionality
        try {
            App.setRoot("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    // DONE
    private void handleCreateAccount() {
        // TODO: Implement create account functionality
        if (optionCreateRole.getValue().equals("Security Guard")) {
            dataManager.createStaffAccount(txtCreateEmployeeId.getText(), txtCreateName.getText(),
                    txtCreatePassword.getText());
        } else {
            dataManager.createManagerAccount(txtCreateEmployeeId.getText(), txtCreateName.getText(),
                    txtCreatePassword.getText());
        }
        System.out.println("Create Account button clicked");
    }

    private void handleReset() {
        // TODO: Implement reset form functionality
        System.out.println("Reset button clicked");
    }

    // Add Schedule panel handler
    private void handleAssignSchedule() {
        // TODO: Implement assign schedule functionality
        String place = optionSelectWorkingPlace.getValue();
        String staffID = scheEmID.getText();
        String day = optionSelectDay.getValue();
        String shift = optionSelectTime.getValue();
        dataManager.giveDuty(place, staffID, day, shift);

        System.out.println("Assign Schedule button clicked");
    }

    private void initializeChoiceBoxes() {
        // Initialize Day options
        optionSelectDay.getItems().addAll(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        // Initialize Time options
        optionSelectTime.getItems().addAll(
                "Morning Shift",
                "Afternoon Shift",
                "Evening Shift");

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

        if(flag) {
            LoadDutyOfStaff();
        }
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

    private void showSalaryPannel() {
        HomePanel.setVisible(false);
        AddStaffPanel.setVisible(false);
        AddSchedulePanel.setVisible(false);
        StaffRequestPanel.setVisible(false);
        SalaryPannel.setVisible(true);

    }

    static HashMap<String, Label> labelMap = new HashMap<>();
    // setup Map
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

    // clear the label
    public void clearLabelsText() {
        for (Label label : labelMap.values()) {
            label.setText("");
        }
    }

    // Load duty to the label scheduel
    public void LoadDutyOfStaff() {
        ArrayList<Duty> dutyList = dataManager.getDutyOfAllStaff();
        ArrayList<Staff> staffList = dataManager.getStaffList();
        HashMap<String,String> staffDutyMap = new HashMap<>();
        for (Staff staff : staffList) {
            staffDutyMap.put(staff.ID, staff.Name);
        }
        for (Duty duty : dutyList) {
            String staffId = duty.StaffID;
            String day = duty.DayOfWeek;
            String shift = duty.Shift;
            shift = shift.split(" ")[0];
            String key = day + shift;
            System.out.println("Loading duty for key: " + key);
            Label label = labelMap.get(key);
            String dutyText = staffDutyMap.get(staffId)+"\n"+staffId;
            label.setText(dutyText);
        }
    }

    //Set up the salary table column
    public void SetUpSalaryTable(){
        staffNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().Name));
        staffIdCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ID));
        totalShiftCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Integer>(cellData.getValue().getListOfDutyId().size()));
        //need some change in salary and absent calculation 
        //number of absent is the number of request that have the isAccepted is TRUE
        dayAbsentCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<Integer>(cellData.getValue().getListOfRequestId().size()));
        rateCol.setCellValueFactory(cellData -> new SimpleStringProperty("50$"));
        totalSalaryCol.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getListOfDutyId().size() * 50) + "$"));
    }
    
    //Load Table Salary
    public void LoadSalaryTable(){
        ArrayList<Staff> staffList = dataManager.getStaffList();
        ObservableList<Staff> observableList = FXCollections.observableArrayList(staffList);
        SalaryTable.setItems(observableList);
    }


    
}