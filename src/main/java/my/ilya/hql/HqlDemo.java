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

        Query query1 = session.getNamedQuery("getPhoneById");
        query1.setInteger(0, 30);
        List<Phone> phones = query1.list();
        for(Phone phone : phones){
            System.out.println(phone.getID() + " " + phone.getNumber());
        }

        Query query2 = session.getNamedQuery("getNativePhoneById");
        query2.setLong(0, 235L);
        List<Phone> phones2 = query2.list();
        for(Phone phone : phones2){
            System.out.println(phone.getID() + " " + phone.getNumber());
        }



        //После того как открыта сессия и объект сохранет
        //до закрытия сессии это persistent объект
        session.getTransaction().commit();
        session.close();

        System.out.println("Size:" + list.size());

    }

}
