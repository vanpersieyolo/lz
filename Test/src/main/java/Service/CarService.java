package Service;

import Model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarService implements ICarService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/SellCar?useSSL=false";
    private String jdbcUsername = "root";
//    private String jdbcPassword = "djenha88";
        private String jdbcPassword = "123456";
//    private static final String INSERT_USERS_SQL = "INSERT INTO car" + "  (car_Name,car_Img,car_Price,car_Description) VALUES " + " (?, ?, ?, ?);";
//    private static final String SELECT_USER_BY_ID = "select * from car where id =" + "?;";
//    private static final String SELECT_ALL_USERS = "select * from car";
//    private static final String DELETE_USERS_SQL = "delete from car where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update car set car_Name = ?,car_Img= ?, car_Price =?,car_Description where id = " + "?;";
//    private static final String SELECT_USERS_ORDER_NAME = "select * from car order by car_Name ;";

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
<<<<<<< HEAD
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
=======
        return false;
>>>>>>> 387c7d0cd755a063548c2f5a306cdd720370a4ec
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
<<<<<<< HEAD
        boolean removeComplete = false;
=======
        boolean removeComplete;
>>>>>>> a07c12bcadd1360eb76224b9d2bf00cfddd9016f
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

<<<<<<< HEAD
        return false;
    }

    public void check() {

=======
            updateComplete = callableStatement.executeUpdate()>0;
        }
        return updateComplete;
>>>>>>> a07c12bcadd1360eb76224b9d2bf00cfddd9016f
    }

    @Override
    public Car findByAll(String text) {
        return null;
    }
}
