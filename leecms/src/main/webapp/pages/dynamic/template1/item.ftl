<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#import "${ftlPath}/common/self.ftl" as self/>

<#macro main bean>
	<div class="detail container clear">
		<div class="main clearfix">
			<div class="column" style="width:59.8%">
				<@left bean=bean/>
			</div>
			<div class="column box-right" style="width:40%">
				<@area.fav bean=bean.item1/>
			</div>
		</div>
	</div>
</#macro>

<#macro left bean>
	<div class="inner1 clearfix">
		<h1 class="componentheading">${bean.name}</h1>
		<div class="contentdescription"></div>
		<table class="tablelist">
			<tr>
				<th class="sectiontableheader" id="count">#</th>
				<th class="sectiontableheader" id="tableOrdering">文章标题</th>
				<th align="center" class="sectiontableheader" width="5%" nowrap="nowrap" id="hits">点击数</th>
			</tr>
			<#list bean.contents as one>
			<tr class="sectiontableentry${one_index%2}">
				<td headers="count">${one_index+1}</td>
				<td headers="tableOrdering"><a href="${one.url}">${one.name}</a></td>
				<td headers="hits" id="${bean.id}${one.contentId}"></td>
			</tr>
			</#list>
			<@g.getCounts bean=bean/>
		</table>
	</div>
<!-- //CONTENT -->
</#macro>


<@frame.exe bean=common>
	<@main bean=data/>
</@frame.exe>
