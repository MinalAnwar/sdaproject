package com.erp.entity;

import com.erp.dao.EmployeeDao;
import com.erp.dao.InventoryDao;
import com.erp.dao.OrderDao;
import com.erp.dao.VendorDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Admin extends User {
    public Admin() {
        super();

    }

    public Admin(String name, String userName, String password, int userId, String designation, String address, String email, String phoneNumber, int age, String dateOfBirth, String cnic, String gender) {
        super(name, userName, password, userId, designation, address, email, phoneNumber, age, dateOfBirth, cnic, gender);
    }

    public boolean addEmplyee(Employee obj) {
        //got data from controller not send it to doa and
        // then add the employee in database
        EmployeeDao insertData = new EmployeeDao();
        boolean insertionCheck = insertData.addEmployeeDAO(obj);
        return insertionCheck;
    }
    public boolean addVendor(Vendor obj) {
        //got data from controller not send it to doa and
        // then add the employee in database
        VendorDao insertData = new VendorDao();
        boolean insertionCheck = insertData.addVendor(obj);
        return insertionCheck;
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
    public boolean updateOrder(String oldOrderNumber,Order obj)
    {
        OrderDao dataUpdate=new OrderDao();
        return dataUpdate.updateOrder(oldOrderNumber,obj);
    }

    public boolean deleteEmployee(int id) {
        EmployeeDao deleteData = new EmployeeDao();
        boolean deletionCheck = deleteData.deleteEmployee(id);
        return deletionCheck;
    }

    public boolean deleteInventory(int id, String status) {
        //got data from controller not send it to doa and
        // then add the employee in database
        boolean insertionCheck = false;
        if (status.equalsIgnoreCase("rawmaterial")) {
            InventoryDao deleteData = new InventoryDao();
            insertionCheck = deleteData.deleteRowMaterial(id);
        } else if (status.equalsIgnoreCase("product")) {
            InventoryDao deleteData = new InventoryDao();
            insertionCheck = deleteData.deleteProductDao(id);

        }
        return insertionCheck;
    }

    public boolean deleteOrder(String orderNumber)
    {
        boolean insertionCheck = false;
        OrderDao deleteData =new OrderDao();
        insertionCheck = deleteData.deleteOrder(orderNumber);
        return insertionCheck;
    }



    public ResultSet viewOrder() throws SQLException {
        OrderDao obj = new OrderDao();
        return obj.viewAllOrders();
    }

    public ResultSet viewEmployee() throws SQLException {
        EmployeeDao obj = new EmployeeDao();
        return obj.viewAllEmployees();
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

    public ResultSet viewVendors() throws SQLException {
        VendorDao obj =new VendorDao();
        return obj.viewAllVendors();
    }


    public boolean updateVendor(int oldID, Vendor obj) {
        VendorDao updateData = new VendorDao();
        return updateData.updateVendor(oldID,obj);
    }

    public boolean addOrder(Order obj) {
        OrderDao dataInsert = new OrderDao();
        return dataInsert.addOrder(obj);
    }
}
