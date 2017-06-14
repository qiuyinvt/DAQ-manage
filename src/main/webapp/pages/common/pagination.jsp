<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
	<div class="row">
		<div class="col-sm-7">
			<div class="dataTables_paginate paging_simple_numbers">
				<ul class="pagination">
					<li class="paginate_button" data-page="1"><a href="?page=1">首页</a></li>
					<c:forEach var="item" items="${pagination}">
						<li class="paginate_button page_${item}" data-page="${item}"><a href="?page=${item }">${item}</a></li>
					</c:forEach>
					<li class="paginate_button" data-page="${PAGE_COUNT}"><a href="?page=${PAGE_COUNT}">尾页</a></li>
				</ul>
			</div>
		</div>
	</div>
</html>