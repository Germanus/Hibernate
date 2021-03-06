package my.ilya.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class HibernateUtil {

    public static SessionFactory configureSessionFactory() {
    	
		Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
        configuration.setProperty("hibernate.cache.region.factory_class",
                "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");

        return configuration.buildSessionFactory(serviceRegistry);
    }
    
    public static Session beginTransaction(SessionFactory factory){
    	 Session session = factory.openSession();
         session.beginTransaction();
         return session;
    }
    
    public static void commitTransaction(Session session){
   	 	session.getTransaction().commit();
   	 	session.close();        
   }

    public static void saveObject(Object object){
        Session session = configureSessionFactory().openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    public static <T> T findObjectById(Class<T> clazz, int id){
        Session session = configureSessionFactory().openSession();
        session.beginTransaction();
        T loaded = (T) session.get(clazz, id);
        session.getTransaction().commit();
        session.close();
        return loaded;
    }

    public static void deleteObject(Object o){
        Session session = configureSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    public static void mergeObject(Object o){
        Session session = configureSessionFactory().openSession();
        session.beginTransaction();
        session.merge(o);
        session.getTransaction().commit();
        session.close();
    }


}
