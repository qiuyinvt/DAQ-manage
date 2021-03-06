<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>数据监测系统-注册</title>
  	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/bootstrap/css/bootstrap-theme.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/adminLTE/css/AdminLTE.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/adminLTE/css/skins/_all-skins.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/weui/css/weui.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/weui/css/jquery-weui.min.css"/>
	<script src="<%=request.getContextPath()%>/style/jquery/jquery.min.js"> </script>
	<script src="<%=request.getContextPath()%>/style/weui/js/jquery-weui.min.js"> </script>
	<script src="<%=request.getContextPath()%>/style/bootstrap/js/bootstrap.min.js"> </script>
	<script src="<%=request.getContextPath()%>/style/common/base.js?v=1"> </script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="<%=request.getContextPath()%>/login/index">数据监测系统</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">用户注册</p>
    <form id="form" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="名称" label="名称" validate="required" name="name">
        <span class="help-block"></span>
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="账号(请使用手机号作为账号)" label="账号" validate="required,mobile" name="account">
        <span class="help-block"></span>
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="密码" label="密码" validate="required" name="password">
        <span class="help-block"></span>
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="重复密码" label="重复密码" validate="required" name="repassword">
        <span class="help-block repassword"></span>
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
            <a href="<%=request.getContextPath()%>/login/index">&nbsp;&nbsp;去登录</a>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" class="btn btn-primary btn-block btn-flat">注册</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->
</body>
<script>
	jQuery(function(){
		CODES.form({
			id:"form",
			btn:"btn-primary",
			url:"/register/save",
			before:function(){
				if(jQuery("input[name=password]").val() != jQuery("input[name=repassword]").val()){
					jQuery(".repassword").parent().addClass("has-error");
					jQuery(".repassword").html("两次输入的密码不一致!");
					return false;
				}else{
					return true;
				}
			}
		});
	});
</script>
</html>