<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>

<head>
	<title></title>
</head>

<!-- jqGreed start-->
<div class="divTree">
	<table id="parentTable"></table>
	<div id="parentDiv"></div>
</div>
<div>
	<input type="button" value="增加栏目" onclick="business.showSon1()"></input>
	<input type="button" value="增加内容链接" onclick="business.showSon2()"></input>
	<input type="button" value="增加链接" onclick="business.showSon3()"></input>
</div>
<div class="divTree" id="son1">
	<input type="button" value="增加" onclick="business.addItems();"></input>
	<table id="son1Table"></table>
	<div id="son1Div"></div>
</div>
<div class="divTree" id="son2">
	<div class="divTree" id="columnParent">
		<table id="columnParentTable"></table>
		<div id="columnParentDiv"></div>
	</div>
	<div class="divTree" id="columnSon">
		<table id="columnSonTable"></table>
		<div id="columnSonDiv"></div>
	</div>
</div>

<div class="divTree" id="son3">
	<input type="button" value="增加" onclick="business.addLinks();"></input>
	<table id="son3Table"></table>
	<div id="son3Div"></div>
</div>
<script type="text/javascript" src="/p/js/business/common.js"></script>
<script type="text/javascript" src="/p/js/business/indexItem.js"></script>
</@common.body>
</#macro>

<@main/>
