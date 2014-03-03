<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<s:url var="authUrl" value="/static/j_spring_security_check" />
	<form:form method="post" modelAttribute="dealer" action="${authUrl}">
		<div class="grid_6 alpha omega">
			<jsp:include page="_notification.jsp" />
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
				<form:password path="password" id="password" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_4 prefix_2 alpha omega">
			<p>
				<input id="remember_me" name="_spring_security_remember_me"
					type="checkbox" /> <label for="remember_me" class="inline">Remember
					me</label>
			</p>
		</div>
		<div class="grid_2 prefix_2 suffix_2 alpha omega">
			<div class="grid_1 alpha">
				<p>
					<input name="commit" type="submit" value="Login" />
				</p>
			</div>
			<div class="grid_1 omega">
				<p>
					<input type="button" id="clear" value="Clear" />
			</div>
		</div>
	</form:form>
	<div class="grid_6 alpha omega">
		<p class="alignCenter">
			<a href="<c:url value="/registration" />">New Dealer Click Here!</a>
		</p>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$("#username").focus();
		$("#clear").click(function() {
			$("#username").val("");
			$("#password").val("");
		});
	});

	
</script>