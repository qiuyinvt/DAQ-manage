<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<% String tag="/admin/user/list"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../../common/layout.jsp"%>
<div class="content-wrapper" tag="/admin/user/list">
	<section class="content-header">
	<h1>用户管理</h1>
	</section>
	<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">编辑用户</h3>
				</div>
				<form id="form">
	              <div class="box-body">
	                <div class="form-group">
	                  <label for="name">名称</label>
	                  <input style="display:none;" type="text" class="form-control" name="id" validate="required" value="${entity.id}">
	                  <input type="text" class="form-control" id="name"  name="name"  placeholder="名称" validate="required" value="${entity.name}">
	                </div>
	                <div class="form-group">
	                  <label for="account">手机号</label>
	                  <input type="text" class="form-control" id="account" name="account" placeholder="手机号" validate="required" value="${entity.account}">
	                </div>
	                <div class="form-group">
	                  <label for="password">密码</label>
	                  <input type="text" class="form-control" id="password" name="password" placeholder="密码" validate="required" value="${entity.password}">
	                </div>
	              </div>
	              <div class="box-footer">
	                <button type="button" class="btn btn-primary">保存</button>
	              </div>
	            </form>
			</div>
		</div>
	</div>
	</section>
</div>
<script>
	jQuery(function(){
		CODES.form({
			id:"form",
			btn:"btn-primary",
			url:"/admin/user/save"
		});
	});
</script>
</html>