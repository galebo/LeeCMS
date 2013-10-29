<#macro selfAbout>
	<div class="selfAbout"><img src="${common.siteDefine['selfPicture']}" alt="律师" />
	  <p><strong><span style="color: #ff6600">${common.siteDefine['selfName']}</span></strong></p>
	  ${common.siteDefine['selfAbout']}</div>
</#macro>
<#macro guanggao>
<!--广告开始-->
	<div class="box2_r">
		<p><a href=""><img src="${commCssBase}/images/but01.jpg" alt="咨询" border="0" /></a></p>
		<p class="qq"><a target="_blank" href="#">
		<img border="0" title="点击这里给我发消息" alt="点击这里给我发消息" src="#"/></a>
		<a href=""><img src="${commCssBase}/images/msn.jpg" alt="msn" border="0" /></a></p>
	    </div>
<!--广告结束-->
</#macro>
<#macro topLogo>
	<a href="${common.homePage.url}"><img src="${uploadDir}/logo.png" alt="${common.siteDefine['siteName']}" border="0" /></a>
</#macro>
<#macro sonTop1>
<div class="box4"><img src="${uploadDir}/banner1.jpg" style="width:972px;height:200px;"/></div>
</#macro>

<#macro bottom>
	<div class="foot_box2"></div>
	<div class="foot_box3">
		<div> 电话：${common.siteDefine['telephone']}（工作时间）&nbsp;&nbsp;传真：${common.siteDefine['fax']}&nbsp;&nbsp;手机：${common.siteDefine['mobile']}</div>
		<div><p>Email：${common.siteDefine['email']} &nbsp;QQ：${common.siteDefine['qq']}&nbsp;MSN：${common.siteDefine['msn']} </p></div>
		<div>地址：${common.siteDefine['address']} 邮编：${common.siteDefine['mail-num']}</div>
	</div>
	<div class="foot_box4">
		<p><a href="#">关于我们</a> -- <a href="#">权责声明</a> -- <a href="#">联系我们</a> -- <a href="#">sitemap</a></p>
	</div>
</#macro>
