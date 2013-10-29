<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="colColumnDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='colColumnDetail.heading'/>"/>
</head>

<form:form commandName="colColumn" method="post" action="colColumnform" id="colColumnForm" onsubmit="return validateColColumn(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="columnId"/>
<form:hidden path="colPid"/>
<form:hidden path="userId"/>
<input type="hidden" id="jbox" name="jbox" value="${jbox}"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="colColumn.colName"/>
        <form:errors path="colName" cssClass="fieldError"/>
        <form:input path="colName" id="colName" cssClass="text medium" cssErrorClass="text medium error" maxlength="100"/>
    </li>
    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty colColumn.columnId}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('colColumn')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <c:if test="${not empty jbox}">
        	<input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="javascript:window.parent.window.jBox.close();"/>
        </c:if>
        <c:if test="${empty jbox}">
			<input type="button" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="javascript:history.back(-1);"/>
        </c:if>
    </li>
</ul>
</form:form>

<v:javascript formName="colColumn" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    Form.focusFirstElement($('colColumnForm'));
</script>
