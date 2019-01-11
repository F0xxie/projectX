package servlets;

import dao.HibernateUserDAO;
import dao.JdbcUserDAO;
import dao.UserDAO;
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
        UserDAO userDAO = new HibernateUserDAO();
        DBService dbService = new DBService();
        ArrayList<User> users = dbService.getUsers();
        Integer id_to_delete = -1;

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/users.jsp");

        request.setAttribute("users", users);

//        String userId = request.getParameter("userId");
//        dispatcher.forward(request, response);
//
//        userDAO.remove(new User(Integer.parseInt(userId),"",""));
    }
}