<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
     <%@ include file="tablemodel.css"%>
     <%@ include file="buttonDesign.css"%>
</style>
<title>Flights</title>
</head>
<body>
	<form name="displayFlights">
		<h3>List of Flights</h3>
		<br>
		<div class="CSSTableGenerator">
		<table>
			<tr>
				<th>Flight Number</th>
				<th>Airplane Type</th>
				<th>Departure City</th>
				<th>Departure Date and Hour</th>
			    <th>Arrival City</th>
			    <th>Arrival Date and Hour</th>
			    <th></th>
			    <th></th>
		    </tr>
		    <c:forEach items="${requestScope.flights}" var="flight">
				<tr>
					<td><c:out value="${flight.id}"/></td>
					<td><c:out value="${flight.airplane_type}"/></td>
					<td><c:out value="${flight.departure_city}"/></td>
					<td><c:out value="${flight.departure_date_hour}"/></td>
					<td><c:out value="${flight.arrival_city}"/></td>
					<td><c:out value="${flight.arrival_date_hour}"/></td>
					<td><a href="${pageContext.request.contextPath}/UpdateFlightController?id=${flight.id}" style="text-decoration: none">Update</a></td>
					<td><a href="${pageContext.request.contextPath}/DeleteFlightController?id=${flight.id}" style="text-decoration: none">Delete</a></td>
				</tr>
		    </c:forEach>       
		</table>
		</div>
	</form>
	<br>
	<div class="btn">
		<a href="${pageContext.request.contextPath}/AddFlightController" style="color: white; text-decoration: none">Add a new flight</a>
	</div>
	<br>
	<div class="btn">
		<a href="${pageContext.request.contextPath}/LogoutController" style="color: white; text-decoration: none">Log out</a>
	</div>
</body>
</html>