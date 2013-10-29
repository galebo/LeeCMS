
<#import "${ftlPath}/common/frame.ftl" as frame/>

<#macro main bean>
<@frame.html title=bean.name+"-安博律师事务所"/>


<div id="orz">
<@frame.head/>

<div id="orz_main">
<div id="orz_left">
	<div id="orz_left_1">菜单导航</div>
	<div id="orz_left_2">
		<ul>
		<#list bean.sonItems as one>
		<li><a href="${one.url}">${one.name}</a></li>
		</#list>
		</ul>
	</div>
	<@frame.marquee/>
</div>
<div id="orz_right">
		<#list bean.sonItems as son>
			<@frame.items_nav name=son.name  url=son.url/>
			<div id="orz_right_2">
				<div class="item_list">
					<ul>
					<#list son.contents as one>
					<li>
				    	<div style="width:100%">
					    <div class="list_txt"><a title="${one.name}" href="${one.url}">${one.name}</a></div>
					    <div class="list_date">${one.updateTime?date}</div></div>
					</li>
					</#list>
					</ul>
				</div>
			</div>
		</#list>
</div>
</div>

<@frame.foot/>
</div>
</body>
</html>
</#macro>

<@main bean=data/>
