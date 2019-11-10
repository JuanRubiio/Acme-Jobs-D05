<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.companyrecord.form.label.name" path="name"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.sector" path="sector"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.ceoName" path="ceoName"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.webSite" path="webSite"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.phone" path="phone"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.email" path="email"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.incorporated" path="incorporated"/>
	<acme:form-textbox code="authenticated.companyrecord.form.label.stars" path="stars"/>
	<acme:form-textarea code="authenticated.companyrecord.form.label.description" path="description"/>
	

<%-- 	<acme:form-submit code="authentication.offer.create" action="/authenticated/offer/create"/>
 --%>
	<acme:form-submit test="${command == 'show'}" code="authenticated.companyrecord.form.button.update" action="/authenticated/companyrecord/update"/>
	<acme:form-submit test="${command == 'show'}" code="authenticated.companyrecord.form.button.delete" action="/authenticated/companyrecord/delete"/> 
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.companyrecord.form.button.create" action="/authenticated/companyrecord/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.companyrecord.form.button.update" action="/authenticated/companyrecord/update"/>
	<acme:form-submit test="${command == 'delete'}" code="authenticated.companyrecord.form.button.delete" action="/authenticated/companyrecord/delete"/>
		
  	<acme:form-return code="authenticated.companyrecord.form.button.return"/>
  	
</acme:form>
