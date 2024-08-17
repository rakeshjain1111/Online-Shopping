<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
     <spring:url value="/resources/css/" var="css"></spring:url>
     <spring:url value="/resources/js/" var="js"></spring:url>
     <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">

	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title> Online Shopping -${title}</title>
	    <!-- Bootstrap core CSS -->
	   <link href="${css}/bootstrap.css" rel="stylesheet">
	   <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
	   <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
	    <!-- Add custom CSS here -->
	    <link href="${css}/myapp.css" rel="stylesheet">
		
	</head>

<body>
	<div class="wrapper">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" id="home" href="${contextRoot}/home">Home</a>
            </div>
        </div>
    </nav>
        <div class="content">
	    <div class="container">
	      <div class="row">
	      	<div class="col-xs-12">
	      	
	      	<div class="jumbotron">
	      		<h1>${errorTitle}</h1>
	      		<hr/>
	      		<blockquote style="word-wrap:break-word">
	      		  ${errorDescription}
	      		</blockquote>
	      	</div>
	      	
	      	</div>
	      </div>
	    </div>
    </div>
	</div>
   		
   		
    <!-- page Content -->

    
	
		<!-- Footer -->
		<%@include file="./shared/footer.jsp" %>
    
           
    <!-- JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap.js"></script>
    <script src="${js}/myapp.js"></script>

</body>

</html>
    
