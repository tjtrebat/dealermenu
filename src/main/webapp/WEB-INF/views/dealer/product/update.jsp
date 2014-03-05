<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<c:url var="updateUrl" value="/dealer/defaultSettings/products/update" />
	<form:form action="${updateUrl}" modelAttribute="product" method="post">
		<div class="grid_6 alpha omega">
			<jsp:include page="../../_notification.jsp">
				<jsp:param value="product" name="commandName" />
			</jsp:include>
		</div>
		<form:hidden path="id" />
		<div class="grid_6">
			<div class="grid_2 alpha">
				<p>
					<strong><form:label path="productName">
							<s:message code="product.productName" />
						</form:label></strong>
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
					<strong><form:label path="provider">
							<s:message code="product.provider" />
						</form:label></strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:select path="provider">
						<c:forEach items="${providers}" var="provider">
							<option value="${provider.id}"
								<c:if test="${product.provider.id eq provider.id}"> selected="selected"</c:if>>${provider.providerName}</option>
						</c:forEach>
					</form:select>
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong><form:label path="productCategory">
							<s:message code="product.productCategory" />
						</form:label></strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:select path="productCategory">
						<c:forEach items="${productCategories}" var="productCategory">
							<option value="${productCategory.id}"
								<c:if test="${product.productCategory.id eq productCategory.id}"> selected="selected"</c:if>>${productCategory.productCategoryName}</option>
						</c:forEach>
					</form:select>
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong><form:label path="description">
							<s:message code="product.description" />
						</form:label></strong>
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
					<strong><form:label path="maxPrice">
							<s:message code="product.maxPrice" />
						</form:label></strong>
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
					<strong><form:label path="defaultPrice">
							<s:message code="product.defaultPrice" />
						</form:label></strong>
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
					<strong><form:label path="minPrice">
							<s:message code="product.minPrice" />
						</form:label></strong>
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
					<strong><form:label path="cost">
							<s:message code="product.cost" />
						</form:label></strong>
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
					<strong><s:message code="product.isFinance" /></strong><br />
					<form:checkbox path="isLease" />
					<strong><s:message code="product.isLease" /></strong><br />
				</div>
				<div class="grid_2 omega">
					<form:checkbox path="isCash" />
					<strong><s:message code="product.isCash" /></strong><br />
					<form:checkbox path="isBalloon" />
					<strong><s:message code="product.isBalloon" /></strong><br />
				</div>
			</div>
			<div class="clear"></div>
			<div class="grid_2 prefix_2 suffix_2 alpha omega">
				<p class="alignCenter">
					<s:message var="submitTxt" code="button_submit" />
					<input type="submit" value="${submitTxt}" />
				</p>
			</div>
		</div>
	</form:form>
</div>