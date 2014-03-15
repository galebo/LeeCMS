<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="conContentDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='conContentDetail.heading'/>"/>
</head>

<form:form commandName="conContent" method="post" action="conContentform" id="conContentForm" onsubmit="return validateConContent(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="contentId"/>
<input type="hidden" name="parentId" value="${parentId}"/>
<input type="hidden" name="parentSonId" value="${parentSonId}"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="conContent.nameCn"/>
        <form:errors path="nameCn" cssClass="fieldError"/>
        <form:input path="nameCn" id="nameCn" cssClass="text large" cssErrorClass="text medium error" maxlength="200"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="conContent.author"/>
        <form:errors path="author" cssClass="fieldError"/>
        <form:input path="author" id="author" cssClass="text large" cssErrorClass="text medium error" maxlength="11"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="conContent.source"/>
        <form:errors path="source" cssClass="fieldError"/>
        <form:input path="source" id="source" cssClass="text large" cssErrorClass="text medium error" maxlength="3"/>
    </li>
    
    <li>
        <appfuse:label styleClass="desc" key="conContent.pic"/>
        <form:errors path="pic" cssClass="fieldError"/>
        <form:input path="pic" id="pic" cssClass="text large" cssErrorClass="text medium error" maxlength="256"/>
        <input type="button" value="<fmt:message key="uploadForm.file"/>" id="image3">
    </li>
    <li>
        <appfuse:label styleClass="desc" key="conContent.desc"/>
        <form:errors path="desc" cssClass="fieldError"/>
        <form:textarea path="desc" id="desc" cssClass="text large2" cssErrorClass="text medium error" rows="6" cols="120" />
    </li>
    <c:if test="${not empty columnId}">
    <li>
        <appfuse:lookupselect name="columnId" code="Columns" disabled="true" selected="${columnId}"/>
    </li>
	</c:if>
    <li>
        <appfuse:label styleClass="desc" key="conContent.html"/>
        <form:errors path="html" cssClass="fieldError"/>
       
        <form:textarea path="html" id="html" cssClass="" rows="12" cols="80" cssErrorClass="text medium error"/> 
    </li>

    <li class="buttonBar bottom">
    	<input type="hidden" id="jbox" name="jbox" value=""/>
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>" onclick="javascript:submitButton();" />
		<input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="javascript:cancelButton();"/>
    </li>
</ul>
</form:form>

<v:javascript formName="conContent" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/plugin/jquery-ui-1.8.17.custom/js/jquery-1.7.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/p/plugin/kindeditor/kindeditor.js'/>"></script>
<script type="text/javascript" src="<c:url value='/p/plugin/kindeditor/zh_CN.js'/>"></script>

<script type="text/javascript">
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="html"]', {
		allowFileManager : true,
		uploadJson : 'aFile'
	});
});
$('#image3').click(function() {
	editor.loadPlugin('image', function() {
		editor.plugin.imageDialog({
			showRemote : false,
			imageUrl : $('#pic').val(),
			clickFn : function(url, title, width, height, border, align) {
				$('#pic').val(url);
				editor.hideDialog();
			}
		})
	})
});
</script>
<style>
<!--
form[id] li  div.ke-container
{ display: block;
}
form[id] li  div.ke-statusbar
{ display: block;
}
-->
</style>
