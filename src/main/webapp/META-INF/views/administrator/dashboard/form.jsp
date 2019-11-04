<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true"> 
	<acme:form-textbox code="administrator.totalNumberCompanyRecords" path="totalNumberCompanyRecords"/>
	<acme:form-return code="administrator.announcement.form.button.return"/>
</acme:form>
