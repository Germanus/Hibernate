package run;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.Address;
import dto.UserDetails;

import java.util.Date;

public class DifferenceGetLoad {
    public static void main(String[] args) {

        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

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

        //user = (UserDetails) session.get(UserDetails.class, 6);
        user = (UserDetails) session.load(UserDetails.class, 6);

        System.out.println("-----User----");
        System.out.println(user.getDescription());
        System.out.println(user.getAddresses().size());
        System.out.println("-------------");
    }
}
