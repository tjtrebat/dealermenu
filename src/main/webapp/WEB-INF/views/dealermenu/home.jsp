<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<p>Hello <security:authentication property="principal.username" />!</p>
<div id="formsContent">
	<h2>Home</h2>
	<p>
		See the
		<code>com.dealer_menu.mvc.simple</code>
		package for the @Controller code
	</p>
</div>
<ul>
</ul>