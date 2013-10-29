<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>
<#import "${ftlPath}/common/area.ftl" as area/>

<@frame.exe1 bean=data>
	<@area.detail_position bean=data/>
	<div style="margin-top:5px;margin-bottom:20px;" class="wrapper">
		<div class="l_left">
		<@area.detail_right bean=data/>
		</div>
	<@frame.left item1=data.item1 item2=data.item2/>
	</div>
	<@g.getItemTop itemId=data.item.id/>
	<@g.upCount contentId=data.content.contentId display="false"/>
</@frame.exe1>
