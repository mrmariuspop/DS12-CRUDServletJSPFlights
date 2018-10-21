<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update flight information</title>
</head>
<body>
	<h1>Flight details</h1>
	<form name="updateFlightForm" action="UpdateFlightController" method="post">
		<table>
			<tr>
				<td>Airplane Type</td>
				<td><input type="text" name="airplane_type" value="${requestScope.airplanetype}"/></td>
			</tr>
			<tr>
				<td>Departure City</td>
				<td>
					<select id="departure_city" name="departure_city">
						<option selected value="${dcity}">"${dcity}"</option>
						<c:forEach items="${requestScope.departurecities}" var="city">
							<option value="${city.name}">"${city.name}"</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Departure Date and Hour</td>
				<td><input type="text" name="departure_date" value="${requestScope.departuredh}"/></td>
			</tr>
			<tr>
				<td>Arrival City</td>
				<td>
					<select id="arrival_city" name="arrival_city">
						<option selected value="${acity}">"${acity}"</option>
						<c:forEach items="${requestScope.arrivalcities}" var="city">
							<option value="${city.name}">"${city.name}"</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Arrival Date and Hour</td>
				<td><input type="text" name="arrival_date" value="${requestScope.arrivaldh}"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="update" value="Update flight" /></td>
				<td><input type="submit" name="back" value="Back" /></td>
			</tr>
		</table>
	</form>
</body>
</html>