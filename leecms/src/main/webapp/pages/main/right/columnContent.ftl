<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>
	<div id="colTip" class="jqTitle">栏目:<span id="currentCol"></span></div>
	<!-- jqGreed start-->
	<div class="divTree">
		<table id="parentTable"></table>
		<div id="parentDiv"></div>
	</div>
	<div class="divTree" id="son">
		<table id="sonTable"></table>
		<div id="sonDiv"></div>
	</div>
	<div class="divTree" id="son1">
		<input type="button" value="增加" onclick="business.addToParent();"></input>
		<table id="son1Table"></table>
		<div id="son1Div"></div>
	</div>
<script type="text/javascript" src="/p/js/common/common.js"></script>
<script>
	var parent_name="栏目";
	var son_name="文章"
	var son_name_big_l="conContent";
	var type='3AC';
	var parentSon='ColColumnContent';
</script>
<script type="text/javascript" src="/p/js/business/columnContent.js"></script>
</@common.body>
</#macro>

<@main/>
