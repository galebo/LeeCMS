
<#import "${ftlPath}/common/frame.ftl" as frame/>

<#macro main bean>
<@frame.html title="安博律师事务所新网站 规模化 专业化 职业化 品牌化综合商务律师事务所 400-070-9070 安博律师事务所"/>

<div id="orz">
	<@frame.head/>
	<div id="orz_main">
		<@search/>
		<div id="orz_main_1">
			<@main_left/>
		</div>
		<@list item=common.itemIdList[1]/>
		<div id="orz_main_3">
			<@main_right/>
		</div>
		
		<@self_area bean=bean/>
	</div>

	<@frame.foot/>
	<div class="clear"></div>
</div>
</body>
</html>
</#macro>

<#macro list item css="orz_main_2" count=9>
<div id="${css}">
	<@frame.title name=item.name url=item.url/>
	<div id="orz_main_1_2">
	  <ul class="list">
		 <#list item.contents as one>
		    <li><span class="txt"><a href="${one.url}" title="${one.name}">${one.name}</a></span><span class="date">2013-01-10</span></li>
			<#if one_index=count><#break></#if>
		 </#list>
	  </ul>  
	</div>
</div>
</#macro>

<#macro main_left>
	<#list common.groupLoops['loop1'].sons as one>
		<@video_area bean=one/>
	</#list>
</#macro>
<#macro main_right>
	<@frame.title name=common.itemIdList[6].name url=common.itemIdList[6].url/>
	<#list common.itemIdList[6].contents as one>
		<div  class="loop2">
			<div class="loop2_img"><a href="${one.url}" ><img src="${one.pic}"/></a></div>
		  	<div class="loop2_txt">
			  	<div class="title"><a href="${one.url}" >${one.name}</a></div>
			  	<div class="txt">${one.desc}</div>
		  	</div>
		  	<div class="clear"></div>
		</div>
		<#if one_index=2><#break></#if>
	</#list>
</#macro>


<#macro self_area bean>
	<#if common.parentSonStyle>
	<div class="self_area">
		<div id="orz_main_1">
			<div style="width:100%;">
				<@video_area bean=common.sonCommon.groupLoops['loop1'].sons[0] height=160 />
				<@video_area bean=common.sonCommon.groupLoops['loop1'].sons[1] height=160 />
				<@list item=common.sonCommon.itemIdList[0] css="orz_main_5"  count=4/>
			</div>
		</div>
		<div id="orz_main_2">
			<div style="width:100%;">
				<@list item=common.sonCommon.itemIdList[1] css="orz_main_5" count=4/>
				<@list item=common.sonCommon.itemIdList[2] css="orz_main_5" count=4/>
				<@list item=common.sonCommon.itemIdList[3] css="orz_main_5" count=4/>
			</div>
		</div>
	
		<div id="orz_main_3">
			<@frame.title name=common.sonCommon.itemIdList[4].name url=common.sonCommon.itemIdList[4].url/>
			<#list common.sonCommon.itemIdList[4].contents as one>
				<div  class="loop2">
					<div class="loop2_img"><a href="${one.url}" ><img src="${one.pic}"/></a></div>
				  	<div class="loop2_txt">
					  	<div class="title"><a href="${one.url}" >${one.name}</a></div>
					  	<div class="txt">${one.desc}</div>
				  	</div>
				  	<div class="clear"></div>
					<#if one_index=4><#break></#if>
				</div>
			</#list>
		</div>
	</div>
	</div>
	</#if>
</#macro>

<#macro video_area bean height=140 width=230>
	<@frame.title name=bean.name url=bean.url/>
	<div id="orz_main_1_2">
	<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" 
	codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,18,60" 
	 width="${width}"  height="${height}" id="fullscreen" align="middle">
	  <param name="wmode" value="transparent" /> 
	    <param name="allowFullScreen" value="true" />
	    <param name="AutoStart" value="true" />
	    <param name="Mute" value="0"/>
	    <param name="movie" value="http://player.youku.com/player.php/sid/${bean.img}/v.swf" />
	    <param name="bgcolor" value="#333333" />
	    <embed src="http://player.youku.com/player.php/sid/${bean.img}/v.swf" allowfullscreen="true"   bgcolor="#333333" width="${width}" height="${height}"   name="fullscreen" align="middle" type="application/x-shockwave-flash"    pluginspage="http://www.macromedia.com/go/getflashplayer" />  
	</object>
	</div>
</#macro>

<#macro search>
<div style="width:962px; height:auto; ">
<div class="gonggao">
    <div class="title"><b>网站公告</b></div>
    <div class="marquee">
	<marquee>
          <#list common.groupLoops['gonggao'].sons as one>
          <a title="${one.name}" href="${one.url}">${one.name}</a>
          </#list>
     </marquee></div>
     <div  class="search"><form method="get" action="../indexSearch/11.html"><strong>搜索律师</strong><input type="text" id="key" name="key">
     <input type="submit" class="done" value=""></form></div>
</div>
</div>
</#macro>
<@main bean=data/>
