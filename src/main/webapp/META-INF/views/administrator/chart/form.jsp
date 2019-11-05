<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<h3>
	 <acme:message code="administrator.chart.totalNumberCompanySector"/>
</h3>
</br>
<div>
	<canvas id="canvas1" style="height: 370px; width: 100%;"></canvas>
</div>

<h3>
	 <acme:message code="administrator.chart.totalNumberInvestorSector"/>
</h3>
</br>
 <div >
	<canvas id="canvas2" style="height: 370px; width: 100%;"></canvas>
</div> 
<acme:form-return code="administrator.announcement.form.button.return"/>
<script type="text/javascript">
	$(document).ready(function(){
		
	
		var data = {
				labels : ["Público", "Privado"],
				datasets : [
					{
						data: [
							<jstl:out value="${totalNumberCompanySectorPublic}"/>,
							<jstl:out value="${totalNumberCompanySectorPrivate}"/>,
						]
					}
				]
		};
		var options = {
				scales : {
					yAxes : [
						{
							ticks : {
								suggestedMin : 0,
								suggestedMax : 10
							}
						}
					]
				},
				legend : {
					display : false
				}
				
		};
		var canvas, context;
		
		canvas = document.getElementById("canvas1");
		context = canvas.getContext("2d");
		new Chart(context, {
			type:"bar",
			data: data,
			options: options
		});
		
		
		});

		$(document).ready(function(){
			
			var data = {
					labels : ["Público", "Privado"],
					datasets : [
						{
							data: [
								<jstl:out value="${totalNumberInvestorSectorPublic}"/>,
								<jstl:out value="${totalNumberInvestorSectorPrivate}"/>,
							]
						}
					]
			};
			var options = {
					scales : {
						yAxes : [
							{
								ticks : {
									suggestedMin : 0,
									suggestedMax : 10
								}
							}
						]
					},
					legend : {
						display : false
					}
					
					
			};
			var canvas, context;
			
			canvas = document.getElementById("canvas2");
			context = canvas.getContext("2d");
			new Chart(context, {
				type:"bar",
				data: data,
				options: options
			});
			
			
			}); 
		

</script>