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

<spring:hasBindErrors name="${commandName}">
	<div class="ui-widget">
		<div class="ui-state-error ui-corner-all">
			<div class="notification">
				<div class="notification">
					<p>
						<span class="ui-icon ui-icon-circle-close"></span> <strong>Error:</strong>
					</p>
					<ul class="errorMessages">
						<c:forEach items="${errors.allErrors}" var="error">
							<c:set scope="request" var="errText" value="" />
							<c:forEach items="${error.codes}" var="errorCode">
								<c:if test="${empty errText}">
									<spring:message code="${errorCode}" text="" scope="request"
										var="errText" arguments="${error.arguments}" />
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${!empty errText}">
									<li>${errText}</li>
								</c:when>
								<c:otherwise>
									<li>${error.defaultMessage}</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</spring:hasBindErrors>
