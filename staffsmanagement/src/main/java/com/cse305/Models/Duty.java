package com.cse305.Models;

public class Duty {
    String ID;
    String Place;
    String StaffID; // The staff member assigned to this duty
    String DayOfWeek; // "Monday", "Tuesday", etc.
    String Shift; // "Morning", "Afternoon", "Evening"
    public Duty(String iD, String place, String staffId, String dayOfWeek, String shift) {
        ID = iD;
        Place = place;
        StaffID = staffId;
        DayOfWeek = dayOfWeek;
        Shift = shift;
    }
}
