package dao;

import entity.Content;
import java.util.ArrayList;

public interface ContentDAO {
    void create(Content type);
    void remove(Content type);
    ArrayList<Content> getAll();
}