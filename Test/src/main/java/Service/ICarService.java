package Service;

import Model.Car;

import java.sql.SQLException;
import java.util.List;

public interface ICarService {
    Car add (Car car) throws SQLException;
    List<Car> selectAll();
    boolean RemoveCar(int id) throws SQLException;
    boolean UpdateCar(Car car) throws SQLException;
    Car CarFindAll(String text);
}
