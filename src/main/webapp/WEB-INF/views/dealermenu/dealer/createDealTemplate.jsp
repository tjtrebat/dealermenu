<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<div class="grid_6 prefix_3 suffix_3 alpha omega">
	<c:url var="dealTemplatesUrl" value="/admin/dealers/dealTemplates" />
	<form:form action="${dealTemplatesUrl}" modelAttribute="template"
		method="post">
		<div class="grid_2 alpha">
			<p>
				<strong>Template Name</strong>
			</p>
		</div>
		<div class="grid_4 omega">
			<p>
				<form:input path="templateName" size="30" />
			</p>
		</div>
		<div class="clear"></div>
	</form:form>
</div>