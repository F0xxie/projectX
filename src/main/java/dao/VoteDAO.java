package dao;

import entity.Vote;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MyDBController;

public class VoteDAO {
    private MyDBController myDBController = new MyDBController();

    public void create(Vote vote) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry(String.format("INSERT INTO votes (user_id, content_id) VALUES ('%s','%s')", vote.getUserId(), vote.getContentId()));
            System.out.println("Vote added.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            System.out.println("Can't add vote");
        }
    }

    public void remove(Vote vote) {
        try {
            this.myDBController.connect();
            this.myDBController.inquiry("DELETE FROM votes\nWHERE user_id=" + vote.getUserId() + " AND content_id=" + vote.getContentId() + ";");
            System.out.println("Vote deleted.");
            this.myDBController.connect().close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Vote> getAll() {
        ArrayList<Vote> mass = new ArrayList<Vote>();
        try {
            this.myDBController.connect();
            ResultSet rs = this.myDBController.inquiryWithResult("select * from votes");
            while (rs.next()) {
                mass.add(new Vote(rs.getInt(1), rs.getInt(2)));
            }
            this.myDBController.connect().close();
        }
        catch (Exception rs) {
            // empty catch block
        }
        return mass;
    }
}