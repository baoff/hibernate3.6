package cn.foot.day03.oneToOne.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.foot.day03.oneToOne.entity.Card;
import cn.foot.day03.oneToOne.entity.Person;

public class App {
	
	private static SessionFactory sessionFactory;
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addClass(Person.class);
		cfg.addClass(Card.class);
		sessionFactory = cfg.buildSessionFactory();
	}
	
	@Test
	public void testSave()throws Exception {
		Session session = sessionFactory.openSession();
		try{
			Transaction tx = session.beginTransaction();
			Person p = new Person();
			p.setName("ÕÅÈý");
			Card card = new Card();
			card.setNumber("123123123123");
			p.setCard(card);
			card.setPerson(p);
			session.save(p);
			session.save(card);
			tx.commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
}
