<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>
 
<#macro main bean>
	<@self.sonTop1/>
	<div class="box3">
		<div class="boxwq"><a href="/" target="_self">${common.siteDefine['siteName']}</a> &raquo; <a href="${bean.url}" target="_self">${bean.name}</a></div>
		<div class="box3_l">
			<@area.list bean=bean />
		</div>
		<div class="box3_r">
			<@area._area1_0 bean=bean.item1 divCss="list_box list_box9" count=5 css="list02"/>
			<@area._area1_0 bean=bean.item2 divCss="list_box list_box9" count=5 css="list02"/>
		</div>
		<div class="clear"></div>
	</div>
</#macro>
<@frame.exe bean=common>
	<@main bean=data/>
</@frame.exe>
