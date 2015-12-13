package edu.mum.cs545.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class WorklogBean {

    private int id;

    @NotNull
    @Column(nullable = false)
    @Range(min = 0)
    private double actualEffort;

    @NotNull
    @Column(nullable = false)
    private Date modifiedDate;

    @NotNull
    @Column(nullable = false)
    private int userStoryId;

    @NotNull
    @Column(nullable = false)
    private String effortType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getActualEffort() {
        return actualEffort;
    }

    public void setActualEffort(double actualEffort) {
        this.actualEffort = actualEffort;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(int userStoryId) {
        this.userStoryId = userStoryId;
    }

    public String getEffortType() {
        return effortType;
    }

    public void setEffortType(String effortType) {
        this.effortType = effortType;
    }

}
