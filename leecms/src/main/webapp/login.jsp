<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<script type="text/javascript">
<!--
if(window.parent.window.jBox!=null)
{
	alert('<fmt:message key="reLogin"/>');
	window.parent.window.jBox.close();
}
//-->
</script>
<head>
    <title><fmt:message key="login.title"/></title>
    <meta name="heading" content="<fmt:message key='login.heading'/>"/>
    <meta name="menu" content="Login"/>
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/p/styles/${appConfig["csstheme"]}/layout-1col.css'/>" />
	<link rel="stylesheet" href="<c:url value='/p/css/login.css'/>" />
</head>
<body id="login">


<c:if test="${param.error != null}">
    <li class="error">
        <img src="${ctx}/p/images/iconWarning.gif" alt="<fmt:message key='icon.warning'/>" class="icon"/>
        <fmt:message key="errors.password.mismatch"/>
        <%--${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}--%>
    </li>
</c:if>

<div id="login-wrap" class="login-wrap">
		<div class="hd">
			<div class="inner">
				<h1 class="site-title">
					<span class="txt-hidden">LEE_CMS</span>
				</h1>
			</div>
		</div>

		<div class="bd">
			<div class="inner">
				<div class="banner"></div>
				<div id="login" class="main" style="margin-top: -10px;">
				
				
				
				<div>
					<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"   onsubmit="saveUsername(this);return validateForm(this)">
					<table>
						<tbody>
						<tr>
							<th><fmt:message key="label.username"/>：</th>
							<td>
								<div class="col">
									<input type="text" autocomplete="false" tabindex="1" class="txt" name="j_username" id="j_username">
								</div>
							</td>
						</tr>
						<tr>
							<th><fmt:message key="label.password"/>：</th>
							<td>
								<div class="col">
									<input type="text" tabindex="2" class="txt" name="j_password" id="j_password">
								</div>
							</td>
						</tr>
						<tr>
							<th></th>
							<td><button tabindex="13" class="act-btn txt-hidden" type="submit" id="imweb_submit">登陆</button>
						</td>
						</tr>
					</tbody></table></form>
				</div>


					<div class="login-nav">
						<a target="_blank" href="#"><i class="i-forgetpass"></i>忘记密码了？</a> <span class="split">|</span> <a href="#" target=_blank>可用Email注册</a>
					</div>
				</div>
			</div>
		</div>
		<div class="ft">
			<div class="inner">
				<div class="copyright">
					<p>
						<a href="#" target="_blank">京网文[2011]0483-070 号</a> 增值电信业务经营许可证：<a href="#" target="_blank">京B2-20090059</a>&nbsp;<a href="#" target="_blank">服务协议</a>|<a href="#" target="_blank">提建议</a>|<a href="#">客服</a> |<a href="#">Complaint Guidelines</a> </span>
					</p>
					<p>
						Copyright © 2008 - <span id="copyendyear">2014</span> Galebo. <a target="_blank" href="#">All Rights Reserved.</a>佳乐博工作室 <a target="_blank" href="#">版权所有</a>
					</p>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript" src="/p/scripts/prototype.js"></script>
<%@ include file="/p/scripts/login.js"%>

</body>