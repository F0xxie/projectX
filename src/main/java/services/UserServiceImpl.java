package services;

import dao.UserDAO;
import entity.User;

import javax.transaction.Transactional;
import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public void create(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void create(User u) {
        this.userDAO.create(u);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.userDAO.remove(id);
    }

    @Override
    @Transactional
    public ArrayList<User> getAll() {
        return this.userDAO.getAll();
    }
}
