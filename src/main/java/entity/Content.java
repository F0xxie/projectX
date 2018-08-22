package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="content")
public class Content {
    @Id
    @Column(name="content_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int content_id;
    @Column(name="author_id")
    private int author_id;
    @Column(name="type")
    private int type;
    @Column(name="parent_content_id")
    private int parent_content_id;
    @Column(name="date")
    private int date;
    @Column(name="title")
    private String title;
    @Column(name="content_body")
    private String content_body;

    protected Content() {
    }

    public Content(int cid, int aid, int typ, int pcid, int d, String t, String b) {
        this.content_id = cid;
        this.author_id = aid;
        this.type = typ;
        this.parent_content_id = pcid;
        this.date = d;
        this.title = t;
        this.content_body = b;
    }

    public int getContentId() {
        return this.content_id;
    }

    public int getAuthorId() {
        return this.author_id;
    }

    public int getType() {
        return this.type;
    }

    public int getParentContentId() {
        return this.parent_content_id;
    }

    public int getDate() {
        return this.date;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContentBody() {
        return this.content_body;
    }
}