package services;

import entity.User;
import java.util.ArrayList;

public interface UserService {
    void create(User user);
    void remove(int id);
    ArrayList<User> getAll();
}