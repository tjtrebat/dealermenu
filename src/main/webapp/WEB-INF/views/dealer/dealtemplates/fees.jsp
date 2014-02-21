<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<div class="grid_8 prefix_2 suffix_2 alpha omega">
	<form:form commandName="feeForm" method="post">
		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
		<div id="tblContents" class="grid_8">
			<div id="tblHeader" class="grid_8 alpha omega">
				<div class="grid_2 alpha">
					<p>
						<strong>Fee Name</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Display Name</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Default Value</strong>
					</p>
				</div>
				<div class="grid_2 omega">
					<p class="alignCenter">
						<strong>Included</strong>
					</p>
				</div>
			</div>
			<div class="clear"></div>
			<div id="tblBody" class="grid_8 alpha omega">
				<c:forEach var="fee" items="${feeForm.fees}">
					<c:if test="${fee.isActive}">
						<div class="grid_8 alpha omega tblRow">
							<div class="grid_2 alpha">
								<p>${fee.feeName}</p>
							</div>
							<div class="grid_2">
								<p>${fee.displayName}</p>
							</div>
							<div class="grid_2">
								<p>${fee.defaultValue}</p>
							</div>
							<div class="grid_2 omega">
								<p class="alignCenter">
									<form:checkbox path="checkboxes[${fee.id}]" />
								</p>
							</div>
						</div>
						<div class="clear"></div>
					</c:if>
				</c:forEach>
				<div class="grid_6 prefix_1 suffix_1 alpha omega">
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
		</div>
	</form:form>
</div>