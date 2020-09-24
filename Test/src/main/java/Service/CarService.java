package Service;

import Model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarService implements ICarService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/SellCar?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "danganhvan";
//    private String jdbcPassword = "123456";
//    private String jdbcPassword = "djenha88";

    public CarService() {

    }

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public boolean add(Car car) throws SQLException {
        boolean check = false;
        String query = "{call insert_car(?,?,?,?)}";

        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, car.getCarName());
            callableStatement.setString(2, car.getCarImg());
            callableStatement.setString(3, car.getCarPrice());
            callableStatement.setString(4, car.getDescription());
            check = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }


    @Override
    public List<Car> selectAll() throws SQLException {
        Car car = null;
        String query = "{call select_all()}";
        List<Car> carList = new ArrayList<>();
        Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(query);
        ResultSet rs = callableStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("car_id");
            String name = rs.getString("car_name");
            String img = rs.getString("car_img");
            String price = rs.getString("car_price");
            String des = rs.getString("car_description");
            car = new Car(name, img, price, des, id);
            carList.add(car);
        }
        return carList;
    }

    @Override
    public boolean removeCar(int id) throws SQLException {
        boolean removeComplete = false;
        String query = "{call delete_car(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            removeComplete = callableStatement.executeUpdate() > 0;
        }
        return removeComplete;
    }

    @Override
    public boolean updateCar(Car car) throws SQLException {
        boolean updateComplete;
        String query ="{call update_car(?,?,?,?,?)}";
        try(Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, car.getId());
            callableStatement.setString(2, car.getCarName());
            callableStatement.setString(3, car.getCarImg());
            callableStatement.setString(4, car.getCarPrice());
            callableStatement.setString(5, car.getDescription());
            return false;
        }
    }


    @Override
    public List<Car> findByAll(String text) {
        return null;
    }
}
