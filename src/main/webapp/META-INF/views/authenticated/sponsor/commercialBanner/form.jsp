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
	<acme:form-submit test="${command == 'show'}" code="sponsor.commercialBanner.form.button.update" action="/sponsor/commercial-banner/update"/>
	<acme:form-submit test="${command == 'show'}" code="sponsor.commercialBanner.form.button.delete" action="/sponsor/commercial-banner/delete"/>
	<acme:form-submit test="${command == 'create'}" code="sponsor.commercialBanner.form.button.create" action="/sponsor/commercial-banner/create"/>
	<acme:form-submit test="${command == 'update'}" code="sponsor.commercialBanner.form.button.update" action="/sponsor/commercial-banner/update"/>
	<acme:form-submit test="${command == 'delete'}" code="sponsor.commercialBanner.form.button.delete" action="/sponsor/commercial-banner/delete"/>
	<acme:form-return code="sponsor.commercialBanner.form.button.return"/>
</acme:form>
