<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="conUploadDataDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='conUploadDataDetail.heading'/>"/>
</head>

<form:form commandName="conUploadData" method="post" action="conUploadDataform" id="conUploadDataForm" onsubmit="return validateConUploadData(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="uploadDataId"/>
<ul>
    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty conUploadData.uploadDataId}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('conUploadData')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="bCancel=true"/>
    </li>
</ul>
</form:form>

<v:javascript formName="conUploadData" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/p/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    //Form.focusFirstElement($('conUploadDataForm'));
</script>
