<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<c:url var="approveDealerUrl"
		value="/admin/dealers/awaitingDealers/approve" />
	<form:form method="post" modelAttribute="dealer"
		action="${approveDealerUrl}">
		<div class="grid_6 alpha omega">
			<jsp:include page="../_notification.jsp">
				<jsp:param value="dealer" name="commandName"/>
			</jsp:include>
		</div>
		<div class="grid_2 alpha">
			<p>
				<strong><form:label path="dealerName">
						<s:message code="dealer.dealerName" />
					</form:label></strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>${dealer.dealerName}</p>
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
			<p>${dealer.streetAddress}</p>
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
			<p>${dealer.city}</p>
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
			<p>${dealer.state}</p>
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
			<p>${dealer.zip}</p>
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
			<p>${dealer.mailId}</p>
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
			<p>${dealer.mobile}</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong><form:label path="loginId">
						<s:message code="dealer.loginId" />
					</form:label></strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="loginId" size="30" />
			</p>
		</div>
		<div id="loginAvailable" class="grid_4 push_5 alpha omega">
			<p>
				<span id="user_msg"></span>
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong><form:label path="password">
						<s:message code="security_login_form_password" />
					</form:label></strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:password path="password" size="30" showPassword="true" />
			</p>
		</div>
		<form:hidden path="id" />
		<div class="grid_4 prefix_1 suffix_1 alpha omega">
			<p>
				<input type="submit" value="Approve Dealer" />
				<button id="btn_clear" type="button">Clear</button>
			</p>
		</div>
	</form:form>
</div>
<script type="text/javascript">
	$(function() {
		$("#loginId")
				.keyup(
						function(event) {
							var loginId = $.trim($("#loginId").val());
							if (loginId.length >= 3) {
								$
										.post(
												"<c:url value="/admin/dealers/awaitingDealers/checkAvailability" />",
												{
													"loginId" : loginId
												})
										.done(
												function(data) {
													var obj = $.parseJSON(data);
													$("#user_msg").html(
															obj.message);
													$("#user_msg").attr(
															"class",
															obj.cssClass);
												});
							} else {
								$("#user_msg").html("");
							}
						});
		$("#btn_clear").click(function(event) {
			$("#loginId").val("");
			$("#password").val("");
			$("#user_msg").html("");
			return false;
		});
	});

	
</script>