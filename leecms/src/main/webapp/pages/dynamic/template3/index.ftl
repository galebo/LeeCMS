<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>

<#macro main bean>
	<div class="divWidth200">
		<@area.login/>
	 	<@area.ask/>
		<@area.leftArea/>
	 </div>

	<div class="divWidth700">
		<@area.recommend item=bean.item2 loop=common.groupLoops['loop2']/>
		<@area.search/>
		<@area.loop bean=common.groupLoops['loop1']/>
		<@area.big bean=bean/>
    </div>
</#macro>

<@frame.exe bean=common jsName="index">
	<@main bean=data/>
</@frame.exe>