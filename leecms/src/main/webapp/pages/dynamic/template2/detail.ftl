<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>

<#macro main bean>
	<@self.sonTop1/>
	<div class="box3">
		<div class="boxw"><a href ="" onClick="parent.history.back(); return false;" onMouseOver="self.status='后退' ;return true;">
			<img src="${commCssBase}/images/houtui.jpg" alt="返回上一级"/> 返回上一级</a>
		</div>
		<div class="box3_l2">
			<@area._area3 bean=bean.item/>
			<div class="box3_l2foot"></div>
		</div>
		<div class="box3_r2">
			<div class="tittle_box2"><h2 >${bean.content.name}</h2></div>
			<div class="article_div">
				<div class="article_tittle">${bean.content.name}</div>
				${bean.content.html}
				<div id="ct-cutepage" class="cutepage"></div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</#macro>

<@frame.exe bean=common>
	<@main bean=data/>
</@frame.exe>
