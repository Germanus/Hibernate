package my.ilya.relationship.action;

import my.ilya.common.HibernateUtil;
import my.ilya.relationship.model.Aim;
import my.ilya.relationship.model.Description;
import my.ilya.relationship.model.SubAim;
import my.ilya.relationship.model.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Demo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();

    public static void main(String[] args) {

        clearTables();

        //oneToOneDemo();
        //oneToManyJoinTableDemo();
        //oneToManyMappedByDemo();
        manyToManyDemo();

    }

    private static void manyToManyDemo() {
        Aim aim = new Aim();
        aim.setName("Be rich");

        Aim aim1 = new Aim();
        aim1.setName("Buy car");

        Subject subject = new Subject();
        subject.setName("Car");

        Subject subject1 = new Subject();
        subject1.setName("Laptop");

        aim.getSubjects().add(subject);
        aim.getSubjects().add(subject1);

        subject.getAimList().add(aim);
        subject.getAimList().add(aim1);

        createAim(aim);
        createAim(aim1);

    }

    private static void oneToManyMappedByDemo() {
        Aim aim = new Aim();
        aim.setName("Buy car");

        Description description = new Description();
        description.setName("Save money");

        SubAim subAim = new SubAim();
        subAim.setName("Get new job");

        SubAim subAim2 = new SubAim();
        subAim2.setName("Win in the lottery");

        //saveObject(subAim);
        //saveObject(subAim2);
        //saveObject(description);

        aim.setDescription(description);
        //subAim.setAim(aim);
        //subAim2.setAim(aim);
        aim.getSubAim().add(subAim);
        aim.getSubAim().add(subAim2);


        createAim(aim);
    }

    private static void oneToManyJoinTableDemo() {
        Aim aim = new Aim();
        aim.setName("Buy car");

        SubAim subAim = new SubAim();
        subAim.setName("Get new job");

        SubAim subAim2 = new SubAim();
        subAim2.setName("Win in the lottery");

        aim.getSubAim().add(subAim);
        aim.getSubAim().add(subAim2);

        createAim(aim);
    }

    private static void oneToOneDemo() {
        Aim aim = new Aim();
        aim.setName("Buy car");

        Description description = new Description();
        description.setName("Save money");

        aim.setDescription(description);

        createAim(aim);
    }

    private static void clearTables() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Aim");
        query.executeUpdate();
        query = session.createQuery("DELETE FROM SubAim");
        query.executeUpdate();
        query = session.createQuery("DELETE FROM Description");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    private static void createAim(Aim aim){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //session.save(aim.getDescription());
        session.persist(aim);//save(aim);
        session.getTransaction().commit();
        session.close();
    }

    private static void saveObject(Object object){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(object);//save(aim);
        session.getTransaction().commit();
        session.close();
    }
}
