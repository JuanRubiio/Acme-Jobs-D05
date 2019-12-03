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
	<acme:form-textbox code="authenticated.threads.form.label.title" path="title" />
	<acme:form-moment code="authenticated.threads.form.label.moment" path="moment"/>
	<acme:form-textbox code="authenticated.threads.form.label.sender" path="sender"/>
	<acme:form-textbox code="authenticated.threads.form.label.recipient" path="recipient"/>
	
	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/message/sender/list?id=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.threads.form.label.message.sender"/>
	</button>	
	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/message/recipient/list?id=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.threads.form.label.message.recipient"/>
	</button>				
	<acme:form-return code="authenticated.threads.form.button.return"/>
</acme:form>
