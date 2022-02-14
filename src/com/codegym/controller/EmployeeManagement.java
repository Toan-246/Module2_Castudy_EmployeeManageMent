package com.codegym.controller;

import com.codegym.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getByName(String name) {
        int index = findEmployeeByName(name);
        return employees.get(index);
    }

    public int size() {
        return employees.size();
    }

    public void displayEmployeeList(List<Employee> list) {
        for (Employee employ : list) {
            System.out.println(employ);
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public int findEmployeeByName(String name) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public void updateEmployeeInfo(String name, Employee employee) {
        int index = findEmployeeByName(name);
        employees.set(index, employee);
    }

    public void updateEmployeeStatus(String name) {
        int index = findEmployeeByName(name);
        if (employees.get(index).isWorkingStatus()) {
            employees.get(index).setWorkingStatus(false);
        } else {
            employees.get(index).setWorkingStatus(true);
        }
    }

    public void checkWorkingStatus(String name) {
        int index = findEmployeeByName(name);
        if (employees.get(index).isWorkingStatus()){
            System.out.println("Nhân viên " + name + " Đang làm việc");
        }
        else {
            System.out.println("Nhân viên " + name + " Đã nghỉ việc");
        }

    }

    public double salaryCaculator(String name) {
        int index = findEmployeeByName(name);
        double salary = employees.get(index).salaryCaculator();
        return salary;
    }
}
