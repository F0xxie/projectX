package utils;

import java.sql.*;

public class MyDBController {
    public Statement statement;
    public Connection connection;

    public Connection connect() {
        try {
            Class.forName("org.h2.Driver");
            //Create DB in E:/data/sample.mv.db
            //Connection connection = DriverManager.getConnection("jdbc:h2:file:~/data/sample;INIT=RUNSCRIPT FROM 'src/main/resources/init-base.ddl'","sa","");
            //Use DB from E:/data/sample.mv.db
            connection = DriverManager.getConnection("jdbc:h2:file:~/data/sample", "sa", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Can't connect to DB: " + e.toString());
        }
        return connection;
    }

    public ResultSet inquiryWithResult(String str) {
        try {
            ResultSet rs = statement.executeQuery(str);
            return rs;
        }
        catch (Exception e) {
            System.out.println("Can't handle inquiry: " + e.toString());
        }
        return null;
    }

    public void inquiry(String str) {
        try {
            statement.execute(str);
        }
        catch (Exception e) {
            System.out.println("Can't handle inquiry" + e.toString());
        }
    }
}
