package com.erp.entity;

import com.erp.dao.InventoryDao;
import com.erp.dao.ManagerDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Manager extends User {
    public Manager() {
        super();
    }

    public Manager(String name, String userName, String password, int userId, String designation, String address, String email, String phoneNumber, int age, String dateOfBirth, String cnic, String gender) {
        super(name, userName, password, userId, designation, address, email, phoneNumber, age, dateOfBirth, cnic, gender);
    }

    public boolean addInventory(Inventory obj, String status) {
        //got data from controller not send it to doa and
        // then add the employee in database
        boolean insertionCheck = false;
        if (status.equalsIgnoreCase("rawmaterial")) {
            List<RawMaterial> rawMaterials = obj.getRawMaterials(); //get the list from inventory
            // Get the last added raw material
            RawMaterial lastAddedRawMaterial = rawMaterials.get(rawMaterials.size() - 1); // get last obj of raw material added
            InventoryDao insertData = new InventoryDao();
            insertionCheck = insertData.addRawMaterialDAO(lastAddedRawMaterial);
        } else if (status.equalsIgnoreCase("product")) {
            List<Product> products = obj.getProducts(); //get the list from inventory
            // Get the last added raw material
            Product lastAddedProduct = products.get(products.size() - 1); // get last obj of raw material added
            InventoryDao insertData = new InventoryDao();
            insertionCheck = insertData.addProductDAO(lastAddedProduct);

        }

        return insertionCheck;
    }

    public boolean updateInventory(int oldId,Inventory obj,String status)
    {
        boolean insertionCheck = false;
        if (status.equalsIgnoreCase("rawmaterial")) {
            List<RawMaterial> rawMaterials = obj.getRawMaterials(); //get the list from inventory
            // Get the last added raw material
            RawMaterial lastAddedRawMaterial = rawMaterials.get(rawMaterials.size() - 1); // get last obj of raw material added
            InventoryDao insertData = new InventoryDao();
            insertionCheck = insertData.updateRawMaterial(oldId,lastAddedRawMaterial);
        } else if (status.equalsIgnoreCase("product")) {
            List<Product> products = obj.getProducts(); //get the list from inventory
            // Get the last added raw material
            Product lastAddedProduct = products.get(products.size() - 1); // get last obj of raw material added
            InventoryDao insertData = new InventoryDao();
            insertionCheck = insertData.updateProduct(oldId,lastAddedProduct);
        }

        return insertionCheck;

    }

    public ResultSet viewInventory(String status) throws SQLException {
        ResultSet result = null;
        if (status.equalsIgnoreCase("rawmaterial")) {
            InventoryDao viewData = new InventoryDao();
            result =  viewData.viewAllMaterial();
        } else if (status.equalsIgnoreCase("product")) {
            InventoryDao viewData = new InventoryDao();
            result =viewData.viewAllProduct();
        }
        return result;
    }


    public boolean addQuotation(String email, Quotations obj) {
        ManagerDao insertion = new ManagerDao();
        return insertion.addQuotations(email,obj);
    }


    public boolean deleteRating(int empid, int managerId) {
        ManagerDao deleteData= new ManagerDao();
        return deleteData.deleteRating(empid,managerId);
    }
}
