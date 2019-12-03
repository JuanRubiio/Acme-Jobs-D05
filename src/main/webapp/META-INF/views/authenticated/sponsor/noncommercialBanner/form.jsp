<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form> 
	<acme:form-textbox code="sponsor.noncommercialBanner.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.noncommercialBanner.form.label.slogan" path="slogan"/>
	<acme:form-url code="sponsor.noncommercialBanner.form.label.target" path="target"/>
	<acme:form-textbox code="sponsor.noncommercialBanner.form.label.jingle" path="jingle"/>
	<acme:form-return code="sponsor.noncommercialBanner.form.button.return"/>
</acme:form>
