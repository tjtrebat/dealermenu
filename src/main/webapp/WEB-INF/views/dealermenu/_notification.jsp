<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<c:if test="${!empty successMsg}">
	<div class="grid_10 ui-widget">
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