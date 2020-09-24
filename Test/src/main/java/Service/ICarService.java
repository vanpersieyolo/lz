package Service;

import Model.Car;

import java.sql.SQLException;
import java.util.List;

public interface ICarService {
    Car add (Car car) throws SQLException;
    List<Car> selectAll();
    boolean removeCar(int id) throws SQLException;
    boolean updateCar(Car car) throws SQLException;
    Car findByAll(String text);
}
