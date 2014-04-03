<#import "${ftlPath}/common.ftl" as g/>
<#import "${ftlPath}/person.ftl" as p/>


<#macro div2 css item>
<div class='neirong_anli${css}'>
	<div class='neirong_anli_1'>
		<h1>${item.name}</h1>
		<span><a href='${item.url}'>more</a></span>
	</div>
	<div class='neirong_anli_1_2'>
		<div class='neirong_anli_11'>
			<div class='neirong_anli_1_21'>
				<ul class='neirong_anliul'>
					<#list item.contents as one>
					<li><a href='${one.url}' target='_blank' title='${one.name}'>'${one.name}</a></li>
					</#list>
				</ul>
			</div>
		</div>
	</div>
</div>
</#macro>

<#macro div1 item1 item2>
	<@div2 css=''  item=item1/>
	<@div2 css='2' item=item2 />
</#macro>



<#macro main bean>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>${common.siteDefine['title']}</title>
	<meta name="description" content="${common.siteDefine['description']}">
	<meta name="keywords" content="${common.siteDefine['keyword']}">
	<link href="http://www.xslsbj.com/style/personal.css" rel="stylesheet" type="text/css" />
</head>

	<@g.top/>
	<@g.menu/>

	<@g.logo1/>
	
	<@p.person_about/>
	
	<div id="neirong">
		<div id="neirong_left">
			<div id="neirong_left1">
				<a href="/AnYuan.asp"><img src="http://www.xslsbj.com/style/images/tup_1.gif" /></a>
			</div>
			<div id="neirong_left1">
				<a href="/GuestBook/#end"><img src="http://www.xslsbj.com/style/images/tup_2.gif" /></a>
			</div>
			<@g.index_search/>
			
			<@p.index_bianli/>
		</div>
		<div class="neirong_right">
			<@div1 item1=common.indexItemList[1] item2=common.indexItemList[2]/>
			<@g.adv1/>
			<@div1 item1=common.indexItemList[3] item2=common.indexItemList[4]/>
			<@div1 item1=common.indexItemList[5] item2=common.itemIdList[6]/>
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

	<@g.foot/>
</body>
</html>
</#macro>

<@main bean=data/>