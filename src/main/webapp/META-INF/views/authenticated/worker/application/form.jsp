<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.application.form.label.referenceNumber" path="referenceNumber"/>
	<acme:form-moment code="authenticated.application.form.label.moment" path="moment"/>
	<acme:form-textbox code="authenticated.application.form.label.status" path="status"/>
	<acme:form-textbox code="authenticated.application.form.label.statement" path="statement"/>
	<acme:form-textbox code="authenticated.application.form.label.skills" path="skills"/>
	<acme:form-textbox code="authenticated.application.form.label.qualifications" path="qualifications"/>
	
	<acme:form-return code="authenticated.application.form.button.return"/>
</acme:form>

