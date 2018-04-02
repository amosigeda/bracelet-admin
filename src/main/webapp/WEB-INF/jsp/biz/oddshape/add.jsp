<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="static/css/chosen.css" />
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>			
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
		<!-- 上传图片插件 -->
		<link href="plugins/uploadify/uploadify.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="plugins/uploadify/swfobject.js"></script>
		<script type="text/javascript" src="plugins/uploadify/jquery.uploadify.v2.1.4.min.js"></script>
		
		<!-- 上传图片插件 -->
		<script type="text/javascript">
		var jsessionid = "<%=session.getId()%>";  //勿删，uploadify兼容火狐用到
		</script>
		
<script type="text/javascript">
	$(top.hangge());
	//保存
	/* function save(){
		$("#userForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	} */
	//保存
	function save(){
		
		if($("#username").val()=="" || $("#username").val()=="此用户名已经存在"){
			
			$("#username").tips({
				side:3,
	            msg:'输入用户名',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#username").focus();
			$("#username").val('');
			$("#username").css("background-color","white");
			return false;
		}else{
			$("#username").val(jQuery.trim($('#username').val()));
		}
		hasU();
	}
	
	//判断用户名是否存在
	function hasU(){
		var username = $.trim($("#username").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>oddshape/validateUser',
	    	data: {username:username},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					$("#userForm").submit();
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				 }else{
					 $("#username").tips({
							side:3,
				            msg:'此用户名不存在,请先注册!',
				            bg:'#AE81FF',
				            time:2
				        });
						
						$("#username").focus();
						//$("#roleName").val('');
						$("#username").css("background-color","white");
				 }
			}
		});
	}
</script>
</head>
<body>
	<form action="oddshape/doAdd" name="userForm" id="userForm" method="post" enctype="multipart/form-data">
		<div id="zhongxin">
		<table>
		    <tr>
				<td><input type="text" name="username" id="username" autocomplete="off" value="" maxlength="32" placeholder="这里输入用户名(手机号)" title="用户名"/></td>
			</tr>
			
			<tr>
				<td><input type="text" name="name" id="name" autocomplete="off" value="" maxlength="32" placeholder="这里输入围栏名称" title="围栏名"/></td>
			</tr>
			<tr>
			<td><input name="excelPath" id="excelPath"   type="file" /></td>
     <!--    <input type="button" id="importBuildInfo" value="从excel导入"/> -->
				<!-- <td><input id="excel_file" type="file" name="filename" accept="xlsx" size="80"/></td> -->
				<!-- <td><input id="excelFile" type="file"> </td> -->
			</tr>
			<tr>
				<td style="text-align: center;">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
		
	</form>
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		
		<script type="text/javascript">
		
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 

		});
		
		</script>
	
</body>
</html>