<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form> 
	<acme:form-textbox code="sponsor.noncommercialBanner.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.noncommercialBanner.form.label.slogan" path="slogan"/>
	<acme:form-url code="sponsor.noncommercialBanner.form.label.target" path="target"/>
	<acme:form-textbox code="sponsor.noncommercialBanner.form.label.jingle" path="jingle"/>
	<acme:form-submit test="${command == 'show'}" code="sponsor.noncommercialBanner.form.button.update" action="/sponsor/non-commercial-banner/update"/>
	<acme:form-submit test="${command == 'show'}" code="sponsor.noncommercialBanner.form.button.delete" action="/sponsor/non-commercial-banner/delete"/>
	<acme:form-submit test="${command == 'create'}" code="sponsor.noncommercialBanner.form.button.create" action="/sponsor/non-commercial-banner/create"/>
	<acme:form-submit test="${command == 'update'}" code="sponsor.noncommercialBanner.form.button.update" action="/sponsor/non-commercial-banner/update"/>
	<acme:form-submit test="${command == 'delete'}" code="sponsor.noncommercialBanner.form.button.delete" action="/sponsor/non-commercial-banner/delete"/>
	<acme:form-return code="sponsor.noncommercialBanner.form.button.return"/>
</acme:form>
