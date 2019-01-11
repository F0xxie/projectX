package servlets;

import dao.HibernateUserDAO;
import dao.JdbcUserDAO;
import dao.TagDAO;
import dao.UserDAO;
import entity.Tag;
import entity.User;
import utils.DBService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowTags extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TagDAO tagDAO = new TagDAO();
        DBService dbService = new DBService();
        ArrayList<Tag> tags = dbService.getTag();
        Integer id_to_delete = -1;

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/tags.jsp");

        request.setAttribute("tags", tags);

        String tagId = request.getParameter("tagId");
        dispatcher.forward(request, response);
        String[] tagIdS = new String[] { tagId };

        tagDAO.remove(new Tag(Integer.parseInt(tagId),""));
    }
}