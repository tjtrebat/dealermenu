<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_10 prefix_1 suffix_1 alpha omega">
	<jsp:include page="../_notification.jsp" />
	<c:url var="dealTemplatesUrl" value="/admin/dealers/dealTemplates" />
	<form:form action="${dealTemplatesUrl}" modelAttribute="templateForm"
		method="post">
		<div id="tblContents" class="grid_10">
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
						<strong>Created By</strong>
					</p>
				</div>
				<div class="grid_1">
					<p>
						<strong>View</strong>
					</p>
				</div>
				<div class="grid_1">
					<p>
						<strong>Edit</strong>
					</p>
				</div>
				<div class="grid_1 omega">
					<p>
						<strong>Delete</strong>
					</p>
				</div>
			</div>
			<div class="clear"></div>
			<div id="tblBody" class="grid_10 alpha omega">
				<c:forEach var="template" items="${templateForm.templates}"
					varStatus="status">
					<div class="grid_10 alpha omega tblRow">
						<div class="grid_3 alpha">
							<p>${template.templateName}</p>
						</div>
						<div class="grid_2">
							<p>${template.type}</p>
						</div>
						<div class="grid_2">
							<p>${template.createdBy}</p>
						</div>
						<div class="grid_1">
							<p>
								<a href="<c:url value="/dealer/dealTemplates/${template.id}" />">view</a>
							</p>
						</div>
						<div class="grid_1">
							<p>
								<a href="#">edit</a>
							</p>
						</div>
						<div class="grid_1 omega">
							<p>
								<input type="checkbox" name="templates[${status.index}].id"
									value="${template.id}" />
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