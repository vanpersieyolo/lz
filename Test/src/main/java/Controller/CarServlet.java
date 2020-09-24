package Controller;

import Model.Car;
import Service.CarService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cars")
public class CarServlet extends HttpServlet {
    CarService carService = new CarService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "search":
                break;
            default:
                selectAll(request,response);
                break;
        }
    }

    protected  void selectAll(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Car> carList = carService.selectAll();
            request.setAttribute("carlist",carList);
            RequestDispatcher rq = request.getRequestDispatcher("/View/HomePage.jsp");
            rq.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
