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
</script>
	</head>
<body>
	<form action="sys/doEdit" name="dataForm" id="dataForm" method="post" >
		<input type="hidden" name="id" id="id" value="${sys.id }"/>
		<div id="zhongxin">
		<table>
			<tr>
				<td>
					<input type="hidden" id="serviceContent" name="serviceContent" value="" />
					<div id="editor"></div>
				</td>
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

		<script type="text/javascript" src="static/js/wangEditor.min.js"></script>
		<script type="text/javascript" src="static/js/utils.js"></script>
		<script type="text/javascript">
			var E = window.wangEditor
			var editor = new E('#editor')
			editor.customConfig.zIndex = 100
			editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
			editor.customConfig.debug = location.href.indexOf('wangeditor_debug_mode=1') > 0
			editor.create()
			// var initContent = "";
			// initContent = HTMLDecode('${sys.serviceContent}');
			setTimeout(function () {
					editor.txt.html('${sys.serviceContent}')
			}, 200); 

			//保存
			function save(){
				$('#serviceContent').val(editor.txt.html());
				if($("#serviceContent").val()==""){
					$("#serviceContent").tips({
						side:3,
									msg:'输入客户服务',
									bg:'#AE81FF',
									time:2
							});
					
					$("#serviceContent").focus();
					$("#serviceContent").val('');
					$("#serviceContent").css("background-color","white");
					return false;
				}else{
					$("#serviceContent").val(jQuery.trim($('#serviceContent').val()));
					$("#dataForm").submit();
				}
			}
		</script>
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
		});
		
		</script>
	
</body>
</html>