package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.MaterialUnitBean;
import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.dao.UnitDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;
import com.accenture.lkm.entity.MaterialUnitEntity;

@Service
public class MaterialServiceImpl implements MaterialService {

	/*
	 * Autowire MaterialCategoryDAO object
	 * 
	 */
	@Autowired
	private MaterialCategoryDAO materialCategoryDAO;

	@Autowired
	private MaterialTypeDAO materialTypeDAO;

	@Autowired
	private UnitDAO unitDAO;
	// Your Code Here

	/*
	 * Method - getMaterialCategoryById() Use MaterialCategoryDAO object findById
	 * method to fetch the entity by --> categoryId Check if the entity is present
	 * initialized the materialCategoryBean object copy the properties value from
	 * entity to materialCategoryBean object
	 */

	@Override
	public MaterialCategoryBean getMaterialCategoryById(String categoryId) {

		MaterialCategoryBean materialCategoryBean = new MaterialCategoryBean();
		Optional<MaterialCategoryEntity> optionalEntity = materialCategoryDAO.findById(categoryId);
		if (optionalEntity.get() != null) {
			BeanUtils.copyProperties(optionalEntity.get(), materialCategoryBean);
		}
		return materialCategoryBean;
	}

	/*
	 * Method - getMaterialCategories() Use the MaterialCategoryDAO to get all the
	 * MaterialCategoryEntity objects Check if list is not empty then Declare a
	 * MaterialCategoryBean object with null value Loop through all the material
	 * categories Initialize a new MaterialCategoryBean object Copy each property
	 * value of entity object to bean object Add the bean object to the
	 * materialCategoryBeans list
	 */

	@Override
	public List<MaterialCategoryBean> getMaterialCategories() {

		List<MaterialCategoryBean> materialCategoryBeans = new ArrayList<>();
		List<MaterialCategoryEntity> listMaterialCategoryEntity = materialCategoryDAO.findAll();
		if (listMaterialCategoryEntity != null) {
			MaterialCategoryBean bean = null;
			for (MaterialCategoryEntity entity : listMaterialCategoryEntity) {
				bean = new MaterialCategoryBean();
				BeanUtils.copyProperties(entity, bean);
				materialCategoryBeans.add(bean);
			}
		}

		return materialCategoryBeans;
	}

	@Override
	public List<MaterialTypeBean> getMaterialTypeByCategoryId(String categoryId) {
		List<MaterialTypeEntity> entityList = materialTypeDAO.getMaterialTypeByCategoryId(categoryId);

		List<MaterialTypeBean> beanList = new ArrayList<>();
		for (MaterialTypeEntity materialTypeEntity : entityList) {
			MaterialTypeBean bean = new MaterialTypeBean();

			BeanUtils.copyProperties(materialTypeEntity, bean);
			beanList.add(bean);
		}

		return beanList;
	}

	@Override
	public List<MaterialUnitBean> getUnitByCategoryId(String categoryId) {
		List<MaterialUnitEntity> entityList = unitDAO.getMaterialUnitByCategoryId(categoryId);

		List<MaterialUnitBean> beanList = new ArrayList<>();
		for (MaterialUnitEntity unit : entityList) {
			MaterialUnitBean bean = new MaterialUnitBean();

			BeanUtils.copyProperties(unit, bean);
			beanList.add(bean);
		}

		return beanList;
	}

}
