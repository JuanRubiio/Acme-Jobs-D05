<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.employer.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="authenticated.employer.job.form.label.title" path="title"/>
 	<%-- 
 	<acme:form-select code="authenticated.employer.job.form.label.status" path="status">
		<acme:form-option code="Draft" value="Draft"/>
		<acme:form-option code="Published" value="Published" />
	</acme:form-select> 
	--%>
	<acme:form-textbox code="authenticated.employer.job.form.label.status" path="status"/>
	<acme:form-moment code="authenticated.employer.job.form.label.deadline" path="deadline"/>
	
	<acme:form-url code="authenticated.employer.job.form.label.link" path="link"/>
	<acme:form-money code="authenticated.employer.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="authenticated.employer.job.form.label.description" path="description"/>
	
	<acme:form-checkbox code="authenticated.employer.job.form.label.active" path="active"/>
	<acme:form-hidden path="id"/>
	
	<acme:form-return code="authenticated.auditor.job.form.button.return" />
	<acme:form-submit code="authenticated.employer.job.form.label.active.duty" action="/auditor/duty/list?id=${id}" method="get"/>
	
	<acme:form-submit code="master.menu.anonymous.listAuditRecords" action="/auditor/audit-record/list-mine?id=${id}" method="get" />
	
	<button type="button" onclick="javascript: pushReturnUrl('/auditor/job/show?id=${id}'); redirect('/auditor/audit-record/create?jobId=${id}')" class="btn btn-primary">
		<acme:message code="master.menu.anonymous.createAuditRecord" />
	</button>
	
	
</acme:form>
