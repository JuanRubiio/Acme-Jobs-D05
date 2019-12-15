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

<acme:form readonly="${hasAccess}">

<input name="jobId" id="jobId" type="hidden" value="${param.jobId}"/>

	<acme:form-textbox code="authenticated.auditor.audit-record.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.auditor.audit-record.form.label.moment" path="moment"/>
	
	
	<acme:form-select code="authenticated.auditor.audit-record.form.label.status" path="status">
		<jstl:choose>
			<jstl:when test="${status == 'Published' }">
				<jstl:set var="publishedSelected" value="true" />
			</jstl:when>
			<jstl:otherwise>
				<jstl:set var="publishedSelected" value="false" />
			</jstl:otherwise>
		</jstl:choose>
		<jstl:choose>
			<jstl:when test="${status == 'Draft' }">
				<jstl:set var="draftSelected" value="true" />
			</jstl:when>
			<jstl:otherwise>
				<jstl:set var="draftSelected" value="false" />
			</jstl:otherwise>
		</jstl:choose>
		<acme:form-option code="authenticated.auditor.audit-record.form.label.status.draft" value="Draft" selected="${draftSelected}" />
		<acme:form-option code="authenticated.auditor.audit-record.form.label.status.published" value="Published" selected="${publishedSelected}" />
	</acme:form-select>
	
	
	
<%-- 	<acme:form-textbox code="authenticated.auditor.audit-record.form.label.status" path="status"/> --%>
	
	
	
	
	<acme:form-textarea code="authenticated.auditor.audit-record.form.label.body" path="body"/>
  	
  	<acme:form-return code="authenticated.auditor.audit-record.form.button.return"/>
  	
  	<acme:form-submit test="${command == 'show' and hasAccess == false }" code="authenticated.auditor.audit-record.form.button.update"
	action="/auditor/audit-record/update"/>
	<acme:form-submit test="${command == 'create' }" code="authenticated.auditor.audit-record.form.button.create"
	action="/auditor/audit-record/create"/>
	<acme:form-submit test="${command == 'update' }" code="authenticated.auditor.audit-record.form.button.update"
	action="/auditor/audit-record/update"/>
</acme:form>
