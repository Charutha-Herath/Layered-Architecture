package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDao {
    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException ;

    public void deleteItem(String code) throws SQLException, ClassNotFoundException;

    public boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public void updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;

    public String generateNewId() throws SQLException, ClassNotFoundException;

    public ItemDTO getInfo(String newItemCode) throws SQLException, ClassNotFoundException;

    public ResultSet loadAllItemCodes() throws SQLException, ClassNotFoundException;

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;

    PreparedStatement UpdateOrder(Connection connection, ItemDTO item) throws SQLException;
}
