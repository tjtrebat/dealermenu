<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<div id="products" class="grid_12 alpha omega">
	<div class="grid_12">
		<c:url var="createUrl" value="/dealer/defaultSettings/products/create" />
		<p>
			<a href="${createUrl}">&#43; Add Product</a>
		</p>
	</div>
	<c:url value="/dealer/defaultSettings/products" var="listUrl" />
	<form:form action="${listUrl}" modelAttribute="productForm"
		method="post">
		<div class="grid_12 alpha omega">
			<jsp:include page="../../_notification.jsp" />
		</div>
		<div id="tblContents" class="grid_12 alpha omega">
			<div id="tblHeader" class="grid_12 alpha omega">
				<div class="grid_2 alpha">
					<p>
						<strong>Product Name</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Provider</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Category</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Finance</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Cash</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Lease</strong>
					</p>
				</div>
				<div class="grid_1">
					<p class="alignCenter">
						<strong>Balloon</strong>
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
			<div id="tblBody" class="grid_12 alpha omega">
				<c:forEach var="product" items="${productForm.products}"
					varStatus="status">
					<div class="grid_12 alpha omega tblRow">
						<div class="grid_2 alpha">
							<p>${product.productName}</p>
						</div>
						<div class="grid_2">
							<p>${product.provider.providerName}</p>
						</div>
						<div class="grid_2">
							<p>${product.productCategory.productCategoryName}</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<tags:yesorno value="${product.isFinance}" />
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<tags:yesorno value="${product.isCash}" />
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<tags:yesorno value="${product.isLease}" />
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<tags:yesorno value="${product.isBalloon}" />
							</p>
						</div>
						<div class="grid_1">
							<p class="alignCenter">
								<c:url var="updateUrl"
									value="/dealer/defaultSettings/products/update/${product.id}" />
								<a href="${updateUrl}">edit</a>
							</p>
						</div>
						<div class="grid_1 omega">
							<p class="alignCenter">
								<form:checkbox path="checkboxes[${product.id}]" />
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
				<div class="grid_2 prefix_5 suffix_5 alpha omega">
					<p class="alignCenter">
						<input type="submit" value="Delete" />
					</p>
				</div>
			</div>
		</div>
	</form:form>
</div>