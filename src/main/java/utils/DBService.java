package utils;

import dao.ContentDAO;
import dao.ImageDAO;
import dao.TypeDAO;
import dao.UserDAO;
import dao.VoteDAO;
import entity.Content;
import entity.Image;
import entity.Type;
import entity.User;
import entity.Vote;
import java.util.ArrayList;

public class DBService {
    private UserDAO userDAO = new UserDAO();
    private ContentDAO contentDAO = new ContentDAO();
    private TypeDAO typeDAO = new TypeDAO();
    private ImageDAO imageDAO = new ImageDAO();
    private VoteDAO voteDAO = new VoteDAO();

    public void addUser(String[] args) {
        this.userDAO.create(new User(0, args[1], args[2]));
    }

    public void removeUser(String[] args) {
        this.userDAO.remove(new User(Integer.parseInt(args[1]), "", ""));
    }

    public ArrayList<User> getUsers() {
        return this.userDAO.getAll();
    }

    public void addContent(String[] args) {
        this.contentDAO.create(new Content(0, Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), args[5], args[6]));
    }

    public void removeContent(String[] args) {
        this.contentDAO.remove(new Content(Integer.parseInt(args[1]), 0, 0, 0, 0, "", ""));
    }

    public ArrayList<Content> getContent() {
        return this.contentDAO.getAll();
    }

    public void addType(String[] args) {
        this.typeDAO.create(new Type(0, args[1]));
    }

    public void removeType(String[] args) {
        this.typeDAO.remove(new Type(Integer.parseInt(args[1]), ""));
    }

    public ArrayList<Type> getType() {
        return this.typeDAO.getAll();
    }

    public void addImage(String[] args) {
        this.imageDAO.create(new Image(Integer.parseInt(args[1]), args[2]));
    }

    public void removeImage(String[] args) {
        this.imageDAO.remove(new Image(Integer.parseInt(args[1]), ""));
    }

    public ArrayList<Image> getImage() {
        return this.imageDAO.getAll();
    }

    public void addVote(String[] args) {
        this.voteDAO.create(new Vote(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
    }

    public void removeVote(String[] args) {
        this.voteDAO.remove(new Vote(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
    }

    public ArrayList<Vote> getVote() {
        return this.voteDAO.getAll();
    }
}