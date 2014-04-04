<#macro top>
<script language="javascript" src="${commTBase}/js/checkForm.js"></script>
<body>

	<div id="topwidth">
		<a href='${common.homePage.url}'><img src='${commTBase}/upload/767889691182.png' border='0' title='北京刑事律师'></a>
	</div>
</#macro>
<#macro menu>
	<div id="menu1">
		<ul class="menul1">
		    <li><a href="${common.homePage.url}" title="common.homePage.name">${common.homePage.name}</a></li>
		  <#list common.menuList as one>
		    <li><a href="${one.url}" title="${one.name}">${one.name}</a></li>
		</#list>
		</ul>
	</div>
</#macro>

<#macro flash id width height src>
<div id='${id}'>
				<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000'
					codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0'
					width='${width}' height='${height}'>
					<param name='movie' value='${src}'>
						<param name='wmode' value='opaque'>
							<param name='quality' value='high'>
								<embed style='width:${width}px; height:${height}px;'
									pluginspage='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'
									src='${src}'
									wmode='transparent' width='${width}' height='${height}' type='application/x-shockwave-flash' quality='high' menu='false'></embed>
				</object>
			</div>
</#macro>
<#macro adv1>
	<@flash id="neirong_allogo" width='680' height='90' src='${commTBase}/upload/tabanner2.swf'/>
</#macro>
<#macro logo1>
	<@flash id="logo" width='1000' height='180' src='${commTBase}/upload/TABanner.swf'/>
</#macro>

<#macro foot>
	<div id="foot1">
		<div id="foot1_1">
			<#list common.links as one>
			<a href="${one.url}">${one.name}</a>
			<span>|</span> 
			</#list>
		</div>
	</div>
	<div id="foot2">
		<div id="foot2_1">
			All Right Reserved 
			<span><a href="http://www.miibeian.gov.cn/" target="_blank">${common.siteDefine['ICP']}</a></span> 
			<font id="foot2_2"><a href="${common.siteDefine['siteDomain']}"><b>${common.siteDefine['siteName']}</b></a></font> 
			<a href="#">网站管理</a></br>${common.siteDefine['copyright']} <span style="color: #000000">版权所有 法律咨询热线：</span>${common.siteDefine['mobile']}
			&nbsp;技术支持： <a href="#" target="_blank" class="linkGray">${common.siteDefine['siteName']}</a>
		</div>
	</div>
</#macro>




<#macro GuestBook>
		<div id="list_right_xq2">
			<div id="list_right_xq2_1">
				<a href='/GuestBook/PingLun.asp?cpid=780459908495&classid=22' target="_blank"> 【已有<span>3</span>位网友浏览过此网页】 </a>
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


<#macro list_search>

			<div id="list_left_nr3">
				<div id="list_left_nr3_1">
					<div id="list_left_nr3_2">
						<div id="list_lfet_input">
							<form name="formsearch" method="post" action="#" onsubmit="return zCheckSearch(this);">
								<input class="list_left_input" type="text" name="key" size="18" />
								 <input type="submit" class="list_left_input_bt" value="文档搜索" />
							</form>
						</div>
					</div>
				</div>
			</div>
</#macro>
<#macro list_left items currentItem>
<div id="list_left">
			<div id="list_left_top">
				<div id="list_left_top_1">
					<h3>${currentItem.name}</h3>
				</div>
				<div id="list_left_nr">
					<div id="list_left_nrbg">
						<div id="list_left_nr1">
							<div id="list_left_nr2">
								<ul class="list_left_nrul">
								<#list items as one>
									<li><a <#if one.name=currentItem.name>class='on'</#if> href='${one.url}'>${one.name}</a></li>
								</#list>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<@list_search/>
		</div>
</#macro>

<#macro index_search>
	<div id="neirong_left2">
		<div id="neirong_leftl2">
			<div id="neirong_left2_2">
				<div id="neirong_left2_2_1">
					<form name="formsearch" method="post" action="#" onsubmit="return zCheckSearch(this);">
						<input id="neirong_left2_2_2" type="text" name="key" /> 
						<input type="submit" value="" id="neirong_left2_2_3" />
					</form>
				</div>
			</div>
		</div>
	</div>
</#macro>