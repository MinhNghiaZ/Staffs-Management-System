package com.cse305.Models;

public class Duty {
    String ID;
    String Name;
    Staff Staff; // The staff member assigned to this duty
    String DayOfWeek; // "Monday", "Tuesday", etc.
    String Shift; // "Morning", "Afternoon", "Evening"
    public Duty(String iD, String name, com.cse305.Models.Staff staff, String dayOfWeek, String shift) {
        ID = iD;
        Name = name;
        Staff = staff;
        DayOfWeek = dayOfWeek;
        Shift = shift;
    }
}
