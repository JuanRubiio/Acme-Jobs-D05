<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true"> 
	<acme:form-textbox code="administrator.announcement.form.label.title" path="title"/>
	<acme:form-url code="administrator.announcement.form.label.link" path="link"/>
	<acme:form-textarea code="administrator.announcement.form.label.description" path="description"/>
	<acme:form-return code="administrator.announcement.form.button.return"/>
</acme:form>
