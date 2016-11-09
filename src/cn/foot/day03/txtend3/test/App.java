package cn.foot.day03.txtend3.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.foot.day03.txtend3.entity.Article;
import cn.foot.day03.txtend3.entity.Reply;
import cn.foot.day03.txtend3.entity.Topic;


public class App {
	private static SessionFactory sessionFactory;
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addClass(Article.class);
		sessionFactory = cfg.buildSessionFactory();
	}
	
	@Test
	public void testSave()throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Article article = new Article();
		article.setTitle("这是个article");
		Topic topic = new Topic();
		topic.setTitle("这是个Topic");
		Reply reply = new Reply();
		reply.setTitle("这是个reply");
		session.save(article);
		session.save(topic);
		session.save(reply);
		tx.commit();
	}
	
	@Test
	public void testGet()throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Article article = (Article) session.get(Reply.class,2);
		System.out.println(article.getTitle());
	}
}
