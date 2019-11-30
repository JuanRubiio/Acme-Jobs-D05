<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">

	<acme:form-textbox code="authenticated.employer.job.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.employer.job.form.label.percentage" path="percentage" />
	<acme:form-textarea code="authenticated.employer.job.form.label.description" path="description" />
	
	<acme:form-return code="authenticated.employer.job.form.button.return"/>
</acme:form>

 