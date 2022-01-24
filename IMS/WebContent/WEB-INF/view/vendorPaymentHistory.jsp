<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	 href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker-1").datepicker();   
		$("#datepicker-1").datepicker("show");
		$("#datepicker-2").datepicker();
		$("#datepicker-2").datepicker("show");
	});
</script>
<title>Vendor Payment History</title>
</head>
<body>
	<center>
		Vendor Payment History

		<sf:form modelAttribute="paymentReportBean"
			action="fetchPaymentReport.html" method="post">
			<table border="2">
				<tr>
					<td>Vendor Name<sf:select path="nameDateBean.vendorName">

							<sf:options items="${vendorList}" itemValue="vendorName"
								itemLabel="vendorName" />

						</sf:select></td>
					<td>Payment Status <sf:select path="status">
							<sf:option value="Pending">Pending</sf:option>
							<sf:option value="Paid">Paid</sf:option>
						</sf:select>
					</td>
					<td>From date <sf:input
							path="nameDateBean.dateRangeBean.fromDate" id="datepicker-1" /></td>
					<td>To date<sf:input path="nameDateBean.dateRangeBean.toDate"
							id="datepicker-2" /></td>
				</tr>


			</table>
			<br>
			<input type="submit" value="Search" />
			<br>
			<br>
			<br>

			<c:if test="${not empty paymentBeanList }">

				<table border="2">
					<tr>
						<th>Purchase Id</th>
						<th>Paid Id</th>
						<th>Paid Type</th>
						<th>Cheque No</th>
						<th>Paid Date</th>
						<th>Paid Amount</th>
						<th>Balance</th>
						<th>Remarks</th>
					</tr>
					<c:forEach items="${paymentBeanList}" var="bean">
						<tr>
							<td><c:out value="${bean.purchaseId}" /></td>
							<td><c:out value="${bean.paidId}" /></td>
							<td><c:out value="${bean.paidType}" /></td>
							<td><c:out value="${bean.chequeNo}" /></td>
							<td><c:out value="${bean.paidDate}" /></td>
							<td><c:out value="${bean.paidAmount}" /></td>
							<td><c:out value="${bean.balance} " /></td>
							<td><c:out value=" ${bean.remarks}" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</sf:form>






	</center>

</body>
</html>