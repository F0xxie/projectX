package entity;

import javax.persistence.*;

@Entity
@Table(name = "post_tags")
public class ContentTag {
    private int id;
    private int contentId;
    private int tagId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "j_type_id")
    public int getContentId() {
        return contentId;
    }
    public void setContentId(int typeId) {
        this.contentId = typeId;
    }

    @Column(name = "j_tag_id")
    public int getTagId() {
        return tagId;
    }
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
