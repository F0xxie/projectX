package dao;

import entity.Type;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HibernateTypeDAO implements TypeDAO {
    @Override
    public void create(Type type) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        Integer typeID = null;

        try {
            tx = session.beginTransaction();
            Type typeE = new Type();
            typeE.setType(type.getType());
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
    public void remove(Type type) {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Type typeE = new Type();
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
    public ArrayList<Type> getAll() {
        Session session = HibernateSessionFactory.getSession().getSession();
        Transaction tx = null;
        ArrayList<Type> types = new ArrayList<Type>();

        try {
            tx = session.beginTransaction();
            types = new ArrayList(session.createQuery("FROM entity.Type").list());
            for (Iterator iterator = types.iterator(); iterator.hasNext();){
                Type type = (Type) iterator.next();
                System.out.print(type.getId() + ": " + type.getType() + "\n");
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
