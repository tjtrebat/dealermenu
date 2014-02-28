<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="product" items="${products}">
	<div class="grid_2 alpha">
		<p>${product.productName}</p>
	</div>
	<div class="grid_1">
		<p>
			<input type="text" name="productValuesKeyedById[${product.id}]"
				value="${deal.productValuesKeyedById[product.id]}" size="6" />
		</p>
	</div>
	<div class="grid_1 omega">
		<p class="alignCenter">
			<input type="checkbox" name="selectedProducts[${product.id}]"
				<c:if test="${deal.selectedProducts[product.id]}">checked="checked"</c:if> />
		</p>
	</div>
	<div class="clear"></div>
</c:forEach>