package com.example.model.pojo;

import com.example.model.dao.CategoryDAO;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        Category c = new Category("TONKA SERVLETA99", TransactionType.EXPENCE, "asdasd", "yes", 1, 1);

        try {
            CategoryDAO.insertCategory(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
