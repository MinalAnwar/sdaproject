package com.erp.entity;

import com.erp.dao.UserDao;

public class User {
    private String name;
    private String userName;
    private String password;
    private int userId;
    private String designation;
    private String address;
    private String email;
    private String phoneNumber;
    private int age;
    private String dateOfBirth;
    private String cnic;
    private String gender;

    public User()
    {}
    public User(String name, String userName, String password, int userId, String designation, String address, String email, String phoneNumber, int age, String dateOfBirth, String cnic, String gender) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.userId = userId;
        this.designation = designation;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.cnic = cnic;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //Getters


    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCnic() {
        return cnic;
    }

    public String getGender() {
        return gender;
    }

    public boolean updateProfile(int id,String name, String designation, String dateOfBirth, String email, String phoneNumber, String address,String cnic,int age) {
        UserDao updateData = new UserDao();
        return updateData.updateProfile(id,name,designation,dateOfBirth,email,phoneNumber,address,cnic,age);
    }

    public boolean changePassword(int id,String oldPassword, String newPassword, String confirmedPassword) {
        UserDao updateObj = new UserDao();
        return updateObj.changePassword(id,oldPassword,newPassword,confirmedPassword);
    }

    public boolean signup(String username, String password, String confrimPassword) {
        UserDao obj = new UserDao();
        return obj.signUp(username,password,confrimPassword);
    }


}
