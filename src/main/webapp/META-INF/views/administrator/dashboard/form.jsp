<h2>
	<acme:message code="administrator.dashboard.form.title.charts"/>
</h2>

<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function)(){
		var data = {
			labels : [	
				"Sector1" , "Sector2", "Sector3"
			],
			datasets : [
				{
					data : [
						<jstl:out value="${NumberCompaniesSector1}"
						<jstl:out value="${NumberCompaniesSector2}"
						<jstl:out value="${NumberCompaniesSector3}"
					]
					
				}
			]
		
		};
		var options={
			scales: {
				yAxes:[
					{
						ticks:{
							suggestedMin: 0.0,
							suggestedMax: 10.0
							
						}
					}
				]
				
			},
			legend:{
				display: false
			}
	};
	
	var canvas, context;
	
	canvas = document.getElementedById("canvas");
	context = canvas.getContext("2d");
	new Chart(context, {
		type:"bar",
		data: data,
		options: options
	});
	
	
	});


</script>