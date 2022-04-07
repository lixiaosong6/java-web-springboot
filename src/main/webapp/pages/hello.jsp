<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%> --%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript" src="${ctx }/js/jui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/js/jui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }/js/jui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx }/js/jui/jquery.form.js"/></script>
</head>

<body>

	helloJsp

	<hr>

	${hello}



</body>

</html>