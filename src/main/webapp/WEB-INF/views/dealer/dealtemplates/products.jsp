<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<form:form commandName="productForm" method="post">
		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
		<div id="tblContents" class="grid_6 alpha omega">
			<div id="tblHeader" class="grid_6 alpha omega">
				<div class="grid_2 alpha">
					<p>
						<strong>Products</strong>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<strong>Provider</strong>
					</p>
				</div>
				<div class="grid_2 omega">
					<p class="alignCenter">
						<strong>Active</strong>
					</p>
				</div>
			</div>
			<div class="clear"></div>
			<div id="tblBody" class="grid_6 alpha omega">
				<c:forEach var="product" items="${productForm.products}">
					<div class="grid_6 alpha omega tblRow">
						<div class="grid_2 alpha">
							<p>${product.productName}</p>
						</div>
						<div class="grid_2">
							<p>${product.provider.providerName}</p>
						</div>
						<div class="grid_2 omega">
							<p class="alignCenter">
								<form:checkbox path="checkboxes[${product.id}]" />
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</c:forEach>
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
		</div>
	</form:form>
</div>