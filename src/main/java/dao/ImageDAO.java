package dao;

import entity.Image;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MyDBController;

public class ImageDAO {
    private MyDBController myDBController = new MyDBController();

    public void create(Image image) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry(String.format("INSERT INTO content_image (content_id, image_url) VALUES ('%s','%s')", image.getContentId(), image.getImageUrl()));
            System.out.println("Image added.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            System.out.println("Can't add image");
        }
    }

    public void remove(Image image) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry("DELETE FROM content_image\nWHERE content_id=" + image.getContentId() + ";");
            System.out.println("Image deleted.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Image> getAll() {
        ArrayList<Image> mass = new ArrayList<Image>();
        try {
            this.myDBController.connect();
            ResultSet rs = this.myDBController.inquiryWithResult("select * from content_image");
            while (rs.next()) {
                mass.add(new Image(rs.getInt(1), rs.getString(2)));
            }
            this.myDBController.connect().close();
        }
        catch (Exception rs) {
            // empty catch block
        }
        return mass;
    }
}