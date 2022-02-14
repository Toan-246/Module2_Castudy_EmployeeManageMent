package com.codegym.model;

public class PartTimeEmployee extends Employee{
    public PartTimeEmployee(String id, String name, boolean workingStatus, double level) {
        super(id, name, workingStatus, level);
    }

    @Override
    public double salaryCaculator() {
        return getLevel()*300000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Part time";
    }
}
