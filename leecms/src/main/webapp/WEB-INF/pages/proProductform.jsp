<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="proProductDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='proProductDetail.heading'/>"/>
</head>

<form:form commandName="proProduct" method="post" action="proProductform" id="proProductForm" onsubmit="return validateProProduct(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="productId"/>
<input type="hidden" name="parentId" value="${parentId}"/>
<input type="hidden" name="jbox" value="${jbox}"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="proProduct.nameCn"/>
        <form:errors path="nameCn" cssClass="fieldError"/>
        <form:input path="nameCn" id="nameCn" cssClass="text medium" cssErrorClass="text medium error" maxlength="200"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="proProduct.html"/>
        <form:errors path="html" cssClass="fieldError"/>
        <form:textarea path="html" id="html" cssClass="xheditor-mini" rows="12" cols="80" cssErrorClass="text medium error"/>
    </li>

    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty jbox}">
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="javascript:window.parent.window.jBox.close();"/>

        </c:if>
        <c:if test="${empty jbox}">
			<input type="button" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="javascript:history.back(-1);"/>
        </c:if>
    </li>
</ul>
</form:form>

<v:javascript formName="proProduct" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>
<script type="text/javascript" src="<c:url value='/p/plugin/jquery-ui-1.8.17.custom/js/jquery-1.7.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/p/plugin/xheditor/xheditor-1.1.14-zh-cn.min.js'/>"></script>

<script type="text/javascript">
    Form.focusFirstElement($('proProductForm'));
</script>
