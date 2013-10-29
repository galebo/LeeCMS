<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>
<#macro main bean>
	<@self.sonTop1/>
	<div class="box3">
		<div class="boxw">
			<a href ="" onClick="parent.history.back(); return false;" onMouseOver="self.status='后退' ;return true;">
			<img src="${commCssBase}/images/houtui.jpg" alt="返回上一级" /> 返回上一级</a>
		</div>
		<div class="box3_l">
			<div class="tittle_box2"><h2><strong>房产中介</strong></h2></div>
			<@area._area2 bean=bean.item1  count=8/>
			<@area._area1_0 bean=bean.item1 count=8 divCss="list_box list_box7" css='list02'/>
			<@area._area1_0 bean=bean.item2 count=8 divCss="list_box list_box7" css='list02'/>
			<@area._area1_0 bean=bean.item3 count=8 divCss="list_box list_box7" css='list02'/>
		</div>
		<div class="box3_r">
			<@area._area1_0 bean=bean.item4 count=5 divCss="list_box list_box9" css='list02'/>
			<@area._area1_0 bean=bean.item5 count=5 divCss="list_box list_box9" css='list02'/>
			<@area._area1_0 bean=bean.item6 count=5 divCss="list_box list_box9" css='list02'/>
		</div>
		<div class="clear"></div>
	</div>
</#macro>
<@frame.exe bean=common>
	<@main bean=data/>
</@frame.exe>