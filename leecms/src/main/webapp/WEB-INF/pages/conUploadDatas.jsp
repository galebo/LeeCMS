<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="conUploadData"/></title>
    <meta name="heading" content="<fmt:message key='conUploadData'/>"/>
    <meta name="menu" content="ConUploadDataMenu"/>
</head>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/fileupload"/>'" value="<fmt:message key="menu.selectFile"/>"/>

<display:table name="conUploadDataList" class="table" requestURI="" id="conUploadDataList" export="false" pagesize="15">
    <display:column property="uploadDataId" sortable="true" href="conUploadDataform" media="html"
        paramId="uploadDataId" paramProperty="uploadDataId" titleKey="conUploadData.uploadDataId"/>
    <display:column property="uploadDataId" media="csv excel xml pdf" titleKey="conUploadData.uploadDataId"/>
    <display:column property="newName" sortable="true" titleKey="conUploadData.newName"/>
    <display:column property="address" sortable="true" titleKey="conUploadData.address"/>
    <display:column property="name" sortable="true" titleKey="conUploadData.name"/>
    <display:column property="size" sortable="true" titleKey="conUploadData.size"/>
    <display:column property="type" sortable="true" titleKey="conUploadData.type"/>
	
    <display:column property="updateTime" sortable="true" titleKey="conUploadData.updateTime" format="{0,date,yyyy-MM-dd HH:mm:ss}"/>
    <display:column titleKey="operate"><form action="<c:url value="/conUploadDataform"/>" method="post">
    <input type="hidden" id="uploadDataId" name="uploadDataId" value="${conUploadDataList.uploadDataId}"/>
    <input type="hidden" id="delete" name="delete" value="true"/>
    <input type="submit" class="button" onclick="return false;" onmouseover="show('<c:url value="${conUploadDataList.address}"/>')" onmouseout="noshow()"
            value="<fmt:message key="view"/>" /></form></display:column>
</display:table>
<script>
function show(img)
{
	document.getElementById('div').style.display='block';
	document.getElementById('img').src=img;
}
function noshow()
{
	document.getElementById('div').style.display='none';
}
</script>
<div style="display: none;position: absolute;top:100px;" id="div"><img id="img" src="" width="600" height="400"></img></div>
