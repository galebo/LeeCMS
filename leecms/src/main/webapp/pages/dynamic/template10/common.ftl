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
		  <#list common.menuList as one>
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


<#macro adv1>
<div id='neirong_allogo'>
				<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000'
					codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0'
					width='680' height='90'>
					<param name='movie'
						value='http://images.xslsbj.com/uploadpic/common/banner/tabanner2.swf'>
						<param name='wmode' value='opaque'>
							<param name='quality' value='high'>
								<embed style='width:680px; height:90px;'
									pluginspage='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'
									src='http://images.xslsbj.com/uploadpic/common/banner/tabanner2.swf'
									wmode='transparent' width='680' height='90'
									type='application/x-shockwave-flash' quality='high'
									menu='false'></embed>
				</object>
			</div>
</#macro>
<#macro GuestBook>
		<div id="list_right_xq2">
			<div id="list_right_xq2_1">
				<a href='/GuestBook/PingLun.asp?cpid=780459908495&classid=22' target="_blank"> 【已有<span>3</span>位网友浏览过此网页】
				</a>
			</div>
			<div id="list_right_xq2_2">
				<iframe id="iframe_gbook" src="http://xslsbj.maxlaw.cn/GuestBook/iframeGbook.asp?classid=22&countPingLun=0&products_id=780459908495&referUrl=http://xslsbj.maxlaw.cn/GuestBook/iframeGbook.asp" height="270px" width="706px" border="no" frameborder="no"
					scrolling="no"></iframe>
			</div>
		</div>


		<script language="javascript" src="/js/ReGuestBook.js"></script>
		<BR>
			<div id="list_right_xq3">
				<div id="list_right_xq3_1">
					<div id="list_right_xq3_2">您可能也对以下文章感兴趣</div>
					<ul>
					<#list 1..5 as one>
						<li><a href='#' target='_blank'>1.执行预案威力大 快速执结效果好</a></li>
					</#list>
					</ul>
				</div>
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



<#macro list_left items>
<div id="list_left">
			<div id="list_left_top">
				<div id="list_left_top_1">
					<h3>法律文集</h3>
				</div>
				<div id="list_left_nr">
					<div id="list_left_nrbg">
						<div id="list_left_nr1">
							<div id="list_left_nr2">
								<ul class="list_left_nrul">
								<#list items as one>
									<li><a <#if one_index=0>class='on'</#if> href='#'>${one.name}</a></li>
								</#list>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="list_left_nr3">
				<div id="list_left_nr3_1">
					<div id="list_left_nr3_2">
						<div id="list_lfet_input">
							<form name="formsearch" method="post" action="/art/Tags.asp" onsubmit="return zCheckSearch(this);">
								<input class="list_left_input" type="text" name="key" size="18" />
								 <input type="submit" class="list_left_input_bt" value="文档搜索" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
</#macro>