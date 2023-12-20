package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDao extends CrudDAO<CustomerDTO> {
    //public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    //public boolean insertCustomerD(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    //public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    //public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    //public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    //public String generateNewId() throws SQLException, ClassNotFoundException;

    public CustomerDTO getDetails(Connection connection, String newValue) throws SQLException, ClassNotFoundException;

    public ResultSet loadAllCustomerIds() throws SQLException, ClassNotFoundException;

}
