package dao;

import entity.Type;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MyDBController;

public class TypeDAO {
    private MyDBController myDBController = new MyDBController();

    public void create(Type type) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry(String.format("INSERT INTO content_type (type) VALUES ('%s')", type.getType()));
            System.out.println("Type added.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            System.out.println("Can't add type");
        }
    }

    public void remove(Type type) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry("DELETE FROM content_type\nWHERE type_id=" + type.getId() + ";");
            System.out.println("Type deleted.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Type> getAll() {
        ArrayList<Type> mass = new ArrayList<Type>();
        try {
            this.myDBController.connect();
            ResultSet rs = this.myDBController.inquiryWithResult("select * from content_type");
            while (rs.next()) {
                mass.add(new Type(rs.getInt(1), rs.getString(2)));
            }
            this.myDBController.connect().close();
        }
        catch (Exception rs) {
            // empty catch block
        }
        return mass;
    }
}