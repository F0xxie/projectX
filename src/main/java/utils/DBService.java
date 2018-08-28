package utils;

import dao.*;
import entity.*;
import java.util.ArrayList;

//TODO убрать аргументы
public class DBService {
    private UserDAO userDAO = new UserDAO();
    private ContentDAO contentDAO = new ContentDAO();
    private TypeDAO typeDAO = new TypeDAO();
    private ImageDAO imageDAO = new ImageDAO();
    private VoteDAO voteDAO = new VoteDAO();

    public void addUser(String[] args){ userDAO.create(new User(0,args[1],args[2])); }
    public void removeUser(String[] args){ userDAO.remove(new User(Integer.parseInt(args[1]),"","")); }
    public ArrayList<User> getUsers() { return userDAO.getAll(); }

    public void addContent(String[] args){ contentDAO.create(new Content(0,Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]),Integer.parseInt(args[4]),args[5],args[6]));}
    public void removeContent(String[] args){ contentDAO.remove(new Content(Integer.parseInt(args[1]),0,0,0,0,"",""));}
    public ArrayList<Content> getContent() { return contentDAO.getAll(); }

    public void addType(String[] args){ typeDAO.create(new Type(0,args[1])); }
    public void removeType(String[] args){ typeDAO.remove(new Type(Integer.parseInt(args[1]),"")); }
    public ArrayList<Type> getType() { return typeDAO.getAll(); }

    public void addImage(String[] args){ imageDAO.create(new Image(Integer.parseInt(args[1]),args[2])); }
    public void removeImage(String[] args){ imageDAO.remove(new Image(Integer.parseInt(args[1]),"")); }
    public ArrayList<Image> getImage() { return imageDAO.getAll(); }

    public void addVote(String[] args){ voteDAO.create(new Vote(Integer.parseInt(args[1]),Integer.parseInt(args[2]))); }
    public void removeVote(String[] args){ voteDAO.remove(new Vote(Integer.parseInt(args[1]),Integer.parseInt(args[2]))); }
    public ArrayList<Vote> getVote() { return voteDAO.getAll(); }
}