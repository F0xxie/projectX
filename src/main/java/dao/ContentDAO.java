package dao;

import entity.Content;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MyDBController;

public class ContentDAO {
    private MyDBController myDBController = new MyDBController();

    public void create(Content content) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry(String.format("INSERT INTO content (author_id, type, parent_content_id, date, title, content_body) VALUES ('%s','%s','%s','%s','%s','%s')", content.getAuthorId(), content.getType(), content.getParentContentId(), content.getDate(), content.getTitle(), content.getContentBody()));
            System.out.println("Content added.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            System.out.println("Can't add content");
        }
    }

    public void remove(Content content) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry("DELETE FROM content\nWHERE user_id=" + content.getContentId() + ";");
            System.out.println("Content deleted.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Content> getAll() {
        ArrayList<Content> mass = new ArrayList<Content>();
        try {
            this.myDBController.connect();
            ResultSet rs = this.myDBController.inquiryWithResult("select * from content");
            while (rs.next()) {
                mass.add(new Content(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
            this.myDBController.connect().close();
        }
        catch (Exception rs) {
            // empty catch block
        }
        return mass;
    }
}