package dao;

import entity.User;
import java.util.ArrayList;

public interface UserDAO {
    void create(User user);

    void remove(User user);

    ArrayList<User> getAll();
}
