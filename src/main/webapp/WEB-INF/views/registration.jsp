<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<c:url var="registrationUrl" value="/registration" />
	<form:form action="${registrationUrl}" modelAttribute="dealer"
		method="post">
		<div class="grid_6 alpha omega">
			<jsp:include page="_notification.jsp" />
		</div>
		<div class="grid_2 alpha">
			<p>
				<strong>Dealer Name</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="dealerName" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Street Address</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="streetAddress" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>City</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="city" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>State</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="state" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Zip</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="zip" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>E-mail</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="mailId" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Mobile no.</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="mobile" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 prefix_2 suffix_2 alpha omega">
			<p>
				<input type="submit" value="Submit" />
			</p>
		</div>
	</form:form>
</div>