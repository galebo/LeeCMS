
<#import "${ftlPath}/common/frame.ftl" as frame/>

<#macro main bean>
<@frame.html title="安博律师事务所新官方网站"/>

<div id="orz">
	<@frame.head/>
	<div id="orz_main">
		<@indexSearch/>
	</div>
	<@frame.foot/>
	<div class="clear"></div>
</div>
</body>
</html>
</#macro>

<#macro indexSearch>
<div id="orz_left">
	<div id="orz_left_1">按职位查找</div>
	<div id="orz_left_2">
		<ul>
		<#list data.key1 as one>
		<li><a id="key1${one.label}" href="javascript:void(0);" onclick="showKey1('${one.label}')" ">${one.value}</a></li>
		</#list>
		</ul>
	</div>
		<@frame.marquee/>
</div>
<div id="orz_right">
	<@frame.nav name="专业团队"/>
	<div id="orz_right_2">
		<div>
		    <div class="indexSearchTitle">
		        <div >
					<#list data.key2 as one>
					  <div class="zimu" ><a href="javascript:void(0);" onclick="showKey2('${one.label}');" ><span id="key2${one.label}" style="color:#ffffff;">${one.value}</span></a></div>
					</#list>
		  		</div>
	  		</div>
			<div id="orz_right">
				<#list data.sons?keys as key11>
				<div id="${key11}" style="display:none;">
					<#list data.sons[key11] as one1>
						<div style="width:170px; text-align:left">
						<a href="${one1.url}" title="${one1.name}">${one1.name}</a>
						</div>
					</#list>
				</div>
				</#list>
			</div>
		</div>
	</div>
</div>
<script>

showKey1("ALL");
showKey2("ALL");
</script>
</#macro>

<@main bean=data/>
