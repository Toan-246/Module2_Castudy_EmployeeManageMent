package com.codegym.model;

public class FullTimeEmployee extends Employee{
    public FullTimeEmployee(String id, String name, boolean workingStatus, double level) {
        super(id, name, workingStatus, level);
    }

    @Override
    public double salaryCaculator() {
        return getLevel()*500000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Full time";
    }
}
