package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "content")
public class Content implements Serializable {
    private int id;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "content", columnDefinition = "clob")
    public String getContent() {
        return content;
    }
    public void setContent(String type) {
        this.content = type;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "post_tags",
            joinColumns = { @JoinColumn(name = "j_content_id") },
            inverseJoinColumns = { @JoinColumn(name = "j_tag_id") }
    )
    Set<Tag> tags = new HashSet<>();

    public Content() { }
    public Content(int anInt, String string) {
        id = anInt;
        content = string;
    }
}