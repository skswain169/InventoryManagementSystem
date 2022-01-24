package com.accenture.lkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.VendorBean;

import com.accenture.lkm.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@GetMapping("/")
	public String index() {
		return "Welcome to Spring Boot Vendor Service API!";
	}

	// Working with xml
	/*
	 * @GetMapping(value="/vendor/controller/getVendors",produces=MediaType.
	 * APPLICATION_XML_VALUE) public ResponseEntity<VendorBeanList>
	 * getVendorDetails() {
	 * 
	 * VendorBeanList beanList=new VendorBeanList(); List<VendorBean> venderBeanList
	 * = vendorService.getVendorDetails();
	 * beanList.setVendorBeanList(venderBeanList);
	 * 
	 * return new ResponseEntity<VendorBeanList>(beanList, HttpStatus.OK);
	 * 
	 * 
	 * 
	 * }
	 */

	@GetMapping(value = "/vendor/controller/getVendors", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VendorBean>> getVendorDetails() {

		List<VendorBean> vendorBeanList = vendorService.getVendorDetails();

		return new ResponseEntity<List<VendorBean>>(vendorBeanList, HttpStatus.OK);

	}

}
