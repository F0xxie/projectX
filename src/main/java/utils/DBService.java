package utils;

import dao.*;
import entity.*;
import java.util.ArrayList;

public class DBService {
    private UserDAO userDAO = new HibernateUserDAO();
    private ContentDAO contentDAO = new HibernateContentDAO();
    private TagDAO tagDAO = new TagDAO();

    public void addUser(String[] args){
        userDAO.create(new User(0,args[1],args[2]));
    }
    public void removeUser(String[] args){
        userDAO.remove(new User(Integer.parseInt(args[1]),"",""));
    }
    public ArrayList<User> getUsers() {
        return userDAO.getAll();
    }

    public void addContent(String[] args){
        contentDAO.create(new Content(0,args[1]));
    }
    public void removeContent(String[] args){
        contentDAO.remove(new Content(Integer.parseInt(args[1]),""));
    }
    public ArrayList<Content> getContent() {
        return contentDAO.getAll();
    }

    public void addTag(String[] args){
        tagDAO.create(new Tag(0,args[1]));
    }
    public void removeTag(String[] args){
        tagDAO.remove(new Tag(Integer.parseInt(args[1]),""));
    }
    public ArrayList<Tag> getTag() {
        return tagDAO.getAll();
    }
}