<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html><head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="/p/css/main/css/style2.css"/>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
<div class="top">
<div class="topbar">
	<div class="topbar_le">
		  <span><a title="" target="_blank" href="#"></a></span>
				<a title="#" target="_blank" href="#"></a>
	</div>
	<div class="topbar_ri">
	 	<div class="opration">
	 	<a title="主站" href="/pp/w/webIndex" target="_black">主站</a>|
	 	<a title="网站预览" href="/pages/view/index/1.html" target="_black">网站预览</a>|
	 	<a title="网站信息" onclick="parent.centerFrame.mainFrame.document.location.href='/pages/webInfo'">网站信息</a>|
	 	<a title="帮助"  onclick="parent.centerFrame.mainFrame.document.location.href='/pages/webInfo'">帮助</a>|
	    <a title="退出" class="toplink" onclick="IsExit();" href="" id="herLogout">退出</a>
	    </div>
    
	    <div class="acc">
	    	<c:if test="${pageContext.request.remoteUser != null}">
	    		<span>您好：${pageContext.request.remoteUser}&nbsp;&nbsp;</span>
	        </c:if>
		</div>
	</div>
</div>

<div class="topB">	
	<div class="topL"><a id="aLogo" target="_top" href="#"></a></div>
    <div id="divObj1" class="topR">
		<div class="topRl">
			<div style="height:24px;  width:300px;" class="newTab"></div>
			<div class="topNav">
		        <div id="divTopMenu" class="topMenu" style="width: 26%;">
		          <ul>
				  	<!--  li title="收件箱" id="mailLs" style="width: 49.5%;"><div class="leftBorderOut"></div>
				 		<div class="rightBorderOut"></div>
				 		<div onclick="" class="contentOut">
				 			<div class="m"><p class="pclickOut" title="收件箱" >收件箱</p></div>
				 		</div></li-->
		          	<li title="" style="width: 49.5%;"><div class="leftBorderOn"></div>
			          	<div class="rightBorderOn"></div>
			          	<div onclick="" class="contentOn">
				          <div class="m"><p class="pclickOn" title="" id="menuOn">欢迎您</p></div>
				          <div class="close"><a onclick=""><span class="x ico"></span></a></div>
				        </div>
			          </li>
		          </ul>
		        </div>
			</div>
			<div id="divlogout"></div>
	    </div>
		<div class="pic"></div>
	</div>
</div>
</div>
</body></html>