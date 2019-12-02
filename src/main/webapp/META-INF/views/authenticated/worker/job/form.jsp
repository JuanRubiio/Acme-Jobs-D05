<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">

	<acme:form-textbox code="authenticated.worker.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="authenticated.worker.job.form.label.title" path="title"/>
		<acme:form-select code="authenticated.worker.job.form.label.status" path="status">
		<acme:form-option code="Draft" value="draft" selected="true"/>
		<acme:form-option code="Published" value="published" />
	</acme:form-select>
	<acme:form-moment code="authenticated.worker.job.form.label.deadline" path="deadline"/>
	<acme:form-url code="authenticated.worker.job.form.label.link" path="link"/>
	<acme:form-money code="authenticated.worker.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="authenticated.worker.job.form.label.description" path="description"/>
	<acme:form-checkbox code="authenticated.worker.job.form.label.active" path="active"/>
	
	<acme:form-hidden path="id"/>

<acme:form-return code="authenticated.worker.job.form.button.return"/>

</acme:form>

 