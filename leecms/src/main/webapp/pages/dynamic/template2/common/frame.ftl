<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/self.ftl" as self/>
<#macro exe bean jsName="">
<@g.Top/>
<@head bean=common/>
<body >
<div class="wrapper">
	<@nav bean=common.menuList/>
	<div class="contents">
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
<link href="${commCssBase}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${commBase}/js/common.js"></script>
<script type="text/javascript" src="${commBase}/js/business.js"></script>
</head>
</#macro>

<#macro nav bean>
	<div class="header">
		<div class="header_box">
			<@self.topLogo/>
			<div class="header_box_1">
				<a href="#">现在咨询</a>
				<a href="#" onclick="this.style.behavior='url(#default#homepage)'; this.sethomepage(document.location); return false;">设为首页</a>
			</div>
		</div>
		<ul class="nav">
			<li><a href="${common.homePage.url}">${common.homePage.name}</a></li>
			<#list bean as one1>
			<li><a href="${one1.url}">${one1.name}</a>
				<ul id="subNews" class="menu_2">
					<#list one1.sonMenus as one2>
					<li><a href="${one2.url}" target="_self">${one2.name}</a></li>
					</#list>
				</ul>
			</li>
			<#if one1_index=6><#break></#if>
			</#list>
		</ul>
		<script>menuFix("nav","sfhover");</script>
	</div>
</#macro>

<#macro foot links groupLinks>
<div class="foot">
	<#list groupLinks?keys as key>
		<div class="foot_box1">
		<h3>${groupLinks[key].name}</h3>
		<ul class="link">
		<li>
			<#list groupLinks[key].sons as one2>
				<a  href="${one2.url}" target="_blank">${one2.name}</a>
			</#list>
		</ul>
		<div class="clear"></div>
	</div>
	</#list>

	<@self.bottom/>
</div>
</#macro>

<#macro footScript jsName>
</#macro>