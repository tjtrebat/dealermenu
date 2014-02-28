<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<div class="grid_10 prefix_1 suffix_1 alpha omega">
	<div class="grid_10">
		<jsp:include page="../../_notification.jsp" />
	</div>
	<div class="grid_10">
		<c:url var="createUrl" value="/dealer/defaultSettings/fees/create" />
		<p>
			<a href="${createUrl}">&#43; Add Fees</a>
		</p>
	</div>
	<c:url var="listUrl" value="/dealer/defaultSettings/fees" />
	<form:form action="${listUrl}" modelAttribute="feeForm" method="post">
		<div id="tblContents" class="grid_10 alpha omega">
			<div id="tblHeader" class="grid_10 alpha omega">
				<div class="grid_2 alpha">
					<p>
						<strong>Name</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Display Name</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Default Value</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Active</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Taxable</strong>
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
				<c:forEach var="fee" items="${feeForm.fees}" varStatus="status">
					<div class="grid_10 alpha omega tblRow">
						<div class="grid_2 alpha">
							<p>${fee.feeName}</p>
						</div>
						<div class="grid_2">
							<p>${fee.displayName}</p>
						</div>
						<div class="grid_2">
							<p>${fee.defaultValue}</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<tags:yesorno value="${fee.isActive}" />
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<tags:yesorno value="${fee.isTaxable}" />
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<c:url var="updateUrl"
									value="/dealer/defaultSettings/fees/update/${fee.id}" />
								<a href="${updateUrl}">edit</a>
							</p>
						</div>
						<div class="grid_1 omega">
							<p class="alignCenter">
								<form:checkbox path="checkboxes[${fee.id}]" />
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<div class="grid_2 prefix_4 suffix_4 alpha omega">
					<p class="alignCenter">
						<input type="submit" value="Submit" />
					</p>
				</div>
			</div>
		</div>
	</form:form>
</div>