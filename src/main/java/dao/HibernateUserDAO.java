package dao;

import entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
            //employee.setSalary(salary);
            userID = (Integer) session.save(userE);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        //return userID;
    }

    @Override
    public void remove(User user) {
    }

    @Override
    public ArrayList<User> getAll() {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM users").list();
            for (Iterator iterator = users.iterator(); iterator.hasNext();){
                User employee = (User) iterator.next();
                System.out.print("L: " + employee.getLogin());
                System.out.print("P: " + employee.getPassword());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
