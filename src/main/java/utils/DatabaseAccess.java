package utils;

import dao.UserDAO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class DatabaseAccess extends HttpServlet {
    private MyDBController myDBController = new MyDBController();
    private DBService dbService = new DBService();
    private UserDAO userDAO = new UserDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String tableName = "Users:";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
        out.println(docType + "<html>\n" +
                "<head><style>table, th, td {\n" +
                "    border: 1px solid black;\n" +
                "}\n" +
                "</style>\n" +
                "<title>\n" +
                title +
                "</title>\n" +
                "</head>\n" +
                "<body bgcolor = #f0f0f0\n" +
                "<h1 align = center> " + tableName +"</h1>");
        out.print(" <table>\n" +
                "  <tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>Login</th>\n" +
                "    <th>Password</th>\n" +
                "  </tr>\n");
        ArrayList<User> mass;
        mass = dbService.getUsers();
        for (User user : mass) {
            out.print("  <tr>\n" +
                    "    <td>" + user.getId() + "</td>\n" +
                    "    <td>" + user.getLogin() + "</td>\n" +
                    "    <td>" + user.getPassword() + "</td>\n" +
                    "  </tr>\n");
        }
        out.print("</table><br/><br/>");
        //trying to implement AddUser, doesn't fucking work, only the form with ghost button appear
            //a bit of working code:
            /*
            String b_name = request.getParameter("b_name");
            String b_pass = request.getParameter("b_pass");
            if (b_name != "") {
                userDAO.create(new User(0, b_name, b_pass));
                b_name = ""; b_pass = "";
            }
            */

        //form:
        out.println("<form action = \"users\" method = \"GET\">\n" +
                "Name: <input type = \"text\" name = \"b_name\" placeholder=\"type name\">\n" +
                "<br/>\n" +
                "Pass: <input type = \"text\" name = \"b_pass\" placeholder=\"type pass\"/>\n");

        //submit button and script:
        out.println("<br/><button onclick=\"myFunction()\">Submit script</button>" +
                "<p id=\"demo\"></p><br/><script>\n" +
                "function myFunction() {\n" +
                "  document.getElementById(\"demo\").innerHTML = \"Added\";\n" +
                "}\n" +
                "</script>");

        out.println("<br/><p>request.getParameter(b_name): " + request.getParameter("b_name"));
        out.println("<br/><p>request.getParameter(b_pass): " + request.getParameter("b_pass"));
            String b_name = request.getParameter("b_name");
            String b_pass = request.getParameter("b_pass");
        out.println("<br/><p>String b_name: " + b_name);
        out.println("<br/><p>String b_pass: " + b_pass);
            if (b_name != "") {
                userDAO.create(new User(0, b_name, b_pass));
                b_name = ""; b_pass = "";
            }
        out.println("<br/><p>String b_name after userDAO.create: " + b_name);
        out.println("<br/><p>String b_pass after userDAO.create: " + b_pass);

        out.println("</body></html>");
        } finally {
            try { myDBController.statement.close(); } catch (Exception e) { /* ignored */ }
            try { myDBController.connection.close(); }catch (Exception e) { /* ignored */ }
        }
    }
}