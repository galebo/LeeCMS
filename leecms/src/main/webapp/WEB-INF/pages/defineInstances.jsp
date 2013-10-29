<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="defineInstance"/><fmt:message key="List.title"/></title>
    <meta name="heading" content="<fmt:message key='defineInstance'/><fmt:message key='List.heading'/>"/>
    <meta name="menu" content="MaterialMenu"/>
</head>


<display:table name="cfgDefineInstanceList" class="table" requestURI="" id="cfgDefineInstanceList" export="false" pagesize="25">
    <display:column property="title" sortable="true" titleKey="defineInstance.title"/>
    <display:column property="text" sortable="true" titleKey="defineInstance.text"/>
    <display:column property="updateTime" sortable="true" titleKey="defineInstance.updateTime" format="{0,date,yyyy-MM-dd HH:mm:ss}"/>

    <display:column href="defineInstanceform" media="html" paramId="defineInstanceId" paramProperty="defineInstanceId" titleKey="operate" >
    <fmt:message key="button.edit"/></display:column>
    
    <display:setProperty name="paging.banner.item_name"><fmt:message key="defineInstance"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="defineInstance"/></display:setProperty>

</display:table>

