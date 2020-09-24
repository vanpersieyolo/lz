package Service;

import Model.Car;

import java.sql.SQLException;
import java.util.List;

public interface ICarService {
    boolean add (Car car) throws SQLException;
    List<Car> selectAll() throws SQLException;
    boolean removeCar(int id) throws SQLException;
    boolean updateCar(Car car) throws SQLException;
    List<Car> findByAll(String text);
}
