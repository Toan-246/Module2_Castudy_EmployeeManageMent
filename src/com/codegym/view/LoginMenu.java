package com.codegym.view;

import com.codegym.controller.UserManagement;
import com.codegym.model.User;
import com.codegym.controller.UserCheck;

import java.util.Scanner;

public class LoginMenu {
    public Scanner scanner = new Scanner(System.in);
    private UserManagement userManagement = new UserManagement();
    private EmployeeManageMenu employeeManageMenu = new EmployeeManageMenu();
    UserCheck userCheck = new UserCheck();
    static User currentUser = new User();

    public void run() {
        int choice = -1;
        do {
            menu();
            System.out.println("Mời bạn nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    doLogin();
                    break;
                }
                case 2: {
                    doRegister();
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Nhật 0 -> 2");
                }
            }
        } while (choice != -0);
    }

    private void doLogin() {
        currentUser = inputUser();
        if (currentUser != null) {
            System.out.println("Đăng nhập thành công");
            System.out.println("---------------------");
            employeeManageMenu.run();

        } else {
            System.err.println("User name hoặc pass word không đúng");
        }

//            boolean isLogin = userManagement.checkLogin(userName, passWord);
//        if (isLogin) {
//            System.out.println("Đăng nhập thành công");
//            System.out.println("---------------------");
//            employeeManageMenu.run();
//        } else {
//            System.err.println("User name hoặc pass word không đúng");
//        }
    }

    public User inputUser() {
        System.out.println("Nhập user name");
        String userName = scanner.nextLine();
        System.out.println("Nhập Mật khẩu");
        String passWord = scanner.nextLine();
        User loginUser = userManagement.login(userName, passWord);
        return loginUser;
    }
//    public User inputUser(String passWord) {
//        System.out.println("Nhập user name");
//        String userName = scanner.nextLine();
//        System.out.println("Nhập Mật khẩu");
//        String passWord = scanner.nextLine();
//        User loginUser = userManagement.login(userName, passWord);
//        return loginUser;
//    }

    private void menu() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Thoát");
    }

    private void doRegister() {
        System.out.println("---Đăng ký tài khoản---");
        User user = creatUser();
        userManagement.register(user);
        System.out.println("Đăng ký thành công!");
        System.out.println("--------------------");

    }

    private User creatUser() {
        String userName = inputUserName();
        String passWord = inputPassWord();
        String phoneNum = creatPhoneNumber();
        String email = creatEmail();
        User user = new User(userName, passWord, phoneNum, email);
        return user;
    }

    private String creatEmail() {
        String email;
        do {
            System.out.println("Nhập địa chỉ Email");
            email = scanner.nextLine();
            if (!userCheck.emailValidate(email)) {
                System.err.println("Email không đúng định dạng không đúng Định dạng");
            }
        } while (!userCheck.emailValidate(email));
        return email;
    }

    private String creatPhoneNumber() {
        String phoneNum;
        do {
            System.out.println("Nhập số điện thoại");
            phoneNum = scanner.nextLine();
            if (!userCheck.phoneNumValidate(phoneNum)) {
                System.err.println("Không đúng Định dạng số điện thoại");
            }
        } while (!userCheck.phoneNumValidate(phoneNum));
        return phoneNum;
    }

    private String inputPassWord() {
        String passWord;
        do {
            System.out.println("Nhập mật khẩu (6-12 ký tự)");
            passWord = scanner.nextLine();
            if (passWord.length() < 6) {
                System.err.println("Mật khẩu  phải có ít nhất 6 ký tự");
            } else if (passWord.length() > 12) {
                System.err.println("Mật khẩu chỉ được phép tối đa 12 ký tự");
            }

        } while (passWord.length() < 6 || passWord.length() > 12);
        return passWord;
    }

    private String inputUserName() {
        String userName;
        do {
            System.out.println("Nhập tên tài khoản (6-12 ký tự)");
            userName = scanner.nextLine();
            if (userName.length() < 6) {
                System.err.println("Tài khoản phải có ít nhất 6 ký tự");
            } else if (userName.length() > 12) {
                System.err.println("Tên tài khoản chỉ được phép tối đa 12 ký tự");
            } else if (userManagement.checkUserNameExist(userName)) {
                System.err.println("Tên tài khoản đăng ký này đã tồn tại!");
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        } while (userName.length() < 6 || userName.length() > 12 || userManagement.checkUserNameExist(userName));
        return userName;
    }
}
