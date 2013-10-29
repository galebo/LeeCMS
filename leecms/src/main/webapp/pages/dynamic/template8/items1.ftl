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
	<div class="left div1_ div1_2">
		<div class="title left_title"><div>古风探秘</div></div>
		<div class="content">
			<div class="left_content">
				<div><img src="/p/image.jpg"/></div>
				<div class="name"><a href="#">带你走进了什么的仙人洞了解仙人洞的历史</a></div>
				<ul>
					<#list 1..2 as one>
					<li ><a href="#">【古风探秘】带你走进了什么的仙人洞了解仙人洞的历史</a></li>
					</#list>
				</ul>
			</div>
			<div class="right_content">
				<div class="list_image3">
					<ul>
					<#list 1..6 as one>
					<li <#if one_index=2 ||  one_index=5>class="noright"</#if> ><div><img src="/p/image.jpg"/></div>
					<div class="name"><a href="#">带你走进了什么的仙人洞了解仙人洞的历史</a></div></li>
					</#list>
					</ul>
				</div>
			</div>
		</div>
	</div>
</#macro>


<#macro right2>
	<div class="right div1_ div1_2 list_num1">
		<div class="title right_title"><div>每日聚焦</div></div>
		<div class="content">
			<div class="day"><span class="day1">每日</span><span class="day2">每周</span></div>
			<ul class="content_ul">
				<#list 1..10 as one>
				<li><div class="url"><a href="#">十八大解读，全面建设小康社会</a></div><div class="count">10000</div></li>
				</#list>
			</ul>
		</div>
	</div>
</#macro>