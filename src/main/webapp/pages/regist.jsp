<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="target-densitydpi=get-target-densitydpi,width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no, initial-scale=1">
<meta name="format-detection" content="telephone=no" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>拍照上传</title>
<script type="text/javascript" src="js/jui/jquery.min.js"></script>
<script type="text/javascript" src="static/jui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="css/game.css" type="text/css"></link>
<link rel="stylesheet" href="static/jui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="static/jui/themes/icon.css" type="text/css"></link>

<script type="text/javascript">
	document.onkeydown = function(e) {
		var event = e || window.event;
		var code = event.keyCode || event.which || event.charCode;
		if (code == 13) {
			login();
		}
	};
	$(function() {
		$("input[name='username']").focus();
		
		
		document.getElementById( 'front').addEventListener( 'change', function () {
		     var reader = new FileReader();
		     reader.onload = function (e) {
		          //调用图片压缩方法：compress();
		     };
		     reader.readAsDataURL(this.files[0]);
		     console.log(this.files[0]);
		     var fileSize = Math.round( this.files[0].size/1024/1024) ; //以M为单位
		     //this.files[0] 该信息包含：图片的大小，以byte计算 获取size的方法如下：this.files[0].size;
		}, false);
	});
	function loginin() {
		if ($("#userName").val() == null || $("#userName").val() == '') {
			alert("请输入用户名");
			return;
		}
		if ($("#password").val() == null || $("#password").val() == '') {
			alert("请输入密码");
			return;
		}
		if ($("#password2").val() == null || $("#password2").val() == '') {
			alert("请输入重复密码");
			return;
		}
		if ($("#mobile").val() == null || $("#mobile").val() == '') {
			alert("请输入手机号");
			return;
		}
		this.loginForm.submit();
	}
</script>
</head>
<body>
	<div id="sky"></div>
	<!-- <div id="head"></div> -->
	<div id="middle">
		<form id="loginForm" method="post" action="<c:url value="/regist"/>">
			<ul style="text-align: center;">
				<li style="font-size: 48px">拍拍拍</li>
				<li>身份证正面照：<input id="front" type="file" accept="image/*;capture=camera"></li>
				<li>身份证反面照：<input id="side" type="file" accept="image/*;capture=camera"></li>
				<li><input class="name" id="userName" name="userName"
					placeholder="请输入用户名" style="width: 90%"></li>
				<li><input type="password" id="password" name="password"
					class="pwd" placeholder="请输入密码" style="width: 90%"></li>
				<li><input type="password" id="password2" name="password2"
					class="pwd" placeholder="请重复输入密码" style="width: 90%"></li>
				<li><input type="text" id="mobile" name="mobile" class="pwd"
					placeholder="请输入手机号" style="width: 90%"></li>
				<li><button id="login" type="button" onclick="loginin()"
						style="width: 95%">立即注册</button></li>
				<!-- <li><span id="err" style="display: inline-block;">密码错误</span></li> -->
			</ul>
		</form>
	</div>
	<div id="footer">

		<a>关于我们@qq996416660 &nbsp &nbsp|&nbsp &nbsp</a> <a>Copyright ©
			2016 木子 保留所有权利 沪ICP备110号-1</a>
	</div>
	<div id="cloud"></div>
</body>
</html>