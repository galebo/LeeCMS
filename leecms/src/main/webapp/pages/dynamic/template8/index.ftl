<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/detail1.ftl" as business/>
<@business.main/>
<#macro main>
	<@frame.exe1 bean=data>
		<@div1/>
		<div class="main_banner"><img src="/p/image4.jpg"/></div>
		<@div1/>
		<@div2/>
		<div class="main_foot"><img src="/p/image3.jpg"/></div>
	</@frame.exe1>
</#macro>

<#macro div1>
	<div class="div1">
		<@left1/><@right1/>
	</div>
	<div class="clear"></div>
</#macro>
<#macro div2>
	<div class="div1">
		<@left2/><@right1/>
	</div>
	<div class="clear"></div>
</#macro>

<#macro left1>
	<div class="left">
		<div class="title"><span class="span1"></span><span class="span2"><ul>
				<#list 1..4 as one>
				<li >鲁南美食&nbsp;|&nbsp;</li>
				</#list>
				</ul></span></div>
		<div class="div1_ div1_1">
			<div class="list_image4">
				<ul>
				<#list 1..4 as one>
				<li <#if one_index=3>class="noright"</#if> ><div><img src="/p/image.jpg"/></div>
				<div><a href="#">带你走进了什么的仙人洞了解仙人洞的历史</a></div><div><a href="#">【古风探秘】</a></div></li>
				</#list>
				</ul>
			</div>
			<div class="clear"></div>
			<div class="title_list">
				<ul>
				<#list 1..4 as one>
				<li>【古风探秘】<a href="#">带你走进了什么的仙人洞了解仙人洞的历史</a></li>
				</#list>
				</ul>
			</div>
		</div>
	</div>
</#macro>

<#macro left2>
	<div class="left">
		<div class="title"><span class="span1"></span><span class="span2"><ul>
				<#list 1..4 as one>
				<li >鲁南美食&nbsp;|&nbsp;</li>
				</#list>
				</ul></span></div>
		<div class="div1_ div1_1">
			<div class="list_image4">
				<ul>
				<#list 1..8 as one>
				<li <#if one_index=3 || one_index=7>class="noright"</#if> ><div><img src="/p/image.jpg"/></div>
				<div class="name"><a href="#">《网的盛宴》</a></div></li>
				</#list>
				</ul>
			</div>
		</div>
	</div>
</#macro>
<#macro right1>
	<div class="right">
		<div class="title"><span class="span1"></span><span class="span1"></span></div>
		<div class="div1_ div1_1">
			<div class="list_num3">
			<ul>
			<#list 1..5 as one>
			<li><a href="#">十八大解读，全面建设小康社会</a></li>
			</#list>
			</ul>
			<div class="adv"><img src="/p/image2.jpg"/></div>
		</div>
		</div>
	</div>
</#macro>