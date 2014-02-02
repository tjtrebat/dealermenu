<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="clear"></div>
<ul id="sub_menu" class="grid_12 alpha omega">
	<li class="grid_2 alpha"><a class="menuLink"
		href="<c:url value="/dealer/defaultSettings/products" />">Products</a></li>
	<li class="grid_2"><a class="menuLink"
		href="<c:url value="/dealer/defaultSettings/packages" />">Packages</a></li>
	<li class="grid_2"><a class="menuLink"
		href="<c:url value="/dealer/defaultSettings/fees" />">Fees</a></li>
	<li class="grid_2"><a class="menuLink"
		href="<c:url value="/dealer/defaultSettings/taxes" />">Taxes</a></li>
	<li class="grid_2"><a class="menuLink"
		href="<c:url value="/dealer/defaultSettings/productCategory" />">Product
			Category</a></li>
	<li class="grid_2 omega"><a class="menuLink"
		href="<c:url value="/dealer/defaultSettings/provider" />">Provider</a></li>
</ul>