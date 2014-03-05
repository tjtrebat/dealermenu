<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<c:url var="updateUrl" value="/dealer/defaultSettings/fees/update" />
	<form:form action="${createUrl}" modelAttribute="fee" method="post">
		<div class="grid_6 alpha omega">
			<jsp:include page="../../_notification.jsp">
				<jsp:param value="fee" name="commandName" />
			</jsp:include>
		</div>
		<form:hidden path="id" />
		<div class="grid_6">
			<div class="grid_2 alpha">
				<p>
					<strong>Fee Name</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="feeName" size="30" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Display Name</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="displayName" size="30" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Default Value (USD)</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="defaultValue" size="4" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Active</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:checkbox path="isActive" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Taxable</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:checkbox path="isTaxable" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 prefix_2 suffix_2 alpha omega">
				<p class="alignCenter">
					<input type="submit" value="Submit" />
				</p>
			</div>
		</div>
	</form:form>
</div>