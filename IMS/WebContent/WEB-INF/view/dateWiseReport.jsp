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
<title>Date Wise Report</title>
</head>
<body>

	<center>
		<h1 style="background-color: DodgerBlue;">Date wise Purchase
			Report</h1>

		<sf:form modelAttribute="DateRangeBeanObj"
			action="FetchDateReport.html">
			<table border="2">
				<tr>
					<td style="border: 1px DodgerBlue;">From date <sf:input
							path="fromDate" id="datepicker-1" /></td>
					<td style="border: 1px DodgerBlue;">To date<sf:input
							path="toDate" id="datepicker-2" /></td>
				</tr>
			</table>
			<input style="background-color: DodgerBlue;" type="submit"
				value="Search" />
			<br>
			<br>
			<br>

			<c:if test="${not empty PurchaseBeanList }">

				<h4 style="border: 2px DodgerBlue;">Materials purchased between
					${dates[0]} and ${dates[1]}</h4>
				<br>
				<br>
				<table border="2">

					<tr>
						<th style="background-color: DodgerBlue;">Material Category</th>
						<th style="background-color: DodgerBlue;">Material Type</th>
						<th style="background-color: DodgerBlue;">Brand</th>
						<th style="background-color: DodgerBlue;">Quantity</th>
						<th style="background-color: DodgerBlue;">Unit</th>
						<th style="background-color: DodgerBlue;">Price</th>
						<th style="background-color: DodgerBlue;">Status</th>
						<th style="background-color: DodgerBlue;">Vendor</th>
					</tr>
					<c:forEach items="${PurchaseBeanList}" var="itr">
						<tr>
							<td><c:out value="${itr[0]}" /></td>
							<td><c:out value="${itr[1]}" /></td>
							<td><c:out value="${itr[2]}" /></td>
							<td><c:out value="${itr[3]}" /></td>
							<td><c:out value="${itr[4]}" /></td>
							<td><c:out value="${itr[5]}" /></td>
							<td><c:out value="${itr[6]}" /></td>
							<td><c:out value="${itr[7]}" /></td>
							<%-- <td><c:out value="${itr.quantity }"/></td>
						<td><c:out value="${itr.purchaseAmount }"/></td>
						<td><c:out value="${itr.status }"/></td>
						<td><c:out value="${itr.vendorName }"/></td> --%>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</sf:form>






	</center>

</body>
</html>