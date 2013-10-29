<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pageContext.request.remoteUser == null}">
<c:redirect url="/pp/w/webIndex"/>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<title>自助建站系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
	<frameset rows="86,6,*,20" cols="*" id="parentframe" framespacing="0" frameborder="NO" border="0">
		<frame src="/pages/main/top2.jsp" name="topFrame" noresize="noresize" scrolling="no">
		<frame src="/pages/main/middle2.html" name="middleFrame">
		<frame src="/pages/main/center.html" name="centerFrame">
		<frame src="/pages/main/bottom.html" name="bottomFrame" noresize="noresize" scrolling="no">
	</frameset>
</html>