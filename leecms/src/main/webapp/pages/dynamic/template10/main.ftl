<#macro search>

			<div id="neirong_left2">
				<div id="neirong_leftl2">
					<div id="neirong_left2_2">
						<div id="neirong_left2_2_1">
							<form name="formsearch" method="post" action="/art/Tags.asp"
								onsubmit="return zCheckSearch(this);">
								<input id="neirong_left2_2_2" type="text" name="key" /> <input
									type="submit" value="" id="neirong_left2_2_3" />
							</form>
						</div>
					</div>
				</div>
			</div>
</#macro>

<#macro person>
<div id="lawerxx">
		<div id="lawerxx_box">
			<div id="lawerxx_2">
				<div id="lawerxx_1_1">
					<div id="lawerxx_1">
						<p>
							<a href="Contact.asp"> <img
								src="http://images.xslsbj.com//UploadPic/lawface/315/4834b2707050ca8b.jpg"
								border="0" alt="李永建律师" height="145px" width="125px" />
							</a>
						</p>
					</div>
					<div id="lawerxx_3">
						<span class="lawerxx_33"><a href="BeijingLawyer.asp">李永建律师</a></span></br>
						<font>北京市东卫律师事务所</font> <br />手机: 13901078504<br />电话: 13901078504 <br />
						<div style="height: 25px; width: 35px; line-height: 20px; float: left;">QQ:</div><a target="_blank"
							href="http://wpa.qq.com/msgrd?v=3&uin=844397512&site=qq&menu=yes">844397512</a>
						<div>
							<a href="/GuestBook/#end"><img src="http://www.xslsbj.com/style/images/anniu.jpg" border="0" /></a>
						</div>
					</div>

					<div id="lawerxx_4">
						<span>专长领域：</span><font id='lawerxx_4_1'>刑事辩护、债务追讨、交通事故<BR>合同纠纷、人身损害、婚姻家庭<BR>遗产继承、房产纠纷、公司犯罪<BR>常年顾问</font><span>律师执业证：</span><font>111111</font><br>
							<span>联系地址：</span><font>北京市朝阳门北大街8号富华大厦D座3B室</font><br />
						<span>邮箱: </span><font><a href="mailto:liyongjianlawyer@163.com" target="_blank">liyongjianlawyer@163.com</a></font></br>
						<span>所在地区：</span> <font> <b>北京</b>-<b>北京</b>
						</font></br>
					</div>

				</div>
				<div id="lawerxx_2_1">
					<img src="style/images/fenge_1.gif" width="2" height="328" />
				</div>
			</div>
			<div id="lawermore">
				<div id="lawermore_top">
					<div class="lawermoretop">
						&nbsp;&nbsp;&nbsp;&nbsp; 个人简介:
						法学.金融双学历,中国政法大学研究生.央视CCTV-12《法律讲堂》主讲人.北京电视台《非常看法》嘉宾律师，北京市律师协会专业委员会委员，2011年1月被评为“北京市百名优秀刑辩律师”.
						从业近二十年来.代理了大量的各类纠纷案件.为当事人挽回经济损失上亿元.在民商方面尤为擅长合同纠纷.婚姻继承.债权债务.股权纠纷.侵权赔偿.几百起该方面案件的成功代理.积累了丰富的办案经验和技巧.
						在刑事方面.成功办理多起在全国范围内有重大影响的刑事案件.类型包括贪污受贿、渎职、涉......<a
							href="/BeijingLawyer.asp">[更多介绍]</a>
					</div>
					<div id="lawermore_top2"></div>
					<br />
				</div>

				<div id="lawermore_down">
					<div id="lawermore_down1">
						<a href="${defaultItem.url}">${defaultItem.name}</a>
					</div>
					<div id="lawermore_down2_1">
						<ul id="lawermore_down2">
						<#list defaultItem.contents as one>
							<li><a href='${one.url}' target='_blank'>${one.name}</a></li>
						</#list>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</#macro>

<#macro adv1>
<div id='neirong_allogo'>
				<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000'
					codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0'
					width='680' height='90'>
					<param name='movie'
						value='http://images.xslsbj.com/uploadpic/common/banner/tabanner2.swf'>
						<param name='wmode' value='opaque'>
							<param name='quality' value='high'>
								<embed style='width:680px; height:90px;'
									pluginspage='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'
									src='http://images.xslsbj.com/uploadpic/common/banner/tabanner2.swf'
									wmode='transparent' width='680' height='90'
									type='application/x-shockwave-flash' quality='high'
									menu='false'></embed>
				</object>
			</div>
</#macro>

<#macro div2 css>

<div class='neirong_anli${css}'>
				<div class='neirong_anli_1'>
					<h1>${defaultItem.name}</h1>
					<span><a href='/art/List.asp?classid=736527670436'>more</a></span>
				</div>
				<div class='neirong_anli_1_2'>
					<div class='neirong_anli_11'>
						<div class='neirong_anli_1_21'>
							<ul class='neirong_anliul'>
								<#list defaultItem.contents as one>
								<li><a href=''${one.url}' target='_blank' title='${one.name}'>'${one.name}</a></li>
								</#list>
							</ul>
						</div>
					</div>
				</div>
			</div>
</#macro>
<#macro div1 >
	<@div2 css=''/>
	<@div2 css='2' />
</#macro>

<#macro logo1>
	<div id="logo">
		<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000'
			codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0'
			width='1000' height='180'>
			<param name='movie' value='http://www.xslsbj.com//uploadpic/common/banner/TABanner.swf'>
				<param name='wmode' value='opaque'>
					<param name='quality' value='high'>
						<embed
							pluginspage='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'
							src='http://www.xslsbj.com//uploadpic/common/banner/TABanner.swf' wmode='transparent'
							width='1000' height='180' type='application/x-shockwave-flash'
							quality='high' menu='false'></embed>
		</object>
	</div>
</#macro>


<#macro main>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>北京刑事律师-北京刑事案件律师-北京刑事辩护律师网-李永建律师</title>
	<meta name="description"
		content="北京刑事律师李永建(电话:13901078504)中国政法大学研究生.央视CCTV-12《法律讲堂》主讲人.北京电视台《非常看法》嘉宾律师,著名北京刑事律师，尤为擅长办理死刑辩护.无罪辩护等重大.疑难刑事案件。">
		<meta name="keywords" content="北京刑事律师,北京刑事案件律师,北京刑事辩护律师网-李永建律师">
			<link href="http://www.xslsbj.com/style/personal.css"
				rel="stylesheet" type="text/css" />
</head>
<script language="javascript" src="/js/checkForm.js"></script>
<body>
	<!--[if IE 6]>
<script type="text/javascript" src="/js/DD_belatedPNG.js" ></script>
<script type="text/javascript">DD_belatedPNG.fix('img,background');</script>
<![endif]-->

	<div id="topwidth">
		<a href='http://www.xslsbj.com/'><img
			src='http://images.xslsbj.com/uploadpic/logo/767889691182.png'
			border='0' title='北京刑事律师'></a>

	</div>

	<div id="menu1">
		<ul class="menul1">
  <#list menuList as one>
    <li><a href="${one.url}" title="${one.name}">${one.name}</a></li>
	</#list>
		</ul>
	</div>

	<@logo1/>
	
	<@person/>
	
	<div id="neirong">
		<div id="neirong_left">
			<div id="neirong_left1">
				<a href="/AnYuan.asp"><img src="http://www.xslsbj.com/style/images/tup_1.gif" /></a>
			</div>
			<div id="neirong_left1">
				<a href="/GuestBook/#end"><img src="http://www.xslsbj.com/style/images/tup_2.gif" /></a>
			</div>
			<@search/>
			
			<div id="neirong_bm">
				<div id="neirong_bml">
					<h3 class="neirong_bm1">便民法律网址导航</h3>
					<div id="neirong_bm2">
					<#list 1..7 as one>
						<div id="neirong_bm2_1">
							<div id="neirong_bm2_2"> <span>律师行业协会</span> <img src="http://www.xslsbj.com/style/images/tub_4.gif" /></div>
							<div id="neirong_bm2_3">
							<#list 1..3 as one1>
									<span><a href='' target='_blank' rel="nofollow">行业协会</a></span> 
							</#list>
							</div>
						</div>
					</#list>
					</div>
				</div>
			</div>
		</div>
		<div class="neirong_right">
			
			<@div1/>
				
			<@adv1/>
			
			<@div1/>
			<@div1/>

		</div>
	</div>
	<div id="hezuo_add">
		<div id="hezuo_add_top"></div>
		<div id="hezuo_add_nr">
			<div id="hezuo_add_nr1">
				<h1>合作网站</h1>
			</div>
			<div id="hezuo_add_nr2">
			<#list 1..30 as one>
			<span><a href='' target='_blank'>信阳刑事律师</a></span>&nbsp;
			</#list>
			</div>
		</div>
	</div>

	<div id="foot1">
		<div id="foot1_1">
			<#list 1..10 as one>
			<a href="/"> 相册影集</a><span>|</span> 
		</#list>
			<a href="/map.xml" target="_blank">网站地图</a>
		</div>
	</div>
	<div id="foot2">
		<div id="foot2_1">
			All Right Reserved <span><a href="http://www.miibeian.gov.cn/"
				target="_blank">闽ICP备08005907号</a></span> <font id="foot2_2"><a
				href="http://www.xslsbj.com/"><b>北京刑事律师</b></a></font> <a href="/LawAdmin/">网站管理</a></br>
			Copyright @2008-2014 <span style="color: #000000">版权所有 法律咨询热线：</span>13901078504
			&nbsp;技术支持： <a href="http://www.maxlaw.cn" target="_blank"
				class="linkGray">中国大律师网</a>
		</div>
	</div>

</body>
</html>
</#macro>

<@main/>