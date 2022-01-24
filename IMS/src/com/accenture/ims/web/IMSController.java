package com.accenture.ims.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.accenture.ims.business.bean.LoginDetailBean;
import com.accenture.ims.business.bean.MaterialCategoryBean;
import com.accenture.ims.business.bean.MaterialTypeBean;
import com.accenture.ims.business.bean.MaterialUnitBean;
import com.accenture.ims.business.bean.PurchaseBean;
import com.accenture.ims.business.bean.VendorBean;

import com.accenture.ims.service.IMSService;

@Controller
public class IMSController {
	@Autowired
	private IMSService imsService;
	// localhost
	 //private final String VENDORURI ="http://localhost:8080/project/vendor/controller/getVendors";
	private final String VENDORURI = "http://javastreamims.devops.vendorservice.ci.34.244.71.102.xip.io/project/vendor/controller/getVendors";
	private final String MATERIALSERVICEURI = "http://localhost:7070/project/material/controller/getMaterialCategories";

	// type="http://localhost:7070/project/material/controller/getMaterialTypeById/"
	// unit="http://localhost:7070/project/material/controller/getMaterialUnitById/"
	// private final String MATERIALSERVICEURI =
	// "http://javastreamims.devops.materialservice.ci.34.241.63.105.xip.io/project/material/controller/getMaterialCategories";
	@RequestMapping(value = "/loadLogin.html", method = RequestMethod.GET)
	public ModelAndView loadLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
	}

	// Working xml
	/*
	 * public ModelAndView validateLogin(@RequestParam("user") String
	 * username, @RequestParam("pwd") String password) { ModelAndView mv = new
	 * ModelAndView(); LoginDetailBean bean = IMSService.getDetails(); if
	 * (bean.getUsername().equals(username) && bean.getPassword().equals(password))
	 * {
	 * 
	 * RestTemplate rt = new RestTemplate();
	 * 
	 * VendorBeanList listFromService = rt
	 * .getForObject("http://localhost:8080/project/vendor/controller/getVendors",
	 * VendorBeanList.class); mv.addObject("purchaseBean", new PurchaseBean());
	 * mv.setViewName("purchaseForm"); List<VendorBean>
	 * beanList=listFromService.getVendorBeanList(); mv.addObject("vendorList",
	 * beanList);
	 * 
	 * } else { /////// fail yet to be complete mv.setViewName("login"); } return
	 * mv; }
	 */
	@RequestMapping(value = "/validateLogin.html", method = RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("user") String username, @RequestParam("pwd") String password) {
		ModelAndView mv = new ModelAndView();
		LoginDetailBean bean = imsService.getDetails();
		if (bean.getUsername().equals(username) && bean.getPassword().equals(password)) {
			mv.addObject("purchaseBean", new PurchaseBean());

			// mv.addObject("vendorList", getVendorNames());
			// mv.addObject("categoryList", getMaterialCategories());
			mv.setViewName("purchaseForm");

		} else {

			/////// fail yet to be complete
			mv.setViewName("login");
		}

		return mv;
	}

	@ModelAttribute("vendorList")
	public List<VendorBean> getVendorNames() {
		/*
		 * ResponseEntity<List<VendorBean>> response = rt.exchange(
		 * "http://localhost:8080/project/vendor/controller/getVendors", HttpMethod.GET,
		 * null, new ParameterizedTypeReference<List<VendorBean>>(){}); List<VendorBean>
		 * beanList= response.getBody();
		 */
		RestTemplate rt = new RestTemplate();

		// Fetching
		ResponseEntity<VendorBean[]> responseEntity = rt.getForEntity(VENDORURI, VendorBean[].class);
		VendorBean[] vendorBeanArray = responseEntity.getBody();
		List<VendorBean> vendorBeanList = Arrays.asList(vendorBeanArray);

		return vendorBeanList;
	}

	@ModelAttribute("categoryList")
	public List<MaterialCategoryBean> getMaterialCategories() {

		RestTemplate rt = new RestTemplate();
		ResponseEntity<MaterialCategoryBean[]> materialResponseEntity = rt.getForEntity(MATERIALSERVICEURI,
				MaterialCategoryBean[].class);
		MaterialCategoryBean[] materialCategoryBeanArray = materialResponseEntity.getBody();
		List<MaterialCategoryBean> catBeanListFromService = Arrays.asList(materialCategoryBeanArray);

		return catBeanListFromService;
	}

	// my code
	/*@RequestMapping(value = "/getTypeAndUnit1.html", method = RequestMethod.POST)
	public void test() {

		System.out.println("inside controller");
	}*/

	@RequestMapping(value = "/getTypeAndUnit.html", method = RequestMethod.POST)
	public ModelAndView getMaterialTypeAndUnit(@ModelAttribute("purchaseBean") PurchaseBean bean ) {
		System.out.println("Inside controller");
		ModelAndView mv = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
		// Fetch Type from MaterialService
		ResponseEntity<MaterialTypeBean[]> responseEntity = restTemplate.getForEntity(
				"http://localhost:7070/project/material/controller/getMaterialTypeById/" +bean.getMaterialCategoryId(),
				MaterialTypeBean[].class);
		MaterialTypeBean[] materialTypeArray = responseEntity.getBody();
		List<MaterialTypeBean> typeList = Arrays.asList(materialTypeArray);
		mv.addObject("typeList", typeList);

		// Fetch Unit from MaterialService
		ResponseEntity<MaterialUnitBean[]> responseUnit = restTemplate.getForEntity(
				"http://localhost:7070/project/material/controller/getMaterialUnitById/" +bean.getMaterialCategoryId(),
				MaterialUnitBean[].class);
		MaterialUnitBean[] materialUnitArray = responseUnit.getBody();
		List<MaterialUnitBean> unitList = Arrays.asList(materialUnitArray);
		mv.addObject("unitList", unitList);
		///
		// mv.addObject("purchaseBean", new PurchaseBean());
		// mv.addObject("vendorList", getVendorNames());
		// mv.addObject("categoryList", getMaterialCategories());
		////
		
		mv.setViewName("purchaseForm");
		return mv;
	}

}
