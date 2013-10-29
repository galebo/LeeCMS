<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="define"/><fmt:message key="Detail.title"/></title>
    <meta name="heading" content="<fmt:message key='define'/><fmt:message key='Detail.heading'/>"/>
</head>

<form:form commandName="cfgDefine" method="post" action="defineform" id="defineForm" onsubmit="return validateDefine(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="defineId"/>
<form:hidden path="updateTime"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="define.key"/>
        <form:errors path="key" cssClass="fieldError"/>
        <form:input path="key" id="key" cssClass="text medium" cssErrorClass="text medium error" maxlength="200"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="define.positionName"/>
        <form:errors path="positionName" cssClass="fieldError"/>
        <form:input path="positionName" id="positionName" cssClass="text medium" cssErrorClass="text medium error" maxlength="100"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="define.defaultValue"/>
        <form:errors path="defaultValue" cssClass="fieldError"/>
        <form:input path="defaultValue" id="defaultValue" cssClass="text medium" cssErrorClass="text medium error" maxlength="500"/>
    </li>

    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty define.defineId}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('define')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="bCancel=true"/>
    </li>
</ul>
</form:form>

<v:javascript formName="define" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>

