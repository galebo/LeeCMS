<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>


<#macro main bean>
		<div class="divWidth200">
			<@area.left4 item=bean.item2/>
		 	<@area.left2/>
			<@area.left3 item=bean.item1/>
   		 </div>
		<div class="divWidth700">
			<@area.currentPosition bean=bean.item2/>
			<@area.right1 item=bean pageSize=bean.page.pageSize/>
			<@area.page bean=bean/>
	    </div>
</#macro>

<@frame.exe bean=common jsName="list">
	<@main bean=data/>
</@frame.exe>