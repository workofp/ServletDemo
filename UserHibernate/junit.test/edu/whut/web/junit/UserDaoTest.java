package edu.whut.web.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.whut.web.dao.OrganizationDao;
import edu.whut.web.dao.UserDao;
import edu.whut.web.dao.impl.OrganizationDaoImpl;
import edu.whut.web.dao.impl.UserDaoImpl;
import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;
import edu.whut.web.domain.User;
import edu.whut.web.util.MD5;

public class UserDaoTest {
	static UserDao userDao;
	static OrganizationDao organizationDao;
	User user = null;
	
	@BeforeClass
	public static void before() {
		userDao = new UserDaoImpl();
		organizationDao = new OrganizationDaoImpl();
	}

	@AfterClass
	public static void after() {
	}
	
	@Test
	public void testFindAllUsers() {
		List<User> users = userDao.findAllOnes();
		assertTrue(users.size()>0);
	}

	@Test
	public void testInsert() {
		user = new User();
		user.setName("qixin");
		user.setEmail("eee@163.com");
		MD5 md5 = new MD5();
		user.setPassword(md5.getMD5ofStr("888"));
		Organization organization = new Organization();
		organization.setId(1);
		user.setOrganization(organization);
//		Set<Role> roles = new HashSet<Role>();
//		Role role1 = new Role();
//		role1.setId(1);
//		roles.add(role1);
//		Role role2 = new Role();
//		role2.setId(2);
//		roles.add(role2);
//		user.setRoles(roles);
		user = userDao.insert(user);
		assertNotNull(user);
	}

	@Test
	public void testUpdate() {
		user = userDao.findById(10);
		user.setName("修改用户名称");
		Organization organization = new Organization();
		organization.setId(2);
		user.setOrganization(organization);
		user = userDao.update(user);		
		assertNotNull(user);
	}

	@Test
	public void testDelete() {
		user = userDao.findById(10);
		user = userDao.delete(user);
		assertNotNull(user);
	}

	@Test
	public void testFindById() {
		user = userDao.findById(1);
		assertNotNull(user);
		assertNotNull(user.getOrganization());
		assertTrue(user.getRoles().size()>0);
	}
	
	@Test
	public void testFindAllOnes() {
		List<User> users = userDao.findAllOnes();
		assertTrue(users.size() > 0);
	}
	
}
