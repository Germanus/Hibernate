package my.ilya.run;

import java.util.Date;

import my.ilya.dto.Address;
import my.ilya.dto.UserDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DifferenceGetLoad {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static void main(String[] args) {

        SessionFactory sessionFactory = configureSessionFactory();

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

        // user = (UserDetails) session.get(UserDetails.class, 6);
        user = (UserDetails) session.load(UserDetails.class, 6);

        System.out.println("-----User----");
        System.out.println(user.getDescription());
        System.out.println(user.getAddresses().size());
        System.out.println("-------------");
    }

    private static SessionFactory configureSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry =
                new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
