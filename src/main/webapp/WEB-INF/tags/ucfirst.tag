<%@ attribute name="value" type="java.lang.String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
${fn:toUpperCase(fn:substring(value, 0, 1))}${fn:toLowerCase(fn:substring(value, 1, fn:length(value)))}
