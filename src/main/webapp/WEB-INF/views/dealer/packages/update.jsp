<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<c:url var="updateUrl" value="/dealer/defaultSettings/packages/update" />
	<form:form action="${updateUrl}" modelAttribute="packages"
		method="post">
		<div class="grid_6 alpha omega">
			<jsp:include page="../../_notification.jsp" />
		</div>
		<div class="grid_2 alpha">
			<p>
				<strong>Package Name</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<select name="packageType">
					<option value="0"><s:message
							code="packages.preferredPackageName" /></option>
					<option value="1"><s:message
							code="packages.premiumPackageName" /></option>
					<option value="2"><s:message
							code="packages.valuePackageName" /></option>
					<option value="3"><s:message
							code="packages.economyPackageName" /></option>
				</select>
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 alpha">
			<p>
				<strong>Alternate Language</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<input type="text" name="alternateLanguage" />
			</p>
		</div>
		<div class="clear"></div>
		<div class="grid_2 prefix_2 suffix_2 alpha omega">
			<p>
				<input type="submit" value="Update" />
			</p>
		</div>
	</form:form>
	<div id="tblContents" class="grid_6 alpha omega">
		<div id="tblHeader" class="grid_6 alpha omega">
			<div class="grid_2 alpha">
				<p>
					<strong>Display Order</strong>
				</p>
			</div>
			<div class="grid_2">
				<p>
					<strong>Package Name</strong>
				</p>
			</div>
			<div class="grid_2 omega">
				<p>
					<strong>Alternate Language</strong>
				</p>
			</div>
		</div>
		<div class="clear"></div>
		<div id="tblBody" class="grid_6 alpha omega">
			<div class="grid_6 alpha omega tblRow">
				<div class="grid_2 alpha">
					<p>1</p>
				</div>
				<div class="grid_2">
					<p>
						<s:message code="packages.preferredPackageName" />
					</p>
				</div>
				<div class="grid_2 omega">
					<p>
						<c:choose>
							<c:when test="${empty packages.preferredPackageName}">
								<s:message code="packages.preferredPackageName" />
							</c:when>
							<c:otherwise>
								${packages.preferredPackageName}
							</c:otherwise>
						</c:choose>
					</p>
				</div>
			</div>
			<div class="grid_6 alpha omega tblRow">
				<div class="grid_2 alpha">
					<p>2</p>
				</div>
				<div class="grid_2">
					<p>
						<s:message code="packages.premiumPackageName" />
					</p>
				</div>
				<div class="grid_2 omega">
					<p>
						<c:choose>
							<c:when test="${empty packages.premiumPackageName}">
								<s:message code="packages.premiumPackageName" />
							</c:when>
							<c:otherwise>
								${packages.premiumPackageName}
							</c:otherwise>
						</c:choose>
					</p>
				</div>
			</div>
			<div class="grid_6 alpha omega tblRow">
				<div class="grid_2 alpha">
					<p>3</p>
				</div>
				<div class="grid_2">
					<p>
						<s:message code="packages.valuePackageName" />
					</p>
				</div>
				<div class="grid_2 omega">
					<p>
						<c:choose>
							<c:when test="${empty packages.valuePackageName}">
								<s:message code="packages.valuePackageName" />
							</c:when>
							<c:otherwise>
								${packages.valuePackageName}
							</c:otherwise>
						</c:choose>
					</p>
				</div>
			</div>
			<div class="grid_6 alpha omega tblRow">
				<div class="grid_2 alpha">
					<p>4</p>
				</div>
				<div class="grid_2">
					<p>
						<s:message code="packages.economyPackageName" />
					</p>
				</div>
				<div class="grid_2 omega">
					<p>
						<c:choose>
							<c:when test="${empty packages.economyPackageName}">
								<s:message code="packages.economyPackageName" />
							</c:when>
							<c:otherwise>
								${packages.economyPackageName}
							</c:otherwise>
						</c:choose>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>