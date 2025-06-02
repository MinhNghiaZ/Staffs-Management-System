package com.cse305.Models;

import java.io.Serializable;

public class Request implements Serializable{
    public String ID;
    public String StaffID;
    public String DutyId;
    public String Type;
    public boolean isAccepted;
    public Request(String iD, String staffID, String dutyId, String type, boolean isAccepted) {
        ID = iD;
        StaffID = staffID;
        DutyId = dutyId;
        Type = type;
        this.isAccepted = isAccepted;
    }

    public void accept() {
        isAccepted = true;
    }
    public void reject() {
        isAccepted = false;
    }

}
