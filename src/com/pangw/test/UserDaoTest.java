package com.pangw.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pangw.bean.User;
import com.pangw.dao.UserDao;
import com.pangw.dao.impl.UserDaoImpl;

public class UserDaoTest {
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		this.context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testQueryUserById() {
		// 获取userDao
		//或者UserDao userDao = this.context.getBean(UserDao.class);
		UserDao userDao = (UserDao) this.context.getBean("userDao");
		
		User user = userDao.queryUserById(1);
		System.out.println(user);

	}

	@Test
	public void testQueryUserByUsername() {
		// 获取userDao
		UserDao userDao = this.context.getBean(UserDao.class);

		List<User> list = userDao.queryUserByUsername("张");
		for (User user : list) {
			System.out.println(user);
		}

	}

	@Test
	public void testSaveUser() {
		// 获取userDao
		UserDao userDao = this.context.getBean(UserDao.class);

		User user = new User();
		user.setUsername("曹操");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("三国");
		userDao.saveUser(user);
		System.out.println(user);

	}

}
