package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.MaterialUnitBean;

public interface MaterialService {
	MaterialCategoryBean getMaterialCategoryById(String categoryId);
	List<MaterialCategoryBean> getMaterialCategories();
	List<MaterialTypeBean> getMaterialTypeByCategoryId(String categoryId);
	 List<MaterialUnitBean> getUnitByCategoryId(String categoryId);
}

