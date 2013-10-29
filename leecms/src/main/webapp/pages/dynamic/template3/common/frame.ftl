<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/self.ftl" as self/>
<#macro exe bean jsName="">
<@g.Top/>
<@head bean=common/>
<body>
<div  class="container">
	<@top/>
	<@self.area3/>
	<@nav menuList=common.menuList/>
	
	 <div class="middleDiv">
	<#nested>
	 </div>

	<div class="clear"></div>
	<@foot links=common.links groupLinks=common.groupLinks/>
</div>
<@footScript jsName=jsName/>
</body>
</html>
</#macro>



<#macro head bean>
<link href="${commCssBase}/css/style1.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${commBase}/js/jquery.min.js"></script>
<script type="text/javascript" src="${commBase}/js/common.js"></script>
<script type="text/javascript" src="${commBase}/js/business.js"></script>
</head>
</#macro>

<#macro nav menuList>
<div class="div_menu">
    <#list menuList as one>
	 <a href="${one.url}" target="_self" class="menu">${one.name}</a>
	<#if one_has_next >|</#if>
	</#list>
</div>
</#macro>
<#macro foot links groupLinks>
	<@link1 links =links groupLinks=groupLinks/>
	<@link2/>
	<@copyright/>
</#macro>

<#macro footScript jsName>
<script language="JavaScript" src="${commTBase}/js/${jsName}.js"></script>
</#macro>



<#macro top>
<div class="div_top">
	<span class="tLeft">2012年8月12日 13:15:44 星期日</span>
	<span class="tRight"><a href="#" class="menu" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('${common.siteDefine['site']}');return(false);" style="behavior:" url(#default#homepage)="">设为主页</a>&nbsp;
	<a href="#" class="menu" onclick="javascript:window.external.AddFavorite('${common.siteDefine['site']}', '${common.siteDefine['siteName']}')" ;="" target="_self">收藏本站</a></span>
</div>
</#macro>

<#macro link1 links groupLinks>
<div>
	<div class="div_link1">
		<span class="link1"><strong>友情链接</strong></span>
		<span class="link2"><a class="menu" href="#" onclick='javascript:window.open("FriendSiteReg.shtml","Announce","top=100,left=100,width=500,height=300,scrollbars=yes")'>申请</a>&nbsp;&nbsp;
			<a href="" class="menu">更多&gt;&gt;&gt;</a>
		</span>
	</div>
	 <div>
		<#list groupLinks?keys as key>
			<div class="links">
				<ul>
				<#list groupLinks[key].sons as one>
				<li><a target="_blank" href="${one.url}">${one.name}</a></li>
				</#list>
				</ul>
			</div>
			<div class="clear"></div>
		</#list>
	</div>
</div>
</#macro>

<#macro link2>
<div>
	<span class="div_link1">
		<a href="#" class="menu" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('${common.siteDefine['site']}');return(false);" style="behavior:" url(#default#homepage)="">设为主页</a>
	&nbsp;|&nbsp;
	<a href="#" class="menu" onclick="javascript:window.external.AddFavorite('${common.siteDefine['keyword']}', '${common.siteDefine['keyword']}')" ;="" target="_self">收藏本站</a>
	| <a href="" class="menu">友情链接</a>&nbsp;|&nbsp;<a href="" target="_blank" class="menu">联盟网站</a>&nbsp;|&nbsp;<a href="" target="_blank" class="menu">管理登录</a>
	</span>
</div>
</#macro>

<#macro copyright>
<div class="div_copyright">
	${common.siteDefine['copyright']}
	<@g.getWebCount userId=1 commCssBase=commCssBase/>
</div>
</#macro>