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
	<acme:form-textbox code="authenticated.auditor.job.form.label.title" path="title" />
	<acme:form-textbox code="authenticated.auditor.job.form.label.reference" path="reference" />
	<acme:form-textbox code="authenticated.auditor.job.form.label.status" path="status" />
	<acme:form-money code="authenticated.auditor.job.form.label.salary" path="salary" />
	<acme:form-moment code="authenticated.auditor.job.form.label.deadline" path="deadline" />

	
	<acme:form-textbox code="authenticated.auditor.job.form.label.description" path="description" />
	
	<acme:menu-suboption code="master.menu.anonymous.listAuditRecords" action="/auditor/audit-record/list-mine?id=${param.id}" />
	<acme:form-return code="authenticated.auditor.job.form.button.return" />
</acme:form>
