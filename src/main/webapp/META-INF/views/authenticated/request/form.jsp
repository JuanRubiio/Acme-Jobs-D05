<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.request.title" path="title"/>
	<acme:form-moment code="authenticated.request.moment" path="moment"/>
	<acme:form-moment code="authenticated.request.deadline" path="deadline"/>
	<acme:form-money code="authenticated.request.text" path="text"/>
	<acme:form-money code="authenticated.request.reward" path="reward"/>

<%-- 	<acme:form-submit code="authentication.request.create" action="/authenticated/request/create"/>
		 --%>
  	<acme:form-return code="authenticated.investorRecord.return"/>
</acme:form>

