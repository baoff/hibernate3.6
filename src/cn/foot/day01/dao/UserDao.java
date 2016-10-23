package cn.foot.day01.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.foot.day01.entity.User;
import cn.foot.day01.util.HibernateUtils;

public class UserDao {

	public void save(User user){
		Session session = HibernateUtils.openSession();
		try{
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			
		}catch(RuntimeException e){
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}finally{
			session.close();
		}
	}
}
