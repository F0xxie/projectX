package servlets;

import dao.ContentTagDAO;
import dao.JdbcUserDAO;
import dao.UserDAO;
import entity.ContentTag;
import entity.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddContentTag extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ContentTagDAO contentTagDAO = new ContentTagDAO();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/add_contentTag.jsp");
        String j_type_id = request.getParameter("j_type_id");
        String j_tag_id = request.getParameter("j_tag_id");
        dispatcher.forward(request, response);

        //todo: разобраться с добавлением джойна, голова в 7 утра не работает
        if(j_type_id != null){
            //contentTagDAO.create(new ContentTag(0, Integer.parseInt(j_type_id), Integer.parseInt(j_tag_id)));
        }
    }
}