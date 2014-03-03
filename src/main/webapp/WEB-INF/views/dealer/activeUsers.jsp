<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<s:url var="activeUsersUrl" value="/dealer/activeUsers" />
	<form:form method="post" modelAttribute="dealer"
		action="${activeUsersUrl}">
		<div class="grid_6 alpha omega">
			<jsp:include page="../_notification.jsp" />
		</div>
		<div class="grid_2 alpha">
			<p class="alignRight">
				<label for="username">Username</label>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="loginId" id="username" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p class="alignRight">
				<label for="password">Password</label>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:password path="password" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 prefix_2 suffix_2 alpha omega">
			<p class="alignCenter">
				<input type="submit" value="Check availability" />
			</p>
		</div>
	</form:form>
</div>
<script type="text/javascript">
	$(function() {
		$("#username").focus();
	});

	
</script>