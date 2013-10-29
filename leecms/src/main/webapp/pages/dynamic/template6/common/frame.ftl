<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/self.ftl" as self/>

<#macro exe1 bean>
<@g.Top/>
<link href="/favicon.ico" rel="shortcut icon"/>
<script type="text/javascript" src="${commTBase}/js/bd.js"></script>
<script type="text/javascript" src="${commBase}/js/common.js"></script>
<script type="text/javascript" src="${commBase}/js/jquery.min.js"></script>
<script type="text/javascript" src="${commBase}/js/business.js"></script>

<link rel="stylesheet" type="text/css" href="${commCssBase}/css/icms.css" rel="stylesheet"/>
</head>
<body>
	<@nav menuList=common.menuList/>
			<#nested>
	<div class="clear"></div>
	<@foot links=common.links groupLinks=common.groupLinks/>
</body>
</html>
</#macro>


<#macro nav menuList>
<@self.topDiv/>

<div class="wrapper">
	<div id="header">
	    <div id="logo"><h1> <a target="_blank" href="${common.homePage.url}"><@self.top/></a> </h1></div>
	    <div class="expand">
			<div class="search">
				<div id="searchbox">
			     <div id="search">
					<form method="get" action="${common.searchPage.url}" id="act">
						<input type="text" tabindex="1" size="10" onfocus="if(this.value=='') this.value='';" onblur="if(this.value=='') this.value='';" value="" class="s_text" id="key"/>
			            <input type="submit" tabindex="2" class="btn1" value=""
			                 onclick="document.getElementById('act').action='${common.searchPage.url}'+document.getElementById('key').value"/>
					</form>
			             </div>
				</div>
			</div>
		</div>
	</div>

   	<#list 1..2 as one1>
	   <div id="navbar">
	    <div id="navbar_right">
	      <div id="menu">
	       <ul id="nav">
	          <li><a target="_blank" href="${common.homePage.url}" class=""><span>网站首页</span></a></li>
				<#list menuList[one1].sonMenus as one>
		          <li class="menu_line"></li><li><a target="_blank" href="${one.url}" class=""><span>${one.name}</span></a></li>
				</#list>
	        </ul>
	      </div>
	    </div>
	  </div>
	</#list>
</div>
</#macro>

<#macro foot links groupLinks>
<div id="footer">
    <@area.noTitleDiv divCss="wrapper">
    <div class="clear" id="footer_c">
		<div id="footer_text">
			<p align="center">
				<span>
					<#list links as one>
					<#if one_index!=0>|</#if> <a target="_blank" href="${one.url}">${one.name}</a> 
					</#list>
				</span>
			</p>
			<@self.siteDesc/>
		</div>
      <div class="clear"></div>
    </div>
    </@area.noTitleDiv>
</div>
</#macro>


<#macro left item1 item2>
  <div class="l_right">
    <@self.aboutDiv2/>
	<@area.listDiv name='top' item=item1/>
	<@area.listDiv name='recommend' item=item2/>
  </div>
</#macro>
