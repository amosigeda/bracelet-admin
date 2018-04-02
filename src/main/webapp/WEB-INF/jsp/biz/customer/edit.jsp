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
		<script type="text/javascript" src="static/js/jquery-3.2.0.min.js"></script>
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
		
		hasU();
	}
	
	//判断用户名是否存在
	function hasU(){
		var userId = $.trim($("#userId").val());
		var username = $.trim($("#username").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>customer/validateUser',
	    	data: {userId:userId,username:username},
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
						$("#username").css("background-color","white");
				 }
			}
		});
	}
</script>
	</head>
<body>
	<form action="customer/doEdit" name="userForm" id="userForm" method="post" >
		<input type="hidden" name="userId" id="userId" value="${user.userId }"/>
		<div id="zhongxin">
		<table>
			<tr>
				<td><input type="text" name="username" id="username" autocomplete="off" value="${user.username }" maxlength="32" placeholder="这里输入用户名" title="用户名"/></td>
			</tr>
			<tr>
				<td><input type="password" name="password" id="password" autocomplete="off" value=""  maxlength="32" placeholder="输入密码" title="密码"/></td>
			</tr>
		<%-- 	<tr>
				<td>
					<img src="data:image/png;base64,${user.avatar }" style="width: 35px; height: 35px;"/>
					<input type="file" id="upload_file" keepDefaultStyle = "true"/>
					<input type="hidden" name="avatar" id="upload_file_base64" value="${user.avatar }"/>
				</td>
			</tr> --%>
			<tr>
				<td><input type="text" name="nickname" id="nickname" autocomplete="off" value="${user.nickname }" maxlength="32" placeholder="这里输入昵称" title="昵称"/></td>
			</tr>
			<tr>
				<td>
					<input name="sex" id="sex0" type="radio" value="0" <c:if test="${user.sex == 0}">checked="true"</c:if> />男</label>
					<input name="sex" id="sex1" type="radio" value="1" <c:if test="${user.sex == 1}">checked="true"</c:if> />女</label>
					<input name="sex" id="sex2" type="radio" value="2" <c:if test="${user.sex == 2}">checked="true"</c:if> />保密</label>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="weight" id="weight" autocomplete="off" value="${user.weight }" maxlength="8" placeholder="这里输入体重" title="体重"/></td>
			</tr>
			<tr>
				<td><input type="text" name="height" id="height" autocomplete="off" value="${user.height }" maxlength="8" placeholder="这里输入身高" title="身高"/></td>
			</tr>
			<tr>
				<td><input type="text" name="address" id="address" autocomplete="off" value="${user.address }" maxlength="255" placeholder="这里输入地址" title="地址"/></td>
			</tr>
			<tr>
				<td><input type="text" name="dv" id="dv"  autocomplete="off" value="${user.dv }" maxlength="64" placeholder="这里输入DV" title="dv"/></td>
			</tr>
			<tr>
				<td><input type="text" name="sd" id="sd"  autocomplete="off" value="${user.sd }" maxlength="64" placeholder="这里输入SD" title="sd"/></td>
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

		<script type="text/javascript">
			
			function run(input_file,get_data){
					if ( typeof(FileReader) === 'undefined' ){
							alert("抱歉，你的浏览器不支持 FileReader，不能将图片转换为Base64，请使用现代浏览器操作！");
					} else {
							try{
									var file = input_file.files[0];
									if(!/image\/\w+/.test(file.type)){
											alert("请确保文件为图像类型");
											return false;
									}
									var limitSize = 512000;
									var file_size = file.size;
									if(file_size >= limitSize){
											alert('文件太大，请保证图片小于500kb！');
											return false;
									}
									var reader = new FileReader();
									reader.onload = function(){
											get_data(this.result);
									}
									reader.readAsDataURL(file);
							} catch (e){
									alert('图片转Base64出错啦！'+ e.toString())
							}
					}
			}
			
			function displayBase64(data){
				$('#upload_file_base64').val(data);
			}
			
			function switchImg(){
				var $img = $(this);
				run(this, displayBase64);
			}
			
			$(function() {				
				$('#upload_file').on('change', switchImg);
			});
			
			</script>
	
</body>
</html>