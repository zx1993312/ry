$(function() {
	ceshis1();
	ceshis2();
	ceshis3();
	function ceshis1() {
		var myChart = echarts.init(document.getElementById('ceshi1'));
		var option = {
			tooltip : {
				trigger : 'item'
			},
			legend : {
				top : '5%',
				left : 'center'
			},
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : [ '40%', '70%' ],
				avoidLabelOverlap : false,
				label : {
					show : false,
					position : 'center'
				},
				emphasis : {
					label : {
						show : true,
						fontSize : '40',
						fontWeight : 'bold'
					}
				},
				labelLine : {
					show : false
				},
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
				} ]
			} ]
		};
		myChart.setOption(option);
	}
	;
	function ceshis2() {
		$.ajax({
			// 几个参数需要注意一下
			type : "POST",// 方法类型
			dataType : "json",// 预期服务器返回的数据类型
			url : "/system/equipmentKanban/getRouteEcharsData",
			type : 'POST',
			success : function(result) {
				var title = [];
				var data = [];

				for (var i = 0; i < result.rows.length; i++) {
					title.push(result.rows[i].key);
					data.push(result.rows[i].value);
				}
				var myChart = echarts.init(document.getElementById('ceshi2'));
				var option = {
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '巡检类别' ]
					},
					xAxis : {
						type : 'category',
						boundaryGap : false,
						data : title
					},
					yAxis : {
						type : 'value',
						axisLabel : {
							formatter : '{value}'
						}
					},
					series : [ {
						name : '最高气温',
						type : 'line',
						data : [ 10, 11, 13, 11, 12, 12, 9 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					}, {
						name : '巡检类别',
						type : 'line',
						data : data,
						markPoint : {
							data : [ {
								name : '周最低',
								value : -2,
								xAxis : 1,
								yAxis : -1.5
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							}, [ {
								symbol : 'none',
								x : '90%',
								yAxis : 'max'
							}, {
								symbol : 'circle',
								label : {
									position : 'start',
									formatter : '最大值'
								},
								type : 'max',
								name : '最高点'
							} ] ]
						}
					} ]
				};
				myChart.setOption(option);
			}
		});
	}
	;
	function ceshis3() {
		$.ajax({
			// 几个参数需要注意一下
			type : "POST",// 方法类型
			dataType : "json",// 预期服务器返回的数据类型
			url : "/system/equipmentKanban/getEquipmentEcharsData",
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
						text : '设备故障统计',
						textStyle : { // 设置主标题风格
							color : '#FFFFFF',// 设置主标题字体颜色
							fontStyle : '',// 主标题文字风格
						}
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
						boundaryGap : [ 0, 0.01 ]
					},
					yAxis : {
						type : 'category',
						data : title
					},
					series : [ {
						name : '2011年',
						type : 'bar',
						data : data
					} ]
				};
				myChart.setOption(option);
			}
		});

	}
	;
});