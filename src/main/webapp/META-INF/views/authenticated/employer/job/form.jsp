<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<jstl:out value="authenticated employer job"></jstl:out>

	<acme:form-textbox code="authenticated.employer.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="authenticated.employer.job.form.label.title" path="title"/>
 	<acme:form-select code="authenticated.employer.job.form.label.status" path="status">
		<acme:form-option code="Draft" value="Draft"/>
		<acme:form-option code="Published" value="Published" />
	</acme:form-select>
	<acme:form-moment code="authenticated.employer.job.form.label.deadline" path="deadline"/>
	<acme:form-url code="authenticated.employer.job.form.label.link" path="link"/>
	<acme:form-money code="authenticated.employer.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="authenticated.employer.job.form.label.description" path="description"/>
	
	<jstl:if test="${command != 'create'}">
		<acme:form-checkbox code="authenticated.employer.job.form.label.active" path="active" readonly="true"/>
	</jstl:if>
	<acme:form-hidden path="id"/>

<acme:form-return code="authenticated.employer.job.form.button.return"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.companyrecord.form.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.companyrecord.form.button.delete" action="/employer/job/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.companyrecord.form.button.create" action="/employer/job/create"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.companyrecord.form.button.update" action="/employer/job/update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.companyrecord.form.button.delete" action="/employer/job/delete"/>
<jstl:if test="${command == 'show'}">
	<acme:form-submit code="authenticated.employer.job.form.label.active.duty" action="/employer/duty/list?id=${id}" method="get"/>
	<acme:form-submit code="authenticated.employer.job.form.label.application" action="/employer/application/list?id=${id}" method="get"/>
	<acme:form-submit code="master.menu.anonymous.listAuditRecords" action="/employer/audit-record/list-mine?id=${id}" method="get" />
</jstl:if>	
</acme:form>


	