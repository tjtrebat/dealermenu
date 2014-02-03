<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<div class="grid_10 prefix_1 suffix_1 alpha omega">
	<div class="grid_10">
		<jsp:include page="../_notification.jsp" />
	</div>
	<c:url var="deleteDealersUrl" value="/admin/dealers/deniedDealers" />
	<form:form action="${deleteDealersUrl}" method="post"
		modelAttribute="dealerForm">
		<div id="tblContents" class="grid_10">
			<div id="tblHeader" class="grid_10 alpha omega">
				<div class="grid_7 alpha">
					<p>
						<strong>Dealer Name</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Details</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Approve</strong>
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
				<c:forEach var="dealer" items="${dealerForm.dealers}"
					varStatus="status">
					<div class="grid_10 alpha omega tblRow">
						<div class="grid_7 alpha">
							<p>${dealer.dealerName}</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<a href="<c:url value="/admin/dealers/${dealer.id}" />">view</a>
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<c:url var="approveDealerUrl"
									value="/admin/dealers/awaitingDealers/approve">
									<c:param name="pk">${dealer.id}</c:param>
								</c:url>
								<a href="${approveDealerUrl}">approve</a>
							</p>
						</div>
						<div class="grid_1 omega">
							<p class="alignCenter">
								<input type="checkbox" name="dealers[${status.index}].id"
									value="${dealer.id}" />
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<div class="grid_2 prefix_4 suffix_4 alpha omega">
					<p>
						<input type="submit" value="Submit" />
					</p>
				</div>
			</div>
		</div>
	</form:form>
</div>