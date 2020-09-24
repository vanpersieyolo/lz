package Service;

import Model.Car;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class CarService implements ICarService{
    private String jdbcURL = "jdbc:mysql://localhost:3306/sellcar?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "djenha88";
//    private String jdbcPassword = "123456";
    private static final String INSERT_USERS_SQL = "INSERT INTO car" + "  (car_Name,car_Img,car_Price,car_Description) VALUES " +" (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from car where id =" + "?;";
    private static final String SELECT_ALL_USERS = "select * from car";
    private static final String DELETE_USERS_SQL = "delete from car where id = ?;";
    private static final String UPDATE_USERS_SQL = "update car set car_Name = ?,car_Img= ?, car_Price =?,car_Description where id = " + "?;";
    private static final String SELECT_USERS_ORDER_NAME = "select * from car order by car_Name ;";
    public CarService (){

    }

    protected Connection getConnection () throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public boolean add(Car car) throws SQLException {
        return false;
    }

    @Override
    public List<Car> selectAll() {
        return null;
    }

    @Override
    public boolean removeCar(int id) throws SQLException {
        boolean removeComplete;
        String query = "{call delete_car(?)}";
        try(Connection connection = getConnection();
            CallableStatement callableStatement =connection.prepareCall(query)) {
            callableStatement.setInt(1,id);
            removeComplete = callableStatement.executeUpdate()>0;
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

            updateComplete = callableStatement.executeUpdate()>0;
        }
        return updateComplete;
    }

    @Override
    public Car findByAll(String text) {
        return null;
    }
}
