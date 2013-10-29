<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>
<#macro main bean>
		<div class="box2">
			<@g.lunBo pictures=common.groupLoops['loop2']/>
			<@self.guanggao/>
		</div>
		<div class="box3">
			<div class="box3_l">
				<@area._area1_0 bean=bean.item1 divCss='list_box list_box1'            count=12 css='list01'/>
				<@area._area1_0 bean=bean.item2 divCss="list_box list_box2 list_box_r" count=10 css='list02'/>
				<@area._area1_0 bean=bean.item3 divCss="list_box list_box3"            count=19 css='list02'/>
				<@area._area1_0 bean=bean.item4 divCss="list_box list_box1"            count=8  css='list02'/>
				<@area._area1_0 bean=bean.item5 divCss="list_box list_box2 list_box_r" count=8  css='list02'/>
				<@area._area1_0 bean=bean.item6 divCss="list_box list_box1"            count=8  css='list02'/>
				<@area._area1_0 bean=bean.item7 divCss="list_box list_box2 list_box_r" count=8  css='list02'/>
			</div>
			<div class="box3_r">
				<@area.area_self/>
				<@area.area_zixun/>
				<@area._area1_0 bean=bean.item8 divCss="list_box list_box4" count=8 css='list02'/>
				<@area._area1_0 bean=bean.item9 divCss="list_box list_box4" count=2 css='list02'/>
			</div>
			<div class="clear"></div>
		</div>
</#macro>

<@frame.exe bean=common>
	<@main bean=data/>
</@frame.exe>