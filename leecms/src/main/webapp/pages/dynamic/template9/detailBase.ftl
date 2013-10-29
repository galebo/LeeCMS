<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>

<#macro main bean isDetail2=false>
<@frame.html title=bean.content.name+"-安博律师事务所"/>

<div id="orz">
<@frame.head/>

<div id="orz_main">
	<div id="orz_left">
		<div id="orz_left_1">菜单导航</div>
		<div id="orz_left_2">
			<ul>
			<#if bean.similar ??>
				<#list bean.similar as one>
				<li><a href="${one.url}">${one.name}</a></li>
				<#if one_index=4><#break></#if>
				</#list>
			<#else>
				<#list bean.parentItems as one>
				<li><a href="${one.url}">${one.name}</a></li>
				</#list>
			</#if>
			</ul>
		</div>
		<@frame.marquee/>
		
	</div>
	<div id="orz_right">
	
		<#if isDetail2>
			<@frame.nav name=bean.content.name/>
		<#else>
			<@frame.nav name=bean.item.name/>
		</#if>
			
		<div id="orz_right_2">
		  <h1 class="detail_title">${bean.content.name}</h1>
		  
			<#if !isDetail2>
		  <div class="detail_about">
			<span>发布作者：${bean.content.author} 该信息已被浏览了<@g.upCount contentId=bean.content.contentId/>次 发布时间：${bean.content.updateTime?date}</span>
		  </div>
			</#if>
			
		  <div class="detail_html">${bean.content.html}</div>
		  
			<#if !isDetail2>
		  <div class="detail_next">
		    <span>上一篇文章：<a href="${bean.content.pre.url}" title="${bean.content.pre.name}">${bean.content.pre.name}</a></span>
		    <span style="float:right;">下一篇文章：<a href="${bean.content.next.url}" title="${bean.content.next.name}">${bean.content.next.name}</a></span>
		  </div>
			</#if>
		</div>
	</div>
</div>



<@frame.foot/>
</div>
</body>
</html>
</#macro>

