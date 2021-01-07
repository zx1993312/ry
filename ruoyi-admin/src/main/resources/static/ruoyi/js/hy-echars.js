// 基于准备好的dom，初始化echarts实例
var myChartBt = echarts.init(document.getElementById('echarsBt'));

// 指定图表的配置项和数据
var optionBt = {
	tooltip : {
		trigger : 'item',
		formatter : '{a} <br/>{b}: {c} ({d}%)'
	},
	legend : {
		orient : 'vertical',
		left : 10,
		data : [ '直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎' ]
	},
	series : [ {
		name : '访问来源',
		type : 'pie',
		radius : [ '50%', '70%' ],
		avoidLabelOverlap : false,
		label : {
			show : false,
			position : 'center'
		},
		emphasis : {
			label : {
				show : true,
				fontSize : '30',
				fontWeight : 'bold'
			}
		},
		labelLine : {
			show : false
		},
		data : [ {
			value : 335,
			name : '直接访问'
		}, {
			value : 310,
			name : '邮件营销'
		}, {
			value : 234,
			name : '联盟广告'
		}, {
			value : 135,
			name : '视频广告'
		}, {
			value : 1548,
			name : '搜索引擎'
		} ]
	} ]
};

// 使用刚指定的配置项和数据显示图表。
myChartBt.setOption(optionBt);

// 基于准备好的dom，初始化echarts实例
var myChartLine = echarts.init(document.getElementById('echarsLine'));
var colors = [ '#5793f3', '#d14a61', '#675bba' ];
var optionLine = {
	color : colors,

	tooltip : {
		trigger : 'none',
		axisPointer : {
			type : 'cross'
		}
	},
	legend : {
		data : [ '2020 降水量', '2021 降水量' ]
	},
	grid : {
		top : 70,
		bottom : 50
	},
	xAxis : [
			{
				type : 'category',
				axisTick : {
					alignWithLabel : true
				},
				axisLine : {
					onZero : false,
					lineStyle : {
						color : colors[1]
					}
				},
				axisPointer : {
					label : {
						formatter : function(params) {
							return '降水量  '
									+ params.value
									+ (params.seriesData.length ? '：'
											+ params.seriesData[0].data : '');
						}
					}
				},
				data : [ '2020-1', '2020-2', '2020-3', '2020-4', '2020-5',
						'2020-6', '2020-7', '2020-8', '2020-9', '2020-10',
						'2020-11', '2020-12' ]
			},
			{
				type : 'category',
				axisTick : {
					alignWithLabel : true
				},
				axisLine : {
					onZero : false,
					lineStyle : {
						color : colors[0]
					}
				},
				axisPointer : {
					label : {
						formatter : function(params) {
							return '降水量  '
									+ params.value
									+ (params.seriesData.length ? '：'
											+ params.seriesData[0].data : '');
						}
					}
				},
				data : [ '2021-1', '2021-2', '2021-3', '2021-4', '2021-5',
						'2021-6', '2021-7', '2021-8', '2021-9', '2021-10',
						'2021-11', '2021-12' ]
			} ],
	yAxis : [ {
		type : 'value'
	} ],
	series : [
			{
				name : '2020 降水量',
				type : 'line',
				xAxisIndex : 1,
				smooth : true,
				data : [ 2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7,
						18.8, 6.0, 2.3 ]
			},
			{
				name : '2021 降水量',
				type : 'line',
				smooth : true,
				data : [ 3.9, 5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 46.6, 55.4,
						18.4, 10.3, 0.7 ]
			} ]
};

// 使用刚指定的配置项和数据显示图表。
myChartLine.setOption(optionLine);
