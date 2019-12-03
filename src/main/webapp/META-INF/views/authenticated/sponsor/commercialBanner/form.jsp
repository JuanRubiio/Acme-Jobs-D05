<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form> 
	<acme:form-textbox code="sponsor.commercialBanner.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.commercialBanner.form.label.slogan" path="slogan"/>
	<acme:form-url code="sponsor.commercialBanner.form.label.target" path="target"/>
	<acme:form-textbox code="sponsor.commercialBanner.form.label.creditCard" path="creditCard"/>
	<acme:form-textbox code="sponsor.commercialBanner.form.label.monthExpired" path="monthExpired"/>
	<acme:form-textbox code="sponsor.commercialBanner.form.label.yearExpired" path="yearExpired"/>
	<acme:form-textbox code="sponsor.commercialBanner.form.label.CVV" path="CVV"/>
	<acme:form-return code="sponsor.commercialBanner.form.button.return"/>
</acme:form>
