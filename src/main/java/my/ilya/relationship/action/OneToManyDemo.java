package my.ilya.relationship.action;

import my.ilya.common.HibernateUtil;
import my.ilya.relationship.model.Aim;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();

    public static void main(String[] args) {

        Aim aim = new Aim();
        createAim(aim);

    }

    private static void createAim(Aim aim){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(aim);
        session.getTransaction().commit();
        session.close();
    }
}
