package com.codegym.controller;

import com.codegym.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagement implements WriteFile, ReadFile {
    List <User> users = new ArrayList<>();

    public UserManagement() {
        File file = new File("user.txt");
        if (file.exists()){
            try {
                readFile("user.txt");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayAll () {
        for (User user:users) {
            System.out.println(user);
        }
    }
    public void register (User user) {
        this.users.add(user);
        try {
            writeFile("user.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.users = (List<User>) ois.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.users);
    }
    public boolean checkUserNameExist (String userName){
        boolean isExist = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName)){
                isExist = true;
                break;
            }
        }
        return isExist;
    }
    public boolean checkLogin (String userName, String pasWord){
        boolean isLogin = false;
        for (int i = 0; i < users.size(); i++) {
            if (userName.equals(users.get(i).getUserName())&&pasWord.equals(users.get(i).getPassword())){
                isLogin = true;
                break;
            }
        }
        return isLogin;
    }
}