package my.ilya.relationship.action;

import my.ilya.common.HibernateUtil;
import my.ilya.relationship.model.Aim;
import my.ilya.relationship.model.Description;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyDemo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();

    public static void main(String[] args) {

        Aim aim = new Aim();
        aim.setName("Buy car");

        Description description = new Description();
        description.setName("Save money");

        aim.setDescription(description);
        createAim(aim);

    }

    private static void createAim(Aim aim){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //session.save(aim.getDescription());
        session.persist(aim);//save(aim);
        session.getTransaction().commit();
        session.close();
    }
}
