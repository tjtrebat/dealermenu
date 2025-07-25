<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<html>
<head>
<link href="<c:url value="/resources/styles/reset.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/text.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/960.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.all.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/main.css" />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<s:message code="application_name" var="app_name" htmlEscape="false" />
<title><s:message code="welcome_h3" arguments="${app_name}" /></title>
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
					<security:authorize access="isAuthenticated()">
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
			<t:insertAttribute name="menu" ignore="true" />
		</ul>
		<t:insertAttribute name="subMenu" ignore="true" />
		<div class="clear"></div>
		<div id="content" class="grid_12 alpha omega">
			<t:insertAttribute name="content" ignore="true" />
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