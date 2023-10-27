package week2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String url = "jdbc:postgresql://localhost:5433/newNeobis";
    private static final String login = "postgres";
    private static final String password = "postgres";
    public static Connection connection(){
        Connection connect = null;
        try {connect = DriverManager.getConnection(url, login, password);
            System.out.println("Connected to PostgreSQL server succesfully!");

        }catch (SQLException e){
            e.printStackTrace();

        }

        return connect;
    }
}
