package com.accenture.ims.web;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.accenture.ims.business.bean.DateRangeBean;
import com.accenture.ims.business.bean.MaterialCategoryBean;
import com.accenture.ims.business.bean.NameDateBean;
import com.accenture.ims.business.bean.PaymentBean;
import com.accenture.ims.business.bean.PurchaseBean;
import com.accenture.ims.business.bean.StatusNameDateBean;
import com.accenture.ims.service.IMSService;

@Controller
public class PurchaseController {

	@Autowired
	private IMSService imsService;
	@Autowired
	private IMSController imsController;

	@RequestMapping(value = "/loadReport.html", method = RequestMethod.GET)
	public ModelAndView showPurchaseReport() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dateWiseReport");
		mv.addObject("DateRangeBeanObj", new DateRangeBean());
		return mv;
	}

	@RequestMapping(value = "/FetchDateReport.html", method = RequestMethod.POST)
	public ModelAndView showPurchaseReportData(@ModelAttribute("DateRangeBeanObj") DateRangeBean rangeBean) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dateWiseReport");
		List<Object[]> list = imsService.showPurchaseDateReport(rangeBean.getFromDate(), rangeBean.getToDate());
		mv.addObject("PurchaseBeanList", list);
		// date conversion
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String fromdate = simpleDateFormat.format(rangeBean.getFromDate());
		String todate = simpleDateFormat.format(rangeBean.getToDate());

		Object[] dates = { fromdate, todate };
		// date conv end
		mv.addObject("dates", dates);
		return mv;
	}

	@RequestMapping(value = "/addProductDetails.html", method = RequestMethod.POST)
	public ModelAndView addPurchaseDetails(@Valid @ModelAttribute("purchaseBean") PurchaseBean bean,
			BindingResult result) {

		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("purchaseForm");

		} else {
			// Transaction Id generation

			String vendorNm = bean.getVendorName().substring(0, 3);

			MaterialCategoryBean beanFromService = getMaterialCategoryById(bean.getMaterialCategoryId());

			String materialCategory = beanFromService.getCategoryName().substring(0, 3);
			// date conversion
			String pattern = "ddMMyyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(bean.getPurchaseDate());
			System.out.println(date);
			// date conv end

			String randomNo = String.valueOf((int) (Math.random() * ((2000 - 1000) + 1)) + 1000);
			String transactionId = "P_" + vendorNm + "_" + date + "_" + materialCategory + "_" + randomNo;
			// purhase id gen end
			bean.setTransactionId(transactionId.toUpperCase());
			bean.setStatus("Pending");
			PurchaseBean purchaseBean = imsService.addPurchaseDetails(bean);
			mv.setViewName("purchaseSuccess");
			mv.addObject("transactionId", purchaseBean.getTransactionId());

		}
		return mv;
	}

	// Report Name Date
	@RequestMapping(value = "/purchaseReport.html", method = RequestMethod.GET)
	public ModelAndView showNameDateReport() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vendorList", imsController.getVendorNames());
		mv.setViewName("vendorPurchaseReport");
		mv.addObject("nameDateBean", new NameDateBean());
		return mv;
	}

	@RequestMapping(value = "/fetchNameDateReport.html", method = RequestMethod.POST)
	public ModelAndView displayNameDateReport(@ModelAttribute("nameDateBean") NameDateBean nameDateBean) {
		ModelAndView mv = new ModelAndView();

		List<Object[]> reportlist = imsService.showNameDateReport(nameDateBean);

		mv.setViewName("vendorPurchaseReport");
		mv.addObject("vendorList", imsController.getVendorNames());
		mv.addObject("purchaseBeanList", reportlist);
		return mv;
	}

	// end
	public MaterialCategoryBean getMaterialCategoryById(String catId) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<MaterialCategoryBean> responseEntity = rt.getForEntity(
				"http://localhost:7070/project/material/controller/getMaterialCategoryById/" + catId,
				MaterialCategoryBean.class);
		MaterialCategoryBean beanFromService = responseEntity.getBody();
		return beanFromService;

	}

	@RequestMapping(value = "/paymentReport.html", method = RequestMethod.GET)
	public ModelAndView showPaymentReport() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("vendorPaymentHistory");
		mv.addObject("vendorList", imsController.getVendorNames());
		mv.addObject("paymentReportBean", new StatusNameDateBean());
		return mv;
	}

	@RequestMapping(value = "/fetchPaymentReport.html", method = RequestMethod.POST)
	public ModelAndView fetchReportByStatus(
			@ModelAttribute("paymentReportBean") StatusNameDateBean statusNameDateBean) {
		ModelAndView mv = new ModelAndView();

		List<PaymentBean> beanList = imsService.getPaymentBeanByStatus(statusNameDateBean);
		mv.setViewName("vendorPaymentHistory");
		mv.addObject("vendorList", imsController.getVendorNames());
		mv.addObject("paymentBeanList", beanList);
		return mv;
	}

}
