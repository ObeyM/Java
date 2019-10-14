package com.app.ora.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @Id
    @Basic(optional = false)
    @NotNull
    private long userRecordId;
    @Column
    private String userFullName;
    @Column
    private String userIdNumber;
    @Basic(optional = false)
    @NotNull
    @Column
    @Temporal(TemporalType.TIMESTAMP)
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