package com.cse305;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminController {
    @FXML
    public Label MondayMorning;
    @FXML
    public Label MondayAfternoon;
    @FXML
    public Label MondayEvening;
    @FXML
    public Label TuesdayMorning;
    @FXML
    public Label TuesdayAfternoon;
    @FXML
    public Label TuesdayEvening;
    @FXML
    public Label WednesdayMorning;
    @FXML
    public Label WednesdayAfternoon;
    @FXML
    public Label WednesdayEvening;
    @FXML
    public Label ThursdayMorning;
    @FXML
    public Label ThursdayAfternoon;
    @FXML
    public Label ThursdayEvening;
    @FXML
    public Label FridayMorning;
    @FXML
    public Label FridayAfternoon;
    @FXML
    public Label FridayEvening;

    HashMap<String, Label> dutyLabels = new HashMap<>();

    //@FXML
    // private void switchToPrimary() throws IOException {
    //     App.setRoot("primary");
    // }

    public void initialize() {
        dutyLabels.put("MondayMorning", MondayMorning);
        dutyLabels.put("MondayAfternoon", MondayAfternoon);
        dutyLabels.put("MondayEvening", MondayEvening);
        dutyLabels.put("TuesdayMorning", TuesdayMorning);
        dutyLabels.put("TuesdayAfternoon", TuesdayAfternoon);
        dutyLabels.put("TuesdayEvening", TuesdayEvening);
        dutyLabels.put("WednesdayMorning", WednesdayMorning);
        dutyLabels.put("WednesdayAfternoon", WednesdayAfternoon);
        dutyLabels.put("WednesdayEvening", WednesdayEvening);
        dutyLabels.put("ThursdayMorning", ThursdayMorning);
        dutyLabels.put("ThursdayAfternoon", ThursdayAfternoon);
        dutyLabels.put("ThursdayEvening", ThursdayEvening);
        dutyLabels.put("FridayMorning", FridayMorning);
        dutyLabels.put("FridayAfternoon", FridayAfternoon);
        dutyLabels.put("FridayEvening", FridayEvening);
    }
}