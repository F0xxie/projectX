package utils;

import dao.UserDAO;
import entity.User;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

@WebServlet("/showusers")
public class DatabaseAccess extends HttpServlet {
    private MyDBController myDBController = new MyDBController();
    private DBService dbService = new DBService();
    private UserDAO userDAO = new UserDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DBService dbService = new DBService();
        ArrayList<User> mass = dbService.getUsers();

        String s = "HelloWolrd";
        response.setContentType("text/jsp");
        request.setAttribute("s", s);
        request.setAttribute("users", mass);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/users.jsp");
        dispatcher.forward(request, response);
        //request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}