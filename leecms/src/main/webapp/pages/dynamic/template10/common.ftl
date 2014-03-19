<#macro top>
<script language="javascript" src="http://www.xslsbj.com/js/checkForm.js"></script>
<body>
	<!--[if IE 6]>
<script type="text/javascript" src="http://www.xslsbj.com/js/DD_belatedPNG.js" ></script>
<script type="text/javascript">DD_belatedPNG.fix('img,background');</script>
<![endif]-->

	<div id="topwidth">
		<a href='http://www.xslsbj.com/'><img src='http://images.xslsbj.com/uploadpic/logo/767889691182.png' border='0' title='北京刑事律师'></a>
	</div>
</#macro>
<#macro menu>
	<div id="menu1">
		<ul class="menul1">
  <#list menuList as one>
    <li><a href="${one.url}" title="${one.name}">${one.name}</a></li>
	</#list>
		</ul>
	</div>
	
</#macro>

<#macro logo1>
	<div id="logo">
		<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000'
			codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0'
			width='1000' height='180'>
			<param name='movie' value='http://www.xslsbj.com//uploadpic/common/banner/TABanner.swf'>
				<param name='wmode' value='opaque'>
					<param name='quality' value='high'>
						<embed
							pluginspage='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'
							src='http://www.xslsbj.com//uploadpic/common/banner/TABanner.swf' wmode='transparent'
							width='1000' height='180' type='application/x-shockwave-flash'
							quality='high' menu='false'></embed>
		</object>
	</div>
</#macro>
<#macro foot>
	<div id="foot1">
		<div id="foot1_1">
			<#list 1..10 as one>
			<a href="/"> 相册影集</a><span>|</span> 
		</#list>
			<a href="/map.xml" target="_blank">网站地图</a>
		</div>
	</div>
	<div id="foot2">
		<div id="foot2_1">
			All Right Reserved <span><a href="http://www.miibeian.gov.cn/"
				target="_blank">闽ICP备08005907号</a></span> <font id="foot2_2"><a
				href="http://www.xslsbj.com/"><b>北京刑事律师</b></a></font> <a href="/LawAdmin/">网站管理</a></br>
			Copyright @2008-2014 <span style="color: #000000">版权所有 法律咨询热线：</span>13901078504
			&nbsp;技术支持： <a href="http://www.maxlaw.cn" target="_blank"
				class="linkGray">中国大律师网</a>
		</div>
	</div>
</#macro>