package com.cse305.Models;

public class Duty {
    String ID;
    String Place;
    Staff Staff; // The staff member assigned to this duty
    String DayOfWeek; // "Monday", "Tuesday", etc.
    String Shift; // "Morning", "Afternoon", "Evening"
    public Duty(String iD, String place, Staff staff, String dayOfWeek, String shift) {
        ID = iD;
        Place = place;
        Staff = staff;
        DayOfWeek = dayOfWeek;
        Shift = shift;
    }
}
