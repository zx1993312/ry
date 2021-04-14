$(function () {

    /*ceshis();*/
    ceshis1();
    ceshis2();
    ceshis3();
    ceshis4();
   // ceshis5();
    ceshis6();
    //ceshis9();
    ceshis10();
    



    function ceshis1() {
        var myChart = echarts.init(document.getElementById('chart2'));

        var ydata = [{
            name: '东安半岛',
            value: 10.5
        },
            {
                name: '京御华府',
                value: 15.3
            },
            {
                name: '天御华府',
                value: 14.9
            },
            {
                name: '中海小区',
                value: 13.6
            },
            {
                name: '锦程物业',
                value: 10.4
            },
            {
                name: '紫竹物业',
                value: 7.9
            },
            {
                name: '长兴物业',
                value: 6.7
            },
            {
                name: '永和物业',
                value: 6
            },
            {
                name: '银城物业',
                value: 3.5
            }
        ];
        var color = ["#8d7fec", "#5085f2", "#e75fc3", "#f87be2", "#f2719a", "#fca4bb", "#f59a8f", "#fdb301", "#57e7ec", "#cf9ef1"]
        var xdata = ['东安半岛', "京御华府", "天御华府", "中海小区", '锦程物业', '紫竹物业', '长兴物业', '永和物业','银城物业'];


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
                "data": ["月租车","储值车", "临时车"]
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
                    "name": "月租车",
                    "value": 30
                }, {
                    "name": "储值车",
                    "value": 30
                }, {
                    "name": "临时车",
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
        myChart.setOption(option);
        myChart.currentIndex = -1;
        //myChart.setOption(option);
        //console.log(option.series[0].data[0]);
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

        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    function ceshis3() {
        var myChart = echarts.init(document.getElementById('chart4'));

        var colors = ['rgb(46, 199, 201)', 'rgb(90, 177, 239)', 'rgb(255, 185, 128)'];

        option = {
            color: colors,

            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                },
                formatter: function(params) {
                    // 系列
                    let html = params[0].name + "<br>";

                    for (var i = 0; i < params.length; i++) {

                        // 获取每个系列对应的颜色值
                        html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>';

                        // 通过判断指定系列增加 % 符号
                        if (option.series[params[i].seriesIndex].type == "line") {
                            html += params[i].seriesName + ": " + params[i].value + "%<br>";
                        } else {
                            html += params[i].seriesName + ": " + params[i].value + "<br>";
                        }
                    }
                    return html;
                }
            },
            grid: {
                right: '20%'
            },
            toolbox: {
                feature: {
                    dataView: {
                        show: true,
                        readOnly: false
                    },
                    restore: {
                        show: true
                    },
                    saveAsImage: {
                        show: true
                    }
                }
            },
            legend: {
                textStyle: {
                    color: '#fff'
                },
                data: ['2017', '2018', '同比增长']
            },
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
                }
            },
                {
                    type: 'value',
                    name: '',
                    min: 0,
                    max: 100,
                    position: 'right',
                    offset: 0,
                    axisLine: {
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
                    name: '同比增长',
                    min: 0,
                    max: 400,
                    position: 'left',
                    axisLine: {
                        lineStyle: {
                            color: colors[2]
                        }
                    },
                    axisLabel: {
                        formatter: '{value} '
                    }
                }
            ],
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
                {
                    barGap: '-50%', // 增加偏移量使重叠显示
                    name: '2018',
                    type: 'bar',
                    yAxisIndex: 1,
                    data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 75.6, 82.2, 48.7, 18.8, 6.0, 2.3],
                    itemStyle: {
                        normal: {
                            barBorderRadius: 2
                        }
                    }
                },
                {
                    name: '同比增长',
                    type: 'line',
                    yAxisIndex: 2,
                    data: [2.0, 2.2, 3.3, 4.5, 6.3, 87.2, 60.3, 32.4,45.0, 16.5, 12.0, 6.2],
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
        	        data: ['物业收入', '停车位收入']
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
        	            name: '物业收入',
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
        	            name: '停车位收入',
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





    function ceshis7() {
        var myChart = echarts.init(document.getElementById('chart_1'));


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
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
    
    function ceshis10() {
        var myChart = echarts.init(document.getElementById('map'));


        var uploadedDataURL = "./js/data-1528971808162-BkOXf61WX.json";
        //console.log(uploadedDataURL);
// echarts.extendsMap = function(id, opt) {
//     // 实例


//     var cityMap = {
//         "郑州市": zhengzhou,
//         "开封市": kaifeng,
//         "洛阳市": luoyang,
//         "平顶山市": pingdingshan,
//         "安阳市": anyang,
//         "鹤壁市": hebi,
//         "新乡市": xinxiang,
//         "焦作市": jiaozuo,
//         "濮阳市": puyang,
//         "漯河市": luohe,
//         "三门峡市": sanmenxia,
//         "南阳市": nanyang,
//         "商丘市": shangqiu,
//         "信阳市": xinyang,
//         "周口市": zhoukou,
//         "许昌市": xuchang,
//         "驻马店市": zhumadian
//     };

// }
        var geoGpsMap = {
            '1': [116.4071, 39.9046],
            '2': [125.8154, 44.2584],
            '3': [121.4737, 31.2303],
            '4': [117.1582, 36.8701],
            '5': [103.9526, 30.7617],
            '6': [106.6302, 26.6470],

        };
        var geoCoordMap = {
//            "江苏": [118.8062, 31.9208],
//            '黑龙江': [127.9688, 45.368],
//            '内蒙古': [110.3467, 41.4899],
//            "吉林": [125.8154, 44.2584],
//            '北京市': [116.4551, 40.2539],
//            "辽宁": [123.1238, 42.1216],
//            "河北": [114.4995, 38.1006],
//            "天津": [117.4219, 39.4189],
//            "山西": [112.3352, 37.9413],
//            "陕西": [109.1162, 34.2004],
//            "甘肃": [103.5901, 36.3043],
//            "宁夏": [106.3586, 38.1775],
//            "青海": [101.4038, 36.8207],
        		"东城区": [118.8062, 31.9208],
                '西城区': [127.9688, 45.368],
                '朝阳区': [110.3467, 41.4899],
                "丰台区": [125.8154, 44.2584],
                '石景山区': [116.4551, 40.2539],
                "海淀区": [123.1238, 42.1216],
                "门头沟区": [114.4995, 38.1006],
                "房山区": [117.4219, 39.4189],
                "通州区": [112.3352, 37.9413],
                "顺义区": [109.1162, 34.2004],
                "昌平区": [103.5901, 36.3043],
                "大兴区": [106.3586, 38.1775],
                "怀柔区": [101.4038, 36.8207],
                "平谷区": [87.9236, 43.5883],
                "密云区": [103.9526, 30.7617],
                "延庆区": [108.384366, 30.439702],
//            "新疆": [87.9236, 43.5883],
//            "四川": [103.9526, 30.7617],
//            "重庆": [108.384366, 30.439702],
//            "山东": [117.1582, 36.8701],
//            "河南": [113.4668, 34.6234],
//            "安徽": [117.29, 32.0581],
//            "湖北": [114.3896, 30.6628],
//            "浙江": [119.5313, 29.8773],
//            "福建": [119.4543, 25.9222],
//            "江西": [116.0046, 28.6633],
//            "湖南": [113.0823, 28.2568],
//            "贵州": [106.6992, 26.7682],
//            "云南": [102.9199, 25.4663],
//            "广东": [113.12244, 23.009505],
//            "广西": [108.479, 23.1152],
//            "海南": [110.3893, 19.8516],
//            '上海': [121.4648, 31.2891],
        };

        var d1 = {
        		'东城区': 10041,
                '西城区': 4093,
                '朝阳区': 1157,
                '丰台区': 4903,
                '石景山区': 2667,
                '海淀区': 8331,
                '门头沟区': 23727,
                '房山区': 681,
                '通州区': 5352,
                '顺义区': 38,
                '昌平区': 77,
                '大兴区': 65,
                '怀柔区': 10,
                '平谷区': 193,
                '密云区': 309,
                '延庆区': 77,
//            '江苏': 10041,
//            '黑龙江': 4093,
//            '内蒙古': 1157,
//            '吉林': 4903,
//            '北京市': 2667,
//            '辽宁': 8331,
//            '河北': 23727,
//            '天津': 681,
//            '山西': 5352,
//            '陕西': 38,
//            '甘肃': 77,
//            '宁夏': 65,
//            '青海': 10,
//            '新疆': 193,
//            '四川': 309,
//            '重庆': 77,
//            '山东': 21666,
//            '河南': 15717,
//            '安徽': 15671,
//            '湖北': 3714,
//            '浙江': 3141,
//            '福建': 955,
//            '江西': 4978,
//            '湖南': 778,
//            '贵州': 33,
//            '云南': 149,
//            '广东': 1124,
//            '广西': 125,
//            '海南': 7,
//            '上海': 2155,

        };

        var d2 = {
            "江苏": 0,
            '黑龙江': 0,
            '内蒙古': 0,
            "吉林": 0,
            '北京市': 0,
            "辽宁": 0,
            "河北": 0,
            "天津": 0,
            "山西": 0,
            "陕西": 0,
            "甘肃": 0,
            "宁夏": 0,
            "青海": 0,
            "新疆": 0,
            "四川": 0,
            "重庆": 0,
            "山东": 0,
            "河南": 0,
            "安徽": 0,
            "湖北": 0,
            "浙江": 0,
            "福建": 0,
            "江西": 0,
            "湖南": 0,
            "贵州": 0,
            "云南": 0,
            "广东": 0,
            "广西": 0,
            '海南': 0,
            '上海': 0,

        };

        var d3 = {
            '江苏': 11788,
            '黑龙江': 1944,
            '内蒙古': 2954,
            '吉林': 3482,
            '北京市': 1808,
            '辽宁': 5488,
            '河北': 27035,
            '天津': 2270,
            '山西': 13623,
            '陕西': 4221,
            '甘肃': 754,
            '宁夏': 1783,
            '青海': 91,
            '新疆': 1907,
            '四川': 4905,
            '重庆': 1420,
            '山东': 39781,
            '河南': 16154,
            '安徽': 7914,
            '湖北': 6802,
            '浙江': 5812,
            '福建': 3345,
            '江西': 4996,
            '湖南': 5627,
            '贵州': 1504,
            '云南': 2725,
            '广东': 6339,
            '广西': 1009,
            '海南': 0,
            '上海': 1988,



        };

        var d4 = {
            "江苏": 0,
            '黑龙江': 0,
            '内蒙古': 0,
            "吉林": 0,
            '北京市': 0,
            "辽宁": 0,
            "河北": 0,
            "天津": 0,
            "山西": 0,
            "陕西": 0,
            "甘肃": 0,
            "宁夏": 0,
            "青海": 0,
            "新疆": 0,
            "四川": 0,
            "重庆": 0,
            "山东": 0,
            "河南": 0,
            "安徽": 0,
            "湖北": 0,
            "浙江": 0,
            "福建": 0,
            "江西": 0,
            "湖南": 0,
            "贵州": 0,
            "云南": 0,
            "广东": 0,
            "广西": 0,
            '海南': 0,
            '上海': 0,
        };

        var d5 = {
            '江苏': 159,
            '黑龙江': 5,
            '内蒙古': 54,
            '吉林': 10,
            '北京市': 0,
            '辽宁': 0,
            '河北': 1679,
            '天津': 1,
            '山西': 2698,
            '陕西': 1744,
            '甘肃': 362,
            '宁夏': 429,
            '青海': 122,
            '新疆': 731,
            '四川': 3925,
            '重庆': 1480,
            '山东': 79,
            '河南': 1017,
            '安徽': 208,
            '湖北': 1209,
            '浙江': 1418,
            '福建': 1237,
            '江西': 1004,
            '湖南': 1511,
            '贵州': 345,
            '云南': 1429,
            '广东': 2242,
            '广西': 2271,
            '海南': 59,
            '上海': 8,



        };

        var d6 = {
            "江苏": 20,
            '黑龙江': 60,
            '内蒙古': 80,
            "吉林": 10,
            '北京市': 80,
            "辽宁": 40,
            "河北": 50,
            "天津": 60,
            "山西": 40,
            "陕西": 60,
            "甘肃": 40,
            "宁夏": 10,
            "青海": 0,
            "新疆": 0,
            "四川": 80,
            "重庆": 0,
            "山东": 60,
            "河南": 0,
            "安徽": 0,
            "湖北": 10,
            "浙江": 100,
            "福建": 60,
            "江西": 0,
            "湖南": 0,
            "贵州": 150,
            "云南": 0,
            "广东": 80,
            "广西": 0,
            '海南': 0,
            '上海': 50,
        };

        var colors = [
            ["#1DE9B6", "#1DE9B6", "#FFDB5C", "#FFDB5C", "#04B9FF", "#04B9FF"],
            ["#1DE9B6", "#F46E36", "#04B9FF", "#5DBD32", "#FFC809", "#FB95D5", "#BDA29A", "#6E7074", "#546570", "#C4CCD3"],
            ["#37A2DA", "#67E0E3", "#32C5E9", "#9FE6B8", "#FFDB5C", "#FF9F7F", "#FB7293", "#E062AE", "#E690D1", "#E7BCF3", "#9D96F5", "#8378EA", "#8378EA"],
            ["#DD6B66", "#759AA0", "#E69D87", "#8DC1A9", "#EA7E53", "#EEDD78", "#73A373", "#73B9BC", "#7289AB", "#91CA8C", "#F49F42"],
        ];
        var colorIndex = 0;
        $(function() {
            // var geoCoordMap = {
            //     '郑州': [113.64964385, 34.7566100641],
            //     '开封': [114.351642118, 34.8018541758],
            //     '洛阳': [112.447524769, 34.6573678177],
            //     '平顶山': [113.300848978, 33.7453014565],
            //     '安阳': [114.351806508, 36.1102667222],
            //     '鹤壁': [114.297769838, 35.7554258742],
            //     '新乡': [113.912690161, 35.3072575577],
            //     '焦作': [113.211835885, 35.234607555],
            //     '濮阳': [115.026627441, 35.7532978882],
            //     '漯河': [114.0460614, 33.5762786885],
            //     '三门峡': [111.181262093, 34.7833199411],
            //     '南阳': [112.542841901, 33.0114195691],
            //     "商丘": [115.641885688, 34.4385886402],
            //     '信阳': [114.085490993, 32.1285823075],
            //     '周口': [114.654101942, 33.6237408181],
            //     '许昌': [113.83531246, 34.0267395887],
            //     '驻马店': [114.049153547, 32.9831581541]
            // };

            var year = ["北京", "长春", "上海", "青岛", "成都", "贵阳"];
            var mapData = [
                [],
                [],
                [],
                [],
                [],
                [],
            ];

            /*柱子Y名称*/
            var categoryData = [];
            var barData = [];

            for (var key in geoCoordMap) {
                mapData[0].push({
                    "year": '长春',
                    "name": key,
                    "value": d1[key] / 100,
                    "value1": d1[key] / 100,
                });
                mapData[1].push({
                    "year": '长春',
                    "name": key,
                    "value": d1[key] / 100,
                    "value1": d2[key] / 100,
                });
                mapData[2].push({
                    "year": '青岛',
                    "name": key,
                    "value": d3[key] / 100,
                    "value1": d3[key] / 100,
                });
                mapData[3].push({
                    "year": '青岛',
                    "name": key,
                    "value": d3[key] / 100,
                    "value1": d4[key] / 100,
                });
                mapData[4].push({
                    "year": '成都',
                    "name": key,
                    "value": d5[key] / 100,
                    "value1": d5[key] / 100,
                });
                mapData[5].push({
                    "year": '成都',
                    "name": key,
                    "value": d5[key] / 100,
                    "value1": d6[key] / 100,
                });
            }

            for (var i = 0; i < mapData.length; i++) {
                mapData[i].sort(function sortNumber(a, b) {
                    return a.value - b.value
                });
                barData.push([]);
                categoryData.push([]);
                for (var j = 0; j < mapData[i].length; j++) {
                    barData[i].push(mapData[i][j].value1);
                    categoryData[i].push(mapData[i][j].name);
                }
            }

            /*$.getJSON(uploadedDataURL, function(geoJson) {*/

                /*echarts.registerMap('china', geoJson);*/
                /*echarts.registerMap('china', geoJson);*/
                var convertData = function(data) {
                    var res = [];
                    for (var i = 0; i < data.length; i++) {
                        var geoCoord = geoCoordMap[data[i].name];
                        if (geoCoord) {
                            res.push({
                                name: data[i].name,
                                value: geoCoord.concat(data[i].value)
                            });
                        }
                    }
                    return res;
                };

                var convertToLineData = function(data, gps) {
                    var res = [];
                    for (var i = 0; i < data.length; i++) {
                        var dataItem = data[i];
                        var toCoord = geoCoordMap[dataItem.name];
                        //debugger;
                        var fromCoord = gps; //郑州
                        //  var toCoord = geoGps[Math.random()*3];
                        if (fromCoord && toCoord) {
                            res.push([{
                                coord: fromCoord,
                                value: dataItem.value
                            }, {
                                coord: toCoord,
                            }]);
                        }
                    }
                    return res;
                };

                optionXyMap01 = {
                    timeline: {
                        data: year,
                        axisType: 'category',
                        autoPlay: true,
                        playInterval: 3000,
                        left: '10%',
                        right: '10%',
                        bottom: '-2%',
                        width: '80%',
                        //  height: null,
                        label: {
                            normal: {
                                textStyle: {
                                    color: '#ddd'
                                }
                            },
                            emphasis: {
                                textStyle: {
                                    color: '#fff'
                                }
                            }
                        },
                        symbolSize: 10,
                        lineStyle: {
                            color: '#555'
                        },
                        checkpointStyle: {
                            borderColor: '#777',
                            borderWidth: 2
                        },
                        controlStyle: {
                            showNextBtn: true,
                            showPrevBtn: true,
                            normal: {
                                color: '#666',
                                borderColor: '#666'
                            },
                            emphasis: {
                                color: '#aaa',
                                borderColor: '#aaa'
                            }
                        },

                    },
                    baseOption: {

                        animation: true,
                        animationDuration: 1000,
                        animationEasing: 'cubicInOut',
                        animationDurationUpdate: 1000,
                        animationEasingUpdate: 'cubicInOut',
                        grid: {
                            right: '1%',
                            top: '15%',
                            bottom: '10%',
                            width: '20%'
                        },
                        tooltip: {
                            trigger: 'axis', // hover触发器
                            axisPointer: { // 坐标轴指示器，坐标轴触发有效
                                type: 'shadow', // 默认为直线，可选为：'line' | 'shadow'
                                shadowStyle: {
                                    color: 'rgba(150,150,150,0.1)' //hover颜色
                                }
                            }
                        },
                        geo: {
                            show: true,
                            map: 'china',
                            roam: true,
                            zoom: 1,
                            center: [113.83531246, 34.0267395887],
                            label: {
                                emphasis: {
                                    show: false
                                }
                            },
                            itemStyle: {
                                normal: {
                                    borderColor: 'rgba(147, 235, 248, 1)',
                                    borderWidth: 1,
                                    areaColor: {
                                        type: 'radial',
                                        x: 0.5,
                                        y: 0.5,
                                        r: 0.8,
                                        colorStops: [{
                                            offset: 0,
                                            color: 'rgba(147, 235, 248, 0)' // 0% 处的颜色
                                        }, {
                                            offset: 1,
                                            color: 'rgba(147, 235, 248, .2)' // 100% 处的颜色
                                        }],
                                        globalCoord: false // 缺省为 false
                                    },
                                    shadowColor: 'rgba(128, 217, 248, 1)',
                                    // shadowColor: 'rgba(255, 255, 255, 1)',
                                    shadowOffsetX: -2,
                                    shadowOffsetY: 2,
                                    shadowBlur: 10
                                },
                                emphasis: {
                                    areaColor: '#389BB7',
                                    borderWidth: 0
                                }
                            }
                        },
                    },
                    options: []

                };

                for (var n = 0; n < year.length; n++) {

                    optionXyMap01.options.push({
                        /*backgroundColor: '#013954',*/
                        title:


                            [{
                                text: '航宇物业平台',
                                subtext: '   ',
                                left: '35%',
                                top: '15%',
                                textStyle: {
                                    color: '#fff',
                                    fontSize: 15
                                }
                            },
                                {
                                    id: 'statistic',
                                    text: year[n] + "数据统计情况",
                                    left: '75%',
                                    top: '5%',
                                    textStyle: {
                                        color: '#fff',
                                        fontSize: 12
                                    }
                                }
                            ],
                        xAxis: {
                            type: 'value',
                            scale: true,
                            position: 'top',
                            min: 0,
                            boundaryGap: false,
                            splitLine: {
                                show: false
                            },
                            axisLine: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            axisLabel: {
                                margin: 2,
                                textStyle: {
                                    color: '#aaa'
                                }
                            },
                        },
                        yAxis: {
                            type: 'category',
                            //  name: 'TOP 20',
                            nameGap: 16,
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: '#ddd'
                                }
                            },
                            axisTick: {
                                show: false,
                                lineStyle: {
                                    color: '#ddd'
                                }
                            },
                            axisLabel: {
                                interval: 0,
                                textStyle: {
                                    color: '#ddd'
                                }
                            },
                            data: categoryData[n]
                        },

                        series: [
                            //未知作用
                            {
                                //文字和标志
                                name: 'light',
                                type: 'scatter',
                                coordinateSystem: 'geo',
                                data: convertData(mapData[n]),
                                symbolSize: function(val) {
                                    return val[2] / 10;
                                },
                                label: {
                                    normal: {
                                        formatter: '{b}',
                                        position: 'right',
                                        show: true
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },
                                itemStyle: {
                                    normal: {
                                        color: colors[colorIndex][n]
                                    }
                                }
                            },
                            //地图？
                            {
                                type: 'map',
                                map: 'china',
                                geoIndex: 0,
                                aspectScale: 0.75, //长宽比
                                showLegendSymbol: false, // 存在legend时显示
                                label: {
                                    normal: {
                                        show: false
                                    },
                                    emphasis: {
                                        show: false,
                                        textStyle: {
                                            color: '#fff'
                                        }
                                    }
                                },
                                roam: true,
                                itemStyle: {
                                    normal: {
                                        areaColor: '#031525',
                                        borderColor: '#FFFFFF',
                                    },
                                    emphasis: {
                                        areaColor: '#2B91B7'
                                    }
                                },
                                animation: false,
                                data: mapData
                            },
                            //地图点的动画效果
                            {
                                //  name: 'Top 5',
                                type: 'effectScatter',
                                coordinateSystem: 'geo',
                                data: convertData(mapData[n].sort(function(a, b) {
                                    return b.value - a.value;
                                }).slice(0, 20)),
                                symbolSize: function(val) {
                                    return val[2] / 10;
                                },
                                showEffectOn: 'render',
                                rippleEffect: {
                                    brushType: 'stroke'
                                },
                                hoverAnimation: true,
                                label: {
                                    normal: {
                                        formatter: '{b}',
                                        position: 'right',
                                        show: true
                                    }
                                },
                                itemStyle: {
                                    normal: {
                                        color: colors[colorIndex][n],
                                        shadowBlur: 10,
                                        shadowColor: colors[colorIndex][n]
                                    }
                                },
                                zlevel: 1
                            },
                            //地图线的动画效果
                            {
                                type: 'lines',
                                zlevel: 2,
                                effect: {
                                    show: true,
                                    period: 4, //箭头指向速度，值越小速度越快
                                    trailLength: 0.1, //特效尾迹长度[0,1]值越大，尾迹越长重
                                    symbol: 'arrow', //箭头图标
                                    symbolSize: 5, //图标大小
                                },
                                lineStyle: {
                                    normal: {
                                        color: colors[colorIndex][n],
                                        width: 0.3, //尾迹线条宽度
                                        opacity: 0.8, //尾迹线条透明度
                                        curveness: .3 //尾迹线条曲直度
                                    }
                                },
                                data: convertToLineData(mapData[n], geoGpsMap[n + 1])
                            },
                            //柱状图
                            {
                                zlevel: 1.5,
                                type: 'bar',
                                symbol: 'none',
                                itemStyle: {
                                    normal: {
                                        color: colors[colorIndex][n]
                                    }
                                },
                                data: barData[n]
                            }
                        ]
                    })
                }
                myChart.setOption(optionXyMap01);
            /*});*/
        });


        function randomNum(minNum, maxNum) {
            switch (arguments.length) {
                case 1:
                    return parseInt(Math.random() * minNum + 1, 10);
                    break;
                case 2:
                    return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10);
                    break;
                default:
                    return 0;
                    break;
            }
        }

        // 使用刚指定的配置项和数据显示图表。
        //myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    
    
});