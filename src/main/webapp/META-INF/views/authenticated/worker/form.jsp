<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<acme:form-textbox code="authenticated.worker.form.label.qualificationsRecord" path="qualificationsRecord"/>
	<acme:form-textbox code="authenticated.worker.form.label.skillsRecord" path="skillsRecord"/>
	<acme:form-hidden path="id"/>
	<acme:form-return code="authenticated.worker.form.button.return"/>
	<acme:form-submit test="${command == 'create'}" code="authenticated.worker.form.button.create" action="/authenticated/worker/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.worker.form.button.update" action="/authenticated/worker/update"/>
		
</acme:form>

