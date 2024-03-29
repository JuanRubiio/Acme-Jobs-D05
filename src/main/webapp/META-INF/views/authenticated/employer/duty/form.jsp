<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	
	<acme:form-textbox code="authenticated.employer.job.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.employer.job.form.label.percentage" path="percentage" />
	<acme:form-textarea code="authenticated.employer.job.form.label.description" path="description" />
	

	<acme:form-return code="authenticated.employer.job.form.button.return"/>
		<acme:form-submit test="${command == 'show'}" code="administrator.companyrecord.form.button.update" action="/employer/duty/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.companyrecord.form.button.delete" action="/employer/duty/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.companyrecord.form.button.create" action="/employer/duty/create"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.companyrecord.form.button.update" action="/employer/duty/update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.companyrecord.form.button.delete" action="/employer/duty/delete"/>
</acme:form>

 