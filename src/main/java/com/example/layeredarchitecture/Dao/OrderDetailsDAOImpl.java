package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailsDao {

    ItemDao itemDao = new ItemDAOImpl();


    @Override
    public boolean InsertAndUpdate(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails, PreparedStatement stm , Connection connection) throws SQLException, ClassNotFoundException {

        stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

        for (OrderDetailDTO detail : orderDetails) {
            stm.setString(1, orderId);
            stm.setString(2, detail.getItemCode());
            stm.setBigDecimal(3, detail.getUnitPrice());
            stm.setInt(4, detail.getQty());

            if (stm.executeUpdate() != 1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

//                //Search & Update Item
            ItemDTO item = itemDao.findItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            /*PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
            pstm.setString(1, item.getDescription());
            pstm.setBigDecimal(2, item.getUnitPrice());
            pstm.setInt(3, item.getQtyOnHand());
            pstm.setString(4, item.getCode());*/

            PreparedStatement pstm = itemDao.UpdateOrder(connection,item);

            if (!(pstm.executeUpdate() > 0)) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;


    }
}
