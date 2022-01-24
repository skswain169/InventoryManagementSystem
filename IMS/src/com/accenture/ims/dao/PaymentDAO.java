package com.accenture.ims.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.ims.entity.PaymentEntity;

public interface PaymentDAO extends CrudRepository<PaymentEntity, Integer> {
	@Query(value = "SELECT pay FROM PaymentEntity pay, com.accenture.ims.entity.PurchaseEntity purchase WHERE purchase.purchaseId=pay.purchaseId and purchase.vendorName=?1 and purchase.status=?2 and purchase.purchaseDate BETWEEN ?3 AND ?4")
	public List<PaymentEntity> getPaymentBeanByStatus(String vendorName, String status, Date fromDate, Date toDate);

}
