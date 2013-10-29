<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="List.title"/></title>
	<meta name="heading" content="<fmt:message key='List.heading'/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/p/css/jq.css'/>" />
</head>

<div id="colTip" class="jqTitle"><fmt:message key="colColumn" />:<span id="currentCol"></span></div>
<!-- jqGreed start-->
<div class="divTree">
	<table id="parentTable"></table>
	<div id="parentDiv"></div>
</div>
<div class="divTree">
	<table id="sonTable"></table>
	<div id="sonDiv"></div>
</div>
<script type="text/javascript" src="<c:url value='/p/js/business/common.js'/>"></script>
<script type="text/javascript" src="<c:url value='/p/js/business/columnContent.js'/>"></script>
<!-- jqGreed end-->
