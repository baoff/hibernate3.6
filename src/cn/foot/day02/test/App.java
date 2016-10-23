package cn.foot.day02.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.foot.day02.entity.User;

public class App {
	
	private static SessionFactory sessionFactory;
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addClass(User.class);
		sessionFactory = cfg.buildSessionFactory();
	}

	@Test
	public void testSave() throws Exception{
		Session session = sessionFactory.openSession();
		try{
			Transaction tx =  session.beginTransaction();
			User user = new User();
			user.setName("����");
			Set<String> addressSet = new HashSet<String>();
			addressSet.add("��ɺ�·");
			addressSet.add("�н�·");
			user.setAddressSet(addressSet);
			List<String> addressList = new ArrayList<String>();
			addressList.add("��ɺ�·");
			addressList.add("�н�·");
			user.setAddressList(addressList);
			Map<String,String> addressMap = new HashMap<String,String>();
			addressMap.put("xx", "�н�·");
			user.setAddressMap(addressMap);
			session.save(user);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	@Test
	public void testGet() throws Exception{
		Session session = sessionFactory.openSession();
		try{
			Transaction tx =  session.beginTransaction();
			User user = (User) session.get(User.class, 5);
			System.out.println(user.getAddressList());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
