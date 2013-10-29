<#macro area title>
	<div class="inner2  clearfix">
		<h3><span>${title}</span></h3>
		<div class="clearfix">
		<#nested>
		</div>
	</div>
</#macro>


<#macro fav bean>
<@area title="您可能感兴趣">
	<ul class="mostread">
		<#list bean.contents as one>
			<li class="mostread"><a href="${one.url}" class="mostread">${one.name}</a></li>
		</#list>
	</ul>
</@area>
</#macro>


<#macro faq bean count>
<@area title=bean.name>
	<#list bean.contents as one>
	<div class="faqtogglerdiv"><a class="faqtoggler" href="#nogo">${one.name}</a></div>
	<div class="answer" style="display:none;">${one.url}</div>
	<#if one_index = count><#break></#if>
	</#list>
</@area>
</#macro>
<#macro area1 bean count>
<@area title=bean.name>
		<ul class="latestnews">
		  <#list bean.contents as one>
			  <li class="latestnews"><a href="${one.url}" class="latestnews">${one.name}</a></li>
			  <#if one_index = count><#break></#if>
		  </#list>
		</ul>
</@area>
</#macro>
<#macro list1 bean css>
	<div class="${css}" style="width: 33.2%;">
		<@area1 bean=bean count=7/>
	</div>
</#macro>
<#macro list2 bean css>
	<div class="${css}" style="width: 33.2%;">
		<@area1 bean=bean count=7/>
		<@area1 bean=bean count=7/>
	</div>
</#macro>

<#macro list3 bean css>
	<div class="${css}" style="width: 33.2%;">
		<@area1 bean=bean count=4/>
		<@area1 bean=bean count=4/>
		<@area1 bean=bean count=4/>
	</div>
</#macro>

