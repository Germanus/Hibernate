package my.ilya.cache;

import my.ilya.common.HibernateUtil;
import my.ilya.crud.model.Phone;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public final class CacheDemo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
    private CacheDemo(){}

    public static void main(String[] args) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Phone where id=10");
        query.setCacheable(true);

        List<Phone> list = query.list();

        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Query query2 = session2.createQuery("from Phone where id=10");
        query2.setCacheable(true);

        List<Phone> list2 = query2.list();

        session2.getTransaction().commit();
        session2.close();

        System.out.println("Size:" + list2.size());

    }

}
