package my.ilya.inheritance.action;

import my.ilya.common.HibernateUtil;
import my.ilya.inheritance.model.discriminator.ExpulsionOrderItemSingle;
import my.ilya.inheritance.model.discriminator.OrderItemSingle;
import my.ilya.inheritance.model.discriminator.TransferOrderItemSingle;
import my.ilya.relationship.model.Aim;
import my.ilya.relationship.model.Description;
import my.ilya.relationship.model.SubAim;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * @author KAZAKEVICH
 */
public class SingleTableDemo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();

    public static void main(String[] args) {

        //clearTables();
        demo();

    }

    private static void demo() {
        OrderItemSingle orderItem = new OrderItemSingle();
        orderItem.setName("Main order");

        TransferOrderItemSingle transferOrderItem = new TransferOrderItemSingle();
        transferOrderItem.setName("Transfer Order Item");
        transferOrderItem.setDate(new Date());

        ExpulsionOrderItemSingle expulsionOrderItem = new ExpulsionOrderItemSingle();
        expulsionOrderItem.setName("Expulsion Order Item");
        expulsionOrderItem.setExpulsionDate(new Date());

        saveObject(orderItem);
        saveObject(transferOrderItem);
        saveObject(expulsionOrderItem);

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
        Query query = session.createQuery("DELETE FROM ORDER_ITEM");
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
