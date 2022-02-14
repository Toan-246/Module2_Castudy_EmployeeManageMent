package com.codegym.model;

public class FullTimeEmployee extends Employee{
    public FullTimeEmployee(String id, String name, boolean workingStatus, double level) {
        super(id, name, workingStatus, level);
    }

    public FullTimeEmployee() {
    }

    @Override
    public double salaryCaculator(double level) {
        return 1000+level*50;
    }

    @Override
    public String toString() {
        return super.toString() + ", Full time";
    }
}
