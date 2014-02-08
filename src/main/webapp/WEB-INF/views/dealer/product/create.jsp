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
	<c:url var="createUrl" value="/dealer/defaultSettings/products/create" />
	<form:form action="${createUrl}" modelAttribute="product" method="post">
		<div class="grid_6">
			<div class="grid_2 alpha">
				<p>
					<strong>Product Name</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="productName" size="30" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Provider</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:select path="provider" items="${providers}" itemValue="id"
						itemLabel="providerName" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Product Category</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:select path="productCategory" items="${productCategories}"
						itemValue="id" itemLabel="productCategoryName" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Description</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="description" size="30" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Maximum Price</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="maxPrice" size="5" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Default Price</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="defaultPrice" size="5" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Minimum Price</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="minPrice" size="5" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Cost</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="cost" size="5" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_4 prefix_1 suffix_1 alpha omega">
				<div class="grid_2 alpha">
					<form:checkbox path="isFinance" />
					<strong>Finance</strong><br />
					<form:checkbox path="isLease" />
					<strong>Lease</strong><br />
				</div>
				<div class="grid_2 omega">
					<form:checkbox path="isCash" />
					<strong>Cash</strong><br />
					<form:checkbox path="isBalloon" />
					<strong>Balloon</strong><br />
				</div>
			</div>
			<div class="clear"></div>
			<div class="grid_2 prefix_2 suffix_2 alpha omega">
				<p class="alignCenter">
					<input type="submit" value="Submit" />
				</p>
			</div>
		</div>
	</form:form>
</div>