package servlets;

import dao.ContentDAO;
import dao.HibernateContentDAO;
import dao.JdbcTypeDAO;
import entity.Content;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddContent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ContentDAO contentDAO= new HibernateContentDAO();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/add_post.jsp");

        String postbody = request.getParameter("postbody");
        dispatcher.forward(request, response);

        String final_pbody = postbody.replace("'", "`");
        if(final_pbody != null) {
            contentDAO.create(new Content(0, final_pbody));
        }
    }
}