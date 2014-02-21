<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<div class="grid_6">
		<jsp:include page="../../_notification.jsp" />
	</div>
	<div class="grid_6">
		<c:url var="createUrl" value="/dealer/defaultSettings/taxes/create" />
		<p>
			<a href="${createUrl}">&#43; Add Taxes</a>
		</p>
	</div>
	<c:url var="listUrl" value="/dealer/defaultSettings/taxes" />
	<form:form action="${listUrl}" modelAttribute="taxForm" method="post">
		<div id="tblContents" class="grid_6">
			<div id="tblHeader" class="grid_6 alpha omega">
				<div class="grid_2 alpha">
					<p>
						<strong>Profile Name</strong>
					</p>
				</div>
				<div class="grid_2">
					<p class="alignCenter">
						<strong>Default Profile</strong>
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
			<div id="tblBody" class="grid_6 alpha omega">
				<c:forEach var="tax" items="${taxForm.taxes}" varStatus="status">
					<div class="grid_6 alpha omega tblRow">
						<div class="grid_2 alpha">
							<p>${tax.profileName}</p>
						</div>
						<div class="grid_2">
							<p class="alignCenter">
								<tags:yesorno value="${tax.isDefault}" />
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<c:url var="updateUrl"
									value="/dealer/defaultSettings/taxes/update/${tax.id}" />
								<a href="${updateUrl}">edit</a>
							</p>
						</div>
						<div class="grid_1 omega">
							<p class="alignCenter">
								<form:checkbox path="checkboxes[${tax.id}]" />
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<div class="grid_2 prefix_2 suffix_2 alpha omega">
					<p class="alignCenter">
						<input type="submit" value="Submit" />
					</p>
				</div>
			</div>
		</div>
	</form:form>
</div>