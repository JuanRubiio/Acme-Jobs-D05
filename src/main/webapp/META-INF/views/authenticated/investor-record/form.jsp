<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.investorRecord.form.label.nameInvestor" path="nameInvestor"/>
	<acme:form-moment code="authenticated.investorRecord.form.label.sector" path="sector"/>
	<acme:form-moment code="authenticated.investorRecord.form.label.investingStatement" path="investingStatement"/>
	<acme:form-money code="authenticated.investorRecord.form.label.stars" path="stars"/>

<%-- 	<acme:form-submit code="authentication.investorRecord.create" action="/authenticated/investorRecord/create"/>
		 --%>
		 
	<acme:form-submit test="${command == 'show'}" code="authenticated.investorRecord.form.button.update" action="/authenticated/investorRecord/update"/>
	<acme:form-submit test="${command == 'show'}" code="authenticated.investorRecord.form.button.delete" action="/authenticated/investorRecord/delete"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.investorRecord.form.button.create" action="/authenticated/investorRecord/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.investorRecord.form.button.update" action="/authenticated/investorRecord/update"/>
	<acme:form-submit test="${command == 'delete'}" code="authenticated.investorRecord.form.button.delete" action="/authenticated/investorRecord/delete"/>
	
  	<acme:form-return code="authenticated.investorRecord.form.button.return"/>
</acme:form>

