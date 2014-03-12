<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>
<!-- jqGreed start-->
<div class="divTree">
	<table id="parentTable"></table>
	<div id="parentDiv"></div>
</div>

<script type="text/javascript" src="/p/js/common/common.js"></script>
<script>
var name="栏目";
var name_en="Column";
var name_big="colColumn";
var name_en_l="column";
var name_code="3AC";
</script>
<script type="text/javascript" src="/p/js/business/category.js"></script>

</@common.body>
</#macro>

<@main/>