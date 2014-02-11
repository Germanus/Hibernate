package my.ilya.kind.action;

import my.ilya.common.HibernateUtil;
import my.ilya.crud.model.Phone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public final class KindDemo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
    private KindDemo(){}

    public static void main(String[] args) {

        //Пока объект не сохранен он - transient
        Phone phone = new Phone();
        phone.setNumber(5L);
        //test branch
        //second test
        //master price
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(phone);
        //После того как открыта сессия и объект сохранет
        //до закрытия сессии это persistent объект
        session.getTransaction().commit();
        session.close();
        //после закрытия сессии это detached объект

    }

}
