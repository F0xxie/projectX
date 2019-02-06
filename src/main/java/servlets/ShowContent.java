package servlets;

import dao.ContentTagDAO;
import entity.Content;
import entity.ContentTag;
import entity.Tag;
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
        ContentTagDAO contentTag = new ContentTagDAO();

        ArrayList<Content> posts = dbService.getContent();
        ArrayList<ContentTag> tags = contentTag.getAll();

        //request.setAttribute("posts", posts);
        //request.setAttribute("tags", tags);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(request, response);
    }
}