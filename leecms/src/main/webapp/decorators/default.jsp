<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/p/styles/${appConfig["csstheme"]}/theme.css'/>" />
        <link rel="stylesheet" type="text/css" media="print" href="<c:url value='/p/styles/${appConfig["csstheme"]}/print.css'/>" />

        <script type="text/javascript" src="<c:url value='/p/scripts/global.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/p/js/common/common.js'/>"></script>
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/>
     <decorator:getProperty property="body.class" writeEntireProperty="true"/>>

    <div id="page">

        <div id="content" class="clearfix">
            <div id="main">
                <%@ include file="/common/messages.jsp" %>
                <decorator:body/>
            </div>

        </div>

    </div>
</body>
</html>
