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
		
		if($("#key").val()==""){
			$("#key").tips({
				side:3,
	            msg:'输入Key',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#key").focus();
			$("#key").val('');
			$("#key").css("background-color","white");
			return false;
		}else{
			$("#key").val(jQuery.trim($('#key').val()));
		}

		if($("#value").val()==""){
			$("#value").tips({
				side:3,
	            msg:'输入Value',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#value").focus();
			$("#value").val('');
			$("#value").css("background-color","white");
			return false;
		}else{
			$("#value").val(jQuery.trim($('#value').val()));
		}

		if($("#description").val()==""){
			$("#description").tips({
				side:3,
	            msg:'输入描述',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#description").focus();
			$("#description").val('');
			$("#description").css("background-color","white");
			return false;
		}else{
			$("#description").val(jQuery.trim($('#description').val()));
		}

		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
</head>
<body>
	<form action="conf/doAdd" name="dataForm" id="dataForm" method="post" >
		<div id="zhongxin">
		<table>
			<tr>
				<td><input type="text" name="key" id="key" autocomplete="off" value="" maxlength="64" placeholder="这里输入Key" title="Key"/></td>
			</tr>
			<tr>
				<td><input type="text" name="value" id="value"  autocomplete="off" value="" maxlength="255" placeholder="这里输入Value" title="Value"/></td>
			</tr>
			<tr>
				<td><input type="text" name="description" id="description" autocomplete="off" value="" maxlength="255" placeholder="这里输入描述" title="描述"/></td>
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