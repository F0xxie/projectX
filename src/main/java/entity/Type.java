package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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

    @Column(name = "type", columnDefinition = "text")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Type() {
    }
    public Type(int anInt, String string) {
        type_id = anInt;
        type = string;
    }
}