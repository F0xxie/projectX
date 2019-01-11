package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "content_type")
public class Type implements Serializable {
    private int type_id;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    public int getId() {
        return type_id;
    }
    public void setId(int id) {
        this.type_id = id;
    }

    @Column(name = "type", columnDefinition = "clob")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "post_tags",
            joinColumns = { @JoinColumn(name = "j_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "j_tag_id") }
    )
    Set<Tag> tags = new HashSet<>();

    public Type() { }
    public Type(int anInt, String string) {
        type_id = anInt;
        type = string;
    }
}