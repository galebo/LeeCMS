
<#macro item_page bean varName>
<div class="list_pages">
   <ul >
	<li class="thisclass">${bean.page.pageNo}</li>
	<li><a href="javascript:" onclick="${varName}.go(1);">首页</a></li>
	<li><a href="javascript:" onclick="${varName}.goPre();">上一页</a></li>
	<li><a href="javascript:" onclick="${varName}.goNext();">下一页</a></li>
	<li><a href="javascript:" onclick="${varName}.goEnd();">末页</a></li>
	<li>
		<select name="sldd" style="width:36px" onchange="${varName}.go(this.options[this.selectedIndex].value);">
		<option value="1" selected="">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		</select>
	</li>
	<li><span class="pageinfo">共 <strong>${bean.page.totalPage}</strong>页<strong>${bean.page.total}</strong>条</span></li>
   </ul>
        <script>var ${varName}=new Page("${varName}",${bean.pageJson},${bean.contentsJson});</script>
</div>
</#macro>