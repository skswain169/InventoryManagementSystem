package com.accenture.ims.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.ims.entity.PurchaseEntity;

public interface PurchaseDAO extends CrudRepository<PurchaseEntity, Integer> {
	@Query(value = "Select c.categoryName,t.typeName,p.brandName,p.quantity,m.unitName,p.purchaseAmount,p.status,p.vendorName from PurchaseEntity p, com.accenture.ims.entity.MaterialUnitEntity m,com.accenture.ims.entity.MaterialCategoryEntity c,com.accenture.ims.entity.MaterialTypeEntity t where p.purchaseDate between ?1 and ?2 and p.unitId=m.unitId and p.materialCategoryId=c.categoryId and p.materialTypeId=t.typeId")
	public List<Object[]> showPurchaseDateReport(Date fromDate, Date toDate);

	@Query(value = "Select c.categoryName, t.typeName, p.brandName, p.quantity, u.unitName, p.purchaseAmount, py.balance,p.purchaseDate from PurchaseEntity p, PaymentEntity py,  com.accenture.ims.entity.MaterialCategoryEntity c, com.accenture.ims.entity.MaterialUnitEntity u, com.accenture.ims.entity.MaterialTypeEntity t where p.purchaseDate between ?2 and ?3 and p.vendorName=?1 and p.unitId=u.unitId and p.materialCategoryId=c.categoryId and p.materialTypeId=t.typeId")
	public List<Object[]> showNameDateReport(String vendorName, Date fromDate, Date toDate);

}
