<#import "${ftlPath}/common.ftl" as g/>
<#import "${ftlPath}/common_item_detail.ftl" as item_detail/>


<#macro detail item>
	<@item_detail.item_detail title=item.name>
		<table width="100%" border="0" cellspacing="0" cellpadding="20" height="300">
		 <tbody><tr>
                  <td valign="top"><table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tbody><tr>
                      <td>
                      <div class="imgList">
	                      <table cellpadding="0" cellspacing="0" align="center" border="0" width="100%"><tbody>
		                     <tr>
		                      <#list item.contents as one>
		                      	 <td align="center" width="33%">
		                      	 <ul><li><a target="_blank" href="${one.url}">
		                      	 <img style="margin-bottom:2px;margin-top:8px;" src="${one.pic}" alt="${one.name}" border="0" height="150" width="200">${one.name}</a></li>
		                      	 </ul></td>
			                      <#if  one_index != 0 && one_index % 3 = 2 >
			                      	</tr>
			                      	<tr>
			                      </#if>
								</#list>
							
	                       <#if item.contents?size % 3 gt 0>
		                       <#list 1..(item.contents?size %3 + 1) as one>
			                     <td align="center" width="33%"><ul><li>&nbsp;</li></ul></td>
								</#list>
		                   </#if>
				           </tr>
	                      </tbody></table>
	                   </div>
                      <div class="pager">
                      <ul><li class="p_total">1/1</li>
                      <li><a href="./list.asp?id=1&amp;PageNo=1">«</a></li>
                      <li><a href="./list.asp?id=1&amp;PageNo=1">‹</a></li>
                      <li class="p_current"> 1</li>
                      <li><a href="./list.asp?id=1&amp;PageNo=1">›</a></li><li><a href="./list.asp?id=1&amp;PageNo=1">»</a></li>
                      </ul></div></td>
                    </tr>
                  </tbody></table></td>
                </tr>
              </tbody>
      </table>
	</@item_detail.item_detail>
</#macro>

<@detail item=data/>