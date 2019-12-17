
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
	<acme:list-column code="authenticated.threaduser.list.label.username" path="username" />
</acme:list>




<acme:form>
<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread-user/list?id=${param.id}');
	redirect('/authenticated/user-account/list-non-included?threadId=${param.id}')" class="btn btn-primary">
	<acme:message code="authenticated.threaduser.list.button.NonIncludedUsers"/>
</button>
<acme:form-return code="authenticated.threaduser.list.button.return" />
</acme:form>


