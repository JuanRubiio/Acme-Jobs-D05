<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">

	<acme:form-textbox code="authenticated.employer.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="authenticated.employer.job.form.label.title" path="title"/>
		<acme:form-select code="authenticated.employer.job.form.label.status" path="status">
		<acme:form-option code="Draft" value="draft" selected="true"/>
		<acme:form-option code="Published" value="published" />
	</acme:form-select>
	<acme:form-moment code="authenticated.employer.job.form.label.deadline" path="deadline"/>
	<acme:form-url code="authenticated.employer.job.form.label.link" path="link"/>
	<acme:form-money code="authenticated.employer.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="authenticated.employer.job.form.label.description" path="descriptor.description"/>
	<acme:form-checkbox code="authenticated.employer.job.form.label.active" path="active"/>
	
		<jstl:forEach var="t" items="descriptor.duties">
			<acme:form-textbox code="authenticated.employer.job.form.label.title" path="t.title"/>
			<acme:form-textbox code="authenticated.employer.job.form.label.description" path="t.description"/>
			<acme:form-textbox code="authenticated.employer.job.form.label.percentage" path="t.percentage"/>
		
		</jstl:forEach> 
	

<acme:form-return code="authenticated.employer.job.form.button.return"/>
</acme:form>

 