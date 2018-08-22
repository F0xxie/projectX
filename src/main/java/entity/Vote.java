package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="content_type")
public class Vote {
    @Column(name="user_id")
    private int user_id;
    @Column(name="content_id")
    private int content_id;

    protected Vote() {
    }

    public Vote(int uid, int cid) {
        this.user_id = uid;
        this.content_id = cid;
    }

    public int getUserId() {
        return this.user_id;
    }

    public int getContentId() {
        return this.content_id;
    }
}