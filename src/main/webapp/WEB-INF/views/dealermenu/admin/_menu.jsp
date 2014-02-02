<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<li class="grid_3 alpha"><a class="menuLink"
	href="<c:url value="/admin/dealers/activeDealers" />">Active
		Dealers</a></li>
<li class="grid_3"><a class="menuLink"
	href="<c:url value="/admin/dealers/awaitingDealers" />">Awaiting
		Dealers</a></li>
<li class="grid_3"><a class="menuLink"
	href="<c:url value="/admin/dealers/deniedDealers" />">Denied
		Dealers</a></li>
<li class="grid_3 omega"><a class="menuLink"
	href="<c:url value="/admin/dealers/createDealer" />">Create Dealer</a></li>