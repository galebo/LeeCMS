
<#macro div1>
	<div class="div1">
		<div class="left"><@left1/></div>
		<div class="right"><@right1/></div>
	</div>
	<div class="clear"></div>
</#macro>
<#macro left1>
	<div class="div1_ div1_3">
		<div class="title left_title"><div>古风探秘</div></div>
		<div class="content">
			<div class="left_content">
				<div><img src="/p/image.jpg"/></div>
				<div class="name"><a href="#">带你走进了什么的仙人洞了解仙人洞的历史</a></div>
				<ul>
					<#list 1..5 as one>
					<li ><a href="#"><span>【古风探秘】</span>带你走进了什么的仙人洞了解仙人洞的历史</a></li>
					</#list>
				</ul>
			</div>
			<div class="right_content">
				<div class="list_image3">
					<ul>
					<#list 1..6 as one>
					<li <#if one_index=1 ||  one_index=3||  one_index=5>class="noright"</#if> ><div><img src="/p/image.jpg"/></div>
					<div class="name"><a href="#">带你走进了什么的仙人洞了解仙人洞的历史</a></div></li>
					</#list>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="left div1_ div1_6">
		<img src="/p/image5.jpg"/>
	</div>
</#macro>


<#macro right1>
	<div class="div1_ div1_4 ">
		<div class="title right_title"><div>每日聚焦</div></div>
		<div class="content">
		</div>
	</div>
	<div class="right div1_ div1_5 list_image1">
		<div class="title right_title"><div>每日一推</div></div>
		<div class="content ">
			<ul>
			<#list 1..4 as one>
			<li >
				<div class="img"><img src="/p/image.jpg"/></div>
				<div class="name"><a href="#">带你走进了什么的仙人洞了解仙人洞的历史</a></div>
				<div class="clear"></div>
			</li>
			</#list>
			</ul>
		</div>
	</div>
</#macro>
