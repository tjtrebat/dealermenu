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
	<c:url var="createUrl"
		value="/dealer/defaultSettings/productCategory/create" />
	<form:form action="${createUrl}" modelAttribute="productCategory"
		method="post">
		<div class="grid_6">
			<div class="grid_2 alpha">
				<p class="alignRight">
					<strong>Product Category Name</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="productCategoryName" size="30" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_6 alpha omega">
				<p class="alignCenter">
					<input type="submit" value="Add" />
				</p>
			</div>
		</div>
		<div class="clear"></div>
	</form:form>
	<c:url var="listUrl" value="/dealer/defaultSettings/productCategory" />
	<form:form action="${listUrl}" modelAttribute="productCategoryForm"
		method="post">
		<div id="tblContents" class="grid_6">
			<div id="tblHeader" class="grid_6 alpha omega">
				<div class="grid_4 alpha">
					<p>
						<strong>Product Category</strong>
					</p>
				</div>
				<div class="grid_2 omega">
					<p class="alignCenter">
						<strong>Delete</strong>
					</p>
				</div>
			</div>
			<div class="clear"></div>
			<div id="tblBody" class="grid_6 alpha omega">
				<c:forEach var="productCategory"
					items="${productCategoryForm.productCategories}" varStatus="status">
					<div class="grid_6 alpha omega tblRow">
						<div class="grid_4 alpha">
							<p>${productCategory.productCategoryName}</p>
						</div>
						<div class="grid_2 omega">
							<p class="alignCenter">
								<input name="productCategories[${status.index}].id"
									value="${productCategory.id}" type="checkbox" />
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