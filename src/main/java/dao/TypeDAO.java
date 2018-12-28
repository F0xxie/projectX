package dao;

import entity.Type;
import java.util.ArrayList;

public interface TypeDAO {
    void create(Type type);
    void remove(Type type);
    ArrayList<Type> getAll();
}