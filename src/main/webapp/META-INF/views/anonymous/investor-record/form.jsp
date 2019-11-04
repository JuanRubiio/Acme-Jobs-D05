<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.investorRecord.nameInvestor" path="nameInvestor"/>
	<acme:form-moment code="authenticated.investorRecord.sector" path="sector"/>
	<acme:form-moment code="authenticated.investorRecord.investingStatement" path="investingStatement"/>
	<acme:form-money code="authenticated.investorRecord.stars" path="stars"/>

<%-- 	<acme:form-submit code="authentication.investorRecord.create" action="/authenticated/investorRecord/create"/>
		 --%>
  	<acme:form-return code="authenticated.investorRecord.return"/>
</acme:form>

