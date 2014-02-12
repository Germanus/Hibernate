package my.ilya.hql;

import my.ilya.common.HibernateUtil;
import my.ilya.crud.model.Phone;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public final class HqlDemo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
    private HqlDemo(){}

    public static void main(String[] args) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Phone");
        //Pagination
        query.setFirstResult(1);
        query.setMaxResults(2);
        List<Phone> list = query.list();

        //После того как открыта сессия и объект сохранет
        //до закрытия сессии это persistent объект
        session.getTransaction().commit();
        session.close();

        System.out.println("Size:" + list.size());

    }

}
