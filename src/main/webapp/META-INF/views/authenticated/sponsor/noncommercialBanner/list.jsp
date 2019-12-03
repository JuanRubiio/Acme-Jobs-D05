<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="sponsor.noncommercialBanner.list.label.slogan" path="slogan" width="50%"/>
	<acme:list-column code="sponsor.noncommercialBanner.list.label.jingle" path="jingle" width="50%"/>
</acme:list>


