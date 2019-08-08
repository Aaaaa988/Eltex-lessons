package ru.kiselev;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@NoArgsConstructor
public class DataBaseJDBC {
    private String[] Langs = {"Java", "C++", "C#", "C", "Kotlin", "Erlang"};

    public Connection CreateBase(Connection connection, Statement statement, PropertiesLoad Pload) throws SQLException {
        Connection connect = connection;
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + Pload.getBaseName()); //создание БД

        connection.close();
        connect = DriverManager.getConnection(Pload.getHost() + Pload.getBaseName(), Pload.getLogin(), Pload.getPassword());
        statement = connect.createStatement();


        String SQL = "CREATE TABLE IF NOT EXISTS Developers " +
                "(id INTEGER (11) NOT NULL, " +
                " name VARCHAR(50) NOT NULL, " +
                " phone VARCHAR (12), " +
                " PRIMARY KEY (id))";
        statement.executeUpdate(SQL);

        SQL = "CREATE TABLE IF NOT EXISTS Dev_and_Lang " +
                "(id_dev INTEGER (11) NOT NULL, " +
                " id_lang INTEGER (11) NOT NULL, " +
                " PRIMARY KEY (id_dev, id_lang))";
        statement.executeUpdate(SQL);

        SQL = "CREATE TABLE IF NOT EXISTS Langs " +
                "(id_lang INTEGER (11) NOT NULL, " +
                " lang VARCHAR (10) NOT NULL, " +
                " PRIMARY KEY (id_lang))";
        statement.executeUpdate(SQL);

        for (int i = 0; i < Langs.length; i++) {
            statement.executeUpdate("INSERT IGNORE INTO Langs(id_lang, lang) VALUE('" + (i + 1) + "', '" + Langs[i] + "')");
        }

        SQL = "CREATE TABLE IF NOT EXISTS Managers " +
                "(id INTEGER (11) NOT NULL, " +
                " name VARCHAR(50) NOT NULL, " +
                " phone VARCHAR (12), " +
                " PRIMARY KEY (id))";
        statement.executeUpdate(SQL);

        SQL = "CREATE TABLE IF NOT EXISTS Man_and_Sale " +
                "(id_man INTEGER (11) NOT NULL, " +
                " id_sale INTEGER (11) NOT NULL, " +
                " PRIMARY KEY (id_man, id_sale))";
        statement.executeUpdate(SQL);

        SQL = "CREATE TABLE IF NOT EXISTS Sale " +
                "(id_sale INTEGER (11) NOT NULL AUTO_INCREMENT, " +
                " sale VARCHAR (20) NOT NULL, " +
                " cost INTEGER (10) NOT NULL, " +
                " PRIMARY KEY (id_sale), UNIQUE (sale,cost))";
        statement.executeUpdate(SQL);
        return connect;
    }


    public ArrayList<String> getLang(Integer index1){
        ArrayList<String> list = new ArrayList<>();
        list.add(Langs[index1]);
        return list;
    }

    public ArrayList<String> getLang(Integer index1, Integer index2){
        ArrayList<String> list = new ArrayList<>();
        list.add(Langs[index1]);
        list.add(Langs[index2]);
        return list;
    }
}
