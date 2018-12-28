package dao;

import entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HibernateUserDAO implements UserDAO {

    @Override
    public void create(User user) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        Integer userID = null;

        try {
            tx = session.beginTransaction();
            User userE = new User();
            userE.setLogin(user.getLogin());
            userE.setPassword(user.getPassword());
            userID = (Integer) session.save(userE);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(User user) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User userE = new User();
            userE.setId(user.getId());
            session.delete(userE);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public ArrayList<User> getAll() {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        ArrayList<User> users = new ArrayList<User>();

        try {
            tx = session.beginTransaction();
            users = new ArrayList(session.createQuery("FROM entity.User").list());
            for (Iterator iterator = users.iterator(); iterator.hasNext();){
                User user = (User) iterator.next();
                System.out.print(user.getId() + ": " + user.getLogin() + "/" + user.getPassword() + "\n");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }
}
