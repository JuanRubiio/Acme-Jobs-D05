<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<acme:form-textbox code="anonymous.garciabulletin.form.label.bulletinName" path="bulletinName"/>
	<acme:form-textbox code="anonymous.garciabulletin.form.label.name" path="name"/>
	<acme:form-textbox code="anonymous.garciabulletin.form.label.surname" path="surname"/>
	<acme:form-textbox code="anonymous.garciabulletin.form.label.dni" path="dni"/>
	<acme:form-select code="anonymous.garciabulletin.form.label.type" path="type">
		<acme:form-option code="Manager" value="MANAGER" selected="true"/>
		<acme:form-option code="Analyst" value="ANALYST" />
		<acme:form-option code="Developer" value="Developer" selected="true"/>
	</acme:form-select>
	<acme:form-textarea code="anonymous.garciabulletin.form.label.body" path="body"/>
	<acme:form-submit code="anonymous.garciabulletin.form.button.create" action="/anonymous/garcia-bulletin/create"/>
	<acme:form-return code="anonymous.garciabulletin.form.button.return"/>
</acme:form>
