<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="template"/><fmt:message key="List.title"/></title>
    <meta name="heading" content="<fmt:message key='template'/><fmt:message key='List.heading'/>"/>
    <meta name="menu" content="TemplateMenu"/>
</head>

<display:table name="templateList" class="table" requestURI="" id="templateList" export="false" pagesize="15">
    <display:column property="cfgTemplateId" sortable="true" href="templateform" media="html"
        paramId="cfgTemplateId" paramProperty="cfgTemplateId" titleKey="template.cfgTemplateId"/>
    <display:column property="cfgTemplateId" media="csv excel xml pdf" titleKey="template.cfgTemplateId"/>
    <display:column property="templateId" sortable="true" titleKey="template.templateId"/>
    <display:column property="templateCssId" sortable="true" titleKey="template.templateCssId"/>
    <display:column property="CTime" sortable="true" titleKey="template.CTime" format="{0,date,yyyy-MM-dd HH:mm:ss}"/>
    <display:column property="userId" sortable="true" titleKey="template.userId"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="template"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="template"/></display:setProperty>
</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/templateform"/>'" value="<fmt:message key="button.add"/>"/>


