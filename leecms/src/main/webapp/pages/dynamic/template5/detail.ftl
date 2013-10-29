<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#macro detail bean>
	<div class="clear"></div>
	<div class="b_d_base">
		<div class="list_title">
			<h2>当前所在位置：<strong><a href='${common.homePage.url}'>${common.homePage.name}</a>&nbsp;&gt;&nbsp;<a href='${bean.item.url}'>${bean.item.name}</a></strong></h2>
		</div>
		<div class="list_left">
			<div class="article">
				<h1>${bean.content.name}</h1>
				<div class="about"> 
					<span>来源：${bean.content.source}</span>
					<span>发布时间：${bean.content.updateTime?date}</span>
					<span>关键字：</span>
					<span>阅读:<@g.upCount contentId=bean.content.contentId/></span></div>
				<div>
				${bean.content.html}
				</div>
			
				<div class="next_pre">
					<span>上一篇：<a href='${bean.content.next.url}'>${bean.content.next.name}</a></span>&nbsp;&nbsp;
					<span>下一篇：<a href='${bean.content.pre.url}'>${bean.content.pre.name}</a></span></div>
			</div>
			<div class="c"></div>
		</div>
		<@frame.item_right item1=bean.item item2=bean.item/>
	</div>
	<@g.getItemTop itemId=bean.item.id/>
</#macro>

<@frame.exe>
<@detail bean=data/>
</@frame.exe>
