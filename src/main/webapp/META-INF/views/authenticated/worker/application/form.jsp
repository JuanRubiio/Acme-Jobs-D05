<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<acme:form-textbox code="authenticated.worker.application.form.label.referenceNumber" path="referenceNumber" placeholder="EEEE-JJJJ:WWWW"/>
<%-- 	<acme:form-select code="authenticated.worker.application.form.label.status" path="status">
		<acme:form-option code="Pending" value="pending"/>
		<acme:form-option code="Accepted" value="accepted" />
		<acme:form-option code="Rejected" value="rejected" />
	</acme:form-select> --%>
	<acme:form-textbox code="authenticated.worker.application.form.label.statement" path="statement"/>
	<acme:form-textbox code="authenticated.worker.application.form.label.skills" path="skills"/>
	<acme:form-textbox code="authenticated.worker.application.form.label.qualifications" path="qualifications"/>
	<acme:form-hidden path="id"/>
	
	
	<acme:form-return code="authenticated.worker.application.form.button.return"/>
	<acme:form-submit test="${command == 'create'}" code="authenticated.worker.application.form.button.create" action="/worker/application/create"/>
	
</acme:form>

