<#import "${ftlBasePath}/common.ftl" as g/>
<#macro html title>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>${title}</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="robots" content="index, follow" />
	<meta name="keywords" content="${common.siteDefine['keyword']}" />
	<meta name="description" content="${common.siteDefine['description']}" />
	<link href="${common.siteDefine['icon']}" rel="shortcut icon">
	<link rel="stylesheet" type="text/css" href="${commCssBase}/css/styles.css" rel="stylesheet"/>
	<script type="text/javascript" src="${commBase}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${commBase}/js/common.js"></script>
	<script type="text/javascript" src="${commBase}/js/business.js"></script>
	</head>
	<body>
</#macro>

<#macro head>
	<div id="orz_head">
		<div class="logotop">
			<div id="orz_head_1">
		<#if common.parentSonStyle>
		<img src="${common.sonCommon.siteDefine['logo']}"/>
		<#else>
		<img src="${common.siteDefine['logo']}"/>
		</#if>
			</div>
			<div id="orz_head_2"><@fenxiang/></div>
		</div>
		<div id="orz_head_3">
			 <a href="${common.homePage.url}" >${common.homePage.name}</a>
		    <#list common.menuList as one>
			 <a href="${one.url}" >${one.name}</a>
			 <#if one_index=7><#break></#if>
			</#list>
		</div>
		<div id="orz_head_4">
		<@loop bean=common.groupLoops['loop3']/>
		</div>
	</div>
</#macro>
<#macro fenxiang>
<div><!-- Baidu Button BEGIN -->
		<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare">
			<a class="bds_qzone"></a>
			<a class="bds_tsina"></a>
			<a class="bds_tqq"></a>
			<a class="bds_renren"></a>
			<a class="bds_t163"></a>
			<span class="bds_more">更多</span>
			<a class="shareCount"></a>
		</div>
		<script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=0" ></script>
		<script type="text/javascript" id="bdshell_js"></script>
		<script type="text/javascript">
		document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
		</script>
		<!-- Baidu Button END -->

		<div>
			<object type="application/x-shockwave-flash" data="http://www.51119.com/Dewplayer/dewplayer.swf" width="200" height="20" id="dewplayer" name="dewplayer">
			<param name="wmode" value="transparent" />
			<param name="movie" value="http://www.51119.com/Dewplayer/dewplayer.swf" />
			<param name="flashvars" value="mp3=http://www.51119.com/Dewplayer/mp3/test.mp3" />
			</object>
		</div>
</div>
</#macro>
		
<#macro loop bean>
	<@g.lunBo pictures=bean  name="lunbo" divCss="focus_d1" imgDivCss="focus_d2" imgCss="scrollbox_img" titleCss="img_bottom" numCss="button_list"/>
</#macro>

<#macro foot>
<div id="orz_foot">
	<div style="width:100%;">
		<span class="link2"><#list common.groupLinks['link2'].sons as one>
			<a href="${one.url}" title="${one.name}" target="_blank">${one.name}</a>
		</#list></span>
	<span style="float:right;">全国免费咨询电话：400-070-9070  安博律师事务所  版权所有</span>
	</div>
	<div style="width:100%;">
		<#list common.groupLinks['link1'].sons as one>
			<a href="${one.url}" title="${one.name}" target="_blank">${one.name}</a>
		</#list>
	<span style="float:right;">Copyright 2012 Ember law firm All Rights Reserved. 京ICP备12046393号-2</span>
	</div>
</div>
</#macro>


<#macro nav name url="" css="orz_right_1">
	<div id="${css}">
		<span class="titleImg">${name}</span>
	    <span class="title_more">您现在的位置：<a href="${common.homePage.url}">${common.homePage.name}</a> -&gt; ${name}</span>
	</div>
</#macro>


<#macro items_nav name url="">
	<div id="orz_right_1">
		<span class="titleImg">${name}</span>
	    <span class="title_more"><a href="${url}">更多&gt;&gt;</a></span>
	</div>
</#macro>

<#macro title name url="">
	<div id="orz_main_1_1">
		<span class="titleImg2">${name}</span>
	    <span class="title_more"><a href="${url}">更多&gt;&gt;</a></span>
	</div> 
</#macro>




<#macro marquee>
<div id="orz_left_1">尊重律师</div>
<div id="orz_left_2">
<div id="demoa" style="overflow:hidden;height:120px;width:201px">
<div id="demoa1">

<div style="width:201px;">张玉枢律师</div>

<div style="width:201px;">王守亮律师</div>

<div style="width:201px;">魏少勇律师</div>

<div style="width:201px;">李立新律师</div>

<div style="width:201px;">李斌律师</div>

<div style="width:201px;">周春茹律师</div>

<div style="width:201px;">王占新律师</div>

<div style="width:201px;">李升泉律师</div>

</div>
<div id="demoa2">

<div style="width:201px;">张玉枢律师</div>

<div style="width:201px;">王守亮律师</div>

<div style="width:201px;">魏少勇律师</div>

<div style="width:201px;">李立新律师</div>

<div style="width:201px;">李斌律师</div>

<div style="width:201px;">周春茹律师</div>

<div style="width:201px;">王占新律师</div>

<div style="width:201px;">李升泉律师</div>

</div>
</div>
   <script>
   var speed=50
   demoa2.innerHTML=demoa1.innerHTML
   function Marquee(){
   if(demoa2.offsetTop-demoa.scrollTop<=0)
   demoa.scrollTop-=demoa1.offsetHeight
   else{
   demoa.scrollTop++
   }
   }
   var MyMar=setInterval(Marquee,speed)
   demoa.onmouseover=function() {clearInterval(MyMar)}
   demoa.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
   </script>
</div>

<div id="orz_left_1">满意客户</div>
<div id="orz_left_2">
<div id="demo" style="overflow:hidden;height:120px;width:201px">
<div id="demo1">

<div style="width:201px;">北京市硬铁文化传播有限公司</div>

<div style="width:201px;">北京市世纪华辰国际管理顾问有限公司</div>

<div style="width:201px;">鼎城科技公司</div>

<div style="width:201px;">大信正道国际贸易公司</div>

<div style="width:201px;">大律师网</div>

</div>
<div id="demo2">

<div style="width:201px;">北京市硬铁文化传播有限公司</div>

<div style="width:201px;">北京市世纪华辰国际管理顾问有限公司</div>

<div style="width:201px;">鼎城科技公司</div>

<div style="width:201px;">大信正道国际贸易公司</div>

<div style="width:201px;">大律师网</div>

</div>
</div>
   <script>
   var speed=50
   demo2.innerHTML=demo1.innerHTML
   function Marquee(){
   if(demo2.offsetTop-demo.scrollTop<=0)
   demo.scrollTop-=demo1.offsetHeight
   else{
   demo.scrollTop++
   }
   }
   var MyMar=setInterval(Marquee,speed)
   demo.onmouseover=function() {clearInterval(MyMar)}
   demo.onmouseout=function() {MyMar=setInterval(Marquee,speed)}
   </script>
</div>
</#macro>