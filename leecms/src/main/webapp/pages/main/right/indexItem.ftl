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
</div>
<div class="divTree" id="son1">
	<input type="button" value="增加" onclick="business.addItems();"></input>
	<table id="son1Table"></table>
	<div id="son1Div"></div>
</div>

<script type="text/javascript" src="/p/js/common/common.js"></script>
<script type="text/javascript" src="/p/js/business/indexItem.js"></script>
</@common.body>
</#macro>

<@main/>
