<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>

<c:if test="${!empty successMsg}">
	<div class="ui-widget">
		<div class="ui-state-highlight ui-corner-all">
			<p class="notification">
				<span class="ui-icon ui-icon-circle-check"></span> <strong>Success!</strong>
				${successMsg}
			</p>
		</div>
	</div>
	<div class="clear"></div>
	<c:remove var="successMsg" scope="session" />
</c:if>

<c:set var="formErrors">
	<form:errors path="*" />
</c:set>
<c:if test="${!empty formErrors}">
	<div class="ui-widget">
		<div class="ui-state-error ui-corner-all">
			<p class="notification">
				<span class="ui-icon ui-icon-circle-close"></span> <strong>Error:</strong>
				<form:errors path="*" />
			</p>
		</div>
	</div>
	<div class="clear"></div>
</c:if>