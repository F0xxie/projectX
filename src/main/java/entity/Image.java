package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="content_type")
public class Image {
    @Column(name="content_id")
    private int content_id;
    @Column(name="image_url")
    private String image_url;

    protected Image() {
    }

    public Image(int cid, String url) {
        this.content_id = cid;
        this.image_url = url;
    }

    public int getContentId() {
        return this.content_id;
    }

    public String getImageUrl() {
        return this.image_url;
    }
}