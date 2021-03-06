<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<style>
  label {
    display: inline-block;
    width: 5em;
  }
  </style>
<script language="JavaScript">
$(function(){
	
	$(document).tooltip();
	chart();
});

function onC(){
	chart();
};

function chart(){
	var title = {
		      text: '城市平均气温'   
		   };
		   var subtitle = {
		      text: 'Source: runoob.com'
		   };
		   var xAxis = {
		      categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
		         'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
		   };
		   var yAxis = {
		      title: {
		         text: 'Temperature (\xB0C)'
		      },
		      plotLines: [{
		         value: 0,
		         width: 1,
		         color: '#808080'
		      }]
		   };   

		   var tooltip = {
		      valueSuffix: '\xB0C'
		   }

		   var legend = {
		      layout: 'vertical',
		      align: 'right',
		      verticalAlign: 'middle',
		      borderWidth: 0
		   };

		   var series =  [
		      {
		         name: 'Tokyo',
		         data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,
		            26.5, 23.3, 18.3, 13.9, 9.6]
		      }, 
		      {
		         name: 'New York',
		         data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8,
		            24.1, 20.1, 14.1, 8.6, 2.5]
		      },
		      {
		         name: 'London',
		         data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 
		            16.6, 14.2, 10.3, 6.6, 4.8]
		      }
		   ];

		   var json = {};

		   json.title = title;
		   json.subtitle = subtitle;
		   json.xAxis = xAxis;
		   json.yAxis = yAxis;
		   json.tooltip = tooltip;
		   json.legend = legend;
		   json.series = series;

		   $('#container').highcharts(json);
}
</script>
</head>

<body>

	折线图 <button class="btn btn-warning animations" onclick="onC()">button</button>

	<a href="#" title="锚描述">tooltip</a><input id="tooltip" type="text" title="We ask for your age only for statistical purposes.">
	<hr>

<div id="container" class="animated flash" style="width: 550px; height: 400px; margin: 0 auto"></div>

</body>

</html>