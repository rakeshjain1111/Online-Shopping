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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>${contextRoot}-${title}</title>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
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
		<%@include file="./shared/navbar.jsp"%>


		<!-- page Content -->
		<div class="content">
			<c:if test="${userClickHome==true }">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout==true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact==true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<c:if test="${userClickShowProduct==true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<c:if test="${userClickManageProducts==true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>

		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>


		<!-- JavaScript -->
		<script src="${js}/jquery-1.10.2.js"></script>
		<script src="${js}/bootstrap.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/bootbox.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>

