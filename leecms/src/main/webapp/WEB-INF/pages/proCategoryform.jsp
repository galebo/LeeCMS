<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="proCategoryDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='proCategoryDetail.heading'/>"/>
</head>

<form:form commandName="proCategory" method="post" action="proCategoryform" id="proCategoryForm" onsubmit="return validateProCategory(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="categoryId"/>
<form:hidden path="parentId"/>
<form:hidden path="userId"/>
<input type="hidden" id="jbox" name="jbox" value="${jbox}"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="proCategory.colName"/>
        <form:errors path="colName" cssClass="fieldError"/>
        <form:input path="colName" id="colName" cssClass="text medium" cssErrorClass="text medium error" maxlength="100"/>
    </li>

    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty proCategory.categoryId}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('proCategory')"
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

<v:javascript formName="proCategory" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    Form.focusFirstElement($('proCategoryForm'));
</script>
