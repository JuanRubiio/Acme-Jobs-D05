<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.employer.worker.form.label.fullName" path="fullName"/>
	<acme:form-textbox code="authenticated.employer.worker.form.label.userName" path="userName"/>
	<acme:form-textbox code="authenticated.employer.worker.form.label.email" path="email"/>
	<acme:form-textbox code="authenticated.employer.worker.form.label.qualificationsRecord" path="qualificationsRecord"/>
	<acme:form-moment code="authenticated.employer.worker.form.label.skillsRecord" path="skillsRecord"/>
	<acme:form-return code="authenticated.employer.worker.form.button.return"/>
</acme:form>

