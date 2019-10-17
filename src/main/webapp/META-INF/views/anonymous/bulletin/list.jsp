<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list readonly="true">
	<acme:list-column code="anonymous.bulletin.list.label.bulletinName" path="bulletinName" width="30%"/>
	<acme:list-column code="anonymous.bulletin.list.label.type" path="type" width="20%"/>
	<acme:list-column code="anonymous.bulletin.list.label.body" path="body" width="50%"/>
</acme:list>


