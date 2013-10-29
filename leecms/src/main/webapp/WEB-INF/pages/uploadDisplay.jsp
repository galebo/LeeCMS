<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="display.title"/></title>
    <meta name="heading" content="<fmt:message key='display.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<p><fmt:message key='display.title'/></p>

<div class="separator"></div>

<table class="detail" cellpadding="5">
    <tr>
        <th><fmt:message key="FileFriendlyName"/>:</th>
        <td><c:out value="${friendlyName}"/></td>
    </tr>
    <tr>
        <th><fmt:message key="Filename"/>:</th>
        <td><c:out value="${fileName}"/></td>
    </tr>
    <tr>
        <th><fmt:message key="FileType"/>:</th>
        <td><c:out value="${contentType}"/></td>
    </tr>
    <tr>
        <th><fmt:message key="FileSize"/>:</th>
        <td><c:out value="${size}"/></td>
    </tr>
    <tr>
        <th class="tallCell"><fmt:message key="FileLocation"/>:</th>
        <td>
            <a href="<c:out value="${link}"/>">
            <c:out value="${location}" escapeXml="false"/></a>
        </td>
    </tr>
    <tr>
        <td></td>
        <td class="buttonBar">
            <input class="button" type="button" value="<fmt:message key="MenuConUploadData"/>"  onclick="location.href='<c:url value="/conUploadDatas"/>'" />
            <input class="button" type="button" style="width: 120px" value="<fmt:message key="uploadAnother"/>" onclick="location.href='/fileupload'" />
        </td>
    </tr>
</table>


