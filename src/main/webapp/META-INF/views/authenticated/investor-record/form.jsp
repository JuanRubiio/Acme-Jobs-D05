<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.investorrecord.nameInvestor" path="nameInvestor"/>
	<acme:form-moment code="authenticated.investorrecord.sector" path="sector"/>
	<acme:form-moment code="authenticated.investorrecord.investingStatement" path="investingStatement"/>
	<acme:form-money code="authenticated.investorrecord.stars" path="stars"/>

<%-- 	<acme:form-submit code="authentication.investorrecord.create" action="/authenticated/investorrecord/create"/>
		 --%>
	
  	<acme:form-return code="authenticated.investorrecord.form.button.return"/>
</acme:form>

