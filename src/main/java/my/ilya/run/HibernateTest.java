package my.ilya.dto.run;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.ilya.dto.Address;
import my.ilya.dto.UserDetails;

public class HibernateTest {

    public static void main(String[] args) {

        String current = null;
        try {
            current = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Current dir:" + current);
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);

        Address addr = new Address();
        addr.setStreet("Street Name");
        addr.setCity("City Name");
        addr.setPincode("22222");

        Address addr2 = new Address();
        addr2.setStreet("Street Name2");
        addr2.setCity("City Name2");
        addr2.setPincode("33333");

        UserDetails user = new UserDetails();
        user.setUserName("Ilya");
        user.setJoinedDate(new Date());
        user.setDescription("Description of the user goes here");
        user.getAddresses().add(addr);
        user.getAddresses().add(addr2);
        addr.setUser(user);
        addr2.setUser(user);

        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(addr);
        session.save(addr2);
        session.getTransaction().commit();
        session.close();

        user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (UserDetails) session.get(UserDetails.class, 1);

        System.out.println("-----User----");
        System.out.println(user.getDescription());
        System.out.println(user.getAddresses().size());

    }

}
