package servlets;

import dao.JdbcUserDAO;
import dao.UserDAO;
import entity.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDAO userDAO = new JdbcUserDAO();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/add_user.jsp");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        dispatcher.forward(request, response);

        if(nickname != null){
            userDAO.create(new User(0, nickname, password));
        }
    }
}