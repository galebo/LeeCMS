<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="templateDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='templateDetail.heading'/>"/>
</head>

<form:form commandName="template" method="post" action="templateform" id="templateForm" onsubmit="return validateTemplate(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="cfgTemplateId"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="template.templateId"/>
        <form:errors path="templateId" cssClass="fieldError"/>
        <form:input path="templateId" id="templateId" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="template.templateCssId"/>
        <form:errors path="templateCssId" cssClass="fieldError"/>
        <form:input path="templateCssId" id="templateCssId" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>
    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty template.cfgTemplateId}">
        <input type="submit" class="button" name="delete" onclick="javascript:deleteButton('template')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="bCancel=true"/>
    </li>
</ul>
</form:form>

<v:javascript formName="template" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>

