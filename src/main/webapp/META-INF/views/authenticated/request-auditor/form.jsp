<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textarea code="authenticated.auditor.form.label.firm" path="firm"/>
	<acme:form-textarea code="authenticated.auditor.form.label.responsabilityStatement" path="responsabilityStatement"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.auditor.form.button.create" action="/authenticated/request-auditor/create"/>
	
	<acme:form-return code="authenticated.auditor.form.button.return"/>
	
</acme:form>
