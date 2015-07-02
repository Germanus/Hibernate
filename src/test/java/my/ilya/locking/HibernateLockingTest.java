package my.ilya.locking;

import java.io.Serializable;

import my.ilya.common.HibernateUtil;
import my.ilya.crud.model.Phone;
import my.ilya.crud.model.User;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HibernateLockingTest extends Assert {

	private SessionFactory sessionFactory;

	@Before
	public void setUp() {
		if(sessionFactory == null){
			sessionFactory = HibernateUtil.configureSessionFactory();
		}		
	}

	@Test
	public void testOptimisticLock() {
		Phone phone = createPhone();
		
		try {

			Session savedSession = HibernateUtil.beginTransaction(sessionFactory);
			savedSession.save(phone);
			HibernateUtil.commitTransaction(savedSession);

			System.out.println(phone.getID());

			Session firstSession = HibernateUtil.beginTransaction(sessionFactory);
			Phone loadedPhone = (Phone) firstSession.get(Phone.class, phone.getID());
			System.out.println(loadedPhone.getVersion());

			Session secondSession = HibernateUtil.beginTransaction(sessionFactory);
			Phone loadedPhone2 = (Phone) secondSession.get(Phone.class, phone.getID());
			loadedPhone2.setNumber(999999L);
			HibernateUtil.commitTransaction(secondSession);

			loadedPhone.setNumber(11311L);
			HibernateUtil.commitTransaction(firstSession);

			fail();
		} catch (StaleObjectStateException ex) {
			
		}

	}

	@Test
	public void testPessimisticLock() {
		User user = createUser();

		Session saveSession = HibernateUtil.beginTransaction(sessionFactory);
		saveSession.save(user);
		HibernateUtil.commitTransaction(saveSession);

		Session firstSession = HibernateUtil.beginTransaction(sessionFactory);
		firstSession.getTransaction().setTimeout(10);
		User loadedUser = (User) firstSession.get(User.class, user.getId(), LockOptions.UPGRADE);
		
//		Session secondSession = HibernateUtil.beginTransaction(sessionFactory);
//		User secondUser = (User) secondSession.get(User.class, user.getId());
//		secondUser.setName("Julia");
//		HibernateUtil.commitTransaction(secondSession);

		loadedUser.setName("Anna");
		HibernateUtil.commitTransaction(firstSession);

	}

	private Phone createPhone() {
		Phone phone = new Phone();
		phone.setNumber(3752529980L);
		return phone;
	}
	
	private User createUser() {
		User user = new User();
		user.setName("Ilya");
		return user;
	}

}
