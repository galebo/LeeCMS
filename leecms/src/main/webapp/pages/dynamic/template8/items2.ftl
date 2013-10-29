<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#macro main>
	<@frame.exe1 bean=data>
		<@area.div1/>
		<@div2/>
		<@div2/>
		<@div2/>
		<@div2/>
	</@frame.exe1>
</#macro>
<#macro div2>
	<div class="div1">
		<@left2/><@right2/>
	</div>
	<div class="clear"></div>
</#macro>
<#macro left2>
	<div class="left div1_ div1_2 list_image2">
		<div class="title left_title"><div>古风探秘</div></div>
		<div class="content">
			<ul>
			<#list 1..10 as one>
			<li <#if one_index=4 | one_index=9>class="noright"</#if> ><div><img src="/p/image.jpg"/></div>
			<div class="name"><a href="#">带你走进了什么的仙人洞了解仙人洞的历史</a></div></li>
			</#list>
			</ul>
		</div>
	</div>
</#macro>


<#macro right2>
	<div class="right div1_ div1_2 list_num2">
		<div class="div_title right_title"><div class="title">每日聚焦</div><div class="day"><span class="day1">每日</span><span class="day2">每周</span></div></div>
		<div class="content">
			<ul class="content_ul">
				<#list 1..10 as one>
				<li><div class="url"><a href="#">十八大解读，全面建设小康社会</a></div></li>
				</#list>
			</ul>
		</div>
	</div>
</#macro>