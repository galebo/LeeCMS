<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<title></title>
<meta name="description" content="" />
<meta property="wb:webmaster" content="" />
<meta name="keywords" content="" />

<link href="${commCssBase}/css/base.css" rel="stylesheet" type="text/css"/>
<link href="${commCssBase}/css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body ID="bodys">
<div style="" class="topimg">
	<img src="${uploadDir}/topmeeting.jpg">
	<div class="shutdownMeeting">
		<a onclick="shutDownMeetButton()" href="javascript:">
		<img title="关闭" alt="关闭" src="${commCssBase}/images/shundownButton.png">
		</a>
	</div>
</div>
<!-- 十八大图片END -->
<div class="header">
  <div  class="logo"><a href=""><img src="${commCssBase}/images/haier_logo.png" width="160" height="47" /></a></div>
  <div class="text_nav_p12 header_sub_nav" style="right:227px;">
    <ul>
      <li id="li_user"></li>
      <li style="padding-left: 13px;"><a href="">我的信息</a></li>
      <li style="padding-left: 13px;"><a href="">新闻中心</a></li>
      <li style="padding-left: 13px;"><a href="">联系地址</a></li>
    </ul>
  </div>
  <div class="header_search" style="right:0px;" >
      <div class="il_box js_il_box search_keywords">
        <input type="text" id="header_search_kw" name="searchword" class="js_autocomplete_header_search_kw" />
        <label for="header_search_kw">键入查询信息</label>
      </div>
      <a href='javascript:quanWenSearch();' class="abtn_grey btn_submit js_form_submit"><span>搜索</span></a>
  </div>
</div>
<!-- END 头部结束 --> 
<@nav/>
<!-- END header -->
<div id="main" class="body_shadow">
  <div class="bs_bd"><div class="bs_rpt_bg"><div class="bs_top_bg">
	<div id="main_content" class="bs_content">
		<input type="hidden" onclick="quanWenSearch()" value="click" />
        <@center/>
		<@foot/>
    </div>
  </div></div></div>
<div class="bs_footer"></div>
</div>
</body>

</html>

<#macro nav>
<!-- START 顶部主导航开始 -->
<div class="top_main_nav" style="top: 134px;">
  <div class="tmn_bg">
    <div class="tmn_box">
      <ul class="ul_lv1">
			<#list 1..4 as one1>
			    <li id="栏目1${one1_index+1}" class="li_lv1 submenu trail hover expend">
				      <ul class="ul_lv2" style="width: 704px; left: -218px;">
						<#list 1..4 as one2>
							<li id="栏目2${one2_index+1}" class="li_lv2 submenu tmn_li_lv2_cp_fridge">
							  <div class="panel_lv3" style="display: none;"><div class="panel_l_lv3"><div class="panel_r_lv3"><div class="panel_c_lv3">
									<div class="list_lv3">
									  <div class="window_lv3">
										  <ul class="ul_lv3">
										  	<#list 1..14 as one3>
												<li class="li_lv3" style="_height:18px;"><a class="tit_lv3 js_ajax" href="">栏目3${one3_index}</a></li>
											</#list>   
								      	   </ul>
							      	   </div>
									</div>
									<a href="javascript:;" class="btn_up_lv4"></a> 
									<a href="javascript:;" class="btn_down_lv4"></a>
									<div class="content_lv5"> </div>
					      	 </div></div></div></div>            
							<a href="" class="tit_lv2">
								<span>
								<i onmouseout="this.style.color = '#505050';" onmouseover="this.style.color = &quot;#000000&quot;;" class="daohang2" style="color: rgb(80, 80, 80);">栏目2${one2_index+1}</i>
								</span>
							</a>
							</li>
						</#list>
				      </ul>
			      	<a href="" class="tit_lv1"><span><i class="daohang">栏目1</i></span></a>
				</li>
			</#list>
	      </ul>
    </div>
  </div>
</div>
<!-- END 顶部主导航结束 -->
</#macro>
<#macro center>
<div class="main_content"> 
    <!-- START hp-main-vision -->
    <div class="hp-main-vision js-hp-main-vision"> 
      <!-- START kv_box -->
      <div class="kv_box js_kv_box">
             <a target="_blank" href="">
             <div class="kv_item_bg_01"  style="cursor:hand; background-image:url(http://image.haier.com/cn/wzsy/banner/201211/P020121101687885841719.jpg)">&nbsp;</div>
             </a>
      </div>
      <!-- END kv_box --> 
      <!-- START nav -->
      <div class="nav">
        <ul class="nav_list js_nav_list">
          <li class="active"><a class="item_01" href="javascript:;" rel=".kv_item_01">1</a></li>
          <li><a class="item_02" href="javascript:;">2</a></li>
          <li><a class="item_03" href="javascript:;">3</a></li>
          <li><a class="item_04" href="javascript:;">4</a></li>
		  <li><a class="item_05" href="javascript:;">5</a></li>
		  <li><a class="item_06" href="javascript:;">6</a></li>
        </ul>
      </div>
      <!-- END nav --> 
      <!-- START arrow_nav -->
      <div class="kv_arrow_nav_prev js_kv_arrow_nav_prev"> <a href="javascript:;">PREV</a> </div>
      <div class="kv_arrow_nav_next js_kv_arrow_nav_next"> <a href="javascript:;">NEXT</a> </div>
      <!-- END arrow_nav --> 
    </div>
    <!-- END hp-main-vision -->
    <div class="hp-bt-flyout-nav">
      <div class="btn1"><a href="javascript:;">推荐1</a></div>
      <div class="btn2"><a href="javascript:;">推荐2</a></div>
      <div class="btn3"><a href="javascript:;">推荐3</a></div>
      <div class="btn4"><a href="javascript:;">推荐4</a></div>
      <div class="clf"></div>
    </div>
  </div>
  <!-- END main content --> 
</#macro>

<#macro foot>
<!-- START footer --> 
  <div class="footer" style="padding-top:0px">
	  <div class="hr_divider1" style="border-top:#0 2px solid">
	    <div class="text_nav_p12 footer_left">
	      <ul>
	        <li class="first"><a href="">关于我们</a></li>
	        <li><a href="">新闻中心</a></li>
	        <li><a href="">联系我们</a></li>
	        <li><a href="">法律声明</a></li>
	      </ul>
	    </div>
	    <div class="text_nav_p12 footer_right">
	      <ul>
	        <li><a href="">京ICP备09096283</a></li>
	        <li class="last">Copyright ©2012 某某集团 版权所有</li>
	      </ul>
	    </div>
	  </div>
  </div>
</#macro>