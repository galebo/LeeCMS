<#macro Top>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="robots" content="index, follow" />
<meta name="keywords" content="${common.siteDefine['keyword']}" />
<meta name="description" content="${common.siteDefine['description']}" />
<meta name="generator" content="galebo iCms" />
<title>${common.siteDefine['title']}</title>
</#macro>

<#macro getCounts bean>
<script>getCounts("${common.globalDefine['getCounts']}",${bean.id},"${bean.contentIds}");</script>
</#macro>

<#macro upCount contentId display="true">
<span id="${contentId}" <#if display!="true"> style='display:none'</#if> ></span><script>upCount("${common.globalDefine['upCount']}","${contentId}");</script>
</#macro>

<#macro getWebCount userId commCssBase display="true">
<div id="number${userId}" <#if display!="true">display="none"</#if> ></div><script>commCssBase="${commCssBase}";getWebCount("${common.globalDefine['getWebCount']}","number",${userId});</script>
</#macro>
<#macro lunBo pictures name="lunbo" divCss="scrollbox" imgDivCss="scrollbox_img" imgCss="" titleCss="txt" numCss="scrollbox_num">
	<div class="${divCss}" id="index_loop1">
        <div class="${imgDivCss}">
			<#list pictures.sons as one>
        	<div id="${name}_div${one_index}" style="display:none"><a href="${one.url}" target="_blank"><img class="${imgCss}" src="${one.img}"/></a></div>
        	</#list>
        </div>
        <div class="${titleCss}"> <a href="#" title="" id="${name}_title"></a></div>
        <ul class="${numCss}">
			<#list pictures.sons as one>
			<li><a href="javascript:" id="${name}_${one_index}" onmouseover="${name}.picOff(${one_index})" onmouseout="${name}.picOn()" >${one_index+1}</a></li>
			</#list>
        </ul>
    </div>
<script type="text/javascript"> var ${name}=new PicTimeChange(${pictures.json},"${name}");</script>
</#macro>

<#macro getItemTop itemId>
	<script>getItemTop('${common.globalDefine['getItemTop']}',${itemId});</script>
</#macro>


<#macro page bean pageSize=10 varName="page">
    <div class="contentListPage">
    	<span class="page_left">共有<font color="#ff0000" id="page_total"></font>篇文章&nbsp;
    	每页显示<font color="#ff0000" id="page_pageSize"></font>篇
    	 当前页	<font color="#ff0000" id="page_pageNo"></font>/<font color="#ff0000" id="page_totalPage"></font>
		</span>
        <span class="page_right">
        <a href="javascript:" onclick="${varName}.go(1)">首页</a>
		<a href="javascript:" onclick="${varName}.goPre()">上页</a>
        <a href="javascript:" onclick="${varName}.goNext()">下页</a>
		<a href="javascript:" onclick="${varName}.goEnd()">尾页</a>
		 转到第 <select onchange="javascript:location=this.options[this.selectedIndex].value;" name="sel_page">
                <option selected value="1">${bean.page.pageNo}</option></select>页
        </span>
        <script>var ${varName}=new Page("${varName}",${pageSize},${bean.contentsJson});</script>
    </div>
</#macro>

<#macro page2 bean pageSize=10 varName="page">
    <div class="pagelist">
		<span class="pages">第<font id="page_pageNo"></font>页，共<font id="page_totalPage"></font>页</span>
        <a href="javascript:" onclick="${varName}.go(1)">首页</a>
		<a href="javascript:" onclick="${varName}.goPre()">上页</a>
        <a href="javascript:" onclick="${varName}.goNext()">下页</a>
		<a href="javascript:" onclick="${varName}.goEnd()">尾页</a>
		 转到第 <select onchange="javascript:location=this.options[this.selectedIndex].value;" name="sel_page">
                <option selected value="1">${bean.page.pageNo}</option></select>页
        </span>
        <script>var ${varName}=new Page("${varName}",${pageSize},${bean.contentsJson});</script>
	</div>
</#macro>
