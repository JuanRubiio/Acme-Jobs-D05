<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="authenticated.employer.worker.list.label.fullName" path="fullName" width="50%"/>
	<acme:list-column code="authenticated.employer.worker.list.label.userName" path="userName" width="20%"/>
	<acme:list-column code="authenticated.employer.worker.list.label.email" path="email" width="30%"/>
</acme:list>
<acme:form>
	<acme:form-return code="authenticated.employer.worker.form.button.return"/>
</acme:form>