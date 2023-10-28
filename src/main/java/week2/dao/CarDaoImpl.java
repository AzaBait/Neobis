package week2.dao;

import week2.model.Car;

import week2.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao{
    public CarDaoImpl() {
    }

    @Override
    public void createCarsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cars (\n" +
                "id BIGSERIAL PRIMARY KEY NOT NULL,\n" +
                "\tname VARCHAR(90) NOT NULL,\n" +
                "\tmodel VARCHAR(90) NOT NULL,\n" +
                "\tyear INT NOT NULL,\n" +
                "\tprice FLOAT NOT NULL);";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table cars created!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void dropCarsTable() throws SQLException {
        String sql = "DROP TABLE cars;";
        try(Connection connection = Util.connection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveCar(String name, String model, int year, double price) throws SQLException {
        String sql = "INSERT INTO cars(name, model, year, price) VALUES(?, ?, ?, ?);";
        Long carId = null;
        try (Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, year);
            preparedStatement.setDouble(4, price);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                carId = resultSet.getLong("id");
                System.out.println("Car with ID " + carId + " saved!");
            }else {
                throw new SQLException("Save car failed!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCar(Long id, String name, String model, int year, double price) throws SQLException {
        String sql = "UPDATE cars SET name = ?, model = ?, year = ?, price = ? WHERE id = ?; ";
        try (Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, year);
            preparedStatement.setDouble(4, price);
            preparedStatement.executeUpdate();
            System.out.println("Car with ID " + id + " is updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCarById(Long id) throws SQLException {
        String sql = "DELETE FROM cars WHERE id = ?;";
        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Car with ID " + id + " is deleted");
        }
    }

    @Override
    public Car getCarById(Long id) throws SQLException {
        Car car = null;
        String sql = "SELECT FROM cars WHERE id = ?;";
        try(Connection connection = Util.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                car = new Car();
                car.setName(resultSet.getString("name"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                car.setPrice(resultSet.getDouble("price"));
                System.out.println(car);
            }throw new SQLException("Car with ID " + id + " not found!");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        String sql = "SELECT * FROM cars;";
        List<Car> cars = new ArrayList<>();
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Car car = new Car();
                car.setName(resultSet.getString("name"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                car.setPrice(resultSet.getDouble("price"));
                cars.add(car);
            }
            System.out.println(cars.size() + " cars found: " + cars);
        }
        return cars;
    }
}
