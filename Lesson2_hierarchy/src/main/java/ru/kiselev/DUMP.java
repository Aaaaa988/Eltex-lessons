package ru.kiselev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class DUMP {
    public static String DB_URL = "jdbc:mysql://localhost:3306/users";

    public void Print_DB() throws SQLException, IOException {
        System.out.println("База Users:");
        Connection connection = DriverManager.getConnection(DB_URL, "root", "qwer1234"); //соединение с БД
        Statement statement = connection.createStatement();

        System.out.println("-Таблица Developer");
        System.out.println("id|   name    | phone| lang");
        statement.executeUpdate("DELETE FROM developer WHERE id >=0");
        Scanner inputFile = new Scanner(new FileInputStream("Developer.json"));
        while (inputFile.hasNextLine()) {
            Developer developer = new Developer();
            developer.readFromJSON(inputFile.nextLine());
            String namee = developer.getName();
            Integer phonee = developer.getPhone();
            String lang = developer.Langs_String();
            statement.executeUpdate("INSERT INTO developer (fio, phone, lang) VALUE('"+namee +"', ' "+ phonee +"', '" + lang +"')");
        }

        ResultSet resultSet = statement.executeQuery("SELECT * FROM developer");
        while(resultSet.next()) {
            String id = resultSet.getString("id");
            String fio = resultSet.getString("fio");
            String phone = resultSet.getString("phone");
            String lang = resultSet.getString("lang");
            System.out.println(id + " " + fio + " " +phone + "  " + lang);
        }


        System.out.println("\n-Таблица Manager");
        System.out.println("id|   name  | phone| sale");
        statement.executeUpdate("DELETE FROM manager WHERE id >=0");
        inputFile = new Scanner(new FileInputStream("Manager.json"));
        while (inputFile.hasNextLine()) {
            Manager manager = new Manager();
            manager.readFromJSON(inputFile.nextLine());
            String namee = manager.getName();
            Integer phonee = manager.getPhone();
            String sale = manager.Sale_String();
            statement.executeUpdate("INSERT INTO manager (fio, phone, sale) VALUE('"+namee +"', ' "+ phonee +"', '" + sale + "')");
        }

        resultSet = statement.executeQuery("SELECT * FROM manager");
        while(resultSet.next()) {
            String id = resultSet.getString("id");
            String fio = resultSet.getString("fio");
            String phone = resultSet.getString("phone");
            String sale = resultSet.getString("sale");
            System.out.println(id + " " + fio + " " + phone + "    " + sale);
        }

        connection.close();

    }
}
