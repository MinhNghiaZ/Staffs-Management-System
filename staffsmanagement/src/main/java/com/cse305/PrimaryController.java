package com.cse305;

import java.io.IOException;

import com.cse305.Models.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    public void show(ActionEvent e) {
        System.out.println("cccccccccccc");
    }
    public void showw2(ActionEvent e) {
        Student student = new Student();
        student.name = "duy123";
        student.id = 1113;
        System.out.println(student.name + student.id);
    }
}
