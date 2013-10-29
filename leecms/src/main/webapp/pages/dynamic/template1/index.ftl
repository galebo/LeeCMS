<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>

<#macro main bean>
	<div class="b_div1 clear">
		<div class="main clearfix">
			<div class="column" style="width: 33.3%;">
				<@self.selfAbout/>
			</div>
			<@area.list2 bean=bean.item2 css="column"/>
			<@area.list3 bean=bean.item1 css="column box-right"/>
		</div>
	</div>
	<div class="b_div2 clear">
		<div class="main clearfix">
			<div class="column" style="width:60%">
				<@self.show2/>
			</div>
			<div class="column box-right" style="width:39.8%">
				<@area.faq bean=bean.item1 count=5/>
			</div>
		</div>
	</div>
	<div class="b_div3 clear">
		<div class="main clearfix">
		<@area.list1 bean=bean.item1 css="column"/>
		<@area.list1 bean=bean.item2 css="column"/>
		<@area.list1 bean=bean.item3 css="column box-right"/>
		</div>
	</div>
</#macro>
<@frame.exe bean=common>
	<@main bean=data/>
</@frame.exe>