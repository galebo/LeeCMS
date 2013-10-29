<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#macro search bean varName="page">
<div id="contents">
	<div class="tittle_box2">
		<h2>当前所在位置：<strong><a href="">主页</a> &gt; <a href="${bean.url}">${bean.name}</a></strong></h2>
	</div>
	<div id="content_left" class="c_b_left">
		<div id="list">
			<ul class="list_ul2">
			<#list 1..14 as one>
			<li>
				<a target="_blank" href="">北京市《<font color="red">商品房</font>销售明码标价规定</a>
				<p>【实施时间】2011/05/01 【颁发文号】 第一条为规范<font color="red">商品房</font>销售价格行为，建立和维护公开、公平、透明的市场价格秩序，保护消费者和经营者合法权..
				<a target="_blank" href="" class="red">【详细】</a></p>
			</li>
			</#list>
			</ul>
		</div>
		
		<@area.item_page bean=bean varName=varName/>
		
		<div class="c"></div>
	</div>
	
	<@frame.item_right item1=bean.item1 item2=bean.item2/>
</div>

</#macro>

<@frame.exe>
<@search bean=data/>
</@frame.exe>