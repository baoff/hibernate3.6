package cn.foot.day02.oneToMany.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.foot.day02.oneToMany.entity.Department;
import cn.foot.day02.oneToMany.entity.Employee;

public class OneToManyTest {
	
	private static SessionFactory sessionFactory ;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addClass(Department.class);
		cfg.addClass(Employee.class);
		sessionFactory = cfg.buildSessionFactory();
	}
	// 测试保存
	@Test
	public void testSave()throws Exception {
		Session session = sessionFactory.openSession();
		try{
			Transaction tx = session.beginTransaction();
			Department department = new Department();
			department.setName("研发部");
			Employee employee1 = new Employee();
			employee1.setName("张三");
			Employee employee2 = new Employee();
			employee2.setName("李四");
			Set<Employee> employees = new HashSet<Employee>();
			employees.add(employee1);
			employees.add(employee2);
			department.setEmployees(employees);
			employee1.setDepartment(department);
			employee2.setDepartment(department);
			session.save(department);
			session.save(employee1);
			session.save(employee2);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}

}
