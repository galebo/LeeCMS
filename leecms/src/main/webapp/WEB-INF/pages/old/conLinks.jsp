<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="conLink"/></title>
    <meta name="heading" content="<fmt:message key='conLinkList.heading'/>"/>
    <meta name="menu" content="ConLinkMenu"/>
</head>


<display:table name="conLinkList" class="table" requestURI="" id="conLinkList" export="flase" pagesize="25">
    <display:column property="linkId" sortable="true" href="/conLinkform" media="html"
        paramId="linkId" paramProperty="linkId" titleKey="conLink.linkId"/>
    <display:column property="linkId" media="csv excel xml pdf" titleKey="conLink.linkId"/>
    <display:column property="imgUrl" sortable="true" titleKey="conLink.imgUrl"/>
    <display:column property="title" sortable="true" titleKey="conLink.title"/>
    <display:column property="url" sortable="true" titleKey="conLink.url"/>
    <display:column property="updateTime" sortable="true" titleKey="conLink.updateTime" format="{0,date,yyyy-MM-dd HH:mm:ss}"/>
    
        <c:if test="${type =='3AA'}">
    <display:setProperty name="paging.banner.item_name"><fmt:message key="conLink"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="conLink"/></display:setProperty>        </c:if>
        <c:if test="${type =='3AB'}">
    <display:setProperty name="paging.banner.item_name"><fmt:message key="changePic"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="changePic"/></display:setProperty>
     </c:if>
</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/conLinkform?type=${type}"/>'" value="<fmt:message key="button.add"/>"/>


<script type="text/javascript">
    highlightTableRows("conLinkList");
</script> 
