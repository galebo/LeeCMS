<%@ include file="/common/taglibs.jsp" %>


<%@page import="com.galebo.common.WorkerException"%><title>Data Access Error</title>

<head>
    <meta name="heading" content="Data Access Failure"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<p>
    <c:out value="${useAfter}"/>
</p>

<!--
<% 
WorkerException.handle((Exception) request.getAttribute("exception"));
%>
-->

<a href="mainMenu" onclick="history.back();return false">&#171; Back</a>
