<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<form:form commandName="dealTemplate" method="post">
		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
		<div class="grid_6">
			<div class="grid_2 alpha">
				<p>
					<strong>Deal Template Name</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="templateName" size="30" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Deal Type</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:select path="type">
						<c:forEach var="dealType" items="${dealTypes}">
							<option value="${dealType}"
								<c:if test="${dealType eq dealTemplate.type}">selected</c:if>>${fn:toUpperCase(fn:substring(dealType, 0, 1))}${fn:toLowerCase(fn:substring(dealType, 1, 50))}</option>
						</c:forEach>
					</form:select>
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_2 alpha">
				<p>
					<strong>Created By</strong>
				</p>
			</div>
			<div class="grid_4 omega">
				<p>
					<form:input path="createdBy" size="30" />
				</p>
			</div>
			<div class="clear"></div>
			<div class="grid_4 prefix_1 suffix_1 alpha omega">
				<p class="alignCenter">
					<s:message var="proceed" code="button_proceed" htmlEscape="false" />
					<input type="submit" id="success" name="_eventId_success"
						value="${fn:escapeXml(proceed)}" />
					<s:message var="cancel" code="button_cancel" htmlEscape="false" />
					<input type="submit" id="cancel" name="_eventId_cancel"
						value="${fn:escapeXml(cancel)}" />
				</p>
			</div>
		</div>
	</form:form>
</div>