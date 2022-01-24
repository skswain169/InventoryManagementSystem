package com.accenture.lkm.test.dao;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.VendorDAO;
import com.accenture.lkm.entity.VendorEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorDAOTest {

	/*
	 * Autowire the VendorDAO object below
	 */

	@Autowired
	private VendorDAO vendorDAO;

	/*
	 * Method - notNullVendorDAOTest() Assert only that VendorDAO object is Not null
	 */

	@Test
	public void notNullVendorDAOTest() {
		assertTrue(vendorDAO != null);
	}

	/*
	 * Method - findByIdVendorDAOTest() Using VendorDAO fetch an entity by its ID
	 * --> "V001" Assert that the entity fetch and it is Not null Assert that the
	 * name of the vendor entity fetch is equal to --> "Only Vimal"
	 */

	@Test
	public void findByIdVendorDAOTest() {
		Optional<VendorEntity> entity = vendorDAO.findById("V001");
		assertTrue(entity != null);
		System.out.println("Testsssss!!!!!!!!!" + entity.get());
		assertTrue(entity.get().getVendorName().equals("Only Vimal"));
	}

}
