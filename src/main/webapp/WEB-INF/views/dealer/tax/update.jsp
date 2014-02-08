<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<div class="grid_6">
		<jsp:include page="../../_notification.jsp" />
	</div>
	<c:url var="updateUrl" value="/dealer/defaultSettings/taxes/update" />
	<form:form action="${updateUrl}" modelAttribute="tax" method="post">
		<form:hidden path="id" />
		<div class="grid_2 alpha">
			<p>
				<strong>Profile Name</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="profileName" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Tax Type</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="taxType" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Rate</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="rate" size="4" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Starting Taxable Amount</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="startingTaxableAmt" size="4" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Max Taxable Amount</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="maxTaxableAmt" size="4" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Max Total Tax</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="maxTotalTax" size="4" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Default</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:checkbox path="isDefault" />
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