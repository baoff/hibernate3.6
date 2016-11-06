package cn.foot.day03.cache.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.foot.day02.entity.User;

public class SessionCacheTest {
	
	private static SessionFactory sessionFactory;
	static{
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addClass(User.class);
		sessionFactory = cfg.buildSessionFactory();
	}
	/*
	 * 
	 * session ����
	 */
	@Test
	public void test() throws Exception {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, 2);
		System.out.println(user.getName());
		session.refresh(user); // ˢ�»��棬���²�ѯ
		user = (User) session.get(User.class, 2);
		System.out.println(user.getName());
	}

}
