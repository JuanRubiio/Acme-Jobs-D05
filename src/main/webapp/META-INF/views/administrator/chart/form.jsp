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
<h3>
	 <acme:message code="administrator.chart.totalNumberJobStatus"/>
</h3>
</br>
 <div >
	<canvas id="canvas3" style="height: 370px; width: 100%;"></canvas>
</div> 
<h3>
	 <acme:message code="administrator.chart.totalNumberApplicationStatus"/>
</h3>
</br>
 <div >
	<canvas id="canvas4" style="height: 370px; width: 100%;"></canvas>
</div> 
<h3>
	 <acme:message code="administrator.chart.totalpendingAppFourWeeks"/>
</h3>
</br>
 <div >
	<canvas id="canvas5" style="height: 370px; width: 100%;"></canvas>
</div> 
<h3>
	 <acme:message code="administrator.chart.totalAcceptedAppFourWeeks"/>
</h3>
</br>
 <div >
	<canvas id="canvas6" style="height: 370px; width: 100%;"></canvas>
</div> 
<h3>
	 <acme:message code="administrator.chart.totalRejectedAppFourWeeks"/>
</h3>
</br>
 <div >
	<canvas id="canvas7" style="height: 370px; width: 100%;"></canvas>
</div> 
<acme:form-return code="administrator.announcement.form.button.return"/>
<script type="text/javascript">
	$(document).ready(function(){
		
	
		var data = {
				labels : [
					<jstl:forEach var="t" items="${totalCompanySector}">
						"${t}",
					</jstl:forEach>
				],
				datasets : [
					{
						data: [
							<jstl:forEach var="t" items="${totalNumberCompanySector}">
							"${t}",
							</jstl:forEach>
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
								suggestedMax : 20
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
					labels : [	
						<jstl:forEach var="t" items="${totalInvestorSector}">
						"${t}",
						</jstl:forEach>
						],
					datasets : [
						{
							data: [
								<jstl:forEach var="t" items="${totalNumberInvestorSector}">
								"${t}",
								</jstl:forEach>
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
									suggestedMax : 20
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

		$(document).ready(function(){
			
			var data = {
					labels : [	
						<jstl:forEach var="t" items="${totalJobStatus}">
						"${t}",
						</jstl:forEach>
						],
					datasets : [
						{
							data: [
								<jstl:forEach var="t" items="${totalNumberJobStatus}">
								"${t}",
								</jstl:forEach>
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
									suggestedMax : 20
								}
							}
						]
					},
					legend : {
						display : false
					}
					
					
			};
			var canvas, context;
			
			canvas = document.getElementById("canvas3");
			context = canvas.getContext("2d");
			new Chart(context, {
				type:"bar",
				data: data,
				options: options
			});
			
			
			}); 


$(document).ready(function(){
			
			var data = {
					labels : [	
						<jstl:forEach var="t" items="${totalAppStatus}">
						"${t}",
						</jstl:forEach>
						],
					datasets : [
						{
							data: [
								<jstl:forEach var="t" items="${totalNumberAppStatus}">
								"${t}",
								</jstl:forEach>
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
									suggestedMax : 20
								}
							}
						]
					},
					legend : {
						display : false
					}
					
					
			};
			var canvas, context;
			
			canvas = document.getElementById("canvas4");
			context = canvas.getContext("2d");
			new Chart(context, {
				type:"bar",
				data: data,
				options: options
			});
			
			
			}); 


$(document).ready(function(){
	
	var data = {
			labels : [	
				<jstl:forEach var="t" items="${pendingAppFourWeeks}">
				"${t}",
				</jstl:forEach>
				],
			datasets : [
				{
					data: [
						<jstl:forEach var="t" items="${totalpendingAppFourWeeks}">
						"${t}",
						</jstl:forEach>
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
							suggestedMax : 20
						}
					}
				]
			},
			legend : {
				display : false
			}
			
			
	};
	var canvas, context;
	
	canvas = document.getElementById("canvas5");
	context = canvas.getContext("2d");
	new Chart(context, {
		type:"bar",
		data: data,
		options: options
	});
	
	
	}); 


$(document).ready(function(){
	
	var data = {
			labels : [	
				<jstl:forEach var="t" items="${acceptedAppFourWeeks}">
				"${t}",
				</jstl:forEach>
				],
			datasets : [
				{
					data: [
						<jstl:forEach var="t" items="${totalAcceptedAppFourWeeks}">
						"${t}",
						</jstl:forEach>
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
							suggestedMax : 20
						}
					}
				]
			},
			legend : {
				display : false
			}
			
			
	};
	var canvas, context;
	
	canvas = document.getElementById("canvas6");
	context = canvas.getContext("2d");
	new Chart(context, {
		type:"bar",
		data: data,
		options: options
	});
	
	
	}); 




$(document).ready(function(){
	
	var data = {
			labels : [	
				<jstl:forEach var="t" items="${rejectedAppFourWeeks}">
				"${t}",
				</jstl:forEach>
				],
			datasets : [
				{
					data: [
						<jstl:forEach var="t" items="${totalRejectedAppFourWeeks}">
						"${t}",
						</jstl:forEach>
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
							suggestedMax : 20
						}
					}
				]
			},
			legend : {
				display : false
			}
			
			
	};
	var canvas, context;
	
	canvas = document.getElementById("canvas7");
	context = canvas.getContext("2d");
	new Chart(context, {
		type:"bar",
		data: data,
		options: options
	});
	
	
	}); 




		

</script>