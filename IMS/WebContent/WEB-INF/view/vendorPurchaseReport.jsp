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
<title>Vendor Purchase Report</title>
</head>
<body>
	<center>
		VendorPurchase Report

		<sf:form modelAttribute="nameDateBean"
			action="fetchNameDateReport.html" method="post">
			<table border="2">
				<tr>
					<td>Vendor Name: <sf:select path="vendorName">

							<sf:options items="${vendorList}" itemValue="vendorName"
								itemLabel="vendorName" />

						</sf:select></td>

					<td>From date <sf:input path="dateRangeBean.fromDate"
							id="datepicker-1" /></td>
					<td>To date<sf:input path="dateRangeBean.toDate"
							id="datepicker-2" /></td>






				</tr>
			</table>
			<br>
			<input type="submit" value="Search" />
			<br>
			<br>
			<br>

			<c:if test="${not empty purchaseBeanList }">
			
			Address:
			Contact Number:
			Contact person:
			
			<table border="2">
					<tr>
						<th>Material Category</th>
						<th>Material Type</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit</th>
						<th>Price</th>
						<th>Balance</th>
						<th>Purchase Date</th>
					</tr>
					<c:forEach items="${purchaseBeanList}" var="purchaseBean">
						<tr>

							<td><c:out value="${purchaseBean[0]}" /></td>
							<td><c:out value="${purchaseBean[1] }" /></td>
							<td><c:out value="${purchaseBean[2]}" /></td>
							<td><c:out value="${purchaseBean[3]}" /></td>
							<td><c:out value=" ${purchaseBean[4]}" /></td>
							<td><c:out value="${purchaseBean[5]}" /></td>
							<td><c:out value="${purchaseBean[6]}" /></td>
							<td><c:out value="${purchaseBean[7]}" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</sf:form>






	</center>

</body>
</html>