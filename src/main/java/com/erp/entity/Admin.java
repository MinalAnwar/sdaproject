package com.erp.entity;

import com.erp.dao.AddEmployeeDao;
import com.erp.entity.Employee;
public class Admin extends User{
    public Admin()
    {
        super();

    }
    public Admin(String name, String userName, String password, int userId, String designation, String address, String email, String phoneNumber, int age, String dateOfBirth, String cnic, String gender) {
        super(name, userName, password, userId, designation, address, email, phoneNumber, age, dateOfBirth, cnic, gender);
    }
    public boolean addEmplyee(Employee obj)
    {
        //got data from controller not send it to doa and
        // then add the employee in database
        AddEmployeeDao insertData = new AddEmployeeDao();
        boolean insertionCheck = insertData.addEmployeeDAO(obj);
        return insertionCheck;
    }
}
