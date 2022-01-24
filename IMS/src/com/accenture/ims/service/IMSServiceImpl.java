package com.accenture.ims.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ims.business.bean.LoginDetailBean;
import com.accenture.ims.business.bean.NameDateBean;
import com.accenture.ims.business.bean.PaymentBean;
import com.accenture.ims.business.bean.PurchaseBean;
import com.accenture.ims.business.bean.StatusNameDateBean;
import com.accenture.ims.dao.IMSDAOWrapper;

@Service
public class IMSServiceImpl implements IMSService {

	@Autowired
	private IMSDAOWrapper imsDAOWrapper;

	@Override
	public List<Object[]> showPurchaseDateReport(Date fromDate, Date toDate) {
		return imsDAOWrapper.showPurchaseDateReport(fromDate, toDate);
	}

	@Override
	public PurchaseBean addPurchaseDetails(PurchaseBean bean) {
		return imsDAOWrapper.addPurchaseDetails(bean);
	}

	@Override
	public LoginDetailBean getDetails() {
		return imsDAOWrapper.getDetails();
	}

	@Override
	public List<Object[]> showNameDateReport(NameDateBean nameDateBean) {
		return imsDAOWrapper.showNameDateReport(nameDateBean);
	}

	@Override
	public List<PaymentBean> getPaymentBeanByStatus(StatusNameDateBean statusNameDateBean) {

		return imsDAOWrapper.getPaymentBeanByStatus(statusNameDateBean);

	}

}
