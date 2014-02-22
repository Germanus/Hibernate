package my.ilya.criteria;

import my.ilya.common.HibernateUtil;
import my.ilya.crud.model.Phone;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public final class CriteriaApiDemo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();
    private CriteriaApiDemo(){}

    public static void main(String[] args) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Phone.class);
        criteria.add(Restrictions.ge("id",40)).add(Restrictions.between("number", 4L,6L));
        printPhones(criteria.list());

        session.getTransaction().commit();
        session.close();

    }

    private static void printPhones(List<Phone> list) {
        for (Phone phone : list){
            System.out.println(phone.getID() + " " + phone.getNumber());
        }
    }

}
