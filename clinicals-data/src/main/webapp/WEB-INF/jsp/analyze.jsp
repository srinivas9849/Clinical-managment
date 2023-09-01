<!-- chart.jsp-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Analyze</title>
<link href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet">
	
<style type="text/css">
.chart{
  padding: 20px;
  border: 1px solid black;
  background-color: gray;
 
}


</style>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
window.onload = function() {
 
var dps = [[]];
var chart= [];
 
var xValue;
var yValue;
var text;
var myArray;
//console.log(${dataPointsList});
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
    dps=[[]];

    chart.push(new CanvasJS.Chart("chartContainer"+${loop.index+1}, {
		theme: "light2", // "light1", "dark1", "dark2"
		animationEnabled: true,
		title: {
			text: "${dataPoints.key}" 
		},
		subtitles: [{
			text: "2006 - 2016"
		}],
		axisX: {
			valueFormatString: "YYYY-MM-DD"
		},
		axisY: {
			title: "Volume (in million carats)"
		},
		data: [{
			type: "spline",
			dataPoints: dps[0]
		}]
	}));
    
    
    
	<c:forEach items="${dataPoints.value}" var="dataPoint">
	

	
	    text = "${dataPoint.x}";
	    myArray = text.split("-");
		xValue = new Date(myArray[0],myArray[1],myArray[2]);
		console.log(${dataPoint.x});
		yValue = parseFloat("${dataPoint.y}");
		dps[0].push({
			x : xValue,
			y : yValue
		});		
	</c:forEach>
	chart[${loop.index}].render();
	
</c:forEach> 



 
}
</script>
</head>
<body>
<%@ include file="common/navigation.jspf" %>




	<div class="container">
		<div class=col-xs-md-14>


			<div class="row">
				<div class="col-md-14">





                    <%int i=0; %>

                        <c:forEach var="i" begin="1" end="${dataSize}" step="2" >
						<div class="row">
                                

							
							    <div class="col-md-6 chart">
							    
							    <div id="chartContainer${i}" 
									style="height: 250px"></div>
																		
							    </div>
							 
													
								<div class="col-md-6 chart">
							    <div id="chartContainer${i+1}" 
									style="height: 250px"></div>
									
									
									
							    </div>
							

						</div>
					</c:forEach>





















				</div>





			</div>






		</div>
	</div>

	<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
	<%@ include file="common/footer.jspf"%>

</body>
</html>
