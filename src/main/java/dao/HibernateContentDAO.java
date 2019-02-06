package dao;

import entity.Content;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class HibernateContentDAO implements ContentDAO {
    @Override
    public void create(Content type) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        Integer typeID = null;

        try {
            tx = session.beginTransaction();
            Content typeE = new Content();
            typeE.setContent(type.getContent());
            typeID = (Integer) session.save(typeE);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(Content type) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Content typeE = new Content();
            typeE.setId(type.getId());
            session.delete(typeE);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public ArrayList<Content> getAll() {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        ArrayList<Content> types = new ArrayList<Content>();

        try {
            tx = session.beginTransaction();
            types = new ArrayList(session.createQuery("FROM entity.Content").list());
            for (Iterator iterator = types.iterator(); iterator.hasNext();){
                Content type = (Content) iterator.next();
                System.out.print(type.getId() + ": " + type.getContent() + "\n");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return types;
    }
}
