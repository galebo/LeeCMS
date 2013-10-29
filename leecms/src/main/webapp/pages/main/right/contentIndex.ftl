<#import "/main/right/common.ftl" as common/>
<#macro main>
<@common.body>
<div>
	<select id="Sex" onchange="business.resetSonTable();">  
	<option value="1"   >已设置</option> 
	<option value="2" selected="selected"  >未设置</option> 
	</select>
</div>
	<div class="divTree">
		<table id="sonTable"></table>
		<div id="sonDiv"></div>
	</div>
<script type="text/javascript" src="/p/js/business/common.js"></script>
<script type="text/javascript" src="/p/js/business/contentIndex.js"></script>
</@common.body>
</#macro>

<@main/>
