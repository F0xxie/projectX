package servlets;

import dao.ContentTagDAO;
import dao.HibernateUserDAO;
import dao.JdbcUserDAO;
import dao.UserDAO;
import entity.ContentTag;
import entity.User;
import utils.DBService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowContentTags extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ContentTagDAO contentTagDAO = new ContentTagDAO();
        DBService dbService = new DBService();
        ArrayList<ContentTag> contentTags = contentTagDAO.getAll();
        Integer id_to_delete = -1;

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/contentTags.jsp");

        request.setAttribute("content_tags", contentTags);

        //String userId = request.getParameter("userId");
        dispatcher.forward(request, response);

        //userDAO.remove(new User(Integer.parseInt(userId),"",""));
    }
}