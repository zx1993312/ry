$(function() {
	ceshis1();
	ceshis2();
	ceshis3();
	function ceshis1() {
		var myChart = echarts.init(document.getElementById('ceshi1'));
		var option = {
			title : {
				text : '某站点用户访问来源',
				subtext : '纯属虚构',
				left : 'center'
			},

			tooltip : {
				trigger : 'item'
			},
			legend : {
				orient : 'vertical',
				left : 'left',
			},
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : '50%',
				data : [ {
					value : 1048,
					name : '搜索引擎'
				}, {
					value : 735,
					name : '直接访问'
				}, {
					value : 580,
					name : '邮件营销'
				}, {
					value : 484,
					name : '联盟广告'
				}, {
					value : 300,
					name : '视频广告'
				} ],
				emphasis : {
					itemStyle : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};
		myChart.setOption(option);
	}
	;
	function ceshis2() {
		var myChart = echarts.init(document.getElementById('ceshi2'));
		var option = {
			xAxis : {
				type : 'category',
				data : [ 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun' ]
			},
			yAxis : {
				type : 'value'
			},
			series : [ {
				data : [ 120, 200, 150, 80, 70, 110, 130 ],
				type : 'bar'
			} ]
		};
		myChart.setOption(option);
	}
	;
	function ceshis3() {
		$.ajax({
			// 几个参数需要注意一下
			type : "POST",// 方法类型
			dataType : "json",// 预期服务器返回的数据类型
			url : "/system/equipmentKanban/getEcharsData",
			type : 'POST',
			success : function(result) {
				var title = [];
				var data = [];

				for (var i = 0; i < result.rows.length; i++) {
					title.push(result.rows[i].key);
					data.push(result.rows[i].value);
				}
				var myChart = echarts.init(document.getElementById('ceshi3'));
				var option = {
					title : {
						text : '世界人口总量',
						textStyle : { // 设置主标题风格
							color : '#FFFFFF',// 设置主标题字体颜色
							fontStyle : '',// 主标题文字风格
						},
					},
					tooltip : {
						trigger : 'axis',
						axisPointer : {
							type : 'shadow'
						}
					},
					legend : {
						data : '设备故障'
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					xAxis : {
						type : 'value',
						boundaryGap : [ 0, 0.01 ],
						axisLabel : {
							color : "#FFFFFF"
						}
					},
					yAxis : {
						type : 'category',
						data : title,
						axisLabel : {
							color : "#FFFFFF"
						}
					},
					series : [ {
						name : '2011年',
						type : 'bar',
						data : data,
						axisLabel : {
							color : "#FFFFFF"
						}
					} ]
				};
				myChart.setOption(option);
			}
		});

	}
	;
});