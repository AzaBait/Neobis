package week2.dao;

import java.sql.SQLException;

public interface Car {
    void createCarsTable() throws SQLException;
    void dropCarsTable() throws SQLException;
}
