package utils;

import dao.*;
import entity.*;
import java.util.ArrayList;

//TODO переписать этот говнокод когда-нибудь
public class DBService {
    private UserDAO userDAO = new HibernateUserDAO();
    private TypeDAO typeDAO = new HibernateTypeDAO();

    public void addUser(String[] args){ userDAO.create(new User(0,args[1],args[2])); }
    public void removeUser(String[] args){ userDAO.remove(new User(Integer.parseInt(args[1]),"","")); }
    public ArrayList<User> getUsers() { return userDAO.getAll(); }

    public void addType(String[] args){ typeDAO.create(new Type(0,args[1])); }
    public void removeType(String[] args){ typeDAO.remove(new Type(Integer.parseInt(args[1]),"")); }
    public ArrayList<Type> getType() { return typeDAO.getAll(); }
}