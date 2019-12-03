<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="sponsor.commercialBanner.list.label.slogan" path="slogan" width="30%"/>
	<acme:list-column code="sponsor.commercialBanner.list.label.creditCard" path="creditCard" width="30%"/>
	<acme:list-column code="sponsor.commercialBanner.list.label.monthExpired" path="monthExpired" width="20%"/>
	<acme:list-column code="sponsor.commercialBanner.list.label.yearExpired" path="yearExpired" width="20%"/>
</acme:list>


