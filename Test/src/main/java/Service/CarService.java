package Service;

import Model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class CarService implements ICarService{
    private String jdbcURL = "jdbc:mysql://localhost:3306/sellcar?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_USERS_SQL = "INSERT INTO car" + "  (car_Name,car_Img,car_Price,car_Description) VALUES " +" (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from car where id =" + "?;";
    private static final String SELECT_ALL_USERS = "select * from car";
    private static final String DELETE_USERS_SQL = "delete from car where id = ?;";
    private static final String UPDATE_USERS_SQL = "update car set car_Name = ?,car_Img= ?, car_Price =?,car_Description where id = " + "?;";
    private static final String SELECT_USERS_ORDER_NAME = "select * from car order by car_Name ;";
    public CarService (){

    }

    protected Connection connection () throws SQLException {
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
    public Car add(Car car) throws SQLException {
        return null;
    }

    @Override
    public List<Car> selectAll() {
        return null;
    }

    @Override
    public boolean RemoveCar() throws SQLException {
        return false;
    }

    @Override
    public boolean UpdateCar() throws SQLException {
        return false;
    }

    @Override
    public Car CarFindAll(String text) {
        return null;
    }
}
