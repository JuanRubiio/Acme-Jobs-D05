<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="administrator.auditor.form.label.userName" path="userName" width="30%"/>	
	<acme:list-column code="administrator.auditor.form.label.firm" path="firm" width="70%"/>
</acme:list>


