package com.accenture.ims.service;

import java.util.Date;
import java.util.List;

import com.accenture.ims.business.bean.LoginDetailBean;
import com.accenture.ims.business.bean.NameDateBean;
import com.accenture.ims.business.bean.PaymentBean;
import com.accenture.ims.business.bean.PurchaseBean;
import com.accenture.ims.business.bean.StatusNameDateBean;

public interface IMSService {

	public List<Object[]> showPurchaseDateReport(Date fromDate, Date toDate);

	public PurchaseBean addPurchaseDetails(PurchaseBean bean);

	public LoginDetailBean getDetails();

	public List<Object[]> showNameDateReport(NameDateBean nameDateBean);

	List<PaymentBean> getPaymentBeanByStatus(StatusNameDateBean statusNameDateBean);
}
