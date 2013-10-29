<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="colColumnList.title"/></title>
    <meta name="heading" content="<fmt:message key='colColumn'/><fmt:message key='List.heading'/>"/>
    <meta name="menu" content="ColColumnMenu"/>
</head>



<!-- jqGreed start-->
<div class="divTree">
	<table id="columnTable"></table>
	<div id="pcolumnTable"></div>
</div>
<script type="text/javascript" src="<c:url value='/p/js/business/column.js'/>"></script>
