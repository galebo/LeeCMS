<#import "${ftlBasePath}/common.ftl" as g/>
<#macro box title>
<div class="box${common.defines.g_boxCssId}">
    <div class="box${common.defines.g_boxCssId}_top"" >${title}</div>
    <div class="box${common.defines.g_boxCssId}_middle">
      	<#nested>
    </div>
    <div class="box${common.defines.g_boxCssId}_bottom" ></div>
</div>
</#macro>



<#macro search>
<div class="div_search" >
	<span> <img src="${commCssBase}/images/search.gif" height="16" width="16">站内搜索： <input name="key" size="20" class="MyInput" type="text"> 
        <select name="condition"><option value="title" selected="selected">标 题</option><option value="content">内 容</option></select>
		<input name="Submit" value=" 搜 索 " type="submit">
     </span>
</div>
</#macro>

<#macro loop bean>
<div class="loop"id="Team">
	<ul>
	      <#list bean.sons as one>
			<li>
			<a href="${one.url}" target="_blank"><img src="${one.img}"  border="0" height="125"><div class="loopTitle">${one.name}</div></a>
			</li>
		</#list>
	</ul>
	<span id="Team_left"><a ></a></span>
	<span id="Team_right"><a ></a></span>
</div>
</#macro>

<#macro login>
	<@box title=common.siteDefine['siteName']>
	    <center>
	    <a onclick="gotoshow()" style="cursor:hand">
	    <img style="" src="${uploadDir}/banner1.jpg" name="slide" border="0" height="150" width="112">
		</a></center>
	  	<div id="textslide">${common.siteDefine['siteName']}</div>
  	</@box>
	<@box title='会员登录'>
	<form action="ChkLogin.shtml" method="post" name="UserLogin" onsubmit="return CheckForm();">
		<div><span class="left_content">用户名：</span><span class="left_content" ><input name="UserName" id="UserName" size="12" maxlength="20" class="MyInput" type="text"></span></div>
		<div><span class="left_content" >密&nbsp;&nbsp;码：</span><span class="left_content" ><input name="Password" id="Password" size="12" maxlength="20" class="MyInput" type="password"></span></div>
		<div><span class="left_content" >Cookie：</span><span class="left_content"><select name="CookieDate"><option selected="selected" value="0">不保存</option><option value="1">保存一天</option><option value="2">保存一月</option><option value="3">保存一年</option></select></span></div>
		<div><span class="left_content" ><input name="Login" id="Login" value=" 登录 " type="submit"> <input name="Reset" id="Reset" value=" 清除 " type="reset"></span></div>
		<div><span class="left_content" ><a href="" class="left_content_a">新用户注册</a>&nbsp;&nbsp;<a href="" class="left_content_a">忘记密码？</a><br></span></div>
	</form>
  	</@box>
      
</#macro>

<#macro leftArea>
<#list common.divDefines as one>
	<@box title=one.title>
      	${one.text}
  	</@box>
</#list>
</#macro>
<#macro ask>
	<@box title='最新留言'>
	   <ul>
		<#list 1..10 as one>
				<li><span><a href="" target="_blank" title="咨询">咨询</a><img src="${commCssBase}/images/new.gif"></span><span>03/18</span></li> 
		</#list>
		</ul>
		<div>
			<div class="box${common.defines.g_boxCssId}_more"><a href="#" target="_blank" title="点击这里,查看更多留言!"><img src="${commCssBase}/images/more.gif" border="0"></a></div>
			<div class="clear"></div>
		</div>
  	</@box>
</#macro>

<#macro product>
	<@box title='产品列表'>
<div>
<div class="product">
	<ul>
		<#list 1..2 as one>
			<li position="0"><div>产品列表</div>
			<ul>
				<#list 1..3 as one>
				<li position="0"><a href="#">新婚姻法离婚房屋分割</a></li>
				</#list>
			</ul></li>
		</#list>
	</ul>
</div>
</div>
  	</@box>
</#macro>

<#macro recommend item loop>
<div id="tuijian">
	<div class="tuijian_title"><span class="title">${item.name}</span></div>
	<div>
        <div class="tuijian_main" >
	        <@g.lunBo pictures=loop/> 
	           <div class="tuijian_list"><ul>
					<#list item.contents as one>
	                <li class="tuijian_list_li"><a href="${one.url}" target="_blank" title="${one.name}">${one.name}</a></li>
	                <#if one_index=7 ><#break></#if>
	                </#list>
	               </ul>
	     	 </div>
        <div class="clear" ></div>
      </div>
	</div>
</div>
</#macro>
	
	
<#macro list bean>
<div class="div_list">
	<div class="list1_title" >
		<span class="title"><a href="${bean.url}" title="${bean.name}" class="list1_titletxt">${bean.name}</a></span> 
	    <span class="more"><a href="${bean.url}"><img src="${commCssBase}/images/more.gif" border="0"></a> </span>
	</div>   
	<div class="list1_main"><ul>
	  <#list bean.contents as one>
	     <li class="list1_main_li"><a href="${one.url}" target="_blank" title="${one.name}" class="">${one.name}</a>&nbsp;<img src="${commCssBase}/images/new.gif"></li>
		    <#if one_index=7 ><#break></#if>
		</#list>
		</ul>
	</div>
	<div class="clear" ></div>
</div>
</#macro>

<#macro big1 bean1 bean2>
	<div >
		<div class="listLeft">
	          <@list bean=bean1/>
		</div>
		<div class="listRight">
	          <@list bean=bean2/>
		</div>
	</div>
	<div class="clear"></div>
</#macro>
<#macro big bean>
	<@big1 bean1=bean.item1 bean2=bean.item2/>
	<@big1 bean1=bean.item3 bean2=bean.item4/>
	<@big1 bean1=bean.item6 bean2=bean.item5/>
	<@big1 bean1=bean.item7 bean2=bean.item8/>
</#macro>











<#macro left1>
	<@box title='轮换图片'>
          <center><a style="cursor:hand" onclick="gotoshow()">
          <img width="112" height="150" border="0" name="slide" src="${uploadDir}/91.jpg" style="">
          <div id="textslide">${common.siteDefine['siteName']}</div></a><center>
  	</@box>
</#macro>

<#macro left2>
	<@box title='站内搜索'>
		<form action="search.shtml" method="post">
		<div><input type="text" class="MyInput" size="21" name="key"> </div>
		<div>
	        <select name="condition">
	          <option selected value="title">标 题</option>
	          <option value="content">内 容</option>
	        </select><input type="submit" value=" 搜 索 " name="Submit">
	    </div>
		</form>
  	</@box>
</#macro>

<#macro left3 item>
	<@box title=item.name>
		<ul >
		<#list item.contents as one>
			<li><a class="left_content_a" target="_blank" href="${one.url}">${one.name}</a></li> 
			    <#if one_index=5 ><#break></#if>
		</#list>
		</ul>
  	</@box>
</#macro>


<#macro left4 item>
<div id="left4">
	<div class="box1_top">${item.name}</div>
	<div class="box1_middle" >
		<ul class="ulNoDot">
		<#list item.contents as one>
		<li ><div><a class="left_content_a" target="_self" href="${one.url}">${one.name}</a></div></li>
			    <#if one_index=5 ><#break></#if>
		</#list>
		</ul>
	</div>
	<div class="box1_bottom" ></div>
</div>
</#macro>
<#macro currentPosition bean>
	<div class="currentPosition">您的位置:<a href="${common.homePage.url}">${common.homePage.name}</a> &gt;&gt; <a href="${bean.url}">${bean.name}</a></div>
</#macro>
<#macro right1 item pageSize=5 varName="page">
<div class="contentList">
	<div class="contentList_title">${item.name}</div>
	<div >
     <ul >
		<#list item.contents as one>
			<li><span><a class="left_content_a" target="_blank" href="${one.url}" id="${varName}${one_index}">${one.name}</a></span></li> 
			    <#if one_index=pageSize-1 ><#break></#if>
		</#list>
		</ul>
	</div>
</div>
</#macro>