<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list readonly="true">
	<acme:list-column code="anonymous.shout.list.label.moment" patch="moment" width="20%"/>
	<acme:list-column code="anonymous.shout.list.label.author" patch="author" width="20%"/>
	<acme:list-column code="anonymous.shout.list.label.text" patch="text" width="60%"/>
</acme:list>


