<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>
<@frame.exe>
<div class="d_main b_d_base">
	
	<div class="l_1"><@g.lunBo pictures=common.groupLoops['loop1']/></div>
	<@self.ziXun/>

	<@self.self/>
	
	<@frame.list1 item=data.item1 divCss="z1 b_div_top" ulCss="list_ul4" h2DivClass="" showColor="true"/>
	<@frame.list1 item=data.item2 divCss="r1 b_div_top" ulCss="list_ul1 list_ul1_1"/>
	<div class="clear"></div>

	<@frame.list1 item=data.item3 divCss="l3 b_div_top" ulCss="list_ul1 list_ul1_3"/>
	<@frame.list1 item=data.item4 divCss="z3 b_div_top" ulCss="list_ul1"/>
	<@frame.list2 item=data.item5 divCss="r3 b_div_top" listDivClass="" h2DivClass=""/>
	
	<div class="clear"></div>
	<@self.guangGao/>

	<@frame.list4 item=data.item5 divCss="r2 b_div_top b_more mw1" ulCss="list_ul1" keyCss="b_key" count=9/>
	<@frame.list4 item=data.item7 divCss="l2 b_div_top b_more mw1" ulCss="list_ul1" keyCss="b_key" count=9/>
	<@frame.list4 item=data.item4 divCss="z2 b_div_top b_more mw1" ulCss="list_ul1" keyCss="b_key" count=9/>

	<@frame.list4 item=data.item5 divCss="r2 b_div_top b_more mw1" ulCss="list_ul1" keyCss="b_key" count=8/>
	<@frame.list4 item=data.item7 divCss="l2 b_div_top b_more mw1" ulCss="list_ul1" keyCss="b_key" count=8/>
	<@frame.list4 item=data.item4 divCss="z2 b_div_top b_more mw1" ulCss="list_ul1" keyCss="b_key" count=8/>

</div>
</@frame.exe>



