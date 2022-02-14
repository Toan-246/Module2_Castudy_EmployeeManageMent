package com.codegym.model;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String id, String name, boolean workingStatus, double level) {
        super(id, name, workingStatus, level);
    }

    public PartTimeEmployee() {
    }

    @Override
    public double salaryCaculator(double level) {
        return 800 + level * 30;
    }

    @Override
    public String toString() {
        return super.toString() + ", Part time";
    }
}
