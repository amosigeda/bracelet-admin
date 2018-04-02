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
		
		if($("#heartRate").val()==""){
			$("#heartRate").tips({
				side:3,
	            msg:'输入脉搏',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#heartRate").focus();
			$("#heartRate").val('');
			$("#heartRate").css("background-color","white");
			return false;
		}else{
			$("#heartRate").val(jQuery.trim($('#heartRate').val()));
		}

		if($("#userId").val()==""){
			$("#userId").tips({
				side:3,
	            msg:'输入用户ID',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#userId").focus();
			$("#userId").val('');
			$("#userId").css("background-color","white");
			return false;
		}else{
			$("#userId").val(jQuery.trim($('#userId').val()));
		}

		if($("#imei").val()==""){
			$("#imei").tips({
				side:3,
	            msg:'输入IMEI',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#imei").focus();
			$("#imei").val('');
			$("#imei").css("background-color","white");
			return false;
		}else{
			$("#imei").val(jQuery.trim($('#imei').val()));
		}	

		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
</head>
<body>
	<form action="heartRate/doAdd" name="dataForm" id="dataForm" method="post" >
		<div id="zhongxin">
		<table>
			<tr>
				<td><input type="text" name="heartRate" id="heartRate" autocomplete="off" value="" maxlength="8" placeholder="这里输入脉搏" title="脉搏"/></td>
			</tr>
			<tr>
				<td><input type="text" name="userId" id="userId" autocomplete="off" value="" maxlength="32" placeholder="这里输入用户ID" title="用户ID"/></td>
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