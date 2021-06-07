$(function () {
	ceshis1();
    function ceshis1() {
    	var myChart = echarts.init(document.getElementById('ceshi1'));
    	var option = {
    	    xAxis: {
    	        type: 'category',
    	        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    	    },
    	    yAxis: {
    	        type: 'value'
    	    },
    	    series: [{
    	        data: [120, 200, 150, 80, 70, 110, 130],
    	        type: 'bar'
    	    }]
    	};
    	myChart.setOption(option);
    }
});