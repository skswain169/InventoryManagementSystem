package com.accenture.lkm.test.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.service.VendorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorServiceTest {

	/*
	 * Autowire the VendorService object below
	 * 
	 */
	@Autowired
	private VendorService vendorService;
	// Your Code Here

	/*
	 * Method - notNullVendorServiceTest() Assert only that VendorService object is
	 * Not null
	 * 
	 */

	@Test
	public void notNullVendorServiceTest() {
		// Your Code Here
		assertTrue(vendorService != null);
	}

	/*
	 * Method - notNullGetVendorDetailsTest() Assert only that VendorService
	 * getVendorDetails is not returning a null value
	 * 
	 */

	@Test
	public void notNullGetVendorDetailsTest() {
		// Your Code Here
		assertTrue(vendorService.getVendorDetails() != null);

	}

	/*
	 * Method - countGetVendorDetailsTest() Assert only that VendorService
	 * getVendorDetails list size matches to 5
	 * 
	 */

	@Test
	public void countGetVendorDetailsTest() {
		// Your Code Here
		assertTrue(vendorService.getVendorDetails().size() == 5);
	}

	/*
	 * Method - recordGetVendorDetailsTest() Assert only that VendorService
	 * getVendorDetails first bean name matches --> "Only Vimal"
	 * 
	 */

	@Test
	//
	public void recordGetVendorDetailsTest() {

		assertTrue("Only Vimal".equals(vendorService.getVendorDetails().get(0).getVendorName()));

	}

}