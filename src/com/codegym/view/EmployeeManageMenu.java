package com.codegym.view;

import com.codegym.controller.EmployeeFilter;
import com.codegym.controller.EmployeeManagement;
import com.codegym.controller.UserManagement;
import com.codegym.model.*;

import java.util.List;
import java.util.Scanner;

public class EmployeeManageMenu {
    public final String FULL_TIME = "Full time";
    public final String PART_TIME = "Part time";
    static Scanner scanner = new Scanner(System.in);
    EmployeeManagement employeeManagement = new EmployeeManagement();
    public void run() {

//        employeeManagement.addEmployee(new FullTimeEmployee("001", "Toan", true, 3.2));
//        employeeManagement.addEmployee(new FullTimeEmployee("002", "Luyt", true, 3.1));
//        employeeManagement.addEmployee(new FullTimeEmployee("003", "Lich", false, 3.0));
//        employeeManagement.addEmployee(new PartTimeEmployee("004", "Hùng", true, 2.5));
//        employeeManagement.addEmployee(new PartTimeEmployee("005", "Việt", false, 2.6));

        List<Employee> fullList = employeeManagement.getEmployees();
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();

        int choice = -1;
        do {
            menu();
            System.out.println("---Mời nhập lựa chọn---");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    showEmployeeList(employeeManagement, fullList);
                    break;
                }
                case 2: {
                    showAddEmployee(employeeManagement);
                    break;
                }
                case 3: {
                    findEmployeeByName(employeeManagement);
                    break;
                }
                case 4: {
                    ShowUpdateEmployee(employeeManagement);
                    break;
                }
                case 5: {
                    showCheckEmployeeWorkingStatus(employeeManagement);
                    break;
                }
                case 6: {
                    ShowSalaryInfo(employeeManagement, fullList, fullTimeEmployee, partTimeEmployee);

                    break;
                }
                case 7: {
                    showAcountInfo();
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Nhập lựa chọn từ 0 - >6");
                }
            }
        } while (choice != 0);
    }

    private void showAcountInfo() {
        System.out.println("---Thông tin tài khoản---");
        System.out.println(LoginMenu.currentUser);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private void ShowSalaryInfo(EmployeeManagement employeeManagement, List<Employee> fullList, FullTimeEmployee fullTimeEmployee, PartTimeEmployee partTimeEmployee) {
        int choiceSalary = -1;
        do {
            salaryMenu();
            choiceSalary = scanner.nextInt();
            scanner.nextLine();
            switch (choiceSalary) {
                case 1: {
                    System.out.println("---Tính lương nhân viên---");
                    String contractType = inputContractType();
                    System.out.println("Nhập level");
                    double level = scanner.nextDouble();
                    scanner.nextLine();
                    double salary;
                    if (contractType.equals("Full time")) {
                        salary = fullTimeEmployee.salaryCaculator(level);
                        System.out.println("Salary: " + salary + " USD");
                        System.out.println("-------------------");
                    } else if (contractType.equals("Part time")) {
                        salary = partTimeEmployee.salaryCaculator(level);
                        System.out.println("Salary: " + salary + " USD");
                        System.out.println("-------------------");
                    }

                    break;
                }
                case 2: {
                    System.out.println("---Tra cứu lương nhân viên---");
                    System.out.println("Nhập tên nhân viên cần tra cứu");
                    String name = scanner.nextLine();
                    int index = employeeManagement.findEmployeeByName(name);
                    if (index != -1) {
                        double salary = employeeManagement.searchSalaRyByName(name);
                        System.out.println("Lương của nhân viên " + name + " là: " + salary  + " USD");
                        System.out.println("-------------------------------------------");
                    } else {
                        System.out.println("Không có nhân viên " + name);
                        System.out.println("--------------------------");
                    }
                    break;
                }
                case 3: {
                    System.out.println("---Hiển thị tổng lương phải trả của công ty---");
                    List<Employee> workingList = EmployeeFilter.workingStatusList(fullList);
                    employeeManagement.displayWorkingEmplyoeeSalaryInfo(workingList);
                    System.out.println("Total:  " + employeeManagement.totalSalaryCayculator(workingList)  + "USD");
                    System.out.println("-------------------");
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Nhập từ 0-3");
                }
            }
        } while (choiceSalary != 0);
    }

    private void salaryMenu() {
        System.out.println("---Tính toán và Hiển thị thông tin lương---");
        System.out.println("    1. Tính lương nhân viên");
        System.out.println("    2. Tra cứu lương nhân viên");
        System.out.println("    3. Hiển thị tổng lương phải trả của công ty");
        System.out.println("    0. Quay lại");
        System.out.println("Mời bạn nhập lựa chọn");
    }

    private void showCheckEmployeeWorkingStatus(EmployeeManagement employeeManagement) {
        System.out.println("---Kiểm tra trạng thái nhân viên Theo tên---");
        System.out.println("Nhập tên nhân viên cần kiểm tra trạng thái");
        String name = scanner.nextLine();
        int index = employeeManagement.findEmployeeByName(name);
        if (index != -1) {
            employeeManagement.checkWorkingStatus(name);
            System.out.println("-----------------------------");
        } else {
            System.out.println("Không có nhân viên " + name);
            System.out.println("------------------------");
        }
    }

    private void ShowUpdateEmployee(EmployeeManagement employeeManagement) {

        int choiceUpdate = -1;
        do {
            employeeUpdateInfoMenu();
            choiceUpdate = scanner.nextInt();
            scanner.nextLine();
            switch (choiceUpdate) {
                case 1: {
                    System.out.println("---Cập nhật thông tin nhân viên---");
                    System.out.println("Nhập tên nhân viên cần chỉnh sửa");
                    String name = scanner.nextLine();
                    int index = employeeManagement.findEmployeeByName(name);
                    if (index != -1) {
                        Employee employee = inputEmployee(name,true);
                        employeeManagement.updateEmployeeInfo(name, employee);
                        System.out.println("Cập nhật thành công");
                        System.out.println("---------------------");
                    } else {
                        System.out.println("Không có nhân viên có tên như bạn nhập");
                        System.out.println("---------------------------------------");
                    }

                    break;
                }
                case 2: {
                    System.out.println("---Cập nhật trạng thái nhân viên---");
                    System.out.println("Nhập tên nhân viên cần cập nhật");
                    String name = scanner.nextLine();
                    int index = employeeManagement.findEmployeeByName(name);
                    if (index != -1) {
                        employeeManagement.updateEmployeeStatus(name);
                        System.out.println("-----------------------------------------------------");
                    } else {
                        System.out.println("Không có nhân viên có tên như bạn nhập");
                        System.out.println("---------------------------------------");
                    }
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Lựa chọn 1 hoặc 2");
                    System.out.println("------------------");
                }
            }
        } while (choiceUpdate != 0);
    }

    private void employeeUpdateInfoMenu() {
        System.out.println(" ---CẬP NHẬT THÔNG TIN, TRẠNG THÁI NHÂN VIÊN---");
        System.out.println("    1. Cập nhật thông tin nhân viên");
        System.out.println("    2. Cập nhật trạng thái nhân viên");
        System.out.println("    0. Quay lại");
        System.out.println("    Mời nhập lựa chọn");
    }

    private void showAddEmployee(EmployeeManagement employeeManagement) {
        System.out.println("---Thêm nhân viên---");
        Employee employee = inputEmployee(false);
        employeeManagement.addEmployee(employee);
        System.out.println(" Thêm nhân viên thành công!!!");
        System.out.println("------------------------------");
    }

    public Employee inputEmployee(boolean allowsDuplicateId) {
        System.out.println("Nhập tên nhân viên");
        String name = scanner.nextLine();
        return inputEmployee(name, allowsDuplicateId);
    }
    public Employee inputEmployee() {
        System.out.println("Nhập tên nhân viên");
        String name = scanner.nextLine();
        return inputEmployee(name);
    }
    public Employee inputEmployee(String name){
        return inputEmployee(name, true);
    }

    public Employee inputEmployee(String name, boolean allowsDuplicateId) {
        Employee employee = null;
        System.out.println("Nhập thông tin nhân viên");
        String id = inputEmployeeID(allowsDuplicateId);
        String contractType = inputContractType();
        System.out.println("Nhập level nhân viên");
        double level = scanner.nextDouble();
        scanner.nextLine();

        switch (contractType) {
            case FULL_TIME: {
                employee = new FullTimeEmployee(id, name, true, level);
                break;
            }
            case PART_TIME: {
                employee = new PartTimeEmployee(id, name, true, level);
                break;
            }
        }

        return employee;
    }

    private String inputContractType() {
        String contractType;
        do {
            System.out.println("Nhập loại hợp đồng làm việc (Full time / Part time)");
            contractType = scanner.nextLine();

        } while (!contractType.equals("Full time") && !contractType.equals("Part time"));
        return contractType;
    }

    private String inputEmployeeID(boolean allowsDuplicateId) {
        String id;
        boolean invalidInput;
        do {
            System.out.println("Nhập mã số nhân viên");
            id = scanner.nextLine();
            boolean idExist = employeeManagement.checkIdExist(id);
            invalidInput = !allowsDuplicateId && idExist;

            if (invalidInput){
                System.err.println("ID trùng");
            }
        }while (invalidInput);
        return id;
    }

    private void findEmployeeByName(EmployeeManagement employeeManagement) {
        System.out.println("---Tìm kiếm nhân viên theo tên---");
        System.out.println("Nhập tên nhân viên cần tìm kiếm");
        String name = scanner.nextLine();
        int index = employeeManagement.findEmployeeByName(name);
        if (index != -1) {
            System.out.println("Thông tin nhân viên cần tìm: " + employeeManagement.getByName(name));
            System.out.println("---------------------------------------------------------------------");
        } else {
            System.out.println("Không có nhân viên " + name);
            System.out.println("------------------------");
        }
    }

    private void showEmployeeList(EmployeeManagement employeeManagement, List<Employee> fullList) {
        int choiceList = -1;
        int size = employeeManagement.size();
        if (size == 0) {
            System.out.println("Danh sách trống");
        } else {
            do {
                menuDisplayEmployeeList();
                System.out.println("    ---Mời nhập lựa chon danh sách---");
                choiceList = scanner.nextInt();
                switch (choiceList) {
                    case 1: {
                        System.out.println("---Danh sách nhân viên đang làm việc---");
                        List<Employee> newList = EmployeeFilter.workingStatusList(fullList);
                        employeeManagement.displayEmployeeList(newList);
                        System.out.println("----------------------------------------");
                        break;
                    }
                    case 2: {
                        System.out.println("---Danh sách nhân viên Đã nghỉ việc---");
                        List<Employee> newList = EmployeeFilter.notWorkingStatusList(fullList);
                        employeeManagement.displayEmployeeList(newList);
                        System.out.println("----------------------------------------");
                        break;
                    }
                    case 3: {
                        System.out.println("---Danh sách nhân viên làm việc full time---");
                        List<Employee> newList = EmployeeFilter.fullTimeEmployeeList(fullList);
                        employeeManagement.displayEmployeeList(newList);
                        System.out.println("----------------------------------------");
                        break;
                    }
                    case 4: {
                        System.out.println("---Danh sách nhân viên làm việc part time---");
                        List<Employee> newList = EmployeeFilter.partTimeEmployeeList(fullList);
                        int partTimeSize = newList.size();
                        if (partTimeSize == 0) {
                            System.out.println("Danh sách trống ");
                            System.out.println("----------------");
                        } else {
                            employeeManagement.displayEmployeeList(newList);
                            System.out.println("----------------------------------------");
                        }
                        break;
                    }
                    case 0: {
                        break;
                    }
                    default: {
                        System.out.println("Nhập lựa chọn từ 0 -> 4");
                        System.out.println("------------------------");
                        break;
                    }
                }

            } while (choiceList != 0);
        }

    }

    private void menuDisplayEmployeeList() {
        System.out.println("    ---HIỂN THỊ DANH SÁCH NHÂN VIÊN---");
        System.out.println("    1. Danh sách nhân viên đang làm việc");
        System.out.println("    2. Danh sách nhân viên Đã nghỉ việc");
        System.out.println("    3. Danh sách nhân viên full time");
        System.out.println("    4. Danh sách nhân viên part time");
        System.out.println("    0. Quay lại");
    }

    private void menu() {
        System.out.println("---MENU QUẢN LÝ NHÂN VIÊN---");
        System.out.println("1. Hiển thị danh sách nhân viên");
        System.out.println("2. Thêm nhân viên");
        System.out.println("3. Tìm kiếm nhân viên theo tên");
        System.out.println("4. Cập nhật thông tin, trạng thái nhân viên");
        System.out.println("5. Kiểm tra trạng thái nhân viên Theo tên");
        System.out.println("6. Tính lương nhân viên");
        System.out.println("7. Thông tin tài khoản");
        System.out.println("0. Đăng xuất");
        System.out.println();
    }

}
