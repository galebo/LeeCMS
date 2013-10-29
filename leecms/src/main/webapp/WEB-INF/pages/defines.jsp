<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="define"/><fmt:message key="List.title"/></title>
    <meta name="heading" content="<fmt:message key='define'/><fmt:message key='List.heading'/>"/>
    <meta name="menu" content="DefineMenu"/>
</head>


<display:table name="cfgDefineList" class="table" requestURI="" id="cfgDefineList" export="false" pagesize="15">
    <display:column property="defineId" sortable="true" href="defineform" media="html"
        paramId="defineId" paramProperty="defineId" titleKey="define.defineId"/>
    <display:column property="defineId" media="csv excel xml pdf" titleKey="define.defineId"/>
    <display:column property="key" sortable="true" titleKey="define.key"/>
    <display:column property="positionName" sortable="true" titleKey="define.positionName"/>
    <display:column property="updateTime" sortable="true" titleKey="define.updateTime" format="{0,date,yyyy-MM-dd HH:mm:ss}"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="define"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="define"/></display:setProperty>

</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/defineform"/>'" value="<fmt:message key="button.add"/>"/>
