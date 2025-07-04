<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<div class="grid_10 prefix_1 suffix_1 alpha omega">
	<div class="grid_10">
		<c:url var="createUrl" value="/dealer/dealtemplates/create" />
		<p>
			<a href="${createUrl}">&#43; Create Deal Template</a>
		</p>
	</div>
	<c:url var="listUrl" value="/dealer/dealtemplates" />
	<form:form action="${listUrl}" modelAttribute="dealTemplateForm"
		method="post">
		<div class="grid_10 alpha omega">
			<jsp:include page="../../_notification.jsp" />
		</div>
		<div id="tblContents" class="grid_10 alpha omega">
			<div id="tblHeader" class="grid_10 alpha omega">
				<div class="grid_3 alpha">
					<p>
						<strong>Template Name</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Type</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong><s:message code="dealTemplate.createdBy" /></strong>
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
						<strong>Delete</strong>
					</p>
				</div>
			</div>
			<div class="clear"></div>
			<div id="tblBody" class="grid_10 alpha omega">
				<c:forEach var="dealTemplate"
					items="${dealTemplateForm.dealTemplates}" varStatus="status">
					<div class="grid_10 alpha omega tblRow">
						<div class="grid_3 alpha">
							<p>${dealTemplate.templateName}</p>
						</div>
						<div class="grid_2">
							<p>
								<tags:ucfirst value="${dealTemplate.type}" />
							</p>
						</div>
						<div class="grid_2">
							<p>${dealTemplate.createdBy}</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<a
									href="<c:url value="/dealer/dealtemplates/info/${dealTemplate.id}" />">view</a>
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<c:url var="updateUrl" value="/dealer/dealtemplates/update">
									<c:param name="pk">${dealTemplate.id}</c:param>
								</c:url>
								<a href="${updateUrl}">edit</a>
							</p>
						</div>
						<div class="grid_1 omega">
							<p class="alignCenter">
								<form:checkbox path="checkboxes[${dealTemplate.id}]" />
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<div class="grid_2 prefix_4 suffix_4 alpha omega">
					<p class="alignCenter">
						<s:message var="submitTxt" code="button_submit" />
						<input type="submit" value="${submitTxt}" />
					</p>
				</div>
			</div>
		</div>
	</form:form>
</div>