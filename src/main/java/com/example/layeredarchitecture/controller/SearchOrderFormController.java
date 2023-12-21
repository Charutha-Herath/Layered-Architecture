package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.Dao.SQLUtil;
import com.example.layeredarchitecture.view.tdm.searchTM;
import javafx.event.ActionEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchOrderFormController {

    public void BtnSearchOrderOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT customer.id, customer.name, customer.address, orders.oid, orders.date, orderdetails.itemCode, orderdetails.qty, orderdetails.unitPrice\n" +
                "FROM customer\n" +
                "INNER JOIN orders ON customer.id = orders.customerID\n" +
                "INNER JOIN orderdetails ON orders.oid = orderdetails.oid;");

        while (rst.next()){
            System.out.println(new searchTM(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("oid"),
                    rst.getDate("date").toLocalDate(),
                    rst.getString("itemCode"),
                    rst.getInt("qty"),
                    rst.getDouble("unitPrice")
            ));


        }
    }
}
