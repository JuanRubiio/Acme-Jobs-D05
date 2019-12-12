<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<acme:form-textbox code="authenticated.employer.application.form.label.referenceNumber" path="referenceNumber" placeholder="EEEE-JJJJ:WWWW" readonly="true"/>
	<acme:form-select code="authenticated.employer.application.form.label.status" path="status">
		<acme:form-option code="Pending" value="Pending"/>
		<acme:form-option code="Accepted" value="Accepted" />
		<acme:form-option code="Rejected" value="Rejected" />
	</acme:form-select> 
	<acme:form-textbox code="authenticated.employer.application.form.label.statement" path="statement" readonly="true"/>
	<acme:form-textbox code="authenticated.employer.application.form.label.skills" path="skills" readonly="true"/>
	<acme:form-textbox code="authenticated.employer.application.form.label.qualifications" path="qualifications" readonly="true"/>	
	
	<acme:form-textbox code="authenticated.employer.application.form.label.messageRejected" path="messageRejected"/>
	
	
	<acme:form-hidden path="id"/>
	
	<acme:form-return code="authenticated.employer.application.form.button.return"/>
	<acme:form-submit code="authenticated.employer.application.form.label.worker" action="/employer/worker/show?id=${id}" method="get"/>
	<acme:form-submit test="${command == 'show'}" code="authenticated.employer.application.form.button.update" action="/employer/application/update"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.employer.application.form.button.update2" action="/employer/application/update"/>
</acme:form>

