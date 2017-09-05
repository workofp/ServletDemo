package edu.whut.web.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.whut.web.dao.RoleDao;
import edu.whut.web.dao.impl.RoleDaoImpl;
import edu.whut.web.domain.Organization;
import edu.whut.web.domain.Role;

public class RoleDaoTest {
	static RoleDao roleDao;
	Role role = null;
	
	@BeforeClass
	public static void before() {
		roleDao = new RoleDaoImpl();
	}

	@AfterClass
	public static void after() {
	}
	@Test
	public void testFindAllRoles() {
		List<Role> roles = roleDao.findAllOnes();
		assertTrue(roles.size()>0);
	}

	@Test
	public void testInsert() {
		role = new Role();
		role.setName("行政人员");
		role.setDescription("行政人员的描述");
		role = roleDao.insert(role);
		assertNotNull(role);
	}

	@Test
	public void testUpdate() {
		role = roleDao.findById(1);
		role.setName("修改用户角色");
		role = roleDao.update(role);
		assertNotNull(role);
	}

	@Test
	public void testDelete() {
		role = roleDao.findById(1);
		role = roleDao.delete(role);
		assertNotNull(role);
	}

	@Test
	public void testFindById() {
		role = roleDao.findById(1);
		assertNotNull(role);
		assertTrue(role.getUsers().size()>0);
	}
	
}
