<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="administrator.investorrecord.nameInvestor" path="nameInvestor"/>
	
	<acme:form-select code="administrator.investorrecord.sector" path="sector">
			<acme:form-option code="Público" value="Público" selected="true"/>
			<acme:form-option code="Privado" value="Privado"/>
	</acme:form-select>	
	
	<acme:form-moment code="administrator.investorrecord.investingStatement" path="investingStatement" />
	
	<acme:form-money code="administrator.investorrecord.stars" path="stars"/>

		 
	<acme:form-submit test="${command == 'show'}" code="administrator.investorrecord.form.button.update" action="/administrator/investor-record/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.investorrecord.form.button.delete" action="/administrator/investor-record/delete"/>
	
	<acme:form-submit test="${command == 'create'}" code="administrator.investorrecord.form.button.create" action="/administrator/investor-record/create"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.investorrecord.form.button.update" action="/administrator/investor-record/update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.investorrecord.form.button.delete" action="/administrator/investor-record/delete"/>
	
  	<acme:form-return code="administrator.investorrecord.form.button.return"/>
</acme:form>

