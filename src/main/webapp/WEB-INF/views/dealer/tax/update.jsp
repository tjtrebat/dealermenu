<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<c:url var="updateUrl" value="/dealer/defaultSettings/taxes/update" />
	<form:form action="${updateUrl}" modelAttribute="tax" method="post">
		<div class="grid_6 alpha omega">
			<jsp:include page="../../_notification.jsp" />
		</div>
		<form:hidden path="id" />
		<div class="grid_2 alpha">
			<p>
				<strong><form:label path="profileName">
						<s:message code="tax.profileName" />
					</form:label></strong>
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
				<strong><form:label path="taxType">
						<s:message code="tax.taxType" />
					</form:label></strong>
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
				<strong><form:label path="rate">
						<s:message code="tax.rate" />
					</form:label></strong>
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
				<strong><form:label path="startingTaxableAmt">
						<s:message code="tax.startingTaxableAmt" />
					</form:label></strong>
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
				<strong><form:label path="tax.maxTaxableAmt">
						<s:message code="tax.maxTaxableAmt" />
					</form:label></strong>
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
				<strong><form:label path="maxTotalTax">
						<s:message code="tax.maxTotalTax" />
					</form:label></strong>
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
				<strong><form:label path="isDefault">
						<s:message code="tax.isDefault" />
					</form:label></strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:checkbox path="isDefault" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 prefix_2 suffix_2 alpha omega">
			<p class="alignCenter">
				<s:message var="submitTxt" code="button_submit" />
				<input type="submit" value="${submitTxt}" />
			</p>
		</div>
		<div class="clear"></div>
	</form:form>
</div>