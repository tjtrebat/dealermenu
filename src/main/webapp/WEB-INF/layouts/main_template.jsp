<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<html>
<head>
<title>dealer-menu</title>
<link href="<c:url value="/resources/styles/reset.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/styles/text.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/styles/960.css" />" rel="stylesheet"
	type="text/css" />
<link
	href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.all.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/main.css" />" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
</head>
<body>
	<div id="container" class="container_12">
		<div id="header" class="grid_12">
			<div class="grid_2 alpha">
				<p>
					<img src="<c:url value="/resources/images/FMS.gif" />" alt="FMS" />
				</p>
			</div>
			<div class="grid_8">
				<h1 class="alignCenter">Frederick M. Small Insurance Services</h1>
			</div>
			<div class="grid_2 omega">
				<p id="greeting">
					<security:authorize url="/**">
						<span id="greeting">Hello <security:authentication
								property="principal.username" />!
						</span>
						<br />
						<a href="<c:url value="/static/j_spring_security_logout" />">Logout</a>
					</security:authorize>
				</p>
			</div>
		</div>
		<div class="clear"></div>
		<ul id="main_menu" class="grid_12 alpha omega">
			<security:authorize url="/admin/**">
				<t:insertAttribute name="adminMenu" ignore="true"></t:insertAttribute>
			</security:authorize>
			<security:authorize url="/dealer/**">
				<t:insertAttribute name="dealerMenu" ignore="true"></t:insertAttribute>
			</security:authorize>
		</ul>
		<t:insertAttribute name="subMenu" ignore="true"></t:insertAttribute>
		<div class="clear"></div>
		<div id="content" class="grid_12 alpha omega">
			<security:authorize url="/admin/**">
				<t:insertAttribute name="adminContent" ignore="true"></t:insertAttribute>
			</security:authorize>
			<security:authorize url="/dealer/**">
				<t:insertAttribute name="dealerContent" ignore="true"></t:insertAttribute>
			</security:authorize>
			<t:insertAttribute name="content" ignore="true"></t:insertAttribute>
		</div>
		<div id="footer" class="grid_12 alpha omega">
			<div class="grid_6 prefix_6 alpha omega">
				<p class="alignRight">Frederick M. Small Insurance Services
					&copy; 2014. All rights reserved.</p>
			</div>
		</div>
	</div>
</body>
</html>