package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.lkm.entity.MaterialUnitEntity;

public interface UnitDAO extends CrudRepository<MaterialUnitEntity, String> {

	@Query("SELECT u FROM MaterialUnitEntity u WHERE u.categoryId=?1")
	List<MaterialUnitEntity> getMaterialUnitByCategoryId(String categoryId);
}
