<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

<spring:bind path="*">
	<c:if test="${status.error}">
		<div class="ui-widget">
			<div class="ui-state-error ui-corner-all">
				<div class="notification">
					<div class="notification">
						<p>
							<span class="ui-icon ui-icon-circle-close"></span> <strong>Error:</strong>
						</p>
						<ul class="errorMessages">
							<c:forEach items="${status.errorMessages}" var="error">
								<li>${error}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</c:if>
</spring:bind>