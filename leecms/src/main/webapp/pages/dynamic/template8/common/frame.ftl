<#import "${ftlBasePath}/common.ftl" as g/>

<#macro exe1 bean>
<@g.Top/>
<link rel="stylesheet" type="text/css" href="${commTBase}/css/icms${cssNum}.css"/>
</head>
<body>
<div class="header1"></div>
<div class="header2"></div>
<div class="nav"><ul>
				<#list 1..5 as one>
				<li <#if one_index=0>class="noleft"</#if>><div><span>新闻中心</span><span>聚焦</span></div><div><span>新闻中心</span><span>聚焦</span></div></li>
				</#list>
				</ul></div>
<div class="main clear">
			<#nested>
</div>
<div class="foot_end"></div>
</body>
</html>
</#macro>