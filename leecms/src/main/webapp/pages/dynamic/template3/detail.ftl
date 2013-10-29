<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/area.ftl" as area/>
<#import "${ftlPath}/common/frame.ftl" as frame/>
<#macro detail bean>
<div id="detail">
	<div> <a href="${common.homePage.url}">${common.homePage.name}</a>&gt;&gt;<a href="${bean.item.url}">${bean.item.name}</a>&gt;&gt;文章正文</div>
	<div class="articleTop">
		<div class="t1">${bean.content.name}</div>
	    <div> 阅读选项: <input type="checkbox" name="auto" value="on" onclick="Action('scroller();')">自动滚屏[左键停止] </div>
	    <div class="t2">作者:${bean.content.author} &nbsp;来源:原创&nbsp;阅读:<@g.upCount contentId=bean.content.contentId/></div>
    </div>
    
    <div class="article">
	   ${bean.content.html}
    </div>
  
	<div class="articleBottom">
	【<a onclick="javascript:window.print()" href="#"><font color="cc0000">打印本文</font></a>】
	【<a href="javascript:window.close()"><font color="#cc0000">关闭窗口</font></a>】
	</div>
</div>
</#macro>

<@frame.exe bean=data jsName="detail">
		<div class="divWidth700">
			<@detail bean=data/>
   		 </div>
    
		<div class="divWidth200">
			<@area.login/>
		 	<@area.ask/>
			<@area.leftArea />
	    </div>
</@frame.exe>