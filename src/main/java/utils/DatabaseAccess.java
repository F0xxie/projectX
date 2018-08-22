package utils;

import entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseAccess extends HttpServlet {
    private DBService dbService = new DBService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String JDBC_DRIVER = "org.h2.Driver";
        String DB_URL = "jdbc:h2:file:E:/data/sample";
        String USER = "sa";
        String PASS = "";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
        out.println(docType + "<html>\n<head><title>" + title + "</title></head>\n<body bgcolor = \"#f0f0f0\">\n<h1 align = \"center\">" + title + "</h1>\n");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:file:E:/data/sample", "sa", "");
            Statement stmt = conn.createStatement();
            ArrayList<User> mass = this.dbService.getUsers();
            for (User user : mass) {
                out.print("ID: " + user.getId() + ", login: " + user.getId() + ", password: " + user.getPassword());
            }
            out.println("</body></html>");
            stmt.close();
            conn.close();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}