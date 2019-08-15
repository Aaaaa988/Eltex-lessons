package ru.kiselev;

import org.jooq.DSLContext;

import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import ru.eltex.database.tables.Developers;
import ru.eltex.database.tables.Managers;
import ru.eltex.database.tables.records.DevelopersRecord;
import ru.eltex.database.tables.records.ManagersRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JOOQ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        Connection connection = null;
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
            properties.load(fis);
            connection = DriverManager.getConnection(properties.getProperty("db.host"),
                    properties.getProperty("db.login"),
                    properties.getProperty("db.password"));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);

        Result<DevelopersRecord> developers = context.selectFrom(Developers.DEVELOPERS).fetch();
        for (DevelopersRecord dev : developers) {
            System.out.println(dev.toString());
        }

        Result<ManagersRecord> managers = context.selectFrom(Managers.MANAGERS).fetch();
        for (ManagersRecord man : managers) {
            System.out.println(man.toString());
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
