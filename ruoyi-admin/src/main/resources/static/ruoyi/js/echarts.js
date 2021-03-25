$(function () {

    /*ceshis();*/
    ceshis1();
    ceshis2();
    ceshis3();
    ceshis4();
    ceshis5();
<<<<<<< HEAD
//    ceshis6();
    ceshis7();
=======
    ceshis6();
    ceshis9();
    
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git



    function ceshis1() {
        var myChart = echarts.init(document.getElementById('chart2'));

        var ydata = [{
            name: '天猫',
            value: 18
        },
            {
                name: '京东',
                value: 16
            },
            {
                name: '苏宁易购',
                value: 15
            },
            {
                name: '拼多多',
                value: 14
            },
            {
                name: '国美',
                value: 10
            },
            {
                name: '亚马逊',
                value: 7.9
            },
            {
                name: '唯品会',
                value: 6.7
            },
            {
                name: '其他',
                value: 6
            }
        ];
        var color = ["#8d7fec", "#5085f2", "#e75fc3", "#f87be2", "#f2719a", "#fca4bb", "#f59a8f", "#fdb301", "#57e7ec", "#cf9ef1"]
        var xdata = ['天猫', "京东", "苏宁易购", "拼多多", '国美', '亚马逊', '唯品会', '唯品会'];


        option = {
            /*backgroundColor: "rgba(255,255,255,1)",*/
            color: color,
            legend: {
                orient: "vartical",
                x: "left",
                top: "center",
                left: "53%",
                bottom: "0%",
                data: xdata,
                itemWidth: 8,
                itemHeight: 8,
                textStyle: {
                    color: '#fff'
                },
                /*itemGap: 16,*/
                /*formatter:function(name){
                  var oa = option.series[0].data;
                  var num = oa[0].value + oa[1].value + oa[2].value + oa[3].value+oa[4].value + oa[5].value + oa[6].value + oa[7].value+oa[8].value + oa[9].value ;
                  for(var i = 0; i < option.series[0].data.length; i++){
                      if(name==oa[i].name){
                          return ' '+name + '    |    ' + oa[i].value + '    |    ' + (oa[i].value/num * 100).toFixed(2) + '%';
                      }
                  }
                }*/

                formatter: function(name) {
                    return '' + name
                }
            },
            series: [{
                type: 'pie',
                clockwise: false, //饼图的扇区是否是顺时针排布
                minAngle: 2, //最小的扇区角度（0 ~ 360）
                radius: ["20%", "60%"],
                center: ["30%", "45%"],
                avoidLabelOverlap: false,
                itemStyle: { //图形样式
                    normal: {
                        borderColor: '#ffffff',
                        borderWidth: 1,
                    },
                },
                label: {
                    normal: {
                        show: false,
                        position: 'center',
                        formatter: '{text|{b}}\n{c} ({d}%)',
                        rich: {
                            text: {
                                color: "#fff",
                                fontSize: 14,
                                align: 'center',
                                verticalAlign: 'middle',
                                padding: 8
                            },
                            value: {
                                color: "#8693F3",
                                fontSize: 24,
                                align: 'center',
                                verticalAlign: 'middle',
                            },
                        }
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: 24,
                        }
                    }
                },
                data: ydata
            }]
        };
        myChart.setOption(option);

        setTimeout(function() {
            myChart.on('mouseover', function(params) {
                if (params.name == ydata[0].name) {
                    myChart.dispatchAction({
                        type: 'highlight',
                        seriesIndex: 0,
                        dataIndex: 0
                    });
                } else {
                    myChart.dispatchAction({
                        type: 'downplay',
                        seriesIndex: 0,
                        dataIndex: 0
                    });
                }
            });

            myChart.on('mouseout', function(params) {
                myChart.dispatchAction({
                    type: 'highlight',
                    seriesIndex: 0,
                    dataIndex: 0
                });
            });
            myChart.dispatchAction({
                type: 'highlight',
                seriesIndex: 0,
                dataIndex: 0
            });
        }, 1000);

        myChart.currentIndex = -1;

        setInterval(function () {
            var dataLen = option.series[0].data.length;
            // 取消之前高亮的图形
            myChart.dispatchAction({
                type: 'downplay',
                seriesIndex: 0,
                dataIndex: myChart.currentIndex
            });
            myChart.currentIndex = (myChart.currentIndex + 1) % dataLen;
            // 高亮当前图形
            myChart.dispatchAction({
                type: 'highlight',
                seriesIndex: 0,
                dataIndex: myChart.currentIndex
            });
        }, 1000);

        // 使用刚指定的配置项和数据显示图表。
        /*myChart.setOption(option);*/
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    function ceshis2() {
        var myChart = echarts.init(document.getElementById('chart3'));

        option = {
<<<<<<< HEAD
        	    tooltip: {
        	        trigger: 'axis',
        	        axisPointer: {
        	            type: 'cross',
        	            crossStyle: {
        	                color: '#999'
        	            }
        	        }
        	    },
        	    toolbox: {
        	        feature: {
        	            dataView: {show: true, readOnly: false},
        	            magicType: {show: true, type: ['line', 'bar']},
        	            restore: {show: true},
        	            saveAsImage: {show: true}
        	        }
        	    },
        	    legend: {
        	        data: ['蒸发量', '降水量', '平均温度']
        	    },
        	    xAxis: [
        	        {
        	            type: 'category',
        	            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
        	            axisPointer: {
        	                type: 'shadow'
        	            }
        	        }
        	    ],
        	    yAxis: [
        	        {
        	            type: 'value',
        	            name: '水量',
        	            min: 0,
        	            max: 250,
        	            interval: 50,
        	            axisLabel: {
        	                formatter: '{value} ml'
        	            }
        	        },
        	        {
        	            type: 'value',
        	            name: '温度',
        	            min: 0,
        	            max: 25,
        	            interval: 5,
        	            axisLabel: {
        	                formatter: '{value} °C'
        	            }
        	        }
        	    ],
        	    series: [
        	        {
        	            name: '蒸发量',
        	            type: 'bar',
        	            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
        	        },
        	        {
        	            name: '降水量',
        	            type: 'bar',
        	            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
        	        },
        	        {
        	            name: '平均温度',
        	            type: 'line',
        	            yAxisIndex: 1,
        	            data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        	        }
        	    ]
        	};
=======
            /*backgroundColor: '#000',*/
            "animation": true,
            "title": {
                /*"text": 24,*/
               /* "subtext": "沥青工",*/
                "x": "center",
                "y": "center",
                "textStyle": {
                    "color": "#fff",
                    "fontSize": 10,
                    "fontWeight": "normal",
                    "align": "center",
                    "width": "200px"
                },
                "subtextStyle": {
                    "color": "#fff",
                    "fontSize": 12,
                    "fontWeight": "normal",
                    "align": "center"
                }
            },
            "legend": {
                "width": "100%",
                "left": "center",
                "textStyle": {
                    "color": "#fff",
                    "fontSize": 12
                },
                "icon": "circle",
                "right": "0",
                "bottom": "0",
                "padding": [15, 20],
                "itemGap": 5,
                "data": ["马尾区","电脑", "仓山区"]
            },
            "series": [{
                "type": "pie",
                "center": ["50%", "40%"],
                "radius": ["20%", "43%"],
                "color": ["#8F59E1", "#41C28A","#0A80FA"],
                "startAngle": 135,
                "labelLine": {
                    "normal": {
                        "length": 15
                    }
                },
                "label": {
                    "normal": {
                        "formatter": "{b|{b}:}  {per|{d}%} ",
                        "backgroundColor": "rgba(255, 147, 38, 0)",
                        "borderColor": "transparent",
                        "borderRadius": 4,
                        "rich": {
                            "a": {
                                "color": "#999",
                                "lineHeight": 12,
                                "align": "center"
                            },
                            "hr": {
                                "borderColor": "#aaa",
                                "width": "100%",
                                "borderWidth": 1,
                                "height": 0
                            },
                            "b": {
                                "color": "#b3e5ff",
                                "fontSize": 16,
                                "lineHeight": 33
                            },
                            "c": {
                                "fontSize": 14,
                                "color": "#eee"
                            },
                            "per": {
                                "color": "#FDF44E",
                                "fontSize": 14,
                                "padding": [5, 8],
                                "borderRadius": 2
                            }
                        },
                        "textStyle": {
                            "color": "#fff",
                            "fontSize": 16
                        }
                    }
                },
                "emphasis": {
                    "label": {
                        "show": true,
                        "formatter": "{b|{b}:}  {per|{d}%}  ",
                        "backgroundColor": "rgba(255, 147, 38, 0)",
                        "borderColor": "transparent",
                        "borderRadius": 4,
                        "rich": {
                            "a": {
                                "color": "#999",
                                "lineHeight": 22,
                                "align": "center"
                            },
                            "hr": {
                                "borderColor": "#aaa",
                                "width": "100%",
                                "borderWidth": 1,
                                "height": 0
                            },
                            "b": {
                                "color": "#fff",
                                "fontSize": 14,
                                "lineHeight": 33
                            },
                            "c": {
                                "fontSize": 14,
                                "color": "#eee"
                            },
                            "per": {
                                "color": "#FDF44E",
                                "fontSize": 14,
                                "padding": [5, 6],
                                "borderRadius": 2
                            }
                        }
                    }
                },
                "data": [{
                    "name": "马尾区",
                    "value": 3
                }, {
                    "name": "仓山区",
                    "value": 2
                }, {
                    "name": "电脑",
                    "value": 26
                }]
            }, {
                "type": "pie",
                "center": ["50%", "40%"],
                "radius": ["15%", "14%"],
                "label": {
                    "show": false
                },
                "data": [{
                    "value": 78,
                    "name": "实例1",
                    "itemStyle": {
                        "normal": {
                            "color": {
                                "x": 0,
                                "y": 0,
                                "x2": 1,
                                "y2": 0,
                                "type": "linear",
                                "global": false,
                                "colorStops": [{
                                    "offset": 0,
                                    "color": "#9F17FF"
                                }, {
                                    "offset": 0.2,
                                    "color": "#01A4F7"
                                }, {
                                    "offset": 0.5,
                                    "color": "#FE2C8A"
                                }, {
                                    "offset": 0.8,
                                    "color": "#FEE449"
                                }, {
                                    "offset": 1,
                                    "color": "#00FFA8"
                                }]
                            }
                        }
                    }
                }]
            }]
        }

        // 使用刚指定的配置项和数据显示图表。
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
        myChart.setOption(option);
    }
    function ceshis3() {
        var myChart = echarts.init(document.getElementById('chart4'));

        var colors = ['#5470C6', '#91CC75', '#EE6666'];

        option = {
            color: colors,

            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            grid: {
                right: '20%'
            },
            toolbox: {
                feature: {
                    dataView: {show: true, readOnly: false},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            legend: {
<<<<<<< HEAD
                data: ['蒸发量', '降水量', '平均温度']
=======
                textStyle: {
                    color: '#fff'
                },
                data: ['2017', '2018', '同比增长']
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
            },
<<<<<<< HEAD
            xAxis: [
                {
                    type: 'category',
                    axisTick: {
                        alignWithLabel: true
                    },
                    data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
=======
            // 缩放组件
            /*dataZoom: {
                type: 'slider'
            },*/
            xAxis: [{
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                axisLabel: {
                    formatter: '{value} ',
                    textStyle: {
                        color: "#ffffff" //X轴文字颜色
                    }
                },
                data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
            }],
            yAxis: [{
                type: 'value',
                name: '',
                min: 0,
                max: 100,
                position: 'right',
                axisLine: {
                    lineStyle: {
                        color: colors[0]
                    }
                },
                axisLabel: {
                    formatter: '{value} %'
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                }
            ],
            yAxis: [
                {
                    type: 'value',
<<<<<<< HEAD
                    name: '蒸发量',
                    min: 0,
                    max: 250,
                    position: 'right',
                    axisLine: {
                        show: true,
                        lineStyle: {
                            color: colors[0]
                        }
                    },
                    axisLabel: {
                        formatter: '{value} ml'
                    }
                },
                {
                    type: 'value',
                    name: '降水量',
=======
                    name: '',
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                    min: 0,
                    max: 100,
                    position: 'right',
                    offset: 0,
                    axisLine: {
                        show: true,
                        lineStyle: {
                            color: colors[1]
                        }
                    },
                    axisLabel: {
<<<<<<< HEAD
                        formatter: '{value} ml'
=======
                        formatter: '{value} %'
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                    }
                },
                {
                    type: 'value',
<<<<<<< HEAD
                    name: '温度',
=======
                    name: '同比增长',
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                    min: 0,
                    max: 400,
                    position: 'left',
                    axisLine: {
                        show: true,
                        lineStyle: {
                            color: colors[2]
                        }
                    },
                    axisLabel: {
<<<<<<< HEAD
                        formatter: '{value} °C'
=======
                        formatter: '{value} '
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                    }
                }
            ],
<<<<<<< HEAD
            series: [
=======
            series: [{
                name: '2017',
                type: 'bar',
                data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 35.6, 62.2, 32.6, 20.0, 6.4, 3.3],
                itemStyle: {
                    normal: {
                        barBorderRadius: 2
                    }
                }
            },
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                {
<<<<<<< HEAD
                    name: '蒸发量',
=======
                    barGap: '-50%', // 增加偏移量使重叠显示
                    name: '2018',
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                    type: 'bar',
<<<<<<< HEAD
                    data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
=======
                    yAxisIndex: 1,
                    data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 75.6, 82.2, 48.7, 18.8, 6.0, 2.3],
                    itemStyle: {
                        normal: {
                            barBorderRadius: 2
                        }
                    }
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                },
                {
<<<<<<< HEAD
                    name: '降水量',
                    type: 'bar',
                    yAxisIndex: 1,
                    data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                },
                {
                    name: '平均温度',
=======
                    name: '同比增长',
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                    type: 'line',
                    yAxisIndex: 2,
<<<<<<< HEAD
                    data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
=======
                    data: [2.0, 2.2, 3.3, 4.5, 6.3, 87.2, 60.3, 32.4,45.0, 16.5, 12.0, 6.2],
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    function ceshis4() {
<<<<<<< HEAD
    	var myChart = echarts.init(document.getElementById('Stastic'));
    	option = {
    		    tooltip: {
    		        trigger: 'item'
    		    },
    		    legend: {
    		        top: '5%',
    		        left: 'center'
    		    },
    		    series: [
    		        {
    		            name: '访问来源',
    		            type: 'pie',
    		            radius: ['40%', '70%'],
    		            avoidLabelOverlap: false,
    		            label: {
    		                show: false,
    		                position: 'center'
    		            },
    		            emphasis: {
    		                label: {
    		                    show: true,
    		                    fontSize: '40',
    		                    fontWeight: 'bold'
    		                }
    		            },
    		            labelLine: {
    		                show: false
    		            },
    		            data: [
    		                {value: 1048, name: '搜索引擎'},
    		                {value: 735, name: '直接访问'},
    		                {value: 580, name: '邮件营销'},
    		                {value: 484, name: '联盟广告'},
    		                {value: 300, name: '视频广告'}
    		            ]
    		        }
    		    ]
    		};
    	 myChart.setOption(option);
=======
        var myChart = echarts.init(document.getElementById('chart5'));
        

        option = {
        	    color: ['#80FFA5', 'yellow'],
        	    title: {
        	        text: ''
        	    },
        	    textStyle:{
        	    	color:'rgb(46, 199, 201)'
        	    },
        	    tooltip: {
        	        trigger: 'axis',
        	        axisPointer: {
        	            type: 'cross',
        	            label: {
        	                backgroundColor: '#6a7985'
        	            }
        	        }
        	    },
        	    legend: {
        	        data: ['出生率', '死亡率']
        	    },
        	    toolbox: {
        	        feature: {
        	            saveAsImage: {}
        	        }
        	    },
        	    grid: {
        	        left: '3%',
        	        right: '4%',
        	        bottom: '3%',
        	        containLabel: true
        	    },
        	    xAxis: [
        	        {
        	            type: 'category',
        	            boundaryGap: false,
        	            data: ['02月', '03月', '04月', '05月', '06月', '07月', '08月']
        	        }
        	    ],
        	    yAxis: [
        	        {
        	            type: 'value'
        	        }
        	    ],
        	    series: [
        	        {
        	            name: '出生率',
        	            type: 'line',
        	            stack: '总量',
        	            smooth: true,
        	            lineStyle: {
        	                width: 0
        	            },
        	            showSymbol: false,
        	            areaStyle: {
        	                opacity: 0.8,
        	                color: '#80FFA5'
        	            },
        	            emphasis: {
        	                focus: 'series'
        	            },
        	            data: [140, 232, 101, 264, 90, 340, 250]
        	        },
        	        {
        	            name: '死亡率',
        	            type: 'line',
        	            stack: '总量',
        	            smooth: true,
        	            lineStyle: {
        	                width: 0
        	            },
        	            showSymbol: false,
        	            areaStyle: {
        	                opacity: 0.8,
        	                color:'yellow'
        	            },
        	            emphasis: {
        	                focus: 'series'
        	            },
        	            data: [120, 282, 111, 234, 220, 340, 310]
        	        }
        	    ]
        	};
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
>>>>>>> branch 'master' of https://github.com/zx1993312/ry.git
    }

    function ceshis5() {
    	var option;
        var myChart = echarts.init(document.getElementById('chart8'));
     option = {
    		 textStyle:{
    			color:'#ffff' 
    		 },
        	    tooltip: {
        	        trigger: 'axis',
        	        axisPointer: {
        	            type: 'shadow'
        	        }
        	    },
        	    legend: {
        	        data: []
        	    },
        	    grid: {
        	        left: '3%',
        	        right: '4%',
        	        bottom: '3%',
        	        containLabel: true
        	    },
        	    xAxis: {
        	        type: 'value',
        	        boundaryGap: [0]
        	    },
        	    yAxis: {
        	        type: 'category',
        	        axisTick:{
        	        	show:false
        	        },
        	        data: ['房地产', '金融', '制造业', '建筑业', '采矿业']
        	        
        	    },
        	    series: [
        	        {
        	            name: '2011年',
        	            type: 'bar',
        	            label:{
        	            	show:true,
        	            	position:'inside'
        	            },
        	            emphasis:{
        	            	focus:'series'
        	            },
        	            data: [260, 270, 290, 320, 350]
        	        }
        	    ]
        	};
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }


    function ceshis6(){
    	var myChart = echarts.init(document.getElementById('USAmap'));

    	option = {
    		    backgroundColor: '#2c343c',

    		    title: {
    		        text: 'Customized Pie',
    		        left: 'center',
    		        top: 20,
    		        textStyle: {
    		            color: '#ccc'
    		        }
    		    },

    		    tooltip: {
    		        trigger: 'item'
    		    },

    		    visualMap: {
    		        show: false,
    		        min: 80,
    		        max: 600,
    		        inRange: {
    		            colorLightness: [0, 1]
    		        }
    		    },
    		    series: [
    		        {
    		            name: '访问来源',
    		            type: 'pie',
    		            radius: '55%',
    		            center: ['50%', '50%'],
    		            data: [
    		                {value: 335, name: '直接访问'},
    		                {value: 310, name: '邮件营销'},
    		                {value: 274, name: '联盟广告'},
    		                {value: 235, name: '视频广告'},
    		                {value: 400, name: '搜索引擎'}
    		            ].sort(function (a, b) { return a.value - b.value; }),
    		            roseType: 'radius',
    		            label: {
    		                color: 'rgba(255, 255, 255, 0.3)'
    		            },
    		            labelLine: {
    		                lineStyle: {
    		                    color: 'rgba(255, 255, 255, 0.3)'
    		                },
    		                smooth: 0.2,
    		                length: 10,
    		                length2: 20
    		            },
    		            itemStyle: {
    		                color: '#c23531',
    		                shadowBlur: 200,
    		                shadowColor: 'rgba(0, 0, 0, 0.5)'
    		            },

    		            animationType: 'scale',
    		            animationEasing: 'elasticOut',
    		            animationDelay: function (idx) {
    		                return Math.random() * 200;
    		            }
    		        }
    		    ]
    		};

    	    myChart.setOption(option);
    	}
    


    function ceshis7() {}
    
    function ceshis9(){
    	var myChart = echarts.init(document.getElementById('a'));
    	
    	var colors = ['#5470C6', '#EE6666'];

    	option = {
    	    color: colors,

    	    tooltip: {
    	        trigger: 'none',
    	        axisPointer: {
    	            type: 'cross'
    	        }
    	    },
    	    legend: {
    	        data:['2015 降水量', '2016 降水量']
    	    },
    	    grid: {
    	        top: 70,
    	        bottom: 50
    	    },
    	    xAxis: [
    	        {
    	            type: 'category',
    	            axisTick: {
    	                alignWithLabel: true
    	            },
    	            axisLine: {
    	                onZero: false,
    	                lineStyle: {
    	                    color: colors[1]
    	                }
    	            },
    	            axisPointer: {
    	                label: {
    	                    formatter: function (params) {
    	                        return '降水量  ' + params.value
    	                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
    	                    }
    	                }
    	            },
    	            data: ['2016-1', '2016-2', '2016-3', '2016-4', '2016-5', '2016-6', '2016-7', '2016-8', '2016-9', '2016-10', '2016-11', '2016-12']
    	        },
    	        {
    	            type: 'category',
    	            axisTick: {
    	                alignWithLabel: true
    	            },
    	            axisLine: {
    	                onZero: false,
    	                lineStyle: {
    	                    color: colors[0]
    	                }
    	            },
    	            axisPointer: {
    	                label: {
    	                    formatter: function (params) {
    	                        return '降水量  ' + params.value
    	                            + (params.seriesData.length ? '：' + params.seriesData[0].data : '');
    	                    }
    	                }
    	            },
    	            data: ['2015-1', '2015-2', '2015-3', '2015-4', '2015-5', '2015-6', '2015-7', '2015-8', '2015-9', '2015-10', '2015-11', '2015-12']
    	        }
    	    ],
    	    yAxis: [
    	        {
    	            type: 'value'
    	        }
    	    ],
    	    series: [
    	        {
    	            name: '2015 降水量',
    	            type: 'line',
    	            xAxisIndex: 1,
    	            smooth: true,
    	            emphasis: {
    	                focus: 'series'
    	            },
    	            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
    	        },
    	        {
    	            name: '2016 降水量',
    	            type: 'line',
    	            smooth: true,
    	            emphasis: {
    	                focus: 'series'
    	            },
    	            data: [3.9, 5.9, 11.1, 18.7, 48.3, 69.2, 231.6, 46.6, 55.4, 18.4, 10.3, 0.7]
    	        }
    	    ]
    	};
    }

    function ceshis6() {
        var myChart = echarts.init(document.getElementById('chart6'));
        var colors = ['#5470C6', '#91CC75', '#EE6666'];

        option = {
            color: colors,

            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            grid: {
                right: '20%'
            },
            toolbox: {
                feature: {
                    dataView: {show: true, readOnly: false},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            legend: {
                data: ['2018',  '环比增长']
            },
            xAxis: [
                {
                    type: 'category',
                    axisTick: {
                        alignWithLabel: true
                    },
                    data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '',
                    min: 0,
                    max: 250,
                    position: 'right',
                    axisLine: {
                        show: true,
                        lineStyle: {
                            color: colors[0]
                        }
                    },
                    axisLabel: {
                        formatter: '{value} %'
                    }
                },
                {
                    type: 'value',
                    name: '',
                    min: 0,
                    max: 250,
                    position: 'right',
                    offset: 0,
                    axisLine: {
                        show: true,
                        lineStyle: {
                            color: colors[1]
                        }
                    },
                    axisLabel: {
                        formatter: '{value} %'
                    }
                },
                {
                    type: 'value',
                    name: '',
                    min: 0,
                    max: 5000,
                    position: 'left',
                    axisLine: {
                        show: true,
                        lineStyle: {
                            color: colors[2]
                        }
                    },
                    axisLabel: {
                        formatter: '{value} '
                    }
                }
            ],
            series: [
                {
                    name: '2018',
                    type: 'bar',
                    data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                },
             
                {
                    name: '环比增长',
                    type: 'line',
                    yAxisIndex: 2,
                    data: [1800, 2200, 3300, 4500, 3600, 1002, 2023, 2340, 2201, 1650, 4000, 4800]
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    function ceshis9() {
    	var myChart = echarts.init(document.getElementById('chart7'));
    	var option;

    	option = {
    			textStyle:{
    				color:'#ffff'
    			},
    	    title: {
    	        text: ''
    	    },
    	    tooltip: {
    	        trigger: 'axis'
    	    },
    	    legend: {
    	        data: ['个体工商户', '外资企业', '私营企业']
    	    },
    	    grid: {
    	        left: '3%',
    	        right: '4%',
    	        bottom: '3%',
    	        containLabel: true
    	    },
    	    toolbox: {
    	        feature: {
    	            saveAsImage: {}
    	        }
    	    },
    	    xAxis: {
    	        type: 'category',
    	        boundaryGap: false,
    	        data: ['1月', '2月', '3月', '4月', '5月', '6月']
    	    },
    	    yAxis: {
    	        type: 'value'
    	    },
    	    series: [
    	        {
    	            name: '个体工商户',
    	            type: 'line',
    	            stack: '总量',
    	            textStyle: {
    	                opacity: 0.8,
    	            },
    	            data: [120, 132, 101, 134, 90, 230, 210]
    	        },
    	        {
    	            name: '外资企业',
    	            type: 'line',
    	            stack: '总量',
    	            data: [220, 182, 191, 234, 290, 330, 310]
    	        },
    	        {
    	            name: '私营企业',
    	            type: 'line',
    	            stack: '总量',
    	            data: [150, 232, 201, 154, 190, 330, 410]
    	        }
    	    ]
    	};
    	// 使用刚指定的配置项和数据显示图表。
    	myChart.setOption(option);
    	window.addEventListener("resize",function(){
    		myChart.resize();
    	});
    }
});