<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="authenticated.employer.job.form.label.reference" path="reference" width="25%"/>
	<acme:list-column code="authenticated.employer.job.form.label.title" path="title" width="25%"/>
	<acme:list-column code="authenticated.employer.job.form.label.deadline" path="deadline" width="25%"/>
	<acme:list-column code="authenticated.employer.job.form.label.description" path="description" width="25%"/>
</acme:list>


