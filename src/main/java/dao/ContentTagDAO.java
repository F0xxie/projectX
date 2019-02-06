package dao;

import entity.ContentTag;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;

public class ContentTagDAO {
    public void create(ContentTag contentTag) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        Integer contentTagID = null;

        try {
            tx = session.beginTransaction();
            ContentTag contentTagE = new ContentTag();
            contentTagE.setContentId(contentTag.getContentId());
            contentTagE.setTagId(contentTag.getTagId());
            contentTagID = (Integer) session.save(contentTagE);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ArrayList<ContentTag> getAll() {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        ArrayList<ContentTag> contentTags = new ArrayList<ContentTag>();

        try {
            tx = session.beginTransaction();
            contentTags = new ArrayList(session.createQuery("FROM entity.ContentTag").list());
            for (Iterator iterator = contentTags.iterator(); iterator.hasNext();){
                ContentTag contentTag = (ContentTag) iterator.next();
                System.out.print(contentTag.getId() + ": " + contentTag.getTagId() + " " + contentTag.getContentId() + "\n");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return contentTags;
    }
}
