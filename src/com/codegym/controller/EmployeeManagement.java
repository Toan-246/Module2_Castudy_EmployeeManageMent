package com.codegym.controller;

import com.codegym.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement implements ReadFile, WriteFile{
    private List<Employee> employees = new ArrayList<>();

    public EmployeeManagement() {
        File file = new File("employee.txt");
        if (file.exists()){
            try {
                readFile("employee.txt");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

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
        try {
            writeFile("employee.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public double searchSalaRyByName(String name) {
        int index = findEmployeeByName(name);
        double salary = employees.get(index).salaryCaculator(employees.get(index).getLevel());
        return salary;
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.employees = (List<Employee>) ois.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.employees);
    }

    public void displayWorkingEmplyoeeSalaryInfo(List<Employee> workingList) {
        for (Employee employee:workingList) {
            System.out.println(employee.getName() + ":  " + employee.salaryCaculator(employee.getLevel()) + " USD");
        }
    }

    public double totalSalaryCayculator(List<Employee> workingList) {
        double total = 0;
        for (Employee employee:workingList) {
            total += employee.salaryCaculator(employee.getLevel());
        }
        return total;
    }
}
