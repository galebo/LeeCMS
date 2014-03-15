<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="conLinkDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='conLinkDetail.heading'/>"/>
</head>
<form:form commandName="conLink" method="post" action="conLinkform" id="conLinkForm" onsubmit="return validateConLink(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="linkId"/>
<form:hidden path="type"/>
<input type="hidden" name="groupId" value="${groupId}"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="conLink.imgUrl"/>
        <form:errors path="imgUrl" cssClass="fieldError"/>
        <form:input path="imgUrl" id="imgUrl" cssClass="text large" cssErrorClass="text medium error" maxlength="200"/>
        <input type="button" onclick="business.showUploadFile();" value='<fmt:message key="menu.selectFile"/>'></input>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="conLink.title"/>
        <form:errors path="title" cssClass="fieldError"/>
        <form:input path="title" id="title" cssClass="text medium" cssErrorClass="text medium error" maxlength="200"/><font style="color: #ff0000"><fmt:message key="require"/></font>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="conLink.url"/>
        <form:errors path="url" cssClass="fieldError"/>
        <form:input path="url" id="url" cssClass="text large" cssErrorClass="text medium error" maxlength="200"/>
        <input type="button" onclick="business.showColumn();" value='<fmt:message key="2BA"/>'></input>
        <input type="button" onclick="business.showContent();" value='<fmt:message key="2BB"/>'></input>
        <input type="button" onclick="business.showSelfDefine();r" value='<fmt:message key="2BC"/>'></input><br/><div id="desc"></div>
    </li>

    <li class="buttonBar bottom">
    	<input type="hidden" id="jbox" name="jbox" value=""/>
        <input type="submit" class="button" name="save"   value="<fmt:message key="button.save"/>"   onclick="javascript:submitButton();"/>
        <c:if test="${not empty conLink.linkId}">
        <c:if test="${type ==1}">
       		 <input type="submit" class="button" name="delete" onclick="javascript:deleteButton('conLink')" value="<fmt:message key="button.delete"/>" />
        </c:if>
        <c:if test="${type ==2}">
   		     <input type="submit" class="button" name="delete" onclick="javascript:deleteButton('changePic')" value="<fmt:message key="button.delete"/>" />
        </c:if>
        </c:if>
		<input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="javascript:cancelButton();"/>
    </li>
</ul>
</form:form>
<div id="select">
	<div class="divTree" id="column">
		<table id="columnTable"></table>
		<div id="columnDiv"></div>
	</div>
	<div class="divTree" id="parent">
		<table id="parentTable"></table>
		<div id="parentDiv"></div>
	</div>
	<div class="divTree" id="son">
		<table id="sonTable"></table>
		<div id="sonDiv"></div>
	</div>
</div>
<script type="text/javascript" src="/p/plugin/jquery-ui-1.8.17.custom/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/p/plugin/jquery-ui-1.8.17.custom/js/jquery-ui-1.8.17.custom.min.js"></script>
<link rel="stylesheet" type="text/css"  href="/p/plugin/jquery-ui-1.8.17.custom/css/ui-lightness/jquery-ui-1.8.17.custom.css"/>

<!-- jquery jqgrid start -->
<link rel="stylesheet" type="text/css" media="screen" href="/p/plugin/jquery.jqGrid-4.3.1/css/ui.jqgrid.css" />
<script type="text/javascript" src="/p/plugin/jquery.jqGrid-4.3.1/js/i18n/grid.locale-cn.js"></script>
<script type="text/javascript" src="/p/plugin/jquery.jqGrid-4.3.1/js/jquery.jqGrid.src.js"></script>
<!-- jquery jqgrid end -->

<!-- jquery jBox start -->
<link rel="stylesheet" type="text/css" media="screen" href="/p/plugin/jBox/Skins2/Green/jbox.css" />
<script type="text/javascript" src="/p/plugin/jBox/jquery.jBox-2.3.min.js"></script>
<script type="text/javascript" src="/p/plugin/jBox/i18n/jquery.jBox-zh-CN.js"></script>		
<!-- jquery jBox end -->	


<v:javascript formName="conLink" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/js/common/common.js'/>"></script>
<script type="text/javascript" src="<c:url value='/p/js/business/conLink.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/p/css/jq.css'/>" />
