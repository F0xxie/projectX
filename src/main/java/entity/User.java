package entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int user_id;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;

    protected User() {
    }

    public User(int id, String l, String p) {
        this.user_id = id;
        this.login = l;
        this.password = p;
    }

    public int getId() {
        return this.user_id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }
}