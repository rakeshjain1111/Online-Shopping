<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
     <spring:url value="/resources/css/" var="css"></spring:url>
     <spring:url value="/resources/js/" var="js"></spring:url>
     <spring:url value="/resources/img/" var="img"></spring:url>
     <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> ${contextRoot} -${title}</title>

    <!-- Bootstrap core CSS -->
   <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	    <!--     navbar-->
		<%@include file="./shared/navbar.jsp" %>
   		
   		
	    <!-- page Content -->
	 <c:if test="${userClickHome==true }">
		<%@include file="home.jsp" %>
	</c:if>
	
	 <c:if test="${userClickAbout==true }">
		<%@include file="about.jsp" %>
	</c:if>
	
	 <c:if test="${userClickContact==true }">
		<%@include file="contact.jsp" %>
	</c:if>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp" %>

    <!-- JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

</body>

</html>
    
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>online shopping</title>
</head>
<body>
  ${contextRoot} says-  ${greeting}
</body>
</html> --%>