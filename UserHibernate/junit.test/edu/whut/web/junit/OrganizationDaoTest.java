package edu.whut.web.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.whut.web.dao.OrganizationDao;
import edu.whut.web.dao.impl.OrganizationDaoImpl;
import edu.whut.web.domain.Organization;

public class OrganizationDaoTest {
	static OrganizationDao organizationDao;
	Organization organization = null;
	
	@BeforeClass
	public static void before() {
		organizationDao = new OrganizationDaoImpl();
	}

	@AfterClass
	public static void after() {
	}
	@Test
	public void testFindAllOnes() {
		List<Organization> organizations = organizationDao.findAllOnes();
		assertTrue(organizations.size()>0);
	}

	@Test
	public void testInsert() {
		organization = new Organization();
		organization.setName("�����0903��");
		organization.setDescription("�����0903�������");
		organization = organizationDao.insert(organization);
		assertNotNull(organization);
	}

	@Test
	public void testUpdate() {
		organization = organizationDao.findById(30);
		organization.setName("�޸ĵ�Ԫ������֯");
		organization = organizationDao.update(organization);
		assertNotNull(organization);
	}

	@Test
	public void testDelete() {
		organization = organizationDao.findById(30);
		organization = organizationDao.delete(organization);
		assertNotNull(organization);
	}

	@Test
	public void testFindById() {
		organization = organizationDao.findById(2);
		assertNotNull(organization);
		assertTrue(organization.getUsers().size()>0);
	}
	
}
