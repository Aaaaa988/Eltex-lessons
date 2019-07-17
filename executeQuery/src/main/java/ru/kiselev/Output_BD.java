package ru.kiselev;

import java.sql.*;

public class Output_BD {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/users";

            Connection connection = DriverManager.getConnection(DB_URL, "root", "qwer1234"); //соединение с БД
            Statement statement = connection.createStatement();

        System.out.println("база данных users");
        System.out.println("имеет две таблицы developer и manager");
        System.out.println("developer:");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM developer"); // получение записей

            while(resultSet.next()) { // проход по полученным записям
                String id = resultSet.getString("id"); // получение значений полей
                String fio = resultSet.getString("fio"); // получение значений полей
                String phone = resultSet.getString("phone"); // получение значений полей
                System.out.println(id + " " + fio + " " +phone);
            }

        System.out.println("\nmanager:");

        resultSet = statement.executeQuery("SELECT * FROM manager"); // получение записей

        while(resultSet.next()) { // проход по полученным записям
            String id = resultSet.getString("id"); // получение значений полей
            String fio = resultSet.getString("fio"); // получение значений полей
            String phone = resultSet.getString("phone"); // получение значений полей
            System.out.println(id + " " + fio + " " +phone);
        }
            connection.close(); // отключение от БД
    }
}
