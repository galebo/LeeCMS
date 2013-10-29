<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/self.ftl" as self/>

<#macro exe>
<@g.Top/>
<link rel=stylesheet type=text/css  href="${commCssBase}/css/icms.css">
<script type="text/javascript" src="${commBase}/js/jquery.min.js"></script>
<script type="text/javascript" src="${commBase}/js/common.js"></script>
<script type="text/javascript" src="${commBase}/js/business.js"></script>
<body>
	<@self.top/>
	<@nav menuList=common.menuList/>
	<div class="clear"></div>
	<#nested>
	<@foot groupLinks=common.groupLinks/>
</body>
</html>
</#macro>


<#macro nav menuList>
<div class="d_nav b_d_base">
	<div class="menu_list1_div">
   		<#list menuList as one>
		<a href="${one.url}" target=_blank>${one.name}</a> 
		<#if one_index=7><#break></#if>
		</#list>
	</div>
	<div class="menu_list2_div">
		<#list menuList[1].sonMenus as one1>
		<a href="${one1.url}" target=_blank>${one1.name}</a> 
		</#list>
	</div>
	<div id="search_div">
		<form name="search" action="${common.searchPage.url}" target="_blank" id="act">
			<span><input style="width: 130px;" class="search_input" name="q"  id="key" size="30" type="text"></span>
			<span><input id="button" class="search_btn" value=" " type="submit"
			 onclick="document.getElementById('act').action='${common.searchPage.url}'+document.getElementById('key').value"></span>
		</form>
	</div>
</div>
</#macro>

<#macro foot groupLinks>
<!--foot开始-->
<div class="mw_link b_d_base">
	<ul>
		<#list groupLinks?keys as key>
		  <li <#if key_index=0>class="nav_hover"</#if> >
		  <div class="link1"><a href="#">${key}</a></div> 
		  </li>
		</#list>
	</ul>
		<#list groupLinks?keys as key>
		  <div class="clear link2" style="<#if key_index=0>display: block;</#if>">
			<#list groupLinks[key].sons as one>
		  		<a href="${one.url}">${one.name}</a>
			</#list>
		  </div>
		</#list>
</div>
<@self.copyright/>
</#macro>

<#macro item_right item1 item2>
<div class="list_right">
	<@self.self divCss="box4 b_div_top2" h2DivClass=""/>
	<@list1 item=item1 divCss="box4 b_div_top2" name="top" ulCss="list_ul2" h2DivClass=""/>
	<@list1 item=item2 divCss="box4 b_div_top2" name="recommend" ulCss="list_ul3" h2DivClass=""/>
</div>
<div class="clear"></div>
</#macro>

<#macro list1 item divCss ulCss name="" h2DivClass="" showColor="false" count=7>
	<div class="${divCss}">
		<div class="${h2DivClass}"><h2><a href="${item.url}" target=_blank><span id="item${name}">${item.name}</span></a></h2></div>
		<ul class="${ulCss}">
			<#list item.contents as one>
			<#if showColor="true" && one_index<4>
			  	<li><a id="${name+one_index}" style="color: #339933" href="${one.url}">${one.name}</a></li>
			<#else>
				<li><a id="${name+one_index}" href="${one.url}" target="_blank" title="${one.name}">${one.name}</a></li>
			</#if>
			<#if one_index =count><#break></#if>
			</#list>
		</ul>
		<div class="clear"></div>
	</div>
</#macro>

<#macro list4 item divCss ulCss keyCss h2DivClass="" count=7>
<div class="${divCss}">
	<div class="${h2DivClass}"><h2><span><a href="${item.url}" target=_blank>更多&gt&gt</a></span>
	<a href="${item.url}" target=_blank>${item.name}</a></h2></div>
	<div class="${keyCss}">
		<a href="${item.url}" target=_blank>${item.name}</a>| <a href="${item.url}" target=_blank>${item.name}</a>| <a href="${item.url}" target=_blank>${item.name}</a> 
	</div>
	<ul class="${ulCss}">
		<#list item.contents as one>
				<li><a href="${one.url}" target="_blank" title="${one.name}">${one.name}</a></li>
			<#if one_index =count><#break></#if>
		</#list>
	</ul>
</div>
</#macro>

<#macro list2 item divCss listDivClass="ct" h2DivClass="">
<div class="${divCss}">
	<div class="${h2DivClass}"><h2>${item.name}</h2></div>
	<div class="${listDivClass}">
		<div class="tags_list">
			<dl class="tbox">
				<dd>
				<#list item.contents as one>
				<a href="${one.url}" title="${one.name}" style="font-size:17px;color:#f6babc">${one.name}</a>
				</#list>
				</dd>
			</dl>
		</div>
	</div>
</div>
</#macro>

<#macro list3 item divCss ulCss h2DivClass="">
<div class="${divCss}">
	<div class="${h2DivClass}"><h2><a href="${item.url}">${item.name}</a></h2></div>
	<div class="item_list">
	  <ul>
		<#list 1..6 as one>
		    <li id="m_${one_index+1}" onmouseover="mover(${one_index+1});" onmouseout="mout(${one_index+1});">
		    <a href="${item.url}">${item.name}</a></li>
		</#list>
	  </ul>
	</div>
	
   <#list 1..6 as one>
   <div class="item_div <#if one_index =0>item_div_on</#if>" id="s_${one_index}" onmouseover="mover(${one_index});" onmouseout="mout(${one_index});">
	   <ul class="list_ul3 list_ul3_1">
		<#list item.contents as one>
		  <li><a href="${one.url}" target="_blank" title="${one.name}">${one.name}</a></li>
		<#if one_index =4><#break></#if>
		</#list>
		</ul>
	</div>
	</#list>
</div>
</#macro>

