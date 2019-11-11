
<%--
- list.jsp
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

<acme:list>
	<acme:list-column code="authenticated.companyrecord.name" path="name" width="10%"/>
	<acme:list-column code="authenticated.companyrecord.sector" path="sector" width="10%"/>	
	<acme:list-column code="authenticated.companyrecord.ceoName" path="ceoName" width="10%"/>	
	<acme:list-column code="authenticated.companyrecord.webSite" path="webSite" width="10%"/>	
	<acme:list-column code="authenticated.companyrecord.phone" path="phone" width="10%"/>
	<acme:list-column code="authenticated.companyrecord.email" path="email" width="10%"/>	
	<acme:list-column code="authenticated.companyrecord.incorporated" path="incorporated" width="10%"/>		
	<acme:list-column code="authenticated.companyrecord.stars" path="stars" width="10%"/>		
	<acme:list-column code="authenticated.companyrecord.description" path="description" width="20%"/>	
</acme:list>




