package commands;

import entity.*;
import java.util.ArrayList;
import utils.DBService;

public class Show extends Command {
    private DBService dbService = new DBService();

    @Override
    public void execute(String[] args) {
        try {
            if (args[0].equals("users")) {
                ArrayList<User> users;
                users = this.dbService.getUsers();
                System.out.println("Users:");
                for (User user : users) {
                    System.out.println("" + user.getId() + ": " + user.getLogin() + "/" + user.getPassword());
                }
            }
            if (args[0].equals("content")) {
                ArrayList<Content> contents;
                contents = this.dbService.getContent();
                System.out.println("Content:");
                for (Content content : contents) {
                    System.out.println("" + content.getContentId() + ": [Author: " + content.getAuthorId() + ", type: " + content.getType() + ", parent: " + content.getParentContentId() + "] Date: " + content.getDate() + " [" + content.getTitle() + " - " + content.getContentBody() + "]");
                }
            }
            if (args[0].equals("types")) {
                ArrayList<Type> types;
                types = this.dbService.getType();
                System.out.println("Content types:");
                for (Type type : types) {
                    System.out.println("" + type.getId() + ": " + type.getType());
                }
            }
            if (args[0].equals("images")) {
                ArrayList<Image> images;
                images = this.dbService.getImage();
                System.out.println("Content images:");
                for (Image image : images) {
                    System.out.println("" + image.getContentId() + ": " + image.getImageUrl());
                }
            }
            if (args[0].equals("votes")) {
                ArrayList<Vote> votes;
                votes = this.dbService.getVote();
                System.out.println("Votes:");
                for (Vote vote : votes) {
                    System.out.println("" + vote.getUserId() + " | " + vote.getContentId());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}