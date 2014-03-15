<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html><head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<script type="text/javascript" src="js/main.js"></script>
<style type="text/css"> 
	<!-- 
body { margin-left: 0px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px; background-image: url(images/top_bg1.jpg); }
.aleft{float: left;top:10px;}
.aright{float: right;}
.aright1{margin: 8px 0px 9px;}

--></style>

<link href="css/Style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="main.js"></script>
</head>
<body>
<div class="aleft"><span style="font-size: 40px;color:#fdf2f9; margin: 30px;line-height: 70px;font-family: 微软雅黑">网&nbsp站&nbsp管&nbsp理&nbsp系&nbsp统</span></div>
<div class="aright">
	<div class="aright1">
		<span><img src="images/user.jpg" height="16" width="16"></span>
		<c:if test="${pageContext.request.remoteUser != null}">
        | <span><font color="#fdf2f9">您好：${pageContext.request.remoteUser}&nbsp;&nbsp;</font></span>
        </c:if>
		
		<span><img src="images/clock.gif" height="18" width="18"></span>
		<span id="jnkc" style="color:#fdf2f9"></span>
	</div>
	<div class="aright2">
		<span><a href="<c:url value="/pages/view/index/1.html"/>" target="_blank"><img src="images/btn1.png" border="0"></a></span>
		<span><a style="cursor: hand" onclick='parent.centerFrame.mainFrame.document.location.href="/pages/webInfo"'><img src="images/btn2.png" border="0"></a></span>
		<span><a style="cursor: hand" onclick='parent.centerFrame.mainFrame.document.location.href="/pages/webInfo"'><img src="images/btn4.png" width="105"></a></span>
		<!--span><a href="" target="_blank"><img src="images/btn5.gif" alt="在线支付，免手续费" border="0" height="40" width="105"></a></span-->
		<span><a style="cursor: hand" onclick="IsExit()"><img src="images/btn4.png"></a></span>
	</div>
</div>
	
<script>
initTime()
</script>
</body></html>