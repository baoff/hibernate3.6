package cn.foot.day03.oneToOne2.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.foot.day03.oneToOne2.entity.Card;
import cn.foot.day03.oneToOne2.entity.Person;

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
	public void testSave()throws Exception{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Person person = new Person();
		person.setName("张三");
		Card card = new Card();
		card.setNumber("010X");
		person.setCard(card);
		card.setPerson(person);
//		session.save(person);
		session.save(card);
		tx.commit();
	}
	/*
	 * 不管是否能维护关联关系获取都是可以获得对方
	 */
	@Test
	public void testGet()throws Exception{
		Session session = sessionFactory.openSession();
		Person person = (Person)session.get(Person.class, 4);
		System.out.println(person.getCard().getNumber());
	}
}
