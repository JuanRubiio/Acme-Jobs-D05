
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

<acme:list readonly="true">
	<acme:list-column code="authenticated.user-account.list.label.username" path="username" />
</acme:list>
<acme:form readonly="false">
	<acme:form-select readonly="false" path="idUserAccount" code="authenticated.user-account.form.select">

		<jstl:forEach var= "var" begin="${0}" end = "${model$size-1}">
			<jstl:set var="var1" value="id[${var}]" />
			<jstl:set var="var2" value="username[${var}]" />
			<acme:form-option code="${requestScope[var2]}" value="${requestScope[var1]}" />
		</jstl:forEach>
	
	
	      </acme:form-select>
	<!--  <button type="button" onclick="javascript: pushReturnUrl('/authenticated/authenticated/list-non-included?threadId=${param.threadId}');
	redirect('/authenticated/user-thread/create?threadId=${param.threadId}')" class="btn btn-primary">
	<acme:message code="authenticated.userThread.list.button.createIncludedUsers"/>
	</button>    -->  
	
	
	<acme:form-submit code="authenticated.thread-user.list.button.createIncludedUsers" action="/authenticated/thread-user/create?threadId=${param.threadId}"/>
	
	<acme:form-return code="authenticated.user-account.list.button.return"/>
	
</acme:form>
	



