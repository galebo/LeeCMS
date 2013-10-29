<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="templatePage"/><fmt:message key="List.title"/></title>
    <meta name="heading" content="<fmt:message key="templatePage"/><fmt:message key='List.heading'/>"/>
    <meta name="menu" content="TemplateMenu"/>
</head>

<display:table name="templatePageList" class="table" requestURI="" id="templatePageList" export="false" pagesize="10">
    <display:column property="templatePageId" sortable="true" href="templatePageform" media="html"
        paramId="templatePageId" paramProperty="templatePageId" titleKey="templatePage.templatePageId"/>
    <display:column property="templatePageId" media="csv excel xml pdf" titleKey="templatePage.templatePageId"/>
    <display:column property="templatePageName" sortable="true" titleKey="templatePage.templatePageName"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="templatePage"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="templatePage"/></display:setProperty>
</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/templatePageform"/>'" value="<fmt:message key="button.add"/>"/>
<input type="button" onclick="location.href='<c:url value="/mainMenu"/>'" value="<fmt:message key="button.done"/>"/>

