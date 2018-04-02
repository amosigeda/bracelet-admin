<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- jsp文件头和头部 -->
	<%@ include file="../../main/top.jsp"%> 	
	</head> 
<body>
		
<div class="container-fluid" id="main-container">


<div id="page-content" class="clearfix">
						
  <div class="row-fluid">


	<div class="row-fluid">
	
			<!-- 检索  -->
			<form action="voltage/list" method="post" name="dataForm" id="dataForm">
			<table>
				<tr>
					<td>
						<span class="input-icon">
							<input autocomplete="off" id="nav-search-input" type="text" name="userId" value="${param.userId }" placeholder="用户id" />
							<i id="nav-search-icon" class="icon-search"></i>
						</span>
					</td>
					<%-- <td style="vertical-align:top;">
						<select class="chzn-select" name="rstatus" id="rstatus" style="vertical-align:top;">
							<option value="">--状态--</option>
							<option value="0" <c:if test="${param.rstatus == 0}">selected</c:if>>正常</option>
							<option value="1" <c:if test="${param.rstatus == 1}">selected</c:if>>错误</option>
						</select>
					</td> --%>
					<td style="vertical-align:top;"><button class="btn btn-mini btn-light" onclick="search();" title="检索"><i id="nav-search-icon" class="icon-search"></i></button></td>
				</tr>
			</table>
			<!-- 检索  -->
		
		
			<table id="table_report" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>用户ID</th>
						<th>电量</th>
						<th>创建时间</th>
						<th class="center">操作</th>
					</tr>
				</thead>

				<tbody>
				<!-- 开始循环 -->	
				<c:choose>
					<c:when test="${not empty voltageList}">
						<c:forEach items="${voltageList}" var="voltage" varStatus="vs">
							<tr>
								<td class='center' style="width: 30px;">${voltage.id}</td>
								<td>${voltage.userId}</td>
								<td>${voltage.voltage}</td>
								<td>${voltage.uploadTimeStr}</td>
								<td style="width: 60px;">
									<div class='hidden-phone visible-desktop btn-group'>
										<shiro:hasPermission name="voltage:delete">
										<a class='btn btn-mini btn-danger' title="删除" onclick="del('${voltage.id }','${voltage.id }');"><i class='icon-trash'></i></a>
										</shiro:hasPermission>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr class="main_info">
							<td colspan="10" class="center">没有相关数据</td>
						</tr>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
			
				<div class="page-header position-relative">
		<table style="width:100%;">
			<tr>
				<%-- <td style="vertical-align:top;">
					<shiro:hasPermission name="voltage:create">
						<a class="btn btn-small btn-success" onclick="add();">新增</a>
					</shiro:hasPermission>
				</td> --%>
				<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
			</tr>
		</table>
		</div>
			
		</form>
	</div>
 
 
 
 
	<!-- PAGE CONTENT ENDS HERE -->
  </div><!--/row-->
	
</div><!--/#page-content-->
</div><!--/.fluid-container#main-container-->
		
		<!-- 返回顶部  -->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript" src="static/js/bootbox.min.js"></script><!-- 确认窗口 -->
		<!-- 引入 -->
		
		
		<script type="text/javascript" src="static/js/jquery.tips.js"></script><!--提示框-->
		<script type="text/javascript">
		
		$(top.hangge());
		
		//检索
		function search(){
			top.jzts();
			$("#dataForm").submit();
		}
		
		//删除
		function del(id,msg){
			bootbox.confirm("确定要删除["+msg+"]吗?", function(result) {
				if(result) {
					top.jzts();
					var url = "<%=basePath%>voltage/delete?id="+id;
					$.get(url,function(data){
						nextPage(${page.currentPage});
					});
				}
			});
		}
		
		</script>
		
		<script type="text/javascript">
		
		$(function() {
			
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//复选框
			$('table th input:checkbox').on('click' , function(){
				var that = this;
				$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
					
			});
			
		});
		
		</script>
		
	</body>
</html>

