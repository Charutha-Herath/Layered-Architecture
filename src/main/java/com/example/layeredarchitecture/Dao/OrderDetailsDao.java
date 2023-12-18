package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDetailsDao {

    boolean InsertAndUpdate(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails, PreparedStatement stm , Connection connection) throws SQLException, ClassNotFoundException;
}
