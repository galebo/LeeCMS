<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="conContentList.title"/></title>
    <meta name="heading" content="<fmt:message key='conContent'/><fmt:message key='List.heading'/>"/>
    <meta name="menu" content="ConContentMenu"/>
</head>



<display:table name="conContentList" class="table" requestURI="" id="conContentList" export="false" pagesize="10">
    <display:column property="contentId" sortable="true" href="conContentform" media="html"
        paramId="sonId" paramProperty="contentId" titleKey="conContent.contentId"/>
    <display:column property="contentId" media="csv excel xml pdf" titleKey="conContent.contentId"/>
    <display:column property="nameCn" sortable="true" titleKey="conContent.nameCn"/>
    <display:column property="author" sortable="true" titleKey="conContent.author"/>
    <display:column property="source" sortable="true" titleKey="conContent.source"/>
    <display:column property="viewCount" sortable="true" titleKey="conContent.viewCount"/>
    <display:column property="submitTime" sortable="true" titleKey="conContent.submitTime" format="{0,date,yyyy-MM-dd HH:mm:ss}"/>
    <!--  display:column property="status" sortable="true" titleKey="conContent.status"-->

    <display:setProperty name="paging.banner.item_name"><fmt:message key="conContent"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="conContent"/></display:setProperty>

</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/conContentform"/>'" value="<fmt:message key="button.add"/>"/>
