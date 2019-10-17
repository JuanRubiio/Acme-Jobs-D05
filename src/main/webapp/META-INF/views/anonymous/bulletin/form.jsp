<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<acme:form-textbox code="anonymous.bulletin.form.label.name" path="name"/>
	<acme:form-textbox code="anonymous.bulletin.form.label.surname" path="surname"/>
	<acme:form-textbox code="anonymous.bulletin.form.label.dni" path="dni"/>
	<acme:form-select code="anonymous.bulletin.form.label.type" path="type">
		<acme:form-option code="Manager" value="MANAGER" selected="true"/>
		<acme:form-option code="Analyst" value="ANALYST" />
		<acme:form-option code="Developer" value="Developer" selected="true"/>
	</acme:form-select>
	<acme:form-textarea code="anonymous.bulletin.form.label.body" path="body"/>
	<acme:form-submit code="anonymous.bulletin.form.button.create" action="/anonymous/bulletin/create"/>
	<acme:form-return code="anonymous.bulletin.form.button.return"/>
</acme:form>
