package com.cse305.Models;

import java.io.Serializable;

public class Request implements Serializable{
    public String ID;
    public String StaffID;
    public String DutyId;
    public String Type;
    public Boolean isAccepted = null;
    public String reason;
    public Request(String iD, String staffID, String dutyId, String type, Boolean isAccepted, String reason) {
        ID = iD;
        StaffID = staffID;
        DutyId = dutyId;
        Type = type;
        this.isAccepted = isAccepted;
        this.reason = reason;
    }
    public void accept() {
        isAccepted = true;
    }
    public void reject() {
        isAccepted = false;
    }

}
