package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.FullTimeEmployee;
import com.codegym.model.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {
    public static List<Employee> workingStatusList(List<Employee> list) {
        List<Employee> newList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.isWorkingStatus()) {
                newList.add(employee);
            }
        }
        return newList;
    }

    public static List<Employee> notWorkingStatusList(List<Employee> list) {
        List<Employee> newList = new ArrayList<>();
        for (Employee employee : list) {
            if (!employee.isWorkingStatus()) {
                newList.add(employee);
            }
        }
        return newList;
    }

    public static List<Employee> fullTimeEmployeeList(List<Employee> list) {
        List<Employee> newList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee instanceof FullTimeEmployee && employee.isWorkingStatus()) {
                newList.add(employee);
            }
        }
        return newList;
    }

    public static List<Employee> partTimeEmployeeList(List<Employee> list) {
        List<Employee> newList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee instanceof PartTimeEmployee && employee.isWorkingStatus()) {
                newList.add(employee);
            }
        }
        return newList;
    }

}
