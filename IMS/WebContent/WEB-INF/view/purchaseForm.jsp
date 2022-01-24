<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Form</title>
<style type="text/css">
.error {
	color: red;
}
</style>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">


	function loadTypeAndUnit(categoryId) {
		
		document.forms["purchaseForm"].action = "getTypeAndUnit.html";
		document.forms["purchaseForm"].method = "POST";
		document.forms["purchaseForm"].submit();
		//location.href="getTypeAndUnit.html?categoryId="+categoryId;
       
	}
	$(function() {
		$("#datepicker").datepicker();
		$("#datepicker").datepicker("show");

	});
</script>
</head>
<body>
	<center>
		Materials Purchased Entry

		<sf:form modelAttribute="purchaseBean" action="addProductDetails.html"
			method="post" name="purchaseForm">
			<table>
				<tr>
					<th>Vendor Name</th>
					<td><sf:select path="vendorName">
                          <sf:option value="">--Select--</sf:option>
							<sf:options items="${vendorList}" itemValue="vendorName"
								itemLabel="vendorName" />

						</sf:select></td>
				</tr>

				<tr>
					<th>Material Category</th>
					<td><sf:select path="materialCategoryId"
							onchange="loadTypeAndUnit(categoryId.value)" id="categoryId">
  <sf:option value="">--Select--</sf:option>
							<sf:options items="${categoryList}" itemValue="categoryId"
								itemLabel="categoryName" />

						</sf:select></td>
				</tr>
				<c:if test="${typeList!=null}">
					<tr>
						<th>Material Type</th>
						<td><sf:select path="materialTypeId">

								<sf:options items="${typeList}" itemValue="typeId"
									itemLabel="typeName" />

							</sf:select></td>
					</tr>

					<tr>
						<th>Brand Name</th>
						<td><sf:input path="brandName" /></td>
					</tr>

					<tr>
						<th>Unit</th>
						<td><sf:select path="unitId">

								<sf:options items="${unitList}" itemValue="unitId"
									itemLabel="unitName" />

							</sf:select></td>
					</tr>

					<tr>
						<th>Quantity</th>
						<td><sf:input path="quantity" /></td>
					</tr>

					<tr>
						<th>Purchase Amount</th>
						<td><sf:input path="purchaseAmount" /></td>
					</tr>

					<tr>
						<th>Purchase Date</th>
						<td><sf:input path="purchaseDate"   id="datepicker"/></td>
					</tr>
				</c:if>
			</table>
			<%-- <c:if test="${not empty transactionId}">
				<h3>
					Purchase Details saved Successfully with Transaction Id:<span
						style="color: green;">${transactionId}</span>
				</h3>
			</c:if> --%>
			<input type="submit" value="Submit">
			<spring:hasBindErrors name="purchaseBean">
				<h3>ALL Errors</h3>
				<sf:errors path="*" cssClass="error" />
			</spring:hasBindErrors>
		</sf:form>

	</center>
</body>
</html>