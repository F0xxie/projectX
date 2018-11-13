package dao;

import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MyDBController;

public class JdbcUserDAO implements UserDAO {
    private MyDBController myDBController = new MyDBController();

    @Override
    public void create(User user) {
        try {
            Connection connect = this.myDBController.connect();
            this.myDBController.inquiry(String.format("INSERT INTO users (login, password) VALUES ('%s','%s')", user.getLogin(), user.getPassword()));
            System.out.println("Attempting to add user...");
            connect.close();
        }
        catch (Exception e) {
            System.out.println("Can't add user");
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) {
        try {
            Connection connect = this.myDBController.connect();
            this.myDBController.inquiry("DELETE FROM users\nWHERE user_id=" + user.getId() + ";");
            System.out.println("Attempting to delete user...");
            connect.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Connection connect = this.myDBController.connect();
            ResultSet rs = this.myDBController.inquiryWithResult("select * from users");
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            connect.close();
        }
        catch (Exception rs) {
            rs.printStackTrace();
        }
        return users;
    }
}