package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO extends CrudDAO<OrderDTO> {

    //public String genNewOrderId() throws SQLException, ClassNotFoundException;

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

    boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;

    //boolean saveOrderDto(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
