<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/self.ftl" as self/>
<#macro exe bean jsName="">
<@g.Top/>
<@head bean=common/>
<body class="fs4">
	<div>
		<@top/>
		<@nav bean=common.menuList/>
		<#nested>
		<@foot links=common.links groupLinks=common.groupLinks/>
	</div>
<@footScript jsName=jsName/>
</body>
</html>
</#macro>

<#macro head bean>
<script language="javascript" type="text/javascript" src="${commBase}/js/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="${commBase}/js/common.js"></script>
<script language="javascript" type="text/javascript" src="${commBase}/js/business.js"></script>

<link rel="stylesheet" type="text/css" href="${commTBase}/css/icms${cssNum}.css"   />
</head>
</#macro>

<#macro top>
<a name="Top" id="Top"></a>
<div class="header clear">
	<div class="main clearfix">
		<div class="top_bar clearfix">
			<p class="day"><span>Saturday</span><span>, Jun 30th</span>	</p>
			<p class="updatetime"><span>Last update</span><em>01:28:35 AM GMT</em></p>
		</div>
		<@self.topLogo/>
	</div>
</div>
</#macro>


<#macro nav bean>
<div class="mainnav clear">
	<div class="main clearfix">
		<ul class="cssmenu">
		  <#list bean as one1>
			<li >
				<a href="${one1.url}" id="menu${one1_index}" title="${one1.name}">
				<span>${one1.name}</span></a>
	
				<ul>
		  			<#list one1.sonMenus as one2>
			  			<li ><a href="${one2.url}" 
			  			<#if one2_index = 0 >class=" first-item" </#if>
			  			<#if !one2_has_next >class=" last-item"  </#if>
			  			 id="menu${one1_index}${one1_index}" title="${one2.name}"><span class="menu-title">${one2.name}</span></a></li>
					</#list>
				</ul>
			</li> 
		  </#list>
		</ul>
	</div>
</div>

<div class="navhelper clear">
	<div class="main clearfix">
		<div class="breadcrums"><strong>You are here</strong> </div>
	</div>
</div>
</#macro>

<#macro foot links groupLinks>
<div class="footer clear">
	<div class="main clearfix">
		<div class="footnav">
			<ul>
				<li class="user-reset"><a href="#" title="Reset user setting">Reset user setting</a></li>
				<li class="top"><a href="#" title="Back to Top">回到页顶</a></li>
			</ul>
		</div>
		<@self.bottomSelf/>
	</div>
</div>
</#macro>

<#macro footScript jsName>
</#macro>