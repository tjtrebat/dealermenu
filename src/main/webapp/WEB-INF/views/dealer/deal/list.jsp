<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<div class="grid_8 prefix_2 suffix_2 alpha omega">
	<div class="grid_8">
		<c:url var="createUrl" value="/dealer/deals/create" />
		<form:form action="${createUrl}" modelAttribute="dealTemplateForm"
			method="post">
			<div class="grid_8 alpha omega">
				<jsp:include page="../../_notification.jsp" />
			</div>
			<form:select path="dealTemplates" multiple="false">
				<c:forEach var="dealTemplate"
					items="${dealTemplateForm.dealTemplates}">
					<option value="${dealTemplate.id}">${dealTemplate.templateName}</option>
				</c:forEach>
			</form:select>
			<input type="submit" value="Create Deal" />
		</form:form>
	</div>
	<c:url var="listUrl" value="/dealer/deals" />
	<form:form action="${listUrl}" modelAttribute="dealForm" method="post">
		<div id="tblContents" class="grid_8 alpha omega">
			<div id="tblHeader" class="grid_8 alpha omega">
				<div class="grid_2 alpha">
					<p>
						<strong> <s:message code="deal.buyerName" />
						</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Deal Type</strong>
					</p>
				</div>
				<div class="grid_1">
					<p>
						<strong>Status</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>View</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Edit</strong>
					</p>
				</div>
				<div class="grid_1 omega">
					<p class="alignCenter">
						<strong>Select</strong>
					</p>
				</div>
			</div>
			<div class="clear"></div>
			<div id="tblBody" class="grid_8 alpha omega">
				<c:forEach var="deal" items="${dealForm.deals}">
					<div class="grid_8 alpha omega tblRow">
						<div class="grid_2 alpha">
							<p>${deal.buyerName}</p>
						</div>
						<div class="grid_2">
							<p>
								<tags:ucfirst value="${deal.dealTemplate.type}" />
							</p>
						</div>
						<div class="grid_1">
							<p>
								<c:choose>
									<c:when test="${deal.isSigned}">Signed</c:when>
									<c:otherwise>Unsigned</c:otherwise>
								</c:choose>
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<c:url var="reportUrl" value="/dealer/deals/report">
									<c:param name="pk">${deal.id}</c:param>
								</c:url>
								<a href="${reportUrl}">view</a>
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<c:url var="updateUrl" value="/dealer/deals/update/${deal.id}" />
								<a href="${updateUrl}">edit</a>
							</p>
						</div>
						<div class="grid_1 omega">
							<p class="alignCenter">
								<form:checkbox path="checkboxes[${deal.id}]" />
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<div class="grid_2 prefix_3 suffix_3 alpha omega">
					<p class="alignCenter">
						<s:message var="submitTxt" code="button_submit" />
						<input type="submit" value="${submitTxt}" />
					</p>
				</div>
			</div>
		</div>
	</form:form>
</div>