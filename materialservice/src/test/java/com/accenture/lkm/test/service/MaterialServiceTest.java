package com.accenture.lkm.test.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.MaterialUnitBean;
import com.accenture.lkm.service.MaterialService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialServiceTest {

	/*
	 * Autowire the MaterialService object below
	 *
	 */
	@Autowired
	private MaterialService materialService;

	/*
	 * Method - notNullMaterialServiceTest() Assert only that MaterialService object
	 * is Not null
	 * 
	 */

	@Test
	public void notNullMaterialServiceTest() {
		// Your Code Here
		assertTrue(materialService != null);

	}

	/*
	 * Method - getMaterialCategoryByIdTest() Assert that MaterialCategoryBean
	 * object fetch using MaterialService getMaterialCategoryById --> C001 is not
	 * null Assert that object fetch name is equal to --> "Thread"
	 */

	@Test
	public void getMaterialCategoryByIdTest() {
		MaterialCategoryBean bean = materialService.getMaterialCategoryById("C001");
		assertTrue(bean != null);
		assertTrue(bean.getCategoryName().equals("Thread"));
	}

	/*
	 * Method - getMaterialCategoriesTest() Assert that MaterialCategoryBean list
	 * fetch using MaterialService getMaterialCategories is not null Assert that
	 * list size matches to --> 3
	 */

	@Test
	public void getMaterialCategoriesTest() {
		List<MaterialCategoryBean> listBean = materialService.getMaterialCategories();
		assertTrue(listBean != null);
		assertTrue(listBean.size() == 3);

	}


	
	/*@Test
	public void getMaterialTypeByCategoryId()
	{
		List <MaterialTypeBean> mtBean=materialService.getMaterialTypeByCategoryId("C001");
		assertTrue(mtBean!=null);

		assertTrue("Silk".equals(mtBean.get(0).getTypeName()));
	}

	@Test
	public void getMaterialUnitByCategoryId() {
		List<MaterialUnitBean> mtBean = materialService.getUnitByCategoryId("C001");
		assertTrue(mtBean != null);
		assertTrue("Metres".equals(mtBean.get(0).getUnitName()));
	}*/
	}
