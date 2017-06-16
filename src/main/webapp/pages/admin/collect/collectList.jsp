<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../../common/layout.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="content-wrapper">
	<section class="content-header">
	<h1>数据列表</h1>
	</section>
	<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<!-- <div class="box-header">
					<h3 class="box-title">用户列表</h3>
				</div> -->
				<!-- /.box-header -->
				<div class="box-body">
					<div class="box-body">
					<div class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-12">
								<table id="tableList" class="table table-bordered table-hover dataTable">
									<thead>
										<tr>
											<th>序号</th>
											<th>数值</th>
											<th>类型</th>
											<th>创建时间</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${entitys}" varStatus="status">
											<tr>
												<td>${status.index +1}</td>
												<td>${item.value}</td>
												<td>${item.type}</td>
												<td>
													<fmt:formatDate value="${item.created}" pattern="yyyy-MM-dd HH:mm:ss"/>
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