package ru.kiselev;

import lombok.NoArgsConstructor;
import net.efabrika.util.DBTablePrinter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@NoArgsConstructor
public class OutPutDB {

    public void outPutAllTablets(Connection connection){
        System.out.println();
        DBTablePrinter.printTable(connection, "Developers");
        DBTablePrinter.printTable(connection, "Dev_and_Lang");
        DBTablePrinter.printTable(connection, "Langs");
        System.out.println();
        DBTablePrinter.printTable(connection, "Managers");
        DBTablePrinter.printTable(connection, "Man_and_Sale");
        DBTablePrinter.printTable(connection, "Sale");
        System.out.println();
    }

    public void outPutDeveloperUnionManager(Connection connection, Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Developers UNION SELECT * FROM Managers");
        DBTablePrinter.printResultSet(resultSet);
    }
}
