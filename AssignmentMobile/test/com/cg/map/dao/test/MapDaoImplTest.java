package com.cg.map.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.map.dao.MapDao;
import com.cg.map.dao.MapDaoImpl;
import com.cg.map.exception.MAPException;
import com.cg.map.model.Mobile;

public class MapDaoImplTest {
	MapDao mapDao = null;

	@Before
	public void setUp() throws Exception {
		mapDao = new MapDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		mapDao = null;
	}

	@Test
	public void testAddCustomerDetails() {
		Mobile mobile = new Mobile();
		mobile.setCustomerName("Saravanan");
		mobile.setMailId("saranbhavan@gmail.com");
		mobile.setMobileNumber("8949898989");
		mobile.setMobileId(1003);
		try {
			int rows = mapDao.addCustomerDetails(mobile);
			assertEquals(1, rows);
		} catch (MAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSearchDetails() {
		Mobile mobile = new Mobile();
		mobile.setMinprice(15000d);
		mobile.setMaxprice(30000d);
		try {
			List<Mobile> list = mapDao.searchDetails(mobile);
			assertEquals(3, list.size());
		} catch (Exception e) {

		}
	}

}
