<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../../common/layout.jsp"%>
<div class="content-wrapper">
	<section class="content-header">
	<h1>用户管理</h1>
	</section>
	<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">用户列表</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="box-body">
					<div class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-12">
								<table id="user_list" class="table table-bordered table-hover dataTable">
									<thead>
										<tr>
											<th>编号</th>
											<th>姓名</th>
											<th>账号</th>
											<th>密码</th>
											<th>账号状态</th>
											<th>接收短信</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${entitys}">
											<tr>
												<td>${item.id}</td>
												<td>${item.name}</td>
												<td>${item.account}</td>
												<td>${item.password}</td>
												<td>
													<c:choose>
														<c:when test="${item.enabled}">
															<a href="/admin/user/disabled?id=${item.id}">已启用</a>
														</c:when>
														<c:otherwise>
															<a href="/admin/user/enabled?id=${item.id}">已禁用</a>
														</c:otherwise>
													</c:choose>
												</td>
												<td><c:choose>
														<c:when test="${item.isSend}">
															<a href="/admin/user/noSend?id=${item.id}">已开启</a>
														</c:when>
														<c:otherwise>
															<a href="/admin/user/send?id=${item.id}">已关闭</a>
														</c:otherwise>
													</c:choose></td>
												<td>
													<a href="">编辑</a>
												</td>
											</tr>	
										</c:forEach>
									</tbody>
								</table>
								<%@ include file="/pages/common/pagination.jsp"%>
							</div>
						</div>
						
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	</section>
</div>

</html>