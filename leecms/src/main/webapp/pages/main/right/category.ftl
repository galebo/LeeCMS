<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>
<!-- jqGreed start-->
<div class="divTree">
	<table id="parentTable"></table>
	<div id="parentDiv"></div>
</div>

<script type="text/javascript" src="/p/js/business/common.js"></script>
<script>
var name="产品分类";
var name_en="Category";
var name_big="proCategory";
var name_en_l="category";
var name_code="3AE";
</script>
<script type="text/javascript" src="/p/js/business/category.js"></script>

</@common.body>
</#macro>

<@main/>