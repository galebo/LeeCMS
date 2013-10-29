<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#macro topDiv>
<div class="dedetoolbar">
	<div class="commtopNav">
		<div id="topleft">
	      <ul>
	         <li class="time">2012年11月21日</li>
	         <li class="login"><a target="_blank" href="#">全国统一咨询热线：<strong>${common.siteDefine['telephone']}</strong></a></li>
	      </ul> 
	    </div>
		<div class="commtopNav_right">
			<div class="webfx-menu-bar" style="left: 0px; top: 0px; visibility: visible;">
				<span><a title="网站首页" href="#" id="webfx-menu-object-31"><img src="${commCssBase}/images/home.gif" class="buttonico"/>网站首页 </a></span>
				<span><a title="婚姻律师" target="_blank" href="#"><img src="${commCssBase}/images/dede.gif" class="buttonico"/>婚姻律师 </a></span>
				<span><a title="律师服务" target="_blank" href="#"><img src="${commCssBase}/images/service.gif" class="buttonico"/>律师服务 </a></span>
				<span><a title="在线咨询" target="_blank" href="#"><img src="${commCssBase}/images/bbs.gif" class="buttonico"/>在线咨询 </a></span>
				<span><a title="律师帮助" target="_blank" href="#"><img src="${commCssBase}/images/help.gif" class="buttonico"/>律师帮助 </a></span>
			</div>
		</div>
	</div>
</div>
</#macro>
<#macro siteDesc>
			<p align="center">
				Copyright &copy; 2010-2088 &nbsp;&nbsp;${common.siteDefine['icp']}&nbsp;&nbsp; 
				<a target="_blank" href="${common.siteDefine['siteDomain']}">${common.siteDefine['address']}</a> &nbsp;&nbsp;
				<a target="_blank" href="#">${common.siteDefine['address']}</a>&nbsp;&nbsp;&nbsp;
				<a href="#header">↑返回顶部</a>
			</p>
			<p align="center">全国统一咨询热线：<strong>${common.siteDefine['telephone']}</strong>
				电话：${common.siteDefine['telephone']}${common.siteDefine['mobile']}
				传真：${common.siteDefine['fax']}
				邮箱：${common.siteDefine['email']}
			</p>
</#macro>

<#macro topLogo>
<img src="${uploadDir}/logo.png" width="249px" height="43px" border="0" align="left" />
</#macro>
<#macro aboutDiv divCss="">
	<@area.titleDiv divCss=divCss title="知名律师">
		<div style="padding-bottom:8px" class="list-post">
			<div style="text-align: center;">
				<a target="_blank" href="#">
				<img width="150" height="173" alt="" src="${uploadDir}/91.jpg" title="" class="size-medium wp-image-54 aligncenter"/>
				<img width="150" height="173" alt="" src="${uploadDir}/92.jpg" title="" class="size-medium wp-image-54 aligncenter"/></a><br/>
				<a target="_blank" href="#">某某某律师咨询电话：400-888-8888&nbsp;&nbsp;${common.siteDefine['mobile']}</a><br/>
				<a target="_blank" href="#">单位：${common.siteDefine['workSite']}</a> <br/>
				<a target="_blank" href="#">地址：${common.siteDefine['address']}</a>
			</div>
		</div>
	</@area.titleDiv>
</#macro>

<#macro aboutDiv2>
    <div>
      <div class="stitle">知名婚姻律师</div>
      <div class="scontent">
        <div class="sliterm">
		   <p>
			<a target="_blank" href="#" class="feedme">北京知名婚姻律师离婚律师</a>
		   	<#list 1..6 as one>
				<a target="_blank" href="#">北京知名婚姻律师离婚律师</a><br/>
			</#list>
		   </p>
        </div>
      </div>
      <div class="stitle_buttom"> </div>
    </div>
</#macro>



<#macro aaa>
<div id="BDBridgeWrap"><div id="BDBridgeIconWrap" style="width: 130px; height: 66px; top: 50%; left: auto; right: 0px; margin-right: 8px; margin-top: -33px; position: fixed;"><object width="2" height="2" align="middle" id="BDBridgeIcon" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000">
<param value="transparent" name="wmode"><param value="always" name="allowscriptaccess">
<param value="http://qiao.baidu.com/swf/icon.swf" name="movie">
<embed width="130" height="66" align="middle" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="BDBridgeIcon" src="http://qiao.baidu.com/swf/icon.swf" allowscriptaccess="always" ver="9.0.0" wmode="transparent"></object></div>
<div id="BDBridgeInviteWrap" style="position: fixed;"><object width="2" height="2" align="middle" id="BDBridgeInvite" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000">
<param value="transparent" name="wmode"><param value="always" name="allowscriptaccess"><param value="http://qiao.baidu.com/swf/invite.swf" name="movie">
<embed width="2" height="2" align="middle" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="BDBridgeInvite" src="http://qiao.baidu.com/swf/invite.swf" allowscriptaccess="always" ver="9.0.0" wmode="transparent"></object></div>
<div id="BDBridgeLS" style="background: none repeat scroll 0% 0% rgb(255, 255, 255);"><object width="2" height="2" align="middle" id="BDBridgeSwf" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"><param value="transparent" name="wmode"><param value="always" name="allowscriptaccess">
<param value="http://qiao.baidu.com/swf/local_storage.swf" name="movie">
<embed width="2" height="2" align="middle" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" name="BDBridgeSwf" src="http://qiao.baidu.com/swf/local_storage.swf" allowscriptaccess="always" wmode="transparent"></object></div>                        <div id="BDBridgeMess"><div style="z-index: 2147483647; display: none; width: 348px; height: 324px; top: 50%; left: 50%; margin-left: -174px; margin-top: -162px; position: fixed;" id="BaiduBridgePigeon">
<div style="background-color:#6cadde" class="bd_bp_bg" id="BdBPTwoPx">&nbsp;</div><div style="background-color:#6cadde" class="bd_bp_bg" id="BdBPOnePx">&nbsp;</div><div style="background-color:#6cadde" class="bd_bp_pigeon bd_bp_bg">	<div style="background-color:#6cadde;" class="bd_bp_bg" id="BdBPTitle"><div style="color:#fff" class="bd_bp_bg" id="BdBPTitleText">欢迎给我们留言</div><a href="#" hidefocus="true" id="BdBPClose"></a>	<div class="bd_bp_clear_all"></div></div>
<div style="max-height:244px;_height:expression((this.clientHeight&gt;=244)?'244':'auto');zoom:1;" id="BdBPBody">		<iframe style="display:none;" name="BdBPIframe" id="BdBPIframe" onload="javascript:BaiduBridgePigeon.succeed();"></iframe>		<form action="http://qiao.baidu.com/?module=default&amp;controller=index&amp;action=doMess&amp;siteid=479049" method="post" accept-charset="utf-8" target="BdBPIframe" id="BdBPForm">
<input type="hidden" value="北京离婚律师|北京起诉离婚首选|婚姻律师提供离婚咨询" name="bd_bp_title">		<input type="hidden" value="" name="bd_bp_referer">		<input type="hidden" value="1353386600515" id="BdBPTick" name="bd_bp_tick"><div><div id="BdBPSpan_0" class="bd_bp_0_head">留言内容</div>
			<textarea style="width:238px;" class="bd_bp_mess" onblur="javascript:BaiduBridgePigeon.blurHandler(this);" onfocus="javascript:BaiduBridgePigeon.focusHandler(this);" id="BdBPInput_0" name="bd_bp_messText">请在此输入留言内容，我们会尽快与您联系。</textarea><span style="display:" id="BdBPAlert_0" class="bd_bp_alert">*</span><div class="bd_bp_clear_all"></div></div><div style="margin:8px 0 0 0;" id="BdBPItem_1"><span class="bd_bp_0_head" id="BdBPSpan_1">姓名</span>
			<input type="text" style="width:238px;" maxlength="100" class="bd_bp_1_input" onblur="javascript:BaiduBridgePigeon.blurHandler(this);" onfocus="javascript:BaiduBridgePigeon.focusHandler(this);" id="BdBPInput_1" value="最多100个字符" name="bd_bp_messName"><span "="" class="bd_bp_alert" id="BdBPAlert_1">*</span>
			<div class="bd_bp_clear_all"></div></div><div style="margin:8px 0 0 0;" id="BdBPItem_2">
			<span class="bd_bp_0_head" id="BdBPSpan_2">电话</span><input type="text" style="width:238px;ime-mode:disabled;" maxlength="100" class="bd_bp_1_input" onblur="javascript:BaiduBridgePigeon.blurHandler(this);" onfocus="javascript:BaiduBridgePigeon.focusHandler(this);" id="BdBPInput_2" value="请输入您的电话号码" name="bd_bp_messPhone"><span "="" class="bd_bp_alert" id="BdBPAlert_2">*</span><div class="bd_bp_clear_all"></div></div><div style="margin:8px 0 0 0;display:none" id="BdBPItem_3">
			<span class="bd_bp_0_head" id="BdBPSpan_3">地址</span><input type="text" style="width:238px;" maxlength="100" class="bd_bp_1_input" onblur="javascript:BaiduBridgePigeon.blurHandler(this);" onfocus="javascript:BaiduBridgePigeon.focusHandler(this);" id="BdBPInput_3" value="最多100个字符" name="bd_bp_messAddress">
			<span style="display:none" class="bd_bp_alert" id="BdBPAlert_3">*</span><div class="bd_bp_clear_all"></div></div>
			<div style="margin:8px 0 0 0;" id="BdBPItem_4"><span class="bd_bp_0_head" id="BdBPSpan_4">邮箱</span><input type="text" style="width:238px;ime-mode:disabled;" maxlength="100" class="bd_bp_1_input" onblur="javascript:BaiduBridgePigeon.blurHandler(this);" onfocus="javascript:BaiduBridgePigeon.focusHandler(this);" id="BdBPInput_4" value="请输入合法邮箱名" name="bd_bp_messEmail"><span style="display:none" class="bd_bp_alert" id="BdBPAlert_4">*</span>
			<div class="bd_bp_clear_all"></div></div><div id="BdBPExtral"></div>		</form>	</div>
				<div style="border-top:1px solid #6cadde;background-color:#B9DDF8;padding:0 27px 0 8px;" id="BdBPFoot" class="bd_bp_border">		<div style="float:left" id="BdBPCopyRight">			<a style="border:1px solid #DDF0FE;" id="BdBPCrIcon" target="_blank" href="http://qiao.baidu.com" title="前往百度商桥" hidefocus="true">
			<div title="前往百度商桥" id="BdBPCrIconRed"></div><div title="前往百度商桥" id="BdBPCrIconBlue"></div></a>
<span style="color:#212121" id="BdBPCrText">百度提供技术支持</span>		</div>
<a style="float:right" id="BdBPSend" href="#" hidefocus="true">发送</a>		<div class="bd_bp_clear_all"></div>	</div></div></div></div></div>

</#macro>

<#macro baidu>
<link rel="stylesheet" type="text/css" href="http://qiao.baidu.com/css/bw.css">
<script type="text/javascript" charset="UTF-8" src="http://qiao.baidu.com/js/bw.js?v=2357"></script>
<script type="text/javascript" language="javascript" id="BDBridgeSendData" src="http://rqiao.baidu.com/Enter.php?callback=BDBridge.handleEnter&amp;siteid=479049&amp;bid=&amp;referrer=&amp;word=&amp;coding=&amp;bdclkid=&amp;title=%E5%8C%97%E4%BA%AC%E7%A6%BB%E5%A9%9A%E5%BE%8B%E5%B8%88%7C%E5%8C%97%E4%BA%AC%E8%B5%B7%E8%AF%89%E7%A6%BB%E5%A9%9A%E9%A6%96%E9%80%89%7C%E5%A9%9A%E5%A7%BB%E5%BE%8B%E5%B8%88%E6%8F%90%E4%BE%9B%E7%A6%BB%E5%A9%9A%E5%92%A8%E8%AF%A2&amp;t=1353386600384" charset="UTF-8"></script>
<script type="text/javascript" language="javascript" id="BDBridgeReport" src="http://rqiao.baidu.com/Refresh.php?callback=BDBridge.handleRefresh&amp;bid=10147c98c68947e835f3b77d&amp;siteid=479049&amp;t=1353387367794" charset="UTF-8"></script>
<script type="text/javascript" async="" src="http://www.google-analytics.com/ga.js"></script>
</#macro>
