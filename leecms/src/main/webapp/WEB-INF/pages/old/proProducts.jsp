<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="proProductList.title"/></title>
    <meta name="heading" content="<fmt:message key='proProductList.heading'/>"/>
    <meta name="menu" content="ProProductMenu"/>
</head>

<div id="search">
<form method="get" action="${ctx}/proProducts" id="searchForm">
    <input type="text" size="20" name="q" id="query" value="${param.q}"
           placeholder="Enter search terms"/>
    <input type="submit" value="<fmt:message key="button.search"/>"/>
</form>
</div>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/proProductform"/>'" value="<fmt:message key="button.add"/>"/>
<input type="button" onclick="location.href='<c:url value="/mainMenu"/>'" value="<fmt:message key="button.done"/>"/>

<display:table name="proProductList" class="table" requestURI="" id="proProductList" export="true" pagesize="25">
    <display:column property="productId" sortable="true" href="proProductform" media="html"
        paramId="productId" paramProperty="productId" titleKey="proProduct.productId"/>
    <display:column property="productId" media="csv excel xml pdf" titleKey="proProduct.productId"/>
    <display:column property="author" sortable="true" titleKey="proProduct.author"/>
    <display:column property="html" sortable="true" titleKey="proProduct.html"/>
    <display:column property="nameCn" sortable="true" titleKey="proProduct.nameCn"/>
    <display:column property="status" sortable="true" titleKey="proProduct.status"/>
    <display:column property="submitTime" sortable="true" titleKey="proProduct.submitTime"/>
    <display:column property="userId" sortable="true" titleKey="proProduct.userId"/>
    <display:column property="viewCount" sortable="true" titleKey="proProduct.viewCount"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="proProductList.proProduct"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="proProductList.proProducts"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="proProductList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="proProductList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="proProductList.title"/>.pdf</display:setProperty>
</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/proProductform"/>'" value="<fmt:message key="button.add"/>"/>
<input type="button" onclick="location.href='<c:url value="/mainMenu"/>'" value="<fmt:message key="button.done"/>"/>

<script type="text/javascript">
    highlightTableRows("proProductList");
</script> 
