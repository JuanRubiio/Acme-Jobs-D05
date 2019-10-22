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

<acme:form>
	<acme:form-textbox code="anonymous.jimenezbulletin.list.label.bulletinName" path="bulletinName"/>
	<acme:form-textbox code="anonymous.jimenezbulletin.form.label.name" path="name"/>
	<acme:form-textbox code="anonymous.jimenezbulletin.form.label.surname" path="surname"/>
	<acme:form-textbox code="anonymous.jimenezbulletin.form.label.nif" path="nif" />
	<acme:form-select code="anonymous.jimenezbulletin.form.label.type" path="type">
			<acme:form-option code="Manager" value="MANAGER" selected="true"/>
			<acme:form-option code="Analyst" value="ANALYST"/>
			<acme:form-option code="Developed" value="DEVELOPED"/>		
	</acme:form-select>		
	<acme:form-textarea code="anonymous.jimenezbulletin.form.label.body" path="body" />
	

	<acme:form-submit code="anonymous.jimenezbulletin.form.button.create" action="/anonymous/jimenez-bulletin/create"/>

		
  	<acme:form-return code="anonymous.jimenezbulletin.form.button.return"/>
</acme:form>
