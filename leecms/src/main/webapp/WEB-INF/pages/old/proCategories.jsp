<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="proCategoryList.title"/></title>
    <meta name="heading" content="<fmt:message key='proCategoryList.heading'/>"/>
    <meta name="menu" content="ProCategoryMenu"/>
</head>

<div id="search">
<form method="get" action="${ctx}/proCategories" id="searchForm">
    <input type="text" size="20" name="q" id="query" value="${param.q}"
           placeholder="Enter search terms"/>
    <input type="submit" value="<fmt:message key="button.search"/>"/>
</form>
</div>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/proCategoryform"/>'" value="<fmt:message key="button.add"/>"/>
<input type="button" onclick="location.href='<c:url value="/mainMenu"/>'" value="<fmt:message key="button.done"/>"/>

<display:table name="proCategoryList" class="table" requestURI="" id="proCategoryList" export="true" pagesize="25">
    <display:column property="categoryId" sortable="true" href="proCategoryform" media="html"
        paramId="categoryId" paramProperty="categoryId" titleKey="proCategory.categoryId"/>
    <display:column property="categoryId" media="csv excel xml pdf" titleKey="proCategory.categoryId"/>
    <display:column property="CTime" sortable="true" titleKey="proCategory.CTime"/>
    <display:column property="colName" sortable="true" titleKey="proCategory.colName"/>
    <display:column property="colType" sortable="true" titleKey="proCategory.colType"/>
    <display:column property="description" sortable="true" titleKey="proCategory.description"/>
    <display:column property="dispType" sortable="true" titleKey="proCategory.dispType"/>
    <display:column property="firstId" sortable="true" titleKey="proCategory.firstId"/>
    <display:column property="id" sortable="true" titleKey="proCategory.id"/>
    <display:column property="lastId" sortable="true" titleKey="proCategory.lastId"/>
    <display:column property="level" sortable="true" titleKey="proCategory.level"/>
    <display:column property="maxId" sortable="true" titleKey="proCategory.maxId"/>
    <display:column property="parentId" sortable="true" titleKey="proCategory.parentId"/>
    <display:column property="relativeId" sortable="true" titleKey="proCategory.relativeId"/>
    <display:column property="smallId" sortable="true" titleKey="proCategory.smallId"/>
    <display:column property="sort" sortable="true" titleKey="proCategory.sort"/>
    <display:column property="status" sortable="true" titleKey="proCategory.status"/>
    <display:column property="userId" sortable="true" titleKey="proCategory.userId"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="proCategoryList.proCategory"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="proCategoryList.proCategories"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="proCategoryList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="proCategoryList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="proCategoryList.title"/>.pdf</display:setProperty>
</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/proCategoryform"/>'" value="<fmt:message key="button.add"/>"/>
<input type="button" onclick="location.href='<c:url value="/mainMenu"/>'" value="<fmt:message key="button.done"/>"/>

<script type="text/javascript">
    highlightTableRows("proCategoryList");
</script> 
