package com.app.ora.dto;

import java.util.Date;

public class UserDto {

    private long userRecordId;
    private String userFullName;
    private String userIdNumber;
    private Date dateRegistered;

    public long getUserRecordId() {
        return userRecordId;
    }

    public void setUserRecordId(long userRecordId) {
        this.userRecordId = userRecordId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(String userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}