package servlets;

import entity.Type;
import utils.DBService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowContent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DBService dbService = new DBService();
        //ArrayList<Type> posts = dbService.getType();

        //request.setAttribute("posts", posts);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(request, response);
    }
}