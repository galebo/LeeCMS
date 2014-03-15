<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="cfgGroupDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='cfgGroupDetail.heading'/>"/>
</head>

<form:form commandName="cfgGroup" method="post" action="cfgGroupform" id="cfgGroupForm" onsubmit="return validateCfgGroup(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="groupId"/>
<form:hidden path="type"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="cfgGroup.groupKey"/>
        <form:errors path="groupKey" cssClass="fieldError"/>
        <form:input path="groupKey" id="groupKey" cssClass="text medium" cssErrorClass="text medium error" maxlength="30"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="cfgGroup.groupName"/>
        <form:errors path="groupName" cssClass="fieldError"/>
        <form:input path="groupName" id="groupName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
    </li>

    <li class="buttonBar bottom">
		<input type="hidden" id="jbox" name="jbox" value=""/>
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>" onclick="javascript:submitButton();" />
        <c:if test="${not empty cfgGroup.groupId}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('cfgGroup')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
		<input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="javascript:cancelButton();"/>
    </li>
</ul>
</form:form>

<v:javascript formName="cfgGroup" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    //Form.focusFirstElement($('cfgGroupForm'));
</script>
