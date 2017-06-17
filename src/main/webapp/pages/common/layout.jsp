<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/bootstrap/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/adminLTE/css/AdminLTE.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/adminLTE/css/skins/_all-skins.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/weui/css/weui.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/weui/css/jquery-weui.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/weui/css/daterangepicker.css"/>
	
	<script src="<%=request.getContextPath()%>/style/jquery/jquery.min.js"> </script>
	<script src="<%=request.getContextPath()%>/style/weui/js/jquery-weui.min.js"> </script>
	<script src="<%=request.getContextPath()%>/style/bootstrap/js/bootstrap.min.js"> </script>
	<script src="<%=request.getContextPath()%>/style/common/base.js?v=2"> </script>
	
	<script src="<%=request.getContextPath()%>/style/weui/js/moment.min.js"> </script>
	<script src="<%=request.getContextPath()%>/style/weui/js/daterangepicker.js"> </script>
</head>
<body class="skin-blue fixed">
	<header class="main-header">
	  <a href="<%=request.getContextPath()%>/admin/collect/view" class="logo">
	    <!-- LOGO -->
	    数据监测系统
	  </a>
	  <a href="<%=request.getContextPath()%>/login/logout" >
	    <!-- LOGO -->
		 退出
	  </a>
	  <nav class="navbar navbar-static-top" role="navigation"></nav>
	</header>
	
	<div class="main-sidebar">
	  <!-- Inner sidebar -->
	  <div class="sidebar">
	
	    <!-- Sidebar Menu -->
	    <ul class="sidebar-menu">
	      <!-- <li class="header">控制面板</li> -->
	      <!-- Optionally, you can add icons to the links -->
	      <li page="/admin/collect/view"><a href="<%=request.getContextPath()%>/admin/collect/view"><span>数据监测</span></a></li>
	      <li page="/admin/user/list"><a href="<%=request.getContextPath()%>/admin/user/list"><span>用户管理</span></a></li>
	      <li page="/admin/collect/list"><a href="<%=request.getContextPath()%>/admin/collect/list"><span>数据列表</span></a><span><</span></li>
	     <!--  <li class="treeview active menu-open">
	        <a href="#"><span>Multilevel</span> <i class="fa fa-angle-left pull-right"></i></a>
	        <ul class="treeview-menu">
	          <li><a href="#">Link in level 2</a></li>
	          <li><a href="#">Link in level 2</a></li>
	        </ul>
	      </li>  -->
	    </ul><!-- /.sidebar-menu -->
	
	  </div><!-- /.sidebar -->
	</div><!-- /.main-sidebar -->
</body>
	<script>
	
		jQuery(document).ready(function(){	
			//高亮菜单标签
			var tag = jQuery("[tag]").attr("tag");
			if(tag == "" || tag == undefined){
				tag = window.location.href;
			}
			jQuery(".sidebar-menu li").each(function(){
				if(tag.indexOf(jQuery(this).attr("page"))!= -1){
					jQuery(this).addClass("active").siblings().removeClass("active");
					return ;
				}
			});
		});
		
	</script>
</html>