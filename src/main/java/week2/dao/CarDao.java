package week2.dao;

import week2.model.Car;
import week2.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    void createCarsTable() throws SQLException;
    void dropCarsTable() throws SQLException;
    void saveCar(String name, String model, int year, double price) throws SQLException;
    void updateCar(Long id, String name, String model, int year, double price) throws SQLException;
    void deleteCarById(Long id) throws SQLException;
    Car getCarById(Long id) throws SQLException;
    List<Car> getAllCars() throws SQLException;
}
