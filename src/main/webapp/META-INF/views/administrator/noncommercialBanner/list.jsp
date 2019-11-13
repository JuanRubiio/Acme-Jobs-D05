<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="administrator.noncommercialBanner.list.label.slogan" path="slogan" width="30%"/>
	<acme:list-column code="administrator.noncommercialBanner.list.label.jingle" path="jingle" width="30%"/>
</acme:list>


