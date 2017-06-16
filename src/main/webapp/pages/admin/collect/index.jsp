<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../../common/layout.jsp"%>
<script src="<%=request.getContextPath()%>/style/common/echarts.min.js"> </script>
<div class="content-wrapper">
	<section class="content-header">
	<h1>数据监测</h1>
	</section>
	<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">实时数据</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body" id="main" style="width: 100%;height:800px;"></div>
			</div>
		</div>
	</div>
	</section>
</div>
<script>
$(function() {
	var myChart = echarts.init(document.getElementById('main'));
	myChart.setOption(option);
	initData();
 	setInterval(function () {
 		initData();
	}, 5000); 
	
	
	function initData() {
	var url="data";
	 $.ajax({
         url:url,
         //data:json,
         type: 'POST',
         success: function(data1) {
        	 var datas=JSON.parse(data1)
        	    myChart.setOption({
        	        series: [
        	        	{
        	               data: datas.XYZ_1
	        	        },
	        	     	{
	        	           data: datas.XYZ_2
	        	        },
	        	     	{
	        	            data: datas.SINGAL_1
	        	        },
	        	     	{
	        	            data: datas.SINGAL_2
	        	        }
        	        ]
        	    });
            // console.log(datas.XYZ_1);
         }
     });
	}
});

var option = {
    title: {
        text: 'SIM900A数据图',
        x: 'center',
        y: 0
    },
    grid: [
        {x: '7%', y: '7%', width: '38%', height: '38%'},
        {x2: '7%', y: '7%', width: '38%', height: '38%'},
        {x: '7%', y2: '7%', width: '38%', height: '38%'},
        {x2: '7%', y2: '7%', width: '38%', height: '38%'}
    ],
    tooltip: {
        trigger: 'axis',
       	axisPointer: {
            animation: false
        }, 
       	formatter: function (params) {
              params = params[0];
             // console.log(params)
             return  params.seriesName+':<br/>时间轴： '+params.value[0] + '  数值:' + params.value[1];
          },
    },
    toolbox: {
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            restore: {},
            saveAsImage: {}
        }
    },
    xAxis: [
        {
			gridIndex: 0, 
			type: 'time',
		    name: '时间轴',
		    splitLine: {show: false},
// 		    min:'2017/06/15 17:00:00',
// 		    max:'2017/06/15 17:30:00'
		},
        {gridIndex: 1, type: 'time',name: '时间轴',splitLine: {show: false}},
        {gridIndex: 2, type: 'time',name: '时间轴',splitLine: {show: false}},
        {gridIndex: 3, type: 'time',name: '时间轴',splitLine: {show: false}}
    ],
    yAxis: [
        {
			gridIndex: 0,    
			type: 'value',
            name: '数量值'
          },
        {gridIndex: 1, type: 'value',name: '数量值'},
        {gridIndex: 2, type: 'value',name: '数量值'},
        {gridIndex: 3, type: 'value',name: '数量值'}
    ],
    series: [
        {
            name: 'XYZ_1',
            type: 'line',
            xAxisIndex: 0,
            yAxisIndex: 0,
            showSymbol: false,
            hoverAnimation: false,
            //data: dataAll[2]
        },
        {
            name: 'XYZ_2',
            type: 'line',
            xAxisIndex: 1,
            yAxisIndex: 1,
            showSymbol: false,
            hoverAnimation: false,
            //data: data,
        },
        {
            name: 'SINGAL_1',
            type: 'line',
            xAxisIndex: 2,
            yAxisIndex: 2,
            showSymbol: false,
            hoverAnimation: false,
            //data: dataAll[2],
        },
        {
            name: 'SINGAL_2',
            type: 'line',
            xAxisIndex: 3,
            yAxisIndex: 3,
            showSymbol: false,
            hoverAnimation: false,
          //  data: dataAll[3],
        }
    ]
};


</script>

</html>