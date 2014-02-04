<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<div class="grid_6">
		<jsp:include page="../_notification.jsp" />
	</div>
	<c:url var="createProductUrl"
		value="/dealer/defaultSettings/createProduct" />
	<form:form action="${createProductUrl}" modelAttribute="product"
		method="post">
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
				<form:input path="provider" size="30" />
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
				<form:input path="productCategory" size="30" />
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
				<form:input path="maxPrice" size="30" />
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
				<form:input path="defaultPrice" size="30" />
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
				<form:input path="minPrice" size="30" />
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
				<form:input path="cost" size="30" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_4 push_2 alpha omega">
			<div class="grid_2 alpha">
				<form:checkbox path="isFinance" />
				Finance<br />
				<form:checkbox path="isLease" />
				Lease<br />
			</div>
			<div class="grid_2 omega">
				<form:checkbox path="isCash" />
				Cash<br />
				<form:checkbox path="isBalloon" />
				Balloon<br />
			</div>
		</div>
		<div class="clear"></div>
		<div class="grid_2 prefix_2 suffix_2 alpha omega">
			<p>
				<input type="submit" value="Submit" />
			</p>
		</div>
	</form:form>
</div>