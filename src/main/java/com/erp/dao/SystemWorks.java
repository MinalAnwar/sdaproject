package com.erp.dao;

public class SystemWorks {
    public boolean checkCredentials(String email,String password)
    {
        AccountDao user = new AccountDao();
        return user.checkCredentials(email,password);
    }
    public String getDesignation(String email,String password)
    {
        AccountDao obj = new AccountDao();
        return obj.getDesignation(email,password);
    }
}
