package com.accenture.lkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.MaterialUnitBean;
import com.accenture.lkm.service.MaterialService;

@RestController
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	/*
	 * Autowire the MaterialService object
	 * 
	 */

	// Your Code Here
 
	@GetMapping("/")
	public String index() {
		return "Welcome to Spring Boot Material Service API!";
	}

	/*
	 * Method - getMaterialCategories() Fetch all the material categories details
	 * using MaterialService and store it inside a List Return a ResponseEntity
	 * object passing the list of material categories
	 * 
	 */

	@GetMapping(value = "/material/controller/getMaterialCategories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialCategoryBean>> getMaterialCategories() {

		// Your Code Here
		List<MaterialCategoryBean> beanList = materialService.getMaterialCategories();

		return new ResponseEntity<List<MaterialCategoryBean>>(beanList, HttpStatus.OK);
	}

	/*
	 * Method - getMaterialCategoryById() Fetch a single MaterialCategoryBean using
	 * MaterialService object and passing --> categoryId Return a ResponseEntity
	 * object passing the MaterialCategoryBean object
	 * 
	 */

	@GetMapping(value = "/material/controller/getMaterialCategoryById/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaterialCategoryBean> getMaterialCategoryById(@PathVariable String categoryId) {

		MaterialCategoryBean beanFromDb = materialService.getMaterialCategoryById(categoryId);

		return new ResponseEntity<MaterialCategoryBean>(beanFromDb, HttpStatus.OK);

	}

	////////// Extra///////////
	@GetMapping(value = "/material/controller/getMaterialTypeById/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)

	public List<MaterialTypeBean> getMaterialTypeById(@PathVariable String categoryId) {

		return materialService.getMaterialTypeByCategoryId(categoryId);
	}

	@GetMapping(value = "/material/controller/getMaterialUnitById/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MaterialUnitBean> getMaterialUnitById(@PathVariable String categoryId) {

		return materialService.getUnitByCategoryId(categoryId);
	}

}
