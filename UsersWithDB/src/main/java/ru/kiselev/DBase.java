package ru.kiselev;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DBase {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            PropertiesLoad Pload = new PropertiesLoad(); //Загрузка свойст
            connection = DriverManager.getConnection(Pload.getHost(), Pload.getLogin(), Pload.getPassword());
            Statement statement = connection.createStatement();
            DataBaseJDBC Base = new DataBaseJDBC();
            connection = Base.CreateBase(connection, statement, Pload); // создание базы данных и таблиц
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            connection.commit(); /// сохранение изменений

            System.out.println("/-------------------Объекты----------------------------/");
            ArrayList<Developer> developers = new ArrayList<>();

            developers.add(new Developer(1,"Vova","+79237353242", Base.getLang(0,1)));
            developers.add(new Developer(2,"Misha","+79567351752", Base.getLang(4)));
            developers.add(new Developer(3,"Petya","+79963757256", Base.getLang(2,5)));
            developers.add(new Developer(4,"Ivan","+795268935777", Base.getLang(3)));

            for(int i = 0; i<developers.size(); i++){
                System.out.println(developers.get(i).toString());
                developers.get(i).toDataBase(statement);
            }

            System.out.println();
            ArrayList<Manager> managers = new ArrayList<>();
            Sale sale = new Sale();

            managers.add(new Manager(1,"Sasha","+787578576543",
                    sale.packageSale("Keyboard", 1300, "Optical Mouse", 899)));
            managers.add(new Manager(2,"Egor","+78754753264",
                    sale.packageSale("Keyboard", 1300, "Laptop", 13899)));
            managers.add(new Manager(3,"Oleg","+788754351125",
                    sale.packageSale("Keyboard", 19000)));
            managers.add(new Manager(4,"Alexey","+798459842755",
                    sale.packageSale("Git", 77777))); //Hi Pydov!

            for(int i = 0; i<managers.size(); i++){
                System.out.println(managers.get(i).toString());
                managers.get(i).toDataBase(statement);
            }

            connection.commit();

            System.out.println("/-----------------База_Данных--------------------------/");
            OutPutDB outPutDB = new OutPutDB();
            outPutDB.outPutAllTablets(connection);
            System.out.println("/------------------Union-------------------------------/");
            outPutDB.outPutDeveloperUnionManager(connection, statement);

            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
