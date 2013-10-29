<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>

<#macro main bean>
	<div class="detail container clear">
		<div class="main clearfix">
			<div class="column" style="width:59.8%">
			<@left bean=bean/>
			</div>
			<div class="column box-right" style="width:40%">
				<@area.fav bean=bean.item1/>
			</div>
		</div>
	</div>
</#macro>

<#macro left bean>
	<div class="inner1 clearfix">
		<h2 class="contentheading clearfix">${bean.content.name}</h2>
		<div class="article-tools clearfix">
			<div class="article-meta">
			<span class="article-section"><a href="${bean.item.url}">${bean.item.name}</a></span></div>
		</div>
		<div class="article-content">
		${bean.content.html}
		<@g.upCount contentId=bean.content.contentId display="false"/>
		</div>
	</div>
</#macro>


<@frame.exe bean=common>
	<@main bean=data/>
</@frame.exe>
