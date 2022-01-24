package com.accenture.lkm.test.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialCategoryDAOTest {

	/*
	 * Autowire the MaterialCategoryDAO object below
	 */

	// Your Code Here
	@Autowired
	private MaterialCategoryDAO materialCategoryDAO;

	/*
	 * Method - notNullMaterialCategoryDAOTest() Assert only that
	 * MaterialCategoryDAO object is Not null
	 */

	@Test
	public void notNullMaterialCategoryDAOTest() {
		assertTrue(materialCategoryDAO != null);

	}

	/*
	 * Method - findByIdMaterialCategoryTest() Using MaterialCategoryDAO fetch an
	 * entity by its ID --> "C001" Assert that the entity fetch and it is Not null
	 * Assert that the name of the material category entity fetch is equal to -->
	 * "Thread"
	 */

	@Test
	public void findByIdMaterialCategoryTest() {
		Optional<MaterialCategoryEntity> entity = materialCategoryDAO.findById("C001");
		assertTrue(entity != null);
		assertTrue(entity.get().getCategoryName().equals("Thread"));

	}

	/*
	 * Method - findAllMaterialCategoryTest() Using MaterialCategoryDAO to fetch all
	 * the entities Assert that the list is Not null Assert that the count of
	 * entities matches to --> 3
	 */
	@Test
	public void findAllMaterialCategoryTest() {
		List<MaterialCategoryEntity> entityList = materialCategoryDAO.findAll();
		assertTrue(entityList != null);
		assertTrue(entityList.size() == 3);
	}

}
