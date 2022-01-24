package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.lkm.entity.MaterialTypeEntity;

public interface MaterialTypeDAO extends JpaRepository<MaterialTypeEntity, String> {

	@Query("SELECT t FROM MaterialTypeEntity t WHERE t.categoryId=?1")
	List<MaterialTypeEntity> getMaterialTypeByCategoryId(String categoryId);
	
	
}
