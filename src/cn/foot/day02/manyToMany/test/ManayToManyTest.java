package cn.foot.day02.manyToMany.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.foot.day02.manyToMany.entity.Student;
import cn.foot.day02.manyToMany.entity.Teacher;

public class ManayToManyTest {
	private static  SessionFactory sessionFactory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addClass(Student.class);
		cfg.addClass(Teacher.class);
		sessionFactory = cfg.buildSessionFactory();
	}
	@Test
	public void testSave() throws Exception {
		Session session = sessionFactory.openSession();
		try{
			Transaction tx = session.beginTransaction();
			Student student1 = new Student();
			student1.setName("张同学");
			Student student2 = new Student();
			student2.setName("李同学");
			
			Teacher teacher1 = new Teacher();
			teacher1.setName("赵老师");
			Teacher teacher2 = new Teacher();
			teacher2.setName("蔡老师");
			
			Set<Teacher> teachers = new HashSet<Teacher>();
			teachers.add(teacher1);
			teachers.add(teacher2);
			Set<Student> students = new HashSet<Student>();
			students.add(student1);
			students.add(student2);
			student1.setTeachers(teachers);
			student2.setTeachers(teachers);
			teacher1.setStudents(students);
			teacher2.setStudents(students);
			session.save(student1);
			session.save(student2);
			session.save(student1);
			session.save(teacher1);
			session.save(teacher2);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
		
		
	}
}
