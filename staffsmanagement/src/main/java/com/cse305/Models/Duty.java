package com.cse305.Models;

import java.io.Serializable;

public class Duty implements Serializable {
    public String ID;
    public String Place;
    public String StaffID; // The staff member assigned to this duty
    public String DayOfWeek; // "Monday", "Tuesday", etc.
    public String Shift; // "Morning", "Afternoon", "Evening"
    public Duty(String iD, String place, String staffId, String dayOfWeek, String shift) {
        ID = iD;
        Place = place;
        StaffID = staffId;
        DayOfWeek = dayOfWeek;
        Shift = shift;
    }
    public String getDayShiftKey() {
        return DayOfWeek + Shift;
    }

}
