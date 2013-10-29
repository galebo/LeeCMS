<#import "${ftlPath}/common/frame.ftl" as frame/>
<#macro item bean varName="page">
<div class="b_d_base">
	<div class="list_title"><h2>当前所在位置：<strong><a href="${common.homePage.url}">${common.homePage.name}</a> &gt;
	<a href="${bean.url}">${bean.name}</a></strong></h2></div>
	<div class="list_left">
			<@frame.list2 item=bean.item1 divCss="box3 b_div_top2"/>
			<@frame.list1 item=bean.item2 divCss="box3 b_div_top2" ulCss="list_ul5"/>
			<@frame.list1 item=bean.item3 divCss="box3 b_div_top2" ulCss="list_ul3 list_ul3_1"/>
			<@frame.list3 item=bean.item4 divCss="box3 b_div_top2" ulCss="list_ul3 list_ul3_1"/>
			<@frame.list1 item=bean.item5 divCss="box3 b_div_top2" ulCss="list_ul3 list_ul3_1"/>
		<div class="clear"></div>
	</div>
	<@frame.item_right item1=bean.item1 item2=bean.item1/>
</div>
</#macro>

<@frame.exe>
<@item bean=data/>
</@frame.exe>
