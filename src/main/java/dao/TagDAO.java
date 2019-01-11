package dao;

import entity.Tag;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class TagDAO {
    public void create(Tag tag) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        Integer tagID = null;

        try {
            tx = session.beginTransaction();
            Tag tagE = new Tag();
            tagE.setTag(tag.getTag());
            tagID = (Integer) session.save(tagE);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void remove(Tag tag) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Tag tagE = new Tag();
            tagE.setId(tag.getId());
            session.delete(tagE);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ArrayList<Tag> getAll() {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        ArrayList<Tag> tags = new ArrayList<Tag>();

        try {
            tx = session.beginTransaction();
            tags = new ArrayList(session.createQuery("FROM entity.Tag").list());
            for (Iterator iterator = tags.iterator(); iterator.hasNext();){
                Tag tag = (Tag) iterator.next();
                System.out.print(tag.getId() + ": " + tag.getTag() + "\n");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tags;
    }
}
