<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>

</head>
<body>
	<div align="center" style="margin-top: 80px;">
		<h2>神兜兜管理平台</h2>
		<p>欢迎登录</p>
		<div style="margin:20px 0;"></div>
		<div class="easyui-panel" title="登录" style="width:400px;padding:30px 70px 20px 70px">
			<div style="color: red;" id="showMsg">
				<strong>
					<c:if test="${param.error=='captchaValidateException'}">验证码错误</c:if>
					<c:if test="${param.error=='loginException'}">用户名/密码错误</c:if> 
					<c:if test="${param.error=='excessiveAttemptsException'}">密码错误次数超限,请5分钟后重试</c:if>
					<c:if test="${param.error=='disableAccountException'}">该用户已被禁用</c:if>
					<c:if test="${param.error=='lockedAccountException'}">用户已被锁定</c:if>
					<c:if test="${param.error=='kickoutException'}">改账户已在别处登陆</c:if>
					<c:if test="${param.error=='unkonwExecption'}">改账户已在别处登陆</c:if>
					<c:if test="${param.error=='otherException'}">其他错误</c:if>
				</strong>
			</div>
			<form id="loginForm" method="post" action="<c:url value="/login"/>">
				<div style="margin-bottom:10px">
				<input class="easyui-textbox" 
					name="username" value="<shiro:principal/>"
					style="width:100%;height:40px;padding:12px" 
					data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38">
			</div>
			<div style="margin-bottom:10px">
				<input class="easyui-textbox" type="password" name="password"
					style="width:100%;height:40px;padding:12px" 
					data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38">
			</div>
			<div style="margin-bottom:20px">
				<span style="padding-right: 25px">
					<img src="<%=request.getContextPath()%>/captcha/captcha-image.do?t=Math.random()"  id="kaptchaImage"
							align="left" width="30%" height="40px"/>
				</span>
				<input class="easyui-textbox" name="captchaCode"
					style="width:60%;height:40px;padding:12px;" 
					data-options="prompt:'验证码',iconCls:'icon-man',iconWidth:38">
			</div>
			<div style="margin-bottom:20px">
				<input type="checkbox" checked="checked" name="rememberMe">
				<span>Remember me</span>
			</div>
			<div>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" 
					style="padding:5px 0px;width:100%;" onclick="login()">
					<span style="font-size:14px;">Login</span>
				</a>
			</div>
			</form>
		</div>
	</div>
</body>
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
	});
	function login() {
		this.loginForm.submit();
	}
	$("#kaptchaImage").bind('click', function(){
		$(this).attr('src', '<%=request.getContextPath()%>/captcha/captcha-image.do?t='+Math.random());
	});

</script>
</html>