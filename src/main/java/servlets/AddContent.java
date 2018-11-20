package servlets;

import dao.TypeDAO;
import entity.Type;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddContent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TypeDAO typeDAO = new TypeDAO();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/add_post.jsp");

        String postbody = request.getParameter("postbody");
        dispatcher.forward(request, response);

        String final_pbody = postbody.replace("'", "`");
        typeDAO.create(new Type(0, final_pbody));
    }
}