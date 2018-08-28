package utils;

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
                    "  </tr>\n" +
                    "</table> ");
        }
        out.println("</body></html>");
        } finally {
            try { myDBController.statement.close(); } catch (Exception e) { /* ignored */ }
            try { myDBController.connection.close(); }catch (Exception e) { /* ignored */ }
        }
    }
}