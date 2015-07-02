package my.ilya.run;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.ilya.dto.NamedQueryTest;

public class NamedQueryRun {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
    	
        NamedQueryTest test = new NamedQueryTest();
        test.setName("ilya");
        saveNQ(test);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.getNamedQuery("findNQ").setString("name", "ilya");
        List list = query.list();
        session.close();
        System.out.println("-----QN TEST----");
        for (Object o : list) {
            NamedQueryTest nq = (NamedQueryTest) o;
            System.out.println(nq.getID() + ":" + nq.getName() + " ");
        }
        System.out.println("-------------");
    }
   

    private static void saveNQ(NamedQueryTest test) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(test);
        session.getTransaction().commit();
        session.close();
    }

}
