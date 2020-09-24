package Service;

import Model.Car;

import java.sql.SQLException;
import java.util.List;

public interface ICarService {
    boolean add (Car car) throws SQLException;
<<<<<<< HEAD
    List<Car> selectAll() throws SQLException;
=======
    List<Car> selectAll();
>>>>>>> 387c7d0cd755a063548c2f5a306cdd720370a4ec
    boolean removeCar(int id) throws SQLException;
    boolean updateCar(Car car) throws SQLException;
    Car findByAll(String text);
}
