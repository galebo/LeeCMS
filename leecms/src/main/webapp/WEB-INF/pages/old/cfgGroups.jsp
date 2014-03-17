<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="cfgGroupList.title"/></title>
    <meta name="heading" content="<fmt:message key='cfgGroupList.heading'/>"/>
    <meta name="menu" content="CfgGroupMenu"/>
</head>

<display:table name="cfgGroupList" class="table" requestURI="" id="cfgGroupList" export="false" pagesize="25">
    <display:column property="groupId" sortable="true" href="cfgGroupform" media="html"
        paramId="groupId" paramProperty="groupId" titleKey="cfgGroup.groupId"/>
    <display:column property="groupId" media="csv excel xml pdf" titleKey="cfgGroup.groupId"/>
    <display:column property="groupKey" sortable="true" titleKey="cfgGroup.groupKey"/>
    <display:column property="groupName" sortable="true" titleKey="cfgGroup.groupName"/>
    <display:column property="updateTime" sortable="true" titleKey="cfgGroup.updateTime"  format="{0,date,yyyy-MM-dd HH:mm:ss}"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="cfgGroupList.cfgGroup"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="cfgGroupList.cfgGroups"/></display:setProperty>

</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/cfgGroupform?type=${type}"/>'" value="<fmt:message key="button.add"/>"/>

<script type="text/javascript">
    highlightTableRows("cfgGroupList");
</script> 
