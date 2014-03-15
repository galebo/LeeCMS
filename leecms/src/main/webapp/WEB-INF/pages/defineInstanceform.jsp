<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="defineInstanceDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='defineInstanceDetail.heading'/>"/>
</head>

<form:form commandName="cfgDefineInstance" method="post" action="defineInstanceform" id="defineInstanceForm" onsubmit="return validateMaterial(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="defineInstanceId"/>
<form:hidden path="userId"/>
<form:hidden path="updateTime"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="defineInstance.text"/>
        <form:errors path="text" cssClass="fieldError"/>
        <form:input path="text" id="text" cssClass="text medium" cssErrorClass="text medium error" maxlength="65535"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="defineInstance.title"/>
        <form:errors path="title" cssClass="fieldError"/>
        <form:input path="title" id="title" cssClass="text medium" cssErrorClass="text medium error" maxlength="200"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="defineInstance.type"/>
        <form:errors path="type" cssClass="fieldError"/>
        <form:input path="type" id="type" cssClass="text medium" cssErrorClass="text medium error" maxlength="3"/>
    </li>

    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty defineInstance.defineInstanceId}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('defineInstance')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="bCancel=true"/>
    </li>
</ul>
</form:form>

<v:javascript formName="defineInstance" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    //Form.focusFirstElement($('defineInstanceForm'));
</script>
