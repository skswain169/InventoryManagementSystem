package com.accenture.ims.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.ims.business.bean.LoginDetailBean;
import com.accenture.ims.business.bean.NameDateBean;
import com.accenture.ims.business.bean.PaymentBean;
import com.accenture.ims.business.bean.PurchaseBean;
import com.accenture.ims.business.bean.StatusNameDateBean;
import com.accenture.ims.entity.LoginDetailEntity;
import com.accenture.ims.entity.PaymentEntity;
import com.accenture.ims.entity.PurchaseEntity;

@Repository
public class IMSDAOWrapper {

	@Autowired
	private PurchaseDAO purchaseDAO;

	@Autowired
	private PaymentDAO paymentDAO;
	@Autowired
	private LoginDao loginDAO;

	public LoginDetailBean getDetails() {

		Iterable<LoginDetailEntity> enitityIterable = loginDAO.findAll();
		LoginDetailBean bean = new LoginDetailBean();
		for (LoginDetailEntity loginDetailEntity : enitityIterable) {
			BeanUtils.copyProperties(loginDetailEntity, bean);
		}

		return bean;
	}

	public PurchaseBean addPurchaseDetails(PurchaseBean bean) {

		PurchaseEntity entity = new PurchaseEntity();
		BeanUtils.copyProperties(bean, entity);
		System.out.println("before save");
		PurchaseEntity purchaseEntity = purchaseDAO.save(entity);
		PurchaseBean purchaseBean = new PurchaseBean();
		BeanUtils.copyProperties(purchaseEntity, purchaseBean);
		return purchaseBean;
	}

	public List<Object[]> showPurchaseDateReport(Date fromDate, Date toDate) {

		List<Object[]> list = purchaseDAO.showPurchaseDateReport(fromDate, toDate);
		return list;
	}

	public List<Object[]> showNameDateReport(NameDateBean nameDateBean) {
		List<Object[]> list = purchaseDAO.showNameDateReport(nameDateBean.getVendorName(),
				nameDateBean.getDateRangeBean().getFromDate(), nameDateBean.getDateRangeBean().getToDate());
		return list;
	}

	public List<PaymentBean> getPaymentBeanByStatus(StatusNameDateBean statusNameDateBean) {
		String vendorName = statusNameDateBean.getNameDateBean().getVendorName();
		Date fromDate = statusNameDateBean.getNameDateBean().getDateRangeBean().getFromDate();
		Date toDate = statusNameDateBean.getNameDateBean().getDateRangeBean().getToDate();
		List<PaymentEntity> entityListFromDb = paymentDAO.getPaymentBeanByStatus(vendorName,
				statusNameDateBean.getStatus(), fromDate, toDate);
		List<PaymentBean> beanList = new ArrayList<>();
		for (PaymentEntity paymentEntity : entityListFromDb) {

			PaymentBean bean = new PaymentBean();
			BeanUtils.copyProperties(paymentEntity, bean);
			beanList.add(bean);
		}
		return beanList;
	}
}
