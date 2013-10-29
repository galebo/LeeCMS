<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/frame.ftl" as frame/>

<#macro main bean>
<@frame.html title=bean.name+"-安博律师事务所"/>


<div id="orz">
<@frame.head/>

<div id="orz_main">
	<#if bean.name="视频中心">
	<@vedio bean=bean/>
	<#else>
	<@exe bean=bean/>
	</#if>
</div>

<@frame.foot/>
</div>
</body>
</html>
</#macro>

<#macro exe bean>
	<div id="orz_left">
		<div id="orz_left_1">菜单导航</div>
		<div id="orz_left_2">
			<ul>
			<#if bean.level==1>
				<#list bean.brotherItems as one>
				<li><a href="${one.url}">${one.name}</a></li>
				<#if one_index=6 ><#break></#if>
				</#list>
			<#else>
				<#list bean.contents as one>
				<li><a href="${one.url}">${one.name}</a></li>
				<#if one_index=6 ><#break></#if>
				</#list>
			</#if>
			</ul>
		</div>
		<@frame.marquee/>
	</div>
	<div id="orz_right">
		<@frame.nav name=bean.name url=bean.url/>
		<div id="orz_right_2">
			<div class="item_list">
				<ul>
				<#list bean.contents as one>
				<li>
				    <div  id="page${one_index}div" style="width:100%">
				    <div class="list_txt"><a title="${one.name}" href="${one.url}" id="page${one_index}">${one.name}</a></div>
				    <div class="list_date">${one.updateTime?date}</div></div>
				</li>
				<#if one_index=6 ><#break></#if>
				</#list>
				</ul>
			</div>
			<@g.page bean=bean pageSize=7/>
		</div>
	</div>
</#macro>


<#macro vedio bean>
		<@frame.nav name=bean.name url=bean.url css="orz_right_1_video"/>
			<div class="orz_right_3_video" id="gg">
			      <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,18,60" id="fullscreen" align="middle" height="420" width="563">
			  <param name="wmode" value="transparent"> 
			    <param name="allowFullScreen" value="true">
			    <param name="AutoStart" value="true">
			    <param name="Mute" value="0">
			    <param id="film" name="movie" value="http://player.youku.com/player.php/sid/XNDQ3MzMzNjMy/v.swf">
			    <param name="bgcolor" value="#333333">
			    <embed id="film" src="http://player.youku.com/player.php/sid/XNDQ3MzMzNjMy/v.swf" allowfullscreen="true" bgcolor="#333333" name="fullscreen"
			     type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" align="middle" height="420" width="563">  
			</object>
			</div>
		<script>
		function play(film)
		{
				var a=document.getElementById("fullscreen");
				var b='<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,18,60"'
				       +' id="fullscreen" align="middle" height="420" width="563">'
				       +' <param name="wmode" value="transparent"> '
				       +'    <param name="allowFullScreen" value="true">'
				       +'   <param name="AutoStart" value="true">'
				       +' <param name="Mute" value="0">'
				       +' <param id="film" name="movie" value="http://player.youku.com/player.php/sid/'+film+'/v.swf">'
				       +' <param name="bgcolor" value="#333333">'
				       +' <embed id="film1" src="http://player.youku.com/player.php/sid/'+film+'/v.swf" allowfullscreen="true" bgcolor="#333333" name="fullscreen"'
				       +' type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" align="middle" height="420" width="563">  '
				       +' </object>';
				$("#gg").html(b);
		}
		</script>
		<div id="orz_right_2_video">
			<div class="item_list">
				<ul>
				<#list bean.contents as one>
				<li>
				    <div  id="page${one_index}div" style="width:100%"><div class="list_txt"><a title="${one.name}" 
				    onclick="play('${one.pic}');" href="javascript:void(0);" id="page${one_index}">${one.name}</a></div>
				    <div class="list_date">${one.updateTime?date}</div></div>
				</li>
				<#if one_index=5 ><#break></#if>
				</#list>
				</ul>
			</div>
			<@g.page bean=bean pageSize=7/>
		</div>
</#macro>
	
<@main bean=data/>
