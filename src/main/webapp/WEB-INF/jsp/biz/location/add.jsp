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

		if($("#locationType").val()==""){
			$("#locationType").tips({
				side:3,
	            msg:'输入类型',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#locationType").focus();
			$("#locationType").val('');
			$("#locationType").css("background-color","white");
			return false;
		}else{
			$("#locationType").val(jQuery.trim($('#locationType').val()));
		}

		if($("#lat").val()==""){
			$("#lat").tips({
				side:3,
	            msg:'输入纬度',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#lat").focus();
			$("#lat").val('');
			$("#lat").css("background-color","white");
			return false;
		}else{
			$("#lat").val(jQuery.trim($('#lat').val()));
		}

		if($("#lng").val()==""){
			$("#lng").tips({
				side:3,
	            msg:'输入经度',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#lng").focus();
			$("#lng").val('');
			$("#lng").css("background-color","white");
			return false;
		}else{
			$("#lng").val(jQuery.trim($('#lng').val()));
		}

		$("#dataForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
</head>
<body>
	<form action="location/doAdd" name="dataForm" id="dataForm" method="post" >
		<div id="zhongxin">
		<table>
			<tr>
				<td><input type="text" name="userId" id="userId" autocomplete="off" value="" maxlength="32" placeholder="这里输入用户ID" title="用户ID"/></td>
			</tr>
			<tr>
				<td><input type="text" name="imei" id="imei"  autocomplete="off" value="" maxlength="64" placeholder="这里输入IMEI" title="imei"/></td>
			</tr>
			<tr>
				<td>
					<input name="locationType" id="locationType0" type="radio" value="0">GPS</label>
					<input name="locationType" id="locationType1" type="radio" value="1">基站</label>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="lat" id="lat" autocomplete="off" value="" maxlength="12" placeholder="这里输入纬度" title="纬度"/></td>
			</tr>
			<tr>
				<td><input type="text" name="lng" id="lng" autocomplete="off" value="" maxlength="12" placeholder="这里输入经度" title="经度"/></td>
			</tr>
			<tr>
				<td><input type="text" name="accuracy" id="accuracy" autocomplete="off" value="" maxlength="8" placeholder="这里输入精度" title="精度"/></td>
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