<#import "${ftlBasePath}/common.ftl" as g/>
<#import "${ftlPath}/common/self.ftl" as self/>
<#macro titleDivTitle title id="" url="" more="" preText="" key=[]>
    <div class="titlel1"><div class="titler1"><div class="title">
        <span class="title_t left"><span class="title_t_i left"><span class="center">${preText}
	        <#if url!="">
	        	<a target="_blank" href="${url}"><span id="${id}">${title}</span></a>
	        <#else>
	        	${title}
	        </#if>
        </span></span></span>
        <div class="iterm right">
          	<#if more!="">
	            <ul>
	              <li><a target="_blank" href="${more}"><span>更多...</span></a></li>
	            </ul>
        	</#if>
        	<#if key?size gt 0>
      		  关键词: <#list key as one><a style="font-size: 10pt;" title="${one_index} 个话题" class="tag-link-24" href="${one.url}">${one.name}</a><#if one_index=2><#break></#if></#list>
        	</#if>
        </div>
	</div></div></div>
</#macro>
<#macro titleDiv divCss title id="" url="" more="" preText="" key=[]>
	<div class="${divCss}">
	   	<@titleDivTitle title=title id=id url=url more=more preText=preText key=key/>
	    <div class="fcontent">
			<#nested/>
	    </div>
	    <div class="bg_buttom"><div class="bg_buttom_r"></div></div>
	</div>
</#macro>

<#macro noTitleDiv divCss>
	<div class="${divCss}">
	<div class="bg_top"><div class="bg_top_r"></div></div>
      <div class="fcontent">
			<#nested/>
	    </div>
	    <div class="bg_buttom"><div class="bg_buttom_r"></div></div>
	</div>
</#macro>

<#macro listDiv item name="" divCss="" more="" listDivCss="top10">
	<@titleDiv divCss=divCss title=item.name  id="item"+name url=item.url more=more>
	   <div class="${listDivCss}">	
			<ul>
			<#list item.contents as one>
				<li><a id="${name+one_index}" title="${one.name}" href="${one.url}">${one.name}</a></li>
				<#if one_index=8><#break></#if>
			</#list>
			</ul>
        </div>
	</@titleDiv>
</#macro>



<#macro index_area1 item1 item2 loop>
<div style="margin-top:5px;" class="wrapper">
	<@index_recommandDiv item=item1/>
	<@index_loopDiv loop=loop/>
	<@index_div13 item=item2/>
	<div class="clear"></div>
</div>
</#macro>
<#macro index_area2 item1 item2 item3>
<div style="margin:5px auto;" class="wrapper">
	<@listDiv item=item1 divCss="postlist" more=item1.url listDivCss="list-post"/>
	<@self.aboutDiv divCss="hotpost"/>
	<@listDiv item=item2 divCss="comfaq" more=item2.url listDivCss="list-post"/>
	<div class="clear"></div>
</div>
</#macro>

<#macro index_area3 item1 item2 item3>
<div style="margin:5px auto;" class="wrapper">
	<@index_picDiv divCss="bigDiv" item=item1/>
	<@listDiv divCss="comfaq" item=item2/>
	<div class="clear"></div>
</div>
</#macro>
<#macro index_area4 item1 item2 item3>
<div style="margin:5px auto;" class="wrapper">
	<@listDiv item=item1 divCss="postlist" more=item1.url listDivCss="list-post"/>
	<@listDiv item=item2 divCss="hotpost" more=item2.url listDivCss="list-post"/>
	<@listDiv item=item3 divCss="comfaq" more=item3.url listDivCss="list-post"/>
	<div class="clear"></div>
</div>
</#macro>

<#macro index_recommandDiv item>
<div class="postlist">
	<div class="bg_top"><div class="new"></div><div class="bg_top_r"></div></div>
	<div class="list_div2">
         <div class="hot">
         	<#assign bean=item.contents[0]/>
			<div class="hot_title"><a target="_blank" rel="bookmark" class="link01" title="${bean.name}" href="${bean.url}">${bean.name}</a></div>
			<div class="hot_summary">${bean.html}</div>
			<div class="hot_line"></div>
	       	<ul>
				<#list item.contents as one>
					<#if one_index!=0>
				    <li><a target="_blank" class="a_blue" title="${one.name}" href="${one.url}">${one.name}</a></li>
				    </#if>
					<#if one_index=6><#break></#if>
				</#list>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	<div style="width: 289px;" class="bg_buttom"><div class="bg_buttom_r"></div></div>
</div>
</#macro>
<#macro index_loopDiv loop>
<div class="hotpost">
	<div class="bg_top"><div class="bg_top_r"></div></div>
	<div class="fcontent">
		<@g.lunBo pictures=loop  name="lunbo" divCss="focus_d1" imgDivCss="focus_d2" imgCss="scrollbox_img" titleCss="img_bottom" numCss="button_list"/>
	</div>
    <div style="width: 383px;" class="bg_buttom"><div class="bg_buttom_r"></div></div>
</div>
</#macro>
<#macro index_div13 item>
<div class="comfaq">
 	<div class="bg_top"><div class="bg_top_r"></div></div>
	<div class="list_div1">
         <div class="top10">
			  <ul>
				<#list item.contents as one>
				<li><a title="${one.name}" href="${one.url}">${one.name}</a> - 19,455 views</li>
				<#if one_index=9><#break></#if>
				</#list>
			  </ul>
		</div>
	</div>
    <div style="width: 269px;" class="bg_buttom"><div class="bg_buttom_r"></div></div>
</div>
</#macro>

<#macro index_statusDiv item>
<div style="margin-top:5px;" class="wrapper">
  <div class="status">
    <div class="newtitle">${item.name}</div>
    <div class="news">
		<ul>
			<#list item.contents as one>
				<li><a target="_blank" title="${one.name}" href="${one.url}">${one.name}</a></li>
				<#if one_index=2><#break></#if>
			</#list>
		</ul>
    </div>
    <div class="newright"></div>
  </div>
</div>
</#macro>



<#macro index_picDiv divCss item>
	<@titleDiv divCss=divCss title="${item.name}">
			<div class="portfolio">
				<#list item.contents as one>
					<div class="card">
						<div class="thumb">
							<a target="_blank" title="${one.name}" href="${one.url}"><img width="200" height="150" src="${uploadDir}/blank.jpg"/></a>
						</div>
					    <h5 class="title"><a target="_blank" title="${one.name}" href="${one.url}">${one.name}</a></h5>
						<p class="author"><a rel="author" title="${one.name}" href="${one.url}">${one.author}</a></p>
					</div>
					<#if one_index=2><#break></#if>
				</#list>	
				<div class="clear"></div>
			</div>
	</@titleDiv>
</#macro>



<#macro item_position bean>
<div style="margin-top:5px;" class="wrapper">
	<div class="position">当前位置: 
  		<a href="${common.homePage.url}">${common.siteDefine['siteName']}</a>/<a rel="category" title="${bean.name}" href="${bean.url}">${bean.name}</a>
	</div>
</div>
</#macro>
<#macro item_right item varName="page">
	<@titleDiv divCss="" title=item.name url=item.url more=""  preText="" key=item.contents>
		<div class="item_list1">
		<#list item.contents as one>
		      <div class="list" id="${varName}${one_index}div">
		         <div class="title left"><a target="_blank" title="${one.name}" href="${one.url}" id="${varName}${one_index}">${one.name}</a></div>
		         <div class="info right">发布时间：${one.updateTime?date}</div>
		         <div class="clear"></div>
		     </div>
		     <#if one_index=15><#break></#if>
		</#list>
	    </div>
	</@titleDiv>
	<@noTitleDiv divCss="mT5">
		<@g.page2 bean=item pageSize=15/>
    </@noTitleDiv>
</#macro>


<#macro detail_position bean>
<div style="margin-top:5px;" class="wrapper">
	<div class="position">当前位置: 
  		<a href="${common.homePage.url}">${common.siteDefine['siteName']}</a>
  		/<a rel="category" title="${bean.item.name}" href="${bean.item.url}">${bean.item.name}</a>
  		/<a rel="category" title="${bean.content.name}" href="${bean.content.url}">${bean.content.name}</a>
	</div>
</div>
</#macro>
<#macro detail_right bean>
    <@titleDiv divCss="" title=bean.item.name url=bean.item.url preText="文章分类：">
      <div class="detail">
        <h1>${bean.content.name}</h1>
  		<div class="times">${bean.content.author}发表于${bean.content.updateTime?date} | 来源：<a target="_blank" href="#">${bean.content.source}</a> </div>
        <div class="content">
          <div class="content">
			${bean.content.html}
			</div>
        </div>
        
        <div class="linkes">
          <li>上一篇：<a rel="prev" href="${bean.content.pre.url}">${bean.content.pre.name}</a> </li>
          <li>下一篇：<a rel="next" href="${bean.content.next.url}">${bean.content.next.name}</a> </li>
        </div>
      </div>
      </@titleDiv>
    
	<div style="width:340px;float:left;"><@listDiv item=bean.item1/></div>
	<div style="width:340px;float:left;"><@listDiv item=bean.item2/></div>
</#macro>

<#macro other>
		<div class="linkes">
			<div class="postother">关键字: <#list 1..6 as one><a rel="tag" href="#">房产分割</a>,</#list></div>
		</div>
</#macro>
<#macro detail_recommand>
	<ul class="related_post wp_rp">
		<#list 1..9 as one>
		<li position="0"><a href="#">新婚姻法离婚房屋分割：房屋增值了90万 法院按还款比例分割给夫妻</a></li>
		</#list>
	</ul>
	<div class="similarity"><br><br>
		<headerh2><strong>相关推荐:</strong></headerh2>
		<ul>
		<#list 1..5 as one>
		<li><a href="http://www.99hunyin.org/?p=59">离婚后因房屋主贷人变更引起纠纷怎么办？</a></li>
		</#list>
		</ul>
	</div>
</#macro>