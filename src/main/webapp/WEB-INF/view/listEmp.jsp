<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("Path", request.getContextPath());
%>
<!-- 引入jquery -->
<script type="text/javascript"
	src="${Path }/static/js/jquery-2.1.0.min.js"></script>
<!-- 引入样式 -->
<link href="${Path }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${Path }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>员工后台管理</h1>
			</div>
		</div>

		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-8 col-md-offset-8">
				<button type="button" class="btn btn-success">新增</button>
				<button type="button" class="btn btn-danger">删除</button>
			</div>

		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped">
					<tr>
						<th>#</th>
						<th>姓名</th>
						<th>绩效</th>
						<th>邮箱</th>
						<th>部门</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<th>${emp.empId }</th>
							<th>${emp.empName }</th>
							<th>${emp.empGrade }</th>
							<th>${emp.empMail }</th>
							<th>${emp.department.depName }</th>
							<th>
								<button type="button" class="btn btn-info btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
								</button>
								<button type="button" class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
								</button>
							</th>
						</tr>
					</c:forEach>


				</table>

			</div>

		</div>
		<!-- 分页 -->
		<div class="row">
			<!-- 分页记录 -->
			<div class="col-md-6">当前第${pageInfo.pageNum }页，总共${pageInfo.pages}页，共${pageInfo.total}条记录</div>
			<!-- 分页条 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${Path }/emps?pn=1">首页</a></li>
					<li><c:if test="${pageInfo.hasPreviousPage}">
							<li><a href="${Path }/emps?pn=${pageInfo.pageNum-1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if></li>
					<c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
						<c:if test="${page_Num == pageInfo.pageNum}">
							<li class="active"><a class="disabled">${page_Num}</a></li>
						</c:if>
						<c:if test="${page_Num != pageInfo.pageNum}">
							<li><a href="${Path }/emps?pn=${page_Num}">${page_Num}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage}">
						<li><a href="${Path }/emps?pn=${pageInfo.pageNum+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					</li>
					<li><a href="${Path }/emps?pn=${pageInfo.pages}">尾页</a></li>
				</ul>
				</nav>
			</div>

		</div>

	</div>

</body>
</html>