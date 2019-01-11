package servlets;

import dao.TagDAO;
import entity.Tag;
import utils.DBService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTag extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TagDAO tagDAO = new TagDAO();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/add_tag.jsp");
        String tag = request.getParameter("tag");
        dispatcher.forward(request, response);

        if(tag != null){
            tagDAO.create(new Tag(0, tag));
        }
    }
}