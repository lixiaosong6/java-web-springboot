<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>神兜兜</title>
<script type="text/javascript" src="static/jui/jquery.min.js"></script>
<script type="text/javascript" src="static/jui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="static/jui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="static/jui/themes/icon.css" type="text/css"></link>
<script type="text/javascript">
	function addTab(title, url) {
		if ($('#tt').tabs('exists', title)) {
			$('#tt').tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="'
					+ url + '" style="width:100%;height:100%;"></iframe>';
			$('#tt').tabs('add', {
				title : title,
				content : content,
				closable : true
			});
		}
	}
</script>
<style>
a {
	text-decoration: none
}
</style>
</head>
<body class="easyui-layout">
	<!-- TOP -->
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">
		<div style="position: absolute; top: 34px; right: 20px;" align="right">
			你好，
			<shiro:principal />
			| <a href="<c:url value="/logout"/>"> <span
				style="font-size: 14px;">退出</span>
			</a>
		</div>
	</div>
	<!-- 左边 -->
	<div data-options="region:'west',split:true,title:'菜单'"
		style="width: 150px;">
		<div class="easyui-accordion"
			style="width: 100%; height: 99%; padding-top: 3px">
			<div title="用户管理" data-options="iconCls:'icon-man'"
				style="overflow: auto; padding: 10px;">
				<ul>
					<li><a href="#"
						onclick="addTab('用户列表','<c:url value="/userManage/userList.jsp"/>')">用户列表</a>
					</li>
				</ul>
			</div>
			<div title="交易管理" data-options="iconCls:'icon-man'"
				style="overflow: auto; padding: 10px;">
				<ul>
					<li><a href="#"
						onclick="addTab('订单列表','<c:url value="/transManage/orderList.jsp"/>')">订单列表</a>
					</li>
				</ul>
				<ul>
					<li><a href="#"
						onclick="addTab('团购列表','<c:url value="/transManage/tgOrderList.jsp"/>')">团购列表</a>
					</li>
				</ul>
			</div>
			<div title="商品管理" data-options="iconCls:'icon-man'"
				style="overflow: auto; padding: 10px;">
				<ul style="margin-top: 5px;">
					<li><a href="#"
						onclick="addTab('栏目管理','<c:url value="/goods/columnList"/>')">栏目管理</a>
					</li>
				</ul>
				<ul style="margin-top: 5px;">
					<li><a href="#"
						onclick="addTab('商品管理','<c:url value="/goods/goodsList"/>')">商品管理</a>
					</li>
				</ul>
				<ul style="margin-top: 5px;">
					<li><a href="#"
						onclick="addTab('团购秒杀商品','<c:url value="/goods/goodsEventList"/>')">团购秒杀商品</a>
					</li>
				</ul>
				<ul style="margin-top: 5px;">
					<li><a href="#"
						onclick="addTab('首页商品管理','<c:url value="/goods/goodsHomeList"/>')">首页商品管理</a>
					</li>
				</ul>
				<ul style="margin-top: 5px;">
					<li><a href="#"
						onclick="addTab('品牌管理','<c:url value="/goods/brandList"/>')">品牌管理</a>
					</li>
				</ul>
				<ul style="margin-top: 5px;">
					<li>
						<a href="#" onclick="addTab('汇率设置','<c:url value="/goods/setGoodsPrice"/>')">汇率设置</a>
					</li>
				</ul>
			</div>
			<div title="推送管理" data-options="iconCls:'icon-man'" style="overflow: auto; padding: 10px;">
				<ul style="margin-top: 5px;">
					<li>
						<a href="#" onclick="addTab('推送','<c:url value="/notice/allNotice.jsp"/>')">推送</a>
					</li>
				</ul>
				<ul style="margin-top: 5px;">
					<li>
						<a href="#" onclick="addTab('推送列表','<c:url value="/notice/noticeList.jsp"/>')">推送列表</a>
					</li>
				</ul>
			</div>
			<div title="礼包管理" data-options="iconCls:'icon-man'" style="overflow: auto; padding: 10px;">
				<ul>
					<li><a href="#"
						onclick="addTab('礼包列表','<c:url value="/giftManage/giftList.jsp"/>')">礼包列表</a>
					</li>
				</ul>
			</div>
			<div title="系统管理" data-options="iconCls:'icon-man'"
				style="overflow: auto; padding: 10px;">
				<ul>
					<li><a href="#"
						onclick="addTab('系统权限','<c:url value="/sysManage/sysPower.jsp"/>')">系统权限</a>
					</li>
				</ul>
				<ul>
					<li><a href="#"
						onclick="addTab('系统管理员','<c:url value="/sysManage/sysUser.jsp"/>')">系统管理员</a>
					</li>
				</ul>
				<ul>
					<li><a href="#"
						onclick="addTab('系统角色','<c:url value="/sysManage/sysRole.jsp"/>')">系统角色</a>
					</li>
				</ul>
				<ul>
					<li><a href="#" onclick="addTab('客户端版本','<c:url value="/sysManage/clientVer.jsp"/>')">客户端版本</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 右边 -->
	<div data-options="region:'east',split:true,collapsed:true,title:'其它'"
		style="width: 100px; padding: 10px;">其它</div>
	<!-- 下面 -->
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">
		<div align="center" style="margin-top: 5px;">
			<span style="size: 14px;"> 版权所有：神兜兜 </span>
		</div>
	</div>
	<!-- 中间 -->
	<div data-options="region:'center'">
		<div id="tt" class="easyui-tabs"
			style="width: 100%; height: 99%; padding-top: 3px">
			<div title="首页">
				<div style="margin-top: 20px;">
					<h3>欢迎登录</h3>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
