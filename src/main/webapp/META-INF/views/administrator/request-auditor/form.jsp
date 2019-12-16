<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">
	<acme:form-textbox code="administrator.auditor.form.label.userName" path="userName"/>
	<acme:form-textbox code="administrator.auditor.form.label.firm" path="firm"/>	
	<acme:form-textarea code="administrator.auditor.form.label.responsabilityStatement" path="responsabilityStatement"/>	
	<acme:form-submit code="administrator.auditor.form.button.accept" action="/administrator/auditor/accept?id=${id}"/>
	<acme:form-submit code="administrator.auditor.form.button.declined" action="/administrator/request-auditor/declined?id=${id}"/>
	<acme:form-return code="administrator.auditor.form.button.return"/>
</acme:form>
