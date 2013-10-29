<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#macro item bean varName="page">
<div class="b_d_base">
	<div class="list_title">
		<h2>当前所在位置：<strong><a href="${common.homePage.url}">${common.homePage.name}</a> &gt; <a href="${bean.url}">${bean.name}</a></strong></h2>
	</div>
	<div class="list_left">
		<div class="content_list">
			<ul >
				<#list bean.contents as one>
				<li><span><a href="${one.url}" target="_blank" id="${varName}${one_index}">${one.name}</a></span><span class="time">${one.updateTime?date}</span></li>
				<#if one_index=10><#break/></#if>
				</#list>
			 </ul>
		</div>
		<@area.item_page bean=bean varName=varName/>
	</div>
	<@frame.item_right item1=bean.item1 item2=bean.item2/>
</div>
</#macro>

<@frame.exe>
<@item bean=data/>
</@frame.exe>
