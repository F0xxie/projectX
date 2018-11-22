package dao;

import entity.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MyDBController;

public class TypeDAO {
    private MyDBController myDBController = new MyDBController();

    public void create(Type type) {
        try {
            Connection connect = this.myDBController.connect();
            this.myDBController.inquiry(String.format("INSERT INTO content_type (type) VALUES ('%s')", type.getType()));
            connect.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Type type) {
        try {
            Connection connect = this.myDBController.connect();
            this.myDBController.inquiry("DELETE FROM content_type\nWHERE type_id=" + type.getId() + ";");
            connect.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Type> getAll() {
        ArrayList<Type> types = new ArrayList<Type>();
        try {
            Connection connect = this.myDBController.connect();
            ResultSet rs = this.myDBController.inquiryWithResult("select * from content_type");
            while (rs.next()) {
                //types.add(new Type(rs.getInt(1), rs.getString(2)));
            }
            connect.close();
        }
        catch (Exception rs) {
            rs.printStackTrace();
        }
        return types;
    }
}