<#macro selfAbout>
	<div class="inner2 clearfix">
		<h3><span>主办律师简介</span></h3>
		<div class="clearfix">
		<p><img src="${common.siteDefine['selfPicture']}" border="0" align="left" /> 
		${common.siteDefine['selfAbout']}</p>
		<p>电话：<strong>${common.siteDefine['mobile']}，${common.siteDefine['telephone']}</strong><br /><br /><strong>
		<span style="font-size: small;">${common.siteDefine['workSite']}简介</span></strong><br />
		${common.siteDefine['workSiteAbout']}</p>
		</div>
    </div>
</#macro>

<#macro show2>
		<div class="clearfix"><p class="img"><img src="${uploadDir}/banner1.jpg" border="0" /></p></div>
</#macro>
<#macro topLogo>
		<div class="inner1 clearfix">
			<h1 class="logo">
				<a href="" title=""><img src="${uploadDir}/logo.png" alt="${common.siteDefine['siteName']}"/></a>
			</h1>
			<div class="search"><img src="${uploadDir}/kouhao.png"/></div>
		</div>
</#macro>

<#macro bottomSelf>
	<div class="inner1">
		<div class="copyright">
			<p style="text-align: center;">
			${common.siteDefine['workSite']}--${common.siteDefine['selfName']}律师@2011<br/>
			地址：${common.siteDefine['address']}<br />
			电话：${common.siteDefine['mobile']}；传真：${common.siteDefine['fax']}<br/>
			<a href="http://www.miibeian.gov.cn">${common.siteDefine['icp']}</a>
			</p>
		</div>
	</div>
</#macro>