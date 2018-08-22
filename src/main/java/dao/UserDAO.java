package dao;

import entity.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MyDBController;

public class UserDAO {
    private MyDBController myDBController = new MyDBController();

    public void create(User user) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry(String.format("INSERT INTO users (login, password) VALUES ('%s','%s')", user.getLogin(), user.getPassword()));
            System.out.println("User added.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            System.out.println("Can't add user");
        }
    }

    public void remove(User user) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry("DELETE FROM users\nWHERE user_id=" + user.getId() + ";");
            System.out.println("User deleted.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAll() {
        ArrayList<User> mass = new ArrayList<User>();
        try {
            this.myDBController.connect();
            ResultSet rs = this.myDBController.inquiryWithResult("select * from users");
            while (rs.next()) {
                mass.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            this.myDBController.connect().close();
        }
        catch (Exception rs) {
            // empty catch block
        }
        return mass;
    }
}