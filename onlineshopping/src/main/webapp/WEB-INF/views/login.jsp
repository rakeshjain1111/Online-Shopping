<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

<title>${contextRoot}-${title}</title>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<%-- <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"> --%>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
<!-- Add custom CSS here -->
<link href="${css}/myapp.css" rel="stylesheet">
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
</head>

<body>

	<div class="wrapper">
		<!--     navbar-->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" id="home" href="${contextRoot}/home">shoppingSite</a>
				</div>
			</div>
		</nav>

		<!-- page Content -->
		<div class="content">
		    <div class="container">
		    
			<!--    This will be displayed if the credentials are wrong -->
			<c:if test = "${not empty message}">
		    	<div class="row">
		          <div class="col-md-offset-3 col-md-6">
		          	<div class="alert alert-danger">${message}</div>
		          </div>
		        </div>
		    </c:if>
		    
		    <c:if test = "${not empty logout}">
		    	<div class="row">
		          <div class="col-md-offset-3 col-md-6">
		          	<div class="alert alert-success">${logout}</div>
		          </div>
		        </div>
		    </c:if>
		    
		    
		       <div class="row">
		          <div class="col-md-offset-3 col-md-6">
		          	<div class="panel panel-primary">
		          		<div class="panel-heading">
		          			<h4>Login</h4>
		          		</div>
		          		<div class="panel-body">
		          		   <form action="${contextRoot}/login" method="post" class="form-horizontal" id="loginForm">
		          		   		
		          		   		<div class="form-group">
		          		   		  <label for="username" class="col-md-4 control-label">Email:</label>
		          		   		  <div class="col-md-8">
		          		   		  	<input type="text" name="username" id="username" class="form-control">
		          		   		  </div>
		          		   		</div>
		          		   		
		          		   		<div class="form-group">
		          		   		  <label for="username" class="col-md-4 control-label">Password:</label>
		          		   		  <div class="col-md-8">
		          		   		  	<input type="password" name="password" id="password" class="form-control">
		          		   		  </div>
		          		   		</div>
		          		   
		          		   			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		          		   
		          		   		<div class="form-group">
		          		   		  <div class="col-md-8 col-md-offset-4">
		          		   		  	<input type="submit" name="Login"  class="btn btn-primary">
		          		   		  </div>
		          		   		</div>
		          		   </form>
		          		</div>
		          	</div>
		          </div>
		       </div>
		    </div>
		
		
		
		
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>


		<!-- JavaScript -->
		<script src="${js}/jquery-1.10.2.js"></script>
		<script src="${js}/bootstrap.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>

