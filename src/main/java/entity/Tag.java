package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tags")
public class Tag implements Serializable {
    private int tag_id;
    private String tag;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    public int getId() {
        return tag_id;
    }
    public void setId(int id) {
        this.tag_id = id;
    }

    @Column(name = "tag")
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

    public Tag() { }
    public Tag(int anInt, String string) {
        tag_id = anInt;
        tag = string;
    }
}