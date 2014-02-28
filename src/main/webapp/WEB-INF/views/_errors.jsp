<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
</c:if>
<div class="clear"></div>