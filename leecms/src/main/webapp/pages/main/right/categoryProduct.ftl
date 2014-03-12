<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>
	<div id="colTip" class="jqTitle">栏目:<span id="currentCol"></span></div>
	<!-- jqGreed start-->
	<div class="divTree" id="parent">
		<table id="parentTable"></table>
		<div id="parentDiv"></div>
	</div>
	<div class="divTree" id="son">
		<table id="sonTable"></table>
		<div id="sonDiv"></div>
	</div>
	<script type="text/javascript" src="/p/js/common/common.js"></script>
	<script>
	var parent_name="类别";
	var son_name="产品"
	var son_name_big_l="proProduct";
	var type='3AE';
	var parentSon='PoCategoryProduct';
	</script>
	<script type="text/javascript" src="/p/js/business/columnContent.js"></script>
</@common.body>
</#macro>

<@main/>
