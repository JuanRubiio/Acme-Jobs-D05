<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authentication.request.title" path="title"/>
	<acme:form-moment code="authentication.request.moment" path="moment"/>
	<acme:form-moment code="authentication.request.deadline" path="deadline"/>
	<acme:form-money code="authentication.request.descripcion" path="descripcion"/>
	<acme:form-money code="authentication.request.reward" path="reward"/>

<%-- 	<acme:form-submit code="authentication.request.create" action="/authenticated/request/create"/>
		 --%>
  	<acme:form-return code="authentication.request.return"/>
</acme:form>

