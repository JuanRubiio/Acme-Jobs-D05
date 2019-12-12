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
	<acme:form-textbox code="authenticated.auditor.audit-record.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.auditor.audit-record.form.label.moment" path="moment"/>
	
	
	<acme:form-select code="authenticated.auditor.audit-record.form.label.status" path="status">
		<jstl:choose>
			<jstl:when test="${status == 'PUBLISHED' }">
				<jstl:set var="publishedSelected" value="true" />
			</jstl:when>
			<jstl:otherwise>
				<jstl:set var="publishedSelected" value="false" />
			</jstl:otherwise>
		</jstl:choose>
		<jstl:choose>
			<jstl:when test="${status == 'DRAFT' }">
				<jstl:set var="draftSelected" value="true" />
			</jstl:when>
			<jstl:otherwise>
				<jstl:set var="draftSelected" value="false" />
			</jstl:otherwise>
		</jstl:choose>
		<acme:form-option code="authenticated.auditor.audit-record.form.label.status.published" value="PUBLISHED" selected="${publishedSelected}" />
		<acme:form-option code="authenticated.auditor.audit-record.form.label.status.draft" value="DRAFT" selected="${draftSelected}" />
	</acme:form-select>
	
	
	
<%-- 	<acme:form-textbox code="authenticated.auditor.audit-record.form.label.status" path="status"/> --%>
	
	
	
	
	<acme:form-textarea code="authenticated.auditor.audit-record.form.label.body" path="body"/>
  	
  	<acme:form-return code="authenticated.auditor.audit-record.form.button.return"/>
</acme:form>
