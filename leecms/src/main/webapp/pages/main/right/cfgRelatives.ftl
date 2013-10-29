<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>
	<div id="colTip" class="jqTitle">组名称:<span id="currentCol"></span></div>
	<div>
	<input type="button" value="增加链接组" onclick="addGroup('3AA')"></input>
	<input type="button" value="增加轮播组" onclick="addGroup('3AB')"></input>
	</div>
	<!-- jqGreed start-->
	<div class="divTree" id="parent">
		<table id="parentTable"></table>
		<div id="parentDiv"></div>
	</div>
	<div class="divTree" id="son">
		<table id="sonTable"></table>
		<div id="sonDiv"></div>
	</div>
	<div class="divTree" id="select">
		<input type="button" value="增加" onclick="business.addToGroup();"></input>
		<table id="selectTable"></table>
		<div id="selectDiv"></div>
	</div>
	<script type="text/javascript" src="/p/js/business/common.js"></script>
	<script type="text/javascript" src="/p/js/business/cfgRelative.js"></script>
	<!-- jqGreed end-->
</@common.body>
</#macro>

<@main/>