<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<c:url var="createDealerUrl" value="/admin/dealers/createDealer" />
	<form:form action="${createDealerUrl}" modelAttribute="dealer"
		method="post">
		<div class="grid_6 alpha omega">
			<jsp:include page="../_notification.jsp">
				<jsp:param value="dealer" name="commandName" />
			</jsp:include>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong><form:label path="dealerName">
						<s:message code="dealer.dealerName" />
					</form:label></strong>
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
				<strong><form:label path="streetAddress">
						<s:message code="dealer.streetAddress" />
					</form:label></strong>
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
				<strong><form:label path="city">
						<s:message code="dealer.city" />
					</form:label></strong>
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
				<strong><form:label path="state">
						<s:message code="dealer.state" />
					</form:label></strong>
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
				<strong><form:label path="zip">
						<s:message code="dealer.zip" />
					</form:label></strong>
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
				<strong><form:label path="mailId">
						<s:message code="dealer.mailId" />
					</form:label></strong>
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
				<strong><form:label path="mobile">
						<s:message code="dealer.mobile" />
					</form:label></strong>
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
				<s:message var="submitTxt" code="button_submit" />
				<input type="submit" value="${submitTxt}" />
			</p>
		</div>
	</form:form>
</div>