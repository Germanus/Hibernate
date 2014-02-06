package my.ilya.crud.action;

import my.ilya.common.HibernateUtil;
import my.ilya.crud.model.Phone;
import my.ilya.inheritance.model.initial.ExpulsionOrderItem;
import my.ilya.inheritance.model.initial.OrderItem;
import my.ilya.inheritance.model.initial.TransferOrderItem;
import my.ilya.relationship.model.Aim;
import my.ilya.relationship.model.Description;
import my.ilya.relationship.model.SubAim;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class CRUDDemo {

    private static SessionFactory sessionFactory = HibernateUtil.configureSessionFactory();

    public static void main(String[] args) {

        //Заполняем таблицу
        //fillPhoneTable();
        //loadPhone();
        //deletePhone(new Phone());
        //mergePhone();

    }

    private static void mergePhone() {
        Phone phone = HibernateUtil.findObjectById(Phone.class, 30);
        phone.setNumber(235L);
        HibernateUtil.mergeObject(phone);
        phone = HibernateUtil.findObjectById(Phone.class, 30);
        System.out.println("Phone id:" + phone.getID());
        System.out.println("Phone number: " + phone.getNumber());
    }

    private static void deletePhone(Phone phone) {
        HibernateUtil.deleteObject(phone);
        System.out.println(phone);
        System.out.println(HibernateUtil.findObjectById(Phone.class, 20));
    }

    private static void loadPhone() {
        Phone phone = HibernateUtil.findObjectById(Phone.class, 20);
        System.out.println("Phone id:" + phone.getID());
        System.out.println("Phone number: " + phone.getNumber());
    }

    private static void fillPhoneTable(){
        for(int i=0; i<10; i++){
            Phone phone = new Phone();
            phone.setNumber(new Long(i));
            HibernateUtil.saveObject(phone);
        }
    }


}
