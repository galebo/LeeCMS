<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="Detail.title"/></title>
    <meta name="heading" content="<fmt:message key='Detail.heading'/>"/>
</head>

<form:form commandName="templatePage" method="post" action="templatePageform" id="templatePageForm" onsubmit="return validateTemplate(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="templatePageId"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="templatePage.templatePageName"/>
        <form:errors path="templatePageName" cssClass="fieldError"/>
        <form:input path="templatePageName" id="templatePageName" cssClass="text medium" cssErrorClass="text medium error" maxlength="255"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="templatePage.template"/>
        <form:errors path="template" cssClass="fieldError"/>
        <form:textarea path="template" id="template" cssClass="text big" cssErrorClass="text medium error" rows="25" cols="160"/>
    </li>

    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty template.templateId}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('templatePage')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="bCancel=true"/>
    </li>
</ul>
</form:form>

<v:javascript formName="templatePage" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>

