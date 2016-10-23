package cn.foot.day01.test;

import org.junit.Test;

import cn.foot.day01.dao.UserDao;
import cn.foot.day01.entity.User;

public class UserDaoTest {
	
	@Test
	public void testSave(){
		User user = new User();
		user.setName("уехЩ");
		UserDao dao = new UserDao();
		dao.save(user);
	}
}
