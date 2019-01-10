<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sprng" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<style type="text/css">
.error {
	color: red
}
</style>
</head>
<body>
	<spring:form action="save" method="post" modelAttribute="employee">
		<sprng:message code="message.empId"/>:<spring:input path="empId" /><spring:errors path="empId" cssClass="error"></spring:errors ><br/>
		<sprng:message code="messages.empName"/>Full Name: <spring:input path="empName" /><spring:errors path="empName" cssClass="error"></spring:errors><br />
		 <sprng:message code="messages.salary"/>Salary: <spring:input path="salary"/><spring:errors path="salary" cssClass="error"></spring:errors><br>
		<input type="submit" value="Submit">
	</spring:form>
</body>
</html>