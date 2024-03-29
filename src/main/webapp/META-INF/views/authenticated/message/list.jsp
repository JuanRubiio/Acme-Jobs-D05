
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
	<acme:list-column code="authenticated.message.list.label.title" path="title" width="15%"/>
	<acme:list-column code="authenticated.message.list.label.sender" path="sender"  width="15%"/>
	<acme:list-column code="authenticated.message.form.label.thread" path="thread"  width="15%"/>
	<acme:list-column code="authenticated.message.list.label.tags" path="tags"  width="15%"/>
	<acme:list-column code="authenticated.message.list.label.moment" path="moment"  width="40%"/>
</acme:list>

<jstl:if test="${send == 'true'}">
	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/message/sender/list?id=${param.id}'); redirect('/authenticated/message/sender/create?threadId=${param.id}')" class="btn btn-primary">
			<acme:message code="authenticated.message.form.button.post" />
		</button>
</jstl:if>
		
<acme:form-return code="authenticated.message.form.button.return"/>


