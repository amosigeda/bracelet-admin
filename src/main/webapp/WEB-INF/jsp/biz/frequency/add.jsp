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
		
<script type="text/javascript">
	$(top.hangge());
	
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
		
		if($("#password").val()==""){
			
			$("#password").tips({
				side:3,
	            msg:'输入密码',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#password").focus();
			return false;
		}
		
		hasU();
	}
	
	//判断用户名是否存在
	function hasU(){
		var username = $.trim($("#username").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>customer/validateUser',
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
				            msg:'此用户名已经存在',
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
	<form action="customer/doAdd" name="userForm" id="userForm" method="post" >
		<div id="zhongxin">
		<table>
			
			<tr>
				<td><input type="text" name="username" id="username" autocomplete="off" value="" maxlength="32" placeholder="这里输入用户名" title="用户名"/></td>
			</tr>
			<tr>
				<td><input type="password" name="password" id="password" autocomplete="off" value=""  maxlength="32" placeholder="输入密码" title="密码"/></td>
			</tr>
			<tr>
				<td><input type="text" name="dv" id="dv"  autocomplete="off" value="" maxlength="64" placeholder="这里输入DV" title="dv"/></td>
			</tr>
			<tr>
				<td><input type="text" name="sd" id="sd"  autocomplete="off" value="" maxlength="64" placeholder="这里输入SD" title="sd"/></td>
			</tr>
			<tr>
				<td><input type="text" name="imei" id="imei"  autocomplete="off" value="" maxlength="64" placeholder="这里输入IMEI" title="imei"/></td>
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