package my.ilya.criteria;

import my.ilya.common.HibernateUtil;
import my.ilya.crud.model.Phone;

import my.ilya.dto.Address;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;

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

        Criteria criteria2 = session.createCriteria(Phone.class)
                .setProjection(Projections.max("id"));
        System.out.println(criteria2.uniqueResult());


        Criteria criteria3 = session.createCriteria(Phone.class)
                .setProjection(Projections.property("id"));
        System.out.println(criteria3.list());

        Criteria criteria4 = session.createCriteria(Phone.class)
                .addOrder(Order.desc("number"));
        printPhones(criteria4.list());

        //По примеру
        Phone phone = new Phone();
        phone.setNumber(235L);
        Example example = Example.create(phone);
        Criteria criteria5 = session.createCriteria(Phone.class)
                .add(example);
        printPhones(criteria5.list());



        session.getTransaction().commit();
        session.close();

    }

    private static void printPhones(List<Phone> list) {
        for (Phone phone : list){
            System.out.println(phone.getID() + " " + phone.getNumber());
        }
    }

}
