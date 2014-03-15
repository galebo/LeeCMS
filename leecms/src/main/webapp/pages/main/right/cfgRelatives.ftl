<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>
	<div id="colTip" class="jqTitle">组名称:<span id="currentCol"></span></div>
	<div><input type="button" id="add" value="增加链接组" onclick="business.addGroup()"></input></div>
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
	<script type="text/javascript" src="/p/js/common/common.js"></script>
	<script type="text/javascript" src="/p/js/business/cfgRelative.js"></script>
	<script type="text/javascript" >
		business.init('${type}');
	</script>
</@common.body>
</#macro>

<@main/>