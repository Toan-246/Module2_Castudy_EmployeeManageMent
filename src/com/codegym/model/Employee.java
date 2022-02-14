package com.codegym.model;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String dateOfBirth;
    private String hometown;
    private String identity;
    private String phone;
    private double level;
    private boolean workingStatus;

    public Employee() {
    }

    public Employee(String id, String name, boolean workingStatus, double level) {
        this.id = id;
        this.name = name;
        this.workingStatus = workingStatus;
        this.level = level;
    }


    public Employee(String id, String name, String sex, String dateOfBirth, String hometown,
                    String identity, String phone, double level, boolean workingStatus) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.hometown = hometown;
        this.identity = identity;
        this.phone = phone;
        this.level = level;
        this.workingStatus = workingStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public boolean isWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(boolean workingStatus) {
        this.workingStatus = workingStatus;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public abstract double salaryCaculator(double level);

    @Override
    public String toString() {
        return "ID:" + id + ", name:" + name + ", level:" + level;
//        return id + ", " + name + ", " + sex + ", " + dateOfBirth + ", " + hometown
//                + ", " + identity + ", " + phone + ", " + level;
    }
}
