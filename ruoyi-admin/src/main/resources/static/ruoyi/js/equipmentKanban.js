$(function () {
	ceshis1();
	ceshis2();
	ceshis3();
    function ceshis1() {
    	var myChart = echarts.init(document.getElementById('ceshi1'));
    	var option = {
    		    title: {
    		        text: '某站点用户访问来源',
    		        subtext: '纯属虚构',
    		        left: 'center'
    		    },
    		    
    		    tooltip: {
    		        trigger: 'item'
    		    },
    		    legend: {
    		        orient: 'vertical',
    		        left: 'left',
    		    },
    		    series: [
    		        {
    		            name: '访问来源',
    		            type: 'pie',
    		            radius: '50%',
    		            data: [
    		                {value: 1048, name: '搜索引擎'},
    		                {value: 735, name: '直接访问'},
    		                {value: 580, name: '邮件营销'},
    		                {value: 484, name: '联盟广告'},
    		                {value: 300, name: '视频广告'}
    		            ],
    		            emphasis: {
    		                itemStyle: {
    		                    shadowBlur: 10,
    		                    shadowOffsetX: 0,
    		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    		                }
    		            }
    		        }
    		    ]
    		};
    	myChart.setOption(option);
    };
    function ceshis2() {
    	var myChart = echarts.init(document.getElementById('ceshi2'));
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
    };
    function ceshis3() {
    	var myChart = echarts.init(document.getElementById('ceshi3'));
    	var option = {
    		    title: {
    		        text: '世界人口总量',
    		        subtext: '数据来自网络'
    		    },
    		    tooltip: {
    		        trigger: 'axis',
    		        axisPointer: {
    		            type: 'shadow'
    		        }
    		    },
    		    legend: {
    		        data: ['2011年', '2012年']
    		    },
    		    grid: {
    		        left: '3%',
    		        right: '4%',
    		        bottom: '3%',
    		        containLabel: true
    		    },
    		    xAxis: {
    		        type: 'value',
    		        boundaryGap: [0, 0.01]
    		    },
    		    yAxis: {
    		        type: 'category',
    		        data: ['巴西', '印尼', '美国', '印度', '中国', '世界人口(万)']
    		    },
    		    series: [
    		        {
    		            name: '2011年',
    		            type: 'bar',
    		            data: [18203, 23489, 29034, 104970, 131744, 630230]
    		        },
    		        {
    		            name: '2012年',
    		            type: 'bar',
    		            data: [19325, 23438, 31000, 121594, 134141, 681807]
    		        }
    		    ]
    		};
    	myChart.setOption(option);
    };
});