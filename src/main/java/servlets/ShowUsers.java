package servlets;

import entity.User;
import utils.DBService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUsers extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DBService dbService = new DBService();
        ArrayList<User> users = dbService.getUsers();

        request.setAttribute("users", users);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/users.jsp");
        dispatcher.forward(request, response);
    }
}