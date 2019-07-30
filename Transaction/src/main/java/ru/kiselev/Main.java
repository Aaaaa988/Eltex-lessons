package ru.kiselev;

import java.sql.*;

public class Main {

    public static final String User_name = "User";
    public static final String Password = "Pass";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;


        final String DB_URL = "jdbc:mysql://localhost:3306/transaction";

        long time1 = System.currentTimeMillis();
        try {
            connection = DriverManager.getConnection(DB_URL, User_name, Password);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM transactions WHERE id >= 0 ");
            for (int i = 0; i < 1000; i++) {
                statement.executeUpdate("INSERT INTO transactions VALUE("+ i +")");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        long time2 = System.currentTimeMillis();
        System.out.println("INSERT 1000 elements without transactions: " + (time2 - time1));

        try {
            connection = DriverManager.getConnection(DB_URL, User_name, Password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            for (int i = 1000; i < 2000; i++) {
                statement.executeUpdate("INSERT INTO transactions VALUE("+ i +")");
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
        time1 = System.currentTimeMillis();

        System.out.println("INSERT 1000 elements with transactions: " + (time1 - time2));
    }
}
