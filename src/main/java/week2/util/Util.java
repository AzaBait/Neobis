package week2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String url = "jdbc:postgresql://localhost:5433/neobis";
    private static final String login = "postgres";
    private static final String password = "postgres";
    public static Connection connection(){
        try (Connection connect = DriverManager.getConnection(url, login, password)){
            connect.setAutoCommit(false);
            System.out.println("Connected to PostgreSQL server succesfully!");
            return connect;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
