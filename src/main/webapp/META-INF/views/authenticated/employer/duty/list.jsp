<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="authenticated.employer.job.form.label.title" path="title" width="20%"/>	
	<acme:list-column code="authenticated.employer.job.form.label.percentage" path="percentage" width="20%"/>
	<acme:list-column code="authenticated.employer.job.form.label.description" path="description" width="60%"/>
</acme:list>

<acme:form-return code="authenticated.employer.job.form.button.return"/>
