<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/backpage" style="margin-left: 1100px">Back To Home Page</a>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<br/><b><h1>Searched result:</h1></b><br/><br/>
<c:forEach var="key" items="${key}">
${key}<br/>
</c:forEach>
		

</body>
</html>