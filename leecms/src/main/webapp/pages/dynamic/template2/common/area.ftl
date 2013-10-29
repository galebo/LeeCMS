<#import "${ftlPath}/common/self.ftl" as self/>
<#macro list bean count=7> 
  <div class="list_box list_box12">
	<ul class="list04">
		<#list bean.contents as one>
			<li><a href="${one.url}"><b>${one.name}</b></a><span class="update_time">${one.updateTime?string('yyyy-MM-dd HH:mm:ss')}</span></li>
		  <#if one_index ==count><#break></#if>
		</#list>
	</ul>
	<div id="cutepage" class="cutpage"><span class="ash">首页</span> <span class="ash">上页</span> <span class="ash">下页</span> <span class="ash">尾页</span> 
		转到：<input type="text" style="width: 30px" id="go-page-num" value="1" maxlength="5"
		 onkeyup="this.value=get_num(this.value);if (this.value>1) this.value=1;" class="text" /> 
		<input type="button" value="GO" onclick="location_href('?type=list&amp;classid=22&amp;page=' + get_id('go-page-num').value + '');"
		 class="button" /> 页
	</div>
</div>
</#macro>

<#macro _area1_0 bean count divCss css>
<div class="${divCss}">
	<div class="tittle_box"><h2><a href="${bean.url}">${bean.name}</a></h2></div>
	<ul class="${css}">
		<#list bean.contents as one>
		  <li><a href="${one.url}" target="_self">${one.name}</a></li>
		  <#if one_index ==count><#break></#if>
		</#list>
	</ul>
</div>
</#macro>

<#macro _area3 bean count=8>
	<div class="box3_l2top">
	<h2><a href="${bean.url}">${bean.name}</a></h2>
	<ul>
		<#list bean.contents as one>
		  <li><a href="${one.url}" target="_self">${one.name}</a></li>
		  <#if one_index == count><#break></#if>
		</#list>
	</ul>
	</div>
</#macro>
<#macro _area2 bean count>
<div class="list_box list_box7">
	<div class="tittle_box"><h2><a href="${bean.url}">${bean.name}</a></h2></div>
	<div class="font_color">
		<ul>
		<#list bean.contents as one>
			<li><a class="font_color0${one_index}" href="${one.url}" target="_self">${one.name}</a></li>
		  <#if one_index == count><#break></#if>
		</#list>
		</ul>
	</div>
</div>
</#macro>

<#macro area_self>
<div class="list_box list_box4">
	<div class="tittle_box"><h2><a href="#">律师介绍</a></h2></div>
	<@self.selfAbout/>
</div>
</#macro>


<#macro area_zixun>
<div class="list_box list_box5">
	<div class="tittle_box"><h2><a href="#">咨询</a></h2></div>
	<div class="gb_zx"><a href="" class="gb_zx">最新咨询问题</a></div>
	<p class="gb_zx2">问题：</p>
	<ul class="list09">
	  <li><a href="" target="_self">ask1</a></li>
	  <li><a href="" target="_self">ask2</a></li>
	 </ul>
	<div class="gb_zx3 clear">
		<a href="#" ><div></div></a>
	</div>
</div>
</#macro>
